<#-- We prefix helper variables (ONLY meant to be used in this file) with _, e.g. _groupPackage -->
<#function relocation classFullName>
    <#return "src/${classFullName?replace('.', '/')}.java">
</#function>

<#assign _groupPackage = request.groupId?replace('-', '')>


<#assign _aidSansModel = request.artifactId?remove_ending('-model')>
<#if request.api>
    <#assign nameBaseKebab = _aidSansModel?remove_ending('-api')>
<#elseif request.deployment>
    <#assign nameBaseKebab = _aidSansModel?remove_ending('-deployment')>
<#else>
    <#assign nameBaseKebab = _aidSansModel>
</#if>
<#assign nameBaseSnake = nameBaseKebab?replace('-', '_')>
<#assign nameBasePascal = support.toPascalCase(nameBaseKebab, '-')>

<#assign basePackage = "${support.smartPackageName(_groupPackage, nameBaseSnake)}">

<#assign modelPackage = "${basePackage}.model">
<#assign modelDeploymentPackage = "${modelPackage}.deployment">
<#assign modelApiPackage = "${modelPackage}.api">

<#if request.api>
    <#assign rootPackage = "${modelApiPackage}">
<#elseif request.deployment>
    <#assign rootPackage = "${modelDeploymentPackage}">
<#else>
    <#assign rootPackage = "${modelPackage}">
</#if>

<#assign packageRootPath = 'src/' + rootPackage?replace(".", "/")>


<#assign serviceProcessorSimple = "${nameBasePascal}ServiceProcessor">
<#assign serviceProcessorFull = "${modelDeploymentPackage}.${serviceProcessorSimple}">

<#assign abstractRequestSimple = "${nameBasePascal}ServiceRequest">
<#assign abstractRequestFull = "${modelApiPackage}.${abstractRequestSimple}">

<#assign transformRequestSimple = "${nameBasePascal}TransformToUpperCase">
<#assign transformRequestFull = "${modelApiPackage}.${transformRequestSimple}">
