<#if !request.api || !request.serviceProcessorSample>
    ${template.ignore()}
</#if>
<#import '/imports/context.ftl' as context>
${template.relocate(context.relocation(context.transformRequestFull))}
package ${context.modelApiPackage};

import com.braintribe.model.generic.eval.EvalContext;
import com.braintribe.model.generic.eval.Evaluator;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;
import com.braintribe.model.service.api.ServiceRequest;

/**
 * This is a sample {@link ${context.abstractRequestSimple}}.
 */
public interface ${context.transformRequestSimple} extends ${context.abstractRequestSimple} {

	EntityType<${context.transformRequestSimple}> T = EntityTypes.T(${context.transformRequestSimple}.class);

	String getText();
	void setText(String text);

	@Override
	EvalContext<String> eval(Evaluator<ServiceRequest> evaluator);

}
