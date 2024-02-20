<#function relocation simpleFileName>
    <#return "src/${simpleFileName}">
</#function>

<#assign _groupPackage = request.groupId?replace('-', '')>
<#assign artifactIdPascal = support.toPascalCase(request.artifactId, '-')>
<#assign version = support.getDefaultArtifactVersion(request.buildSystem)>

<#assign nameBaseKebab = request.artifactId?remove_ending('-doc')>
<#assign nameBaseSnake = nameBaseKebab?replace('-', '_')>
<#assign nameBasePascal = support.toPascalCase(nameBaseKebab, '-')>
<#assign nameBaseCamel = nameBasePascal?uncap_first>

<#assign basePackage = support.smartPackageName(_groupPackage, nameBaseSnake)>

<#assign modelPackage = "${basePackage}.model">
<#assign modelDeploymentPackage = "${modelPackage}.deployment">
<#assign modelApiPackage = "${modelPackage}.api">
<#assign processingPackage = "${basePackage}.processing">

<#assign abstractRequestSimple = "${nameBasePascal}ServiceRequest">
<#assign abstractRequestFull = "${modelApiPackage}.${abstractRequestSimple}">

<#assign transformRequestSimple = "${nameBasePascal}TransformToUpperCase">
<#assign transformRequestFull = "${modelApiPackage}.${transformRequestSimple}">

<#assign overviewFile = "${nameBaseKebab}-overview.md">
<#assign serviceDomainFile = "${nameBaseKebab}-service-domain.md">
