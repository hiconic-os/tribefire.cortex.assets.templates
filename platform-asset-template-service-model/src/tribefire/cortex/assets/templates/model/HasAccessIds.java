package tribefire.cortex.assets.templates.model;

import java.util.List;

import com.braintribe.model.generic.GenericEntity;
import com.braintribe.model.generic.annotation.Abstract;
import com.braintribe.model.generic.annotation.Initializer;
import com.braintribe.model.generic.annotation.meta.Alias;
import com.braintribe.model.generic.annotation.meta.Description;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

@Abstract
public interface HasAccessIds extends GenericEntity {

	EntityType<HasAccessIds> T = EntityTypes.T(HasAccessIds.class);

	@Description("The ids of the targeted accesses.")
	@Initializer("['cortex']")
	@Alias("acids")
	List<String> getAccessIds();
	void setAccessIds(List<String> accessIds);
	
}