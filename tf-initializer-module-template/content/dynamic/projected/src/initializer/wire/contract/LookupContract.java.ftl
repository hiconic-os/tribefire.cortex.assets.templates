<#import '/imports/context.ftl' as context>
${template.relocate(context.relocation(context.lookupContractFull))}
package ${context.initializerContractPackage};

import com.braintribe.wire.api.space.WireSpace;

import tribefire.cortex.initializer.support.impl.lookup.GlobalId;
import tribefire.cortex.initializer.support.impl.lookup.InstanceLookup;

@InstanceLookup(lookupOnly = true)
public interface ${context.lookupContractSimple} extends WireSpace {

	String GROUP_ID = "${request.groupId}";

//  EXAMPLE:
//
//	@GlobalId("model:com.braintribe.gm:root-model")
//	GmMetaModel rootModel();
//
//  MAKE SURE TO IMPORT [tribefire.cortex.initializer.support.impl.lookup.GlobalId]

}
