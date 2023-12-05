package tribefire.cortex.assets.templates.model;

import com.braintribe.devrock.templates.model.artifact.CreateArtifactWithSamples;
import com.braintribe.model.generic.annotation.meta.Description;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

@Description("Creates an initializer platform asset.")
public interface CreateInitializer extends CreateArtifactWithSamples, HasAccessIds {

	EntityType<CreateInitializer> T = EntityTypes.T(CreateInitializer.class);

	@Override
	default String template() {
		return "tribefire.cortex.assets.templates:tf-initializer-module-template#2.0";
	}
	
}
