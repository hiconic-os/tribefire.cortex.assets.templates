$nature = !com.braintribe.model.asset.natures.PrimingModule()
<#if request.accessIds?has_content>
.accessIds = (<#list request.accessIds as accessId>'${accessId}'<#if !accessId?is_last>, </#if></#list>)
</#if>
