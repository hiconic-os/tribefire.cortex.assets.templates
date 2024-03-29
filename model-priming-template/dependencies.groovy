import com.braintribe.devrock.templates.model.artifact.CreateBuildSystemConfig;
import com.braintribe.devrock.templates.model.artifact.CreateProjectMetadata;
import com.braintribe.devrock.templates.model.artifact.CreateSourceControlConfig;
import com.braintribe.devrock.templates.model.Dependency;
import com.braintribe.devrock.templates.model.Property;

def buildSystemConfigRequest = CreateBuildSystemConfig.T.create();
support.mapFromTo(request, buildSystemConfigRequest);
buildSystemConfigRequest.artifactType = 'model';

def deps = [assetDependency('com.braintribe.gm', 'root-model')];

if (request.api)
	deps += [assetDependency('com.braintribe.gm', 'service-api-model')];

if (request.deployment)
	deps += [assetDependency('tribefire.cortex', 'extension-deployment-model')];

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
	projectMetadataRequest.builders = [
		'com.braintribe.devrock.arb.builder.ArtifactReflectionBuilder',
		'org.eclipse.jdt.core.javabuilder',
		'com.braintribe.eclipse.model.nature.ModelBuilder'
	];
	projectMetadataRequest.builderOutputLibs = ["class-gen"];
	projectMetadataRequest.natures = ['org.eclipse.jdt.core.javanature', 'com.braintribe.eclipse.model.nature.ModelNature'];
}

def sourceControlConfigRequest = CreateSourceControlConfig.T.create();
support.mapFromTo(request, sourceControlConfigRequest);
sourceControlConfigRequest.ignoredFiles = ['/' + projectMetadataRequest.outputDirectory];

return [buildSystemConfigRequest, projectMetadataRequest, sourceControlConfigRequest]

Dependency assetDependency(String groupId, String artifactId) {
	def dep = Dependency.T.create();
	dep.groupId = groupId;
	dep.artifactId = artifactId;
	dep.tags = ['asset'];
	return dep;
}