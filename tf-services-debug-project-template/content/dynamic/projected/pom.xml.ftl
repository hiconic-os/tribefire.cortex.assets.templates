<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>${request.groupId}</groupId>
	<artifactId>${request.artifactId}</artifactId>
	<version>${request.version}</version>

	<dependencies>
<#list request.dependencies as dependency>
		${dependency}    
</#list>

		<dependency><groupId>javax.servlet</groupId><artifactId>javax.servlet-api</artifactId><version>3.0.1</version><scope>provided</scope></dependency>
		<dependency><groupId>javax.websocket</groupId><artifactId>javax.websocket-api</artifactId><version>1.1</version><scope>provided</scope></dependency>
	</dependencies>
</project>





