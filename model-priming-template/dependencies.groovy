import com.braintribe.devrock.templates.model.artifact.CreateBuildSystemConfig;
import com.braintribe.devrock.templates.model.artifact.CreateProjectMetadata;
import com.braintribe.devrock.templates.model.artifact.CreateSourceControlConfig;
import com.braintribe.devrock.templates.model.Dependency;
import com.braintribe.devrock.templates.model.Property;

def buildSystemConfigRequest = CreateBuildSystemConfig.T.create();
support.mapFromTo(request, buildSystemConfigRequest);
buildSystemConfigRequest.artifactType = 'model';
def dep1 = Dependency.T.create();
dep1.groupId = 'com.braintribe.gm';
dep1.artifactId = 'root-model';
dep1.tags = ['asset'];
def deps = [dep1];
if (request.api) {
	def dep2 = Dependency.T.create();
	dep2.groupId = 'com.braintribe.gm'
	dep2.artifactId = 'service-api-model'
	dep2.tags = ['asset'];
	def dep3 = Dependency.T.create();
	dep3.groupId = 'com.braintribe.gm'
	dep3.artifactId = 'access-request-model'
	dep3.tags = ['asset'];
	deps += [dep2, dep3];
} else if (request.deployment) {
	def dep2 = Dependency.T.create();
	dep2.groupId = 'tribefire.cortex'
	dep2.artifactId = 'extension-deployment-model'
	dep2.tags = ['asset'];
	deps += [dep2];
}
buildSystemConfigRequest.dependencies = support.distinctDependencies(deps + buildSystemConfigRequest.dependencies);
def archetypeProp = Property.T.create();
archetypeProp.name = 'archetype';
archetypeProp.value = 'model';
buildSystemConfigRequest.properties = support.distinctProperties([archetypeProp] + buildSystemConfigRequest.properties);

def projectMetadataRequest = CreateProjectMetadata.T.create();
support.mapFromTo(request, projectMetadataRequest);
projectMetadataRequest.projectName = request.artifactId + " - " + request.groupId;
projectMetadataRequest.sourceDirectory = 'src';
if ('eclipse'.equals(request.ide)) {
	projectMetadataRequest.classPathEntries = ["org.eclipse.jdt.launching.JRE_CONTAINER"];
	projectMetadataRequest.builders = ['com.braintribe.devrock.arb.builder.ArtifactReflectionBuilder', 'org.eclipse.jdt.core.javabuilder', 'com.braintribe.eclipse.model.nature.ModelBuilder'];
	projectMetadataRequest.builderOutputLibs = ["class-gen"];
	projectMetadataRequest.natures = ['org.eclipse.jdt.core.javanature', 'com.braintribe.eclipse.model.nature.ModelNature'];
}

def sourceControlConfigRequest = CreateSourceControlConfig.T.create();
support.mapFromTo(request, sourceControlConfigRequest);
sourceControlConfigRequest.ignoredFiles = ['/' + projectMetadataRequest.outputDirectory];

[buildSystemConfigRequest, projectMetadataRequest, sourceControlConfigRequest]
