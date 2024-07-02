// ============================================================================
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// ============================================================================
package tribefire.cortex.assets.templates.model;

import com.braintribe.devrock.templates.model.ArtifactTemplateRequest;
import com.braintribe.model.generic.annotation.Initializer;
import com.braintribe.model.generic.annotation.meta.Alias;
import com.braintribe.model.generic.annotation.meta.Description;
import com.braintribe.model.generic.annotation.meta.Mandatory;
import com.braintribe.model.generic.annotation.meta.PositionalArguments;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

@Description("Creates a module project containing commonly used artifacts.")
@PositionalArguments({"name", "version", "buildSystem", "ide", "sourceControl"})
public interface CreateModuleProject extends ArtifactTemplateRequest {

	EntityType<CreateModuleProject> T = EntityTypes.T(CreateModuleProject.class);
	
	@Description("The name of the project. The name will be used as the prefix of the artifact ids.")
	@Alias("n")
	@Mandatory
	String getName();
	void setName(String name);
	
	@Description("The group id of the project.")
	@Alias("gid")
	@Initializer("'${support.getFileName(request.installationPath)}'")
	String getGroupId();
	void setGroupId(String groupId);

	@Description("The initial version of the artifacts in the project.")
	@Alias("v")
	@Initializer("'1.0'")
	String getVersion();
	void setVersion(String version);
	
	@Description("Specifies the targeted TF platform the module project is created for. Currently only 'web' is available.")
	@Alias("p")
	@Initializer("'web'")
	String getPlatform();
	void setPlatform(String platform);
	
	@Description("The build system used in the project. Currently available options are 'bt-ant' and 'maven'.")
	@Alias("bs")
	@Initializer("'bt-ant'")
	String getBuildSystem();
	void setBuildSystem(String buildSystem);
	
	@Description("The IDE to create project metadata for. Currently only 'eclipse' is available.")
	@Initializer("'eclipse'")
	String getIde();
	void setIde(String ide);
	
	@Description("The source control to create project configuration for. Currently only 'git' is available.")
	@Alias("sc")
	@Initializer("'git'")
	String getSourceControl();
	void setSourceControl(String sourceControl);
	
	@Override
	default String template() {
		return "tribefire.cortex.assets.templates:module-project-template#2.0";
	}

}
