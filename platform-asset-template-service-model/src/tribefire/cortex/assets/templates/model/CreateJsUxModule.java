package tribefire.cortex.assets.templates.model;

import com.braintribe.devrock.templates.model.artifact.CreateArtifact;
import com.braintribe.model.generic.annotation.meta.Description;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

@Description("Creates a js-ux-module platform asset.")
public interface CreateJsUxModule extends CreateArtifact {

	EntityType<CreateJsUxModule> T = EntityTypes.T(CreateJsUxModule.class);
	
	@Override
	default String template() {
		return "tribefire.cortex.assets.templates:js-ux-module-template#2.0";
	}
	
}
