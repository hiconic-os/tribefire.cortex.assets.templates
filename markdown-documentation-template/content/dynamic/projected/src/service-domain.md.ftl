<#if !request.serviceProcessorSample>
    ${template.ignore()}
</#if>
<#import '/imports/context.ftl' as context>
${template.relocate(context.relocation(context.serviceDomainFile))}
# ${context.nameBasePascal} Service Domain

Base Request Type: `${context.abstractRequestSimple}`

## ${context.transformRequestSimple}

Properties:

Name | Description
--- | ---
`text` | text to capitalize

### Description
Converts given text to uppercase.

### Error handling

Error | Reason
--- | ---
`text` is null or empty | `InvalidArgument`


