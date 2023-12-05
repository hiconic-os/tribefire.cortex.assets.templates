<#if !request.hasSample()>
    ${template.ignore()}
</#if>
<#import '/imports/context.ftl' as context>
${template.relocate(context.relocation(context.overviewFile))}
# ${context.nameBasePascal} Overview 

<#if request.serviceProcessorSample>
## ${context.nameBasePascal} Service Domain

Request: `${context.abstractRequestSimple}`

**[read more...](${context.serviceDomainFile})**

</#if>