<#import '/imports/context.ftl' as context>
${template.relocate('HowToBuild.md')}
# How To Build

To project this markdown documentation to `HTML` we need two steps in the command line.

## Install this artifact locally with `ant`

In group folder:

```cli
> ant -Drange=[${request.artifactId}]
```

Alternatively, in the artifact folder:

```cli
> ant
```

## Project the installed artifact as `HTML` with `jinni`

**Command:** `package-platform-setup`

**Parameters:**
name | details
--- | ---
setupDependency | name of this artifact (`${request.groupId}:${request.artifactId}#${context.version}`)
packageBaseDir | target directory for the generated HTML files

**Example:**
```
jinni package-platform-setup --setupDependency ${request.groupId}:${request.artifactId}#${context.version} --packageBaseDir '${request.artifactId}-html' --noDocu false
```

**NOTE:** Goes without saying the target directory should probably be outside of your group folder, so it doesn't end up in your version control system (git). Unless you have a really good reason to do it.