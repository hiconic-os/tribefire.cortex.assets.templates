package tribefire.cortex.assets.templates.model;

import com.braintribe.devrock.templates.model.artifact.CreateArtifact;
import com.braintribe.model.generic.annotation.meta.Description;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

@Description("Creates a runtime-properties platform asset.")
public interface CreateRuntimeProperties extends CreateArtifact {

	EntityType<CreateRuntimeProperties> T = EntityTypes.T(CreateRuntimeProperties.class);

	@Override
	default String template() {
		return "tribefire.cortex.assets.templates:runtime-properties-template#2.0";
	}
	
}
