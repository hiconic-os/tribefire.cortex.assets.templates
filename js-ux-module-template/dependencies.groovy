import com.braintribe.devrock.templates.model.artifact.CreateBuildSystemConfig;
import com.braintribe.devrock.templates.model.artifact.CreateProjectMetadata;
import com.braintribe.devrock.templates.model.artifact.CreateSourceControlConfig;
import com.braintribe.devrock.templates.model.Dependency;

def buildSystemConfigRequest = CreateBuildSystemConfig.T.create();
support.mapFromTo(request, buildSystemConfigRequest);
buildSystemConfigRequest.artifactType = 'js-library';
def dep1 = Dependency.T.create();
dep1.groupId = 'com.braintribe.gm.gwt'
dep1.artifactId = 'gm-view-api'
buildSystemConfigRequest.dependencies = support.distinctDependencies([dep1] + buildSystemConfigRequest.dependencies);

def projectMetadataRequest = CreateProjectMetadata.T.create();
support.mapFromTo(request, projectMetadataRequest);
projectMetadataRequest.projectName = request.artifactId + " - " + request.groupId;
projectMetadataRequest.sourceDirectory = 'src';
if ('eclipse'.equals(request.ide)) {
	projectMetadataRequest.builders = ['org.eclipse.wst.validation.validationbuilder'];
	projectMetadataRequest.natures = ['org.eclipse.wst.jsdt.core.jsNature'];
}

def sourceControlConfigRequest = CreateSourceControlConfig.T.create();
support.mapFromTo(request, sourceControlConfigRequest);
sourceControlConfigRequest.ignoredFiles = ['/' + projectMetadataRequest.outputDirectory, '/lib'];

[buildSystemConfigRequest, projectMetadataRequest, sourceControlConfigRequest]