package tribefire.cortex.assets.templates.model;

import com.braintribe.devrock.templates.model.artifact.CreateArtifact;
import com.braintribe.model.generic.annotation.meta.Description;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

@Description("Creates a markdown-documentation-configuration platform asset.")
public interface CreateMdDocConfig extends CreateArtifact {

	EntityType<CreateMdDocConfig> T = EntityTypes.T(CreateMdDocConfig.class);

	@Override
	default String template() {
		return "tribefire.cortex.assets.templates:markdown-documentation-config-template#2.0";
	}
	
}
