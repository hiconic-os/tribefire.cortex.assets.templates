${template.relocate('src/index.js')}
<#assign pascalCaseArtifactId=support.toPascalCase(request.artifactId, '-')/>
class ${pascalCaseArtifactId}Contract extends $tf.module.TribefireUxModuleContract {
    
    createComponent(context, denotation) {
        // TODO instantiate your ux component (according to the denotation) and return it here
    }

}

export let contract = new ${pascalCaseArtifactId}Contract();