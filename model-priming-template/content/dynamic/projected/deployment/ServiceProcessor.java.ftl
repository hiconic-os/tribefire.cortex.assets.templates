<#if !request.deployment || !request.serviceProcessorSample>
    ${template.ignore()}
</#if>
<#import '/imports/context.ftl' as context>
${template.relocate(context.relocation(context.serviceProcessorFull))}
package ${context.modelDeploymentPackage};

import com.braintribe.model.extensiondeployment.ServiceProcessor;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

/**
 * Denotation type for a processor which handles ${context.nameBasePascal}Requests from ${context.nameBaseKebab}-api-model.
 */
public interface ${context.serviceProcessorSimple} extends ServiceProcessor {

	EntityType<${context.serviceProcessorSimple}> T = EntityTypes.T(${context.serviceProcessorSimple}.class);

}
