<#if !request.api || !request.serviceProcessorSample>
    ${template.ignore()}
</#if>
<#import '/imports/context.ftl' as context>
${template.relocate(context.relocation(context.abstractRequestFull))}
package ${context.modelApiPackage};

import com.braintribe.model.generic.annotation.Abstract;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;
import com.braintribe.model.service.api.AuthorizedRequest;
import com.braintribe.model.service.api.DomainRequest;

/**
 * Base type for all requests of this api-model.
 */
@Abstract
public interface ${context.abstractRequestSimple} extends AuthorizedRequest, DomainRequest {

	EntityType<${context.abstractRequestSimple}> T = EntityTypes.T(${context.abstractRequestSimple}.class);

}
