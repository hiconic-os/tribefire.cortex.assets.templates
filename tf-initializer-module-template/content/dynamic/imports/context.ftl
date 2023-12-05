<#function relocation classFullName>
    <#return "src/${classFullName?replace('.', '/')}.java">
</#function>

<#assign _groupPackage = request.groupId?replace('-', '')>
<#assign artifactIdPascal = support.toPascalCase(request.artifactId, '-')>

<#assign nameBaseKebab = request.artifactId?remove_ending('-initializer')>
<#assign nameBaseSnake = nameBaseKebab?replace('-', '_')>
<#assign nameBasePascal = support.toPascalCase(nameBaseKebab, '-')>
<#assign nameBaseCamel = nameBasePascal?uncap_first>

<#assign basePackage = support.smartPackageName(_groupPackage, nameBaseSnake)>

<#assign initializerPackage = "${basePackage}.initializer">
<#assign initializerWireModulePackage = "${initializerPackage}.wire">
<#assign initializerContractPackage = "${initializerWireModulePackage}.contract">
<#assign initializerSpacePackage = "${initializerWireModulePackage}.space">

<#assign initializerSimple = "${nameBasePascal}Initializer">
<#assign initializerFull = "${initializerPackage}.${initializerSimple}">

<#assign initializerWireModuleSimple = "${artifactIdPascal}WireModule">
<#assign initializerWireModuleFull = "${initializerWireModulePackage}.${initializerWireModuleSimple}">

<#assign initializerContractSimple = "${artifactIdPascal}Contract">
<#assign initializerContractFull = "${initializerContractPackage}.${initializerContractSimple}">

<#assign lookupContractSimple = "${nameBasePascal}LookupContract">
<#assign lookupContractFull = "${initializerContractPackage}.${lookupContractSimple}">
<#assign lookupContractInstance = "${nameBaseCamel}Lookup">

<#assign envContractSimple = "${nameBasePascal}EnvContract">
<#assign envContractFull = "${initializerContractPackage}.${envContractSimple}">

<#assign initializerSpaceSimple = "${artifactIdPascal}Space">
<#assign initializerSpaceFull = "${initializerSpacePackage}.${initializerSpaceSimple}">

<#assign serviceDomainSpaceSimple = "${nameBasePascal}ServiceDomainSpace">
<#assign serviceDomainSpaceFull = "${initializerSpacePackage}.${serviceDomainSpaceSimple}">
<#assign serviceDomainSpaceInstance = "${nameBaseCamel}ServiceDomain">

<#assign apiModelArtifactReflectionSimple = "_${nameBasePascal}ApiModel_">
<#assign apiModelArtifactReflectionFull = "${_groupPackage}.${apiModelArtifactReflectionSimple}">
