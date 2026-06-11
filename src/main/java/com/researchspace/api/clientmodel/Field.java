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
