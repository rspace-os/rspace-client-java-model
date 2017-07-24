/**
 * RSpace API
 * Access your RSpace documents programmatically.   All requests require authentication using an API key set as the value of the header `RSpace-API-Key`. 
 *
 * OpenAPI spec version: 0.1
 * Contact: support@researchspace.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.researchspace.api.clientmodel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * A field in a Document, with a list of attached Files
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@ToString(callSuper = true, of={ "type", "lastModified"})
public class Field extends IdentifiableNameable {

    private TypeEnum type = null;
    private String content = null;
    private Date lastModified = null;
    private List<ApiFile> files = new ArrayList<>();

    /**
     * The data type of this field
     */
    public enum TypeEnum {
       
       STRING("string"),
        TEXT("text"),
        CHOICE("choice"),
        RADIO("radio"),
        DATE("date"),
        NUMBER("number"),
        TIME("time");

        private String value;

        TypeEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
    
}
