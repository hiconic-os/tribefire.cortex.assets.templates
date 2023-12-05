import com.braintribe.devrock.templates.model.Dependency;
import tribefire.cortex.assets.templates.model.CreateModel;

def modelRequest = CreateModel.T.create();
support.mapFromTo(request, modelRequest);
def dep1 = Dependency.T.create();
dep1.groupId = 'com.braintribe.gm'
dep1.artifactId = 'service-api-model'
dep1.tags = ['asset'];
def dep2 = Dependency.T.create();
dep2.groupId = 'com.braintribe.gm'
dep2.artifactId = 'access-request-model'
dep2.tags = ['asset'];
modelRequest.dependencies = support.distinctDependencies([dep1, dep2] + modelRequest.dependencies);

[modelRequest]