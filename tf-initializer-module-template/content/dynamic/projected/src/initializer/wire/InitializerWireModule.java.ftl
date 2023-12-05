<#import '/imports/context.ftl' as context>
${template.relocate(context.relocation(context.initializerWireModuleFull))}
package ${context.initializerWireModulePackage};

import static com.braintribe.wire.api.util.Lists.list;

import java.util.List;

import com.braintribe.wire.api.module.WireModule;
import com.braintribe.wire.api.module.WireTerminalModule;

import tribefire.cortex.initializer.support.integrity.wire.CoreInstancesWireModule;

import ${context.initializerContractFull};

public enum ${context.initializerWireModuleSimple} implements WireTerminalModule<${context.initializerContractSimple}> {

	INSTANCE;

	@Override
	public List<WireModule> dependencies() {
		return list(CoreInstancesWireModule.INSTANCE);
	}

}
