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

import com.braintribe.devrock.templates.model.artifact.CreateArtifactWithSamples;
import com.braintribe.model.generic.annotation.Initializer;
import com.braintribe.model.generic.annotation.meta.Alias;
import com.braintribe.model.generic.annotation.meta.Description;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

@Description("Creates a Tribefire module.")
public interface CreateModule extends CreateArtifactWithSamples {

	EntityType<CreateModule> T = EntityTypes.T(CreateModule.class);

	@Description("Specifies the targeted TF platform the projected module is created for. Currently only 'web' is available.")
	@Alias("p")
	@Initializer("'web'")
	String getPlatform();
	void setPlatform(String platform);

	@Description("Specifies whether to include hints as comments in the code.")
	boolean getSuppressComments();
	void setSuppressComments(boolean suppressComments);

	@Override
	default String template() {
		return "tribefire.cortex.assets.templates:tf-module-template#2.0";
	}

}
