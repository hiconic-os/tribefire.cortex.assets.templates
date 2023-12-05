<#import '/imports/context.ftl' as context>
${template.relocate(context.relocation(context.spaceFull))}
package ${context.spacePackage};

import com.braintribe.model.processing.deployment.api.binding.DenotationBindingBuilder;
import com.braintribe.wire.api.annotation.Import;
import com.braintribe.wire.api.annotation.Managed;

import tribefire.module.api.InitializerBindingBuilder;
import tribefire.module.api.WireContractBindingBuilder;
<#if request.platform == 'web'>
import tribefire.module.wire.contract.TribefireWebPlatformContract;
<#else>
import tribefire.module.wire.contract.TribefirePlatformContract;
</#if>
import tribefire.module.wire.contract.TribefireModuleContract;
<#if request.serviceProcessorSample>

import ${context.serviceProcessorFull};
import ${context.requestProcessorFull};
</#if>

/**
 * This module's javadoc is yet to be written.
 */
@Managed
public class ${context.spaceSimple} implements TribefireModuleContract {

	@Import
<#if request.platform == 'web'>
	private TribefireWebPlatformContract tfPlatform;
<#else>
	private TribefirePlatformContract tfPlatform;
</#if>

	//
	// WireContracts
	//

	@Override
	public void bindWireContracts(WireContractBindingBuilder bindings) {
<#if request.suppressComments>

<#else>
		// Bind wire contracts to make them available for other modules.
		// Note that the Contract class cannot be defined in this module, but must be in a gm-api artifact.
</#if>
	}

	//
	// Hardwired deployables
	//

	@Override
	public void bindHardwired() {
<#if request.suppressComments>

<#else>
		// Bind hardwired deployables here.
</#if>
	}

	//
	// Initializers
	//

	@Override
	public void bindInitializers(InitializerBindingBuilder bindings) {
<#if request.suppressComments>

<#else>
		// Bind DataInitialiers for various CollaborativeAcceses
</#if>
	}

	//
	// Deployables
	//

	@Override
	public void bindDeployables(DenotationBindingBuilder bindings) {
<#if request.suppressComments>

<#else>
		// Bind deployment experts for deployable denotation types.
		// Note that the basic component binders (for e.g. serviceProcessor or incrementalAccess) can be found via tfPlatform.deployment().binders(). 
</#if>
<#if request.serviceProcessorSample>
		bindings.bind(${context.serviceProcessorSimple}.T) //
				.component(tfPlatform.binders().serviceProcessor()) //
				.expertSupplier(this::${context.requestProcessorMethod});
</#if>
	}

<#if request.serviceProcessorSample>
	@Managed
	private ${context.requestProcessorSimple} ${context.requestProcessorMethod}() {
		return new ${context.requestProcessorSimple}();
	}
</#if>

}