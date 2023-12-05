import com.braintribe.devrock.templates.model.artifact.CreateServiceTest;
import com.braintribe.devrock.templates.model.artifact.CreateLibrary;
import com.braintribe.devrock.templates.model.artifact.CreateParent;
import com.braintribe.devrock.templates.model.artifact.CreateGroupBuildScript;
import com.braintribe.devrock.templates.model.artifact.CreateSourceControlConfig;
import com.braintribe.devrock.templates.model.Property;
import com.braintribe.devrock.templates.model.Dependency;
import tribefire.cortex.assets.templates.model.CreateModel;
import tribefire.cortex.assets.templates.model.CreateModule;
import tribefire.cortex.assets.templates.model.CreateInitializer;
import tribefire.cortex.assets.templates.model.CreateAggregator;

def artifactIdPrefix = request.name;

def cortexProp = Property.T.create();
cortexProp.name = 'V.tribefire.cortex';
cortexProp.value = '[2.0, 2.1)';

def cortexAssetsProp = Property.T.create();
cortexAssetsProp.name = 'V.tribefire.cortex.assets';
cortexAssetsProp.value = '[2.0, 2.1)';

def setupProp = Property.T.create();
setupProp.name = 'V.tribefire.setup.classic.env';
setupProp.value = '[2.1, 2.2)';

def gmProp = Property.T.create();
gmProp.name = 'V.com.braintribe.gm';
gmProp.value = '[1.0, 1.1)';

def wireProp = Property.T.create();
wireProp.name = 'V.com.braintribe.wire';
wireProp.value = '[1.0, 1.1)';

def serviceApiDep = Dependency.T.create();
serviceApiDep.groupId = 'com.braintribe.gm';
serviceApiDep.artifactId = 'service-api';

def standardAggregatorDep = Dependency.T.create();
standardAggregatorDep.groupId = 'tribefire.setup.classic.env';
standardAggregatorDep.artifactId = 'env-aware-standard-setup';
standardAggregatorDep.classifier = 'asset';
standardAggregatorDep.type = 'man';
standardAggregatorDep.tags = ['asset'];

def parentRequest = CreateParent.T.create();
support.mapFromTo(request, parentRequest);
parentRequest.directoryName = 'parent';
parentRequest.properties = [cortexProp, cortexAssetsProp, setupProp, gmProp, wireProp];

def dataModelRequest = CreateModel.T.create();
support.mapFromTo(request, dataModelRequest);
dataModelRequest.artifactId = artifactIdPrefix + "-model";
dataModelRequest.directoryName = dataModelRequest.artifactId;
def dataModelDep = Dependency.T.create();
dataModelDep.groupId = dataModelRequest.groupId;
dataModelDep.artifactId = dataModelRequest.artifactId;
dataModelDep.tags = ['asset'];

def serviceModelRequest = CreateModel.T.create();
support.mapFromTo(request, serviceModelRequest);
serviceModelRequest.artifactId = artifactIdPrefix + "-api-model";
serviceModelRequest.directoryName = serviceModelRequest.artifactId;
serviceModelRequest.dependencies = [dataModelDep];
serviceModelRequest.api = true;
def serviceModelDep = Dependency.T.create();
serviceModelDep.groupId = serviceModelRequest.groupId;
serviceModelDep.artifactId = serviceModelRequest.artifactId;
serviceModelDep.tags = ['asset'];

def deploymentModelRequest = CreateModel.T.create();
support.mapFromTo(request, deploymentModelRequest);
deploymentModelRequest.artifactId = artifactIdPrefix + "-deployment-model";
deploymentModelRequest.directoryName = deploymentModelRequest.artifactId;
deploymentModelRequest.deployment = true;
def deploymentModelDep = Dependency.T.create();
deploymentModelDep.groupId = deploymentModelRequest.groupId;
deploymentModelDep.artifactId = deploymentModelRequest.artifactId;
deploymentModelDep.tags = ['asset'];

def processingRequest = CreateLibrary.T.create();
support.mapFromTo(request, processingRequest);
processingRequest.artifactId = artifactIdPrefix + "-processing";
processingRequest.directoryName = processingRequest.artifactId;
processingRequest.dependencies = [serviceApiDep, dataModelDep, serviceModelDep, deploymentModelDep];
def processingDep = Dependency.T.create();
processingDep.groupId = processingRequest.groupId;
processingDep.artifactId = processingRequest.artifactId;

def moduleRequest = CreateModule.T.create();
support.mapFromTo(request, moduleRequest);
moduleRequest.artifactId = artifactIdPrefix + "-module";
moduleRequest.directoryName = moduleRequest.artifactId;
moduleRequest.dependencies = [processingDep, dataModelDep, serviceModelDep, deploymentModelDep];
def moduleDep = Dependency.T.create();
moduleDep.groupId = moduleRequest.groupId;
moduleDep.artifactId = moduleRequest.artifactId;
moduleDep.classifier = 'asset';
moduleDep.type = 'man';
moduleDep.tags = ['asset'];

def initializerRequest = CreateInitializer.T.create();
support.mapFromTo(request, initializerRequest);
initializerRequest.artifactId = artifactIdPrefix + "-initializer";
initializerRequest.directoryName = initializerRequest.artifactId;
initializerRequest.dependencies = [moduleDep, dataModelDep, serviceModelDep, deploymentModelDep];
def initializerDep = Dependency.T.create();
initializerDep.groupId = initializerRequest.groupId;
initializerDep.artifactId = initializerRequest.artifactId;
initializerDep.classifier = 'asset';
initializerDep.type = 'man';
initializerDep.tags = ['asset'];

def setupRequest = CreateAggregator.T.create();
support.mapFromTo(request, setupRequest);
setupRequest.artifactId = artifactIdPrefix + "-setup";
setupRequest.directoryName = setupRequest.artifactId;
setupRequest.dependencies = [standardAggregatorDep, initializerDep];

def testRequest = CreateServiceTest.T.create();
support.mapFromTo(request, testRequest);
testRequest.artifactId = artifactIdPrefix + "-test";
testRequest.directoryName = testRequest.artifactId;
testRequest.dependencies = [processingDep];

def groupBuildScriptRequest = CreateGroupBuildScript.T.create();
support.mapFromTo(request, groupBuildScriptRequest);
groupBuildScriptRequest.builtArtifactIds = ['parent', dataModelRequest.artifactId, serviceModelRequest.artifactId, deploymentModelRequest.artifactId, processingRequest.artifactId, moduleRequest.artifactId, initializerRequest.artifactId, setupRequest.artifactId, testRequest.artifactId];

def sourceControlConfigRequest = CreateSourceControlConfig.T.create();
support.mapFromTo(request, sourceControlConfigRequest, ["buildSystem"]);
sourceControlConfigRequest.ignoredFiles = ['**/.DS_Store', '**/.DS_Store?', '**/.Spotlight-V100', '**/.Trashes', '**/ehthumbs.db', '**/Thumbs.db'];

[parentRequest, dataModelRequest, serviceModelRequest, deploymentModelRequest, processingRequest, moduleRequest, initializerRequest, setupRequest, testRequest, groupBuildScriptRequest, sourceControlConfigRequest]