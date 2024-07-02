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
import com.braintribe.model.generic.annotation.meta.Alias;
import com.braintribe.model.generic.annotation.meta.Description;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

@Description("Creates a model artifact.")
public interface CreateModel extends CreateArtifactWithSamples {

	EntityType<CreateModel> T = EntityTypes.T(CreateModel.class);
	
	@Description("Specifies whether or not the model is deployment model.")
	@Alias("d")
	boolean getDeployment();
	void setDeployment(boolean deployment);
	
	@Description("Specifies whether or not the model is api model.")
	@Alias("a")
	boolean getApi();
	void setApi(boolean api);

	@Override
	default String template() {
		return "tribefire.cortex.assets.templates:model-priming-template#2.0";
	}
	
}
