import com.braintribe.devrock.templates.model.Dependency;
import tribefire.cortex.assets.templates.model.CreateModel;

def modelRequest = CreateModel.T.create();
support.mapFromTo(request, modelRequest);
def dep1 = Dependency.T.create();
dep1.groupId = 'com.braintribe.gm'
dep1.artifactId = 'extension-deployment-model'
dep1.tags = ['asset'];
modelRequest.dependencies = support.distinctDependencies([dep1] + modelRequest.dependencies);

[modelRequest]