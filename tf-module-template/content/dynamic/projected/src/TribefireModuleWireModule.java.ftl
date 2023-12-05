<#import '/imports/context.ftl' as context>
${template.relocate(context.relocation(context.wireModuleFull))}
package ${context.wirePackage};

import tribefire.module.wire.contract.StandardTribefireModuleWireModule;
import tribefire.module.wire.contract.TribefireModuleContract;
import ${context.spaceFull};

public enum ${context.wireModuleSimple} implements StandardTribefireModuleWireModule {

	INSTANCE;

	@Override
	public Class<? extends TribefireModuleContract> moduleSpaceClass() {
		return ${context.spaceSimple}.class;
	}

}