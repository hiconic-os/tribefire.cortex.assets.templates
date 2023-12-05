<#if !request.gwtSupport>
	${static.createDir('src/' + request.groupId?replace('.', '/')?replace('-', '') + '/model/api')}
</#if>