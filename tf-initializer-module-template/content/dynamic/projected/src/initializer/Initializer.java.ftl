<#import '/imports/context.ftl' as context>
${template.relocate(context.relocation(context.initializerFull))}
package ${context.initializerPackage};

import com.braintribe.model.processing.session.api.collaboration.PersistenceInitializationContext;
import com.braintribe.wire.api.module.WireTerminalModule;

import tribefire.cortex.initializer.support.api.WiredInitializerContext;
import tribefire.cortex.initializer.support.impl.AbstractInitializer;

import ${context.initializerWireModuleFull};
import ${context.initializerContractFull};

public class ${context.initializerSimple} extends AbstractInitializer<${context.initializerContractSimple}> {

	@Override
	public WireTerminalModule<${context.initializerContractSimple}> getInitializerWireModule() {
		return ${context.initializerWireModuleSimple}.INSTANCE;
	}

	@Override
	public void initialize(PersistenceInitializationContext context, WiredInitializerContext<${context.initializerContractSimple}> initializerContext,
			${context.initializerContractSimple} initializerContract) {

		initializerContract.initialize();

	}

}