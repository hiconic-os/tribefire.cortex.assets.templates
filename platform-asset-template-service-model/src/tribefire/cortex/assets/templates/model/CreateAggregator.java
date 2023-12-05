package tribefire.cortex.assets.templates.model;

import com.braintribe.devrock.templates.model.artifact.CreateArtifact;
import com.braintribe.model.generic.annotation.meta.Description;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

@Description("Creates an asset-aggregator platform asset.")
public interface CreateAggregator extends CreateArtifact {

	EntityType<CreateAggregator> T = EntityTypes.T(CreateAggregator.class);
	
	@Override
	default String template() {
		return "tribefire.cortex.assets.templates:asset-aggregator-template#2.0";
	}
	
}
