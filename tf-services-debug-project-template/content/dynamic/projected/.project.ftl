<?xml version="1.0" encoding="UTF-8"?>
<projectDescription>
	<name>${request.artifactId} - ${request.groupId}</name>
	<comment></comment>
	<projects>
	</projects>
	<buildSpec>
		<buildCommand>
			<name>org.eclipse.jdt.core.javabuilder</name>
			<arguments/>
		</buildCommand>
		<buildCommand>
			<name>com.braintribe.devrock.dmb.builder.DebugModuleBuilder</name>
			<arguments>
			</arguments>
		</buildCommand>
	</buildSpec>
	<natures>
		<nature>com.braintribe.devrock.artifactcontainer.natures.TribefireServicesNature</nature>
		<nature>net.sf.eclipse.tomcat.tomcatnature</nature>
		<nature>org.eclipse.jdt.core.javanature</nature>
	</natures>
</projectDescription>
