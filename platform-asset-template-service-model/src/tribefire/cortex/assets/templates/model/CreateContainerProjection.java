package tribefire.cortex.assets.templates.model;

import com.braintribe.devrock.templates.model.artifact.CreateArtifact;
import com.braintribe.model.generic.annotation.meta.Alias;
import com.braintribe.model.generic.annotation.meta.Description;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

@Description("Creates a container-projection platform asset.")
public interface CreateContainerProjection extends CreateArtifact {

	EntityType<CreateContainerProjection> T = EntityTypes.T(CreateContainerProjection.class);

	@Description("The name of the container which stands for a separately sclabale runtime instance of TF.")
	@Alias("cn")
	String getContainerName();
	void setContainerName(String containerName);
	
	@Override
	default String template() {
		return "tribefire.cortex.assets.templates:container-projection-template#2.0";
	}
	
}
