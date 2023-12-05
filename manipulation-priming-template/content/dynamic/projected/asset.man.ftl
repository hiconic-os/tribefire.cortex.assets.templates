$nature = !com.braintribe.model.asset.natures.ManipulationPriming()
<#if request.accessIds?has_content>
.accessId = '${request.accessIds[0]}' <#-- --accessId property is deprecated, but this is a workaround only in case of manipulation-priming -->
</#if>
