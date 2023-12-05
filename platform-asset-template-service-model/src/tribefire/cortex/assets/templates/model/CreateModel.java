package tribefire.cortex.assets.templates.model;

import com.braintribe.devrock.templates.model.artifact.CreateArtifactWithSamples;
import com.braintribe.model.generic.annotation.meta.Alias;
import com.braintribe.model.generic.annotation.meta.Description;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

@Description("Creates a model artifact.")
public interface CreateModel extends CreateArtifactWithSamples {

	EntityType<CreateModel> T = EntityTypes.T(CreateModel.class);
	
	@Description("Specifies whether or not the model is deployment model.")
	@Alias("d")
	boolean getDeployment();
	void setDeployment(boolean deployment);
	
	@Description("Specifies whether or not the model is api model.")
	@Alias("a")
	boolean getApi();
	void setApi(boolean api);

	@Override
	default String template() {
		return "tribefire.cortex.assets.templates:model-priming-template#2.0";
	}
	
}
