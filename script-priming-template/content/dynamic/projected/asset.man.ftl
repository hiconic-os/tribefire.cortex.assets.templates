ScriptPriming = com.braintribe.model.asset.natures.ScriptPriming

$nature = ScriptPriming()
<#if request.accessIds?has_content>
.accessIds = (<#list request.accessIds as accessId>'${accessId}'<#if !accessId?is_last>, </#if></#list>)
</#if>
