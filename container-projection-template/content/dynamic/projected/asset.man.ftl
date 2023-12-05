ContainerProjection = com.braintribe.model.asset.natures.ContainerProjection

$nature = ContainerProjection()
<#if request.containerName??>
.containerName = '${request.containerName}'
<#else>
.containerName = '${request.artifactId}'
</#if>