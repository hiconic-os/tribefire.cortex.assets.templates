<#-- We prefix helper variables (ONLY meant to be used in this file) with _, e.g. _groupPackage -->
<#function relocation classFullName>
    <#return "src/${classFullName?replace('.', '/')}.java">
</#function>

<#assign _groupPackage = request.groupId?replace("-", "")>
<#assign _artifactIdPascal = support.toPascalCase(request.artifactId, '-')>

<#assign nameBaseKebab = request.artifactId?remove_ending("-module")>
<#assign nameBaseSnake = nameBaseKebab?replace("-", "_")>
<#assign nameBasePascal = support.toPascalCase(nameBaseKebab, '-')>
<#assign nameBaseCamel = nameBasePascal?uncap_first>

<#assign basePackage = "${support.smartPackageName(_groupPackage, nameBaseSnake)}">

<#assign wirePackage = "${basePackage}.wire">
<#assign spacePackage = "${wirePackage}.space">
<#assign modelPackage = "${basePackage}.model">
<#assign modelDeploymentPackage = "${modelPackage}.deployment">
<#assign modelApiPackage = "${modelPackage}.api">
<#assign processingPackage = "${basePackage}.processing">

<#assign wireModuleSimple = "${_artifactIdPascal}WireModule">
<#assign wireModuleFull = "${wirePackage}.${wireModuleSimple}">

<#assign spaceSimple = "${_artifactIdPascal}Space">
<#assign spaceFull = "${spacePackage}.${spaceSimple}">

<#assign serviceProcessorSimple = "${nameBasePascal}ServiceProcessor">
<#assign serviceProcessorFull = "${modelDeploymentPackage}.${serviceProcessorSimple}">
<#assign requestProcessorSimple = "${nameBasePascal}RequestProcessor">
<#assign requestProcessorFull = "${processingPackage}.${requestProcessorSimple}">
<#assign requestProcessorMethod = "${nameBaseCamel}RequestProcessor">
