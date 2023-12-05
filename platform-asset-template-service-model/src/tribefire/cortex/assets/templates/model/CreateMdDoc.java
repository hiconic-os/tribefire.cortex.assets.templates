package tribefire.cortex.assets.templates.model;

import com.braintribe.devrock.templates.model.artifact.CreateArtifactWithSamples;
import com.braintribe.model.generic.annotation.meta.Description;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

@Description("Creates a markdown-documentation platform asset.")
public interface CreateMdDoc extends CreateArtifactWithSamples {

	EntityType<CreateMdDoc> T = EntityTypes.T(CreateMdDoc.class);

	@Override
	default String template() {
		return "tribefire.cortex.assets.templates:markdown-documentation-template#2.0";
	}
	
}
