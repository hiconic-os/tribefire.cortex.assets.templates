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

import com.braintribe.devrock.templates.model.artifact.CreateArtifact;
import com.braintribe.model.generic.annotation.Initializer;
import com.braintribe.model.generic.annotation.meta.Alias;
import com.braintribe.model.generic.annotation.meta.Description;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

@Description("Creates a manipulation-priming platform asset.")
public interface CreateManipulationPriming extends CreateArtifact, HasAccessIds {

	EntityType<CreateManipulationPriming> T = EntityTypes.T(CreateManipulationPriming.class);

	@Description("Specifies whether or not to include the data.man file in the projected artifact.")
	@Initializer("true")
	@Alias("id")
	boolean getIncludeData();
	void setIncludeData(boolean includeData);
	
	@Description("Specifies whether or not to include the model.man file in the projected artifact.")
	@Alias("im")
	boolean getIncludeModel();
	void setIncludeModel(boolean includeModel);
	
	@Override
	default String template() {
		return "tribefire.cortex.assets.templates:manipulation-priming-template#2.0";
	}
	
}
