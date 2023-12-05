<#import '/imports/context.ftl' as context>
${template.relocate(context.relocation(context.envContractFull))}
package ${context.initializerContractPackage};

import com.braintribe.wire.impl.properties.PropertyLookups;

import tribefire.cortex.initializer.support.wire.contract.PropertyLookupContract;

/**
 * @see PropertyLookupContract
 * @see PropertyLookups
 */
public interface ${context.envContractSimple} extends PropertyLookupContract {
	// Empty; For an example see the super-type (PropertyLookupContract); More info also in PropertyLookups
}
	