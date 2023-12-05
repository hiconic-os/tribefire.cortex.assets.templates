<#if !request.serviceProcessorSample>
 ${template.ignore()}
</#if>
<#import '/imports/context.ftl' as context>
${template.relocate(context.relocation(context.serviceDomainSpaceFull))}
package ${context.initializerSpacePackage};

import com.braintribe.model.extensiondeployment.meta.ProcessWith;
import com.braintribe.model.meta.GmMetaModel;
import com.braintribe.model.processing.meta.editor.ModelMetaDataEditor;
import com.braintribe.model.service.domain.ServiceDomain;
import com.braintribe.wire.api.annotation.Import;
import com.braintribe.wire.api.annotation.Managed;

import tribefire.cortex.initializer.support.wire.space.AbstractInitializerSpace;

import ${context.apiModelArtifactReflectionFull};
import ${context.basePackage}.model.api.${context.nameBasePascal}ServiceRequest;
import ${context.basePackage}.model.deployment.${context.nameBasePascal}ServiceProcessor;
import ${context.lookupContractFull};

@Managed
public class ${context.serviceDomainSpaceSimple} extends AbstractInitializerSpace {

	@Import
	private ${context.lookupContractSimple} ${context.lookupContractInstance};

	@Managed
	public ServiceDomain serviceDomain() {
		ServiceDomain bean = create(ServiceDomain.T);
		bean.setName("${context.nameBasePascal} Service Domain");
		bean.setExternalId("${context.nameBaseSnake}");
		bean.setServiceModel(configuredApiModel());

		return bean;
	}

	@Managed
	private GmMetaModel configuredApiModel() {
		GmMetaModel bean = buildConfiguredModelFor(${context.apiModelArtifactReflectionSimple}.reflection).get();

		configureProcessWithMd(bean);

		return bean;
	}

	private void configureProcessWithMd(GmMetaModel bean) {
		ModelMetaDataEditor mdEditor = modelApi.newMetaDataEditor(bean).done();
		mdEditor.onEntityType(${context.nameBasePascal}ServiceRequest.T) //
				.addMetaData(processWith());
	}

	@Managed
	private ProcessWith processWith() {
		ProcessWith bean = create(ProcessWith.T);
		bean.setProcessor(serviceProcessor());

		return bean;
	}

	@Managed
	private ${context.nameBasePascal}ServiceProcessor serviceProcessor() {
		${context.nameBasePascal}ServiceProcessor bean = create(${context.nameBasePascal}ServiceProcessor.T);
		bean.setName("Sample ${context.nameBasePascal} Processor");
		bean.setExternalId("serviceProcessor.${context.nameBaseCamel}");
		return bean;
	}
}
