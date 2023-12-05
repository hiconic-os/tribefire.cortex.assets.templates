package tribefire.cortex.assets.templates.model;

import com.braintribe.devrock.templates.model.artifact.CreateArtifact;
import com.braintribe.model.generic.annotation.meta.Description;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

@Description("Creates a script-priming platform asset.")
public interface CreateScriptPriming extends CreateArtifact, HasAccessIds {

	EntityType<CreateScriptPriming> T = EntityTypes.T(CreateScriptPriming.class);

	@Override
	default String template() {
		return "tribefire.cortex.assets.templates:script-priming-template#2.0";
	}
	
}
