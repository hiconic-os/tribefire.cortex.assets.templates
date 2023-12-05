<#import '/imports/context.ftl' as context>
${template.relocate(context.relocation(context.initializerContractFull))}
package ${context.initializerContractPackage};

import com.braintribe.wire.api.space.WireSpace;
import ${context.initializerSpaceFull};

public interface ${context.initializerContractSimple} extends WireSpace {

	/** @see ${context.initializerSpaceSimple}#initialize()  */
	void initialize();

}
