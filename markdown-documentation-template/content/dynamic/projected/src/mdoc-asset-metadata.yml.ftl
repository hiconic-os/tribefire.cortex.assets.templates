<#if !request.hasSample()>
    ${template.ignore()}
</#if>
<#import '/imports/context.ftl' as context>
${template.relocate(context.relocation('mdoc-asset-metadata.yml'))}
---
!com.braintribe.doc.meta.CustomAssetMetaData
hidden: false
displayTitle: "${context.nameBasePascal}"
shortDescription: "Documentation of all things ${context.nameBaseKebab}."
