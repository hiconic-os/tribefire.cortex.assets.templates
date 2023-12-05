<#import '/imports/context.ftl' as context>
${template.relocate(context.relocation(context.initializerSpaceFull))}
package ${context.initializerSpacePackage};

import com.braintribe.wire.api.annotation.Import;
import com.braintribe.wire.api.annotation.Managed;

import tribefire.cortex.initializer.support.integrity.wire.contract.CoreInstancesContract;
import tribefire.cortex.initializer.support.wire.space.AbstractInitializerSpace;

import ${context.initializerContractFull};
import ${context.lookupContractFull};

@Managed
public class ${context.initializerSpaceSimple} extends AbstractInitializerSpace implements ${context.initializerContractSimple} {

	@Import
	private ${context.lookupContractSimple} ${context.lookupContractInstance};

	@Import
	private CoreInstancesContract coreInstances;

<#if request.serviceProcessorSample>
	@Import
	private ${context.serviceDomainSpaceSimple} ${context.serviceDomainSpaceInstance};

</#if>
	/* To ensure beans are initialized simply reference them here (i.e. invoke their defining methods).  */
	@Override
	public void initialize() {
<#if request.serviceProcessorSample>
	${context.serviceDomainSpaceInstance}.serviceDomain();
</#if>

	}

}
