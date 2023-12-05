package tribefire.cortex.assets.templates.model;

import com.braintribe.devrock.templates.model.artifact.CreateArtifact;
import com.braintribe.model.generic.annotation.meta.Description;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

@Description("Creates a resource-priming platform asset.")
public interface CreateResourcePriming extends CreateArtifact, HasAccessIds {

	EntityType<CreateResourcePriming> T = EntityTypes.T(CreateResourcePriming.class);

	@Override
	default String template() {
		return "tribefire.cortex.assets.templates:resource-priming-template#2.0";
	}
	
}
