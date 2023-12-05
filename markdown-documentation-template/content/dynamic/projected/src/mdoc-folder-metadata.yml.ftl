<#if !request.hasSample()>
    ${template.ignore()}
</#if>
<#import '/imports/context.ftl' as context>
${template.relocate(context.relocation('mdoc-folder-metadata.yml'))}
---
!com.braintribe.doc.meta.CustomFolderMetaData
files:

  ${context.overviewFile}:
    displayTitle: "Overview"
    priority: -200


<#if request.serviceProcessorSample>
  ${context.serviceDomainFile}:
    displayTitle: "${context.nameBasePascal} Service Domain"
    priority: -190

</#if>
