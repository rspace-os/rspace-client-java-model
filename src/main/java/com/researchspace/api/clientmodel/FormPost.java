package com.researchspace.api.clientmodel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.researchspace.api.jackson.ISO8601DateSerialiser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Singular;
/**
 * For constructing request bodies to create new forms or edit existing ones.
 * @author rspace
 *
 */
public class FormPost {	
	
	@Data
	@Builder
	public static class  Form {
		/**
		 * Optional, must be set for PUT requests
		 */
		private Long id;
		@NotNull
	    @Size(min=1)
		private String name;	
		private String tags;
		@Valid
		@Singular
		private List<FormFieldPost> fields ;
		/**
		 * 
		 * @param fieldToAdd the FormFieldPost
		 * @return <code>this</code> for method chaining
		 * @since 1.40
		 */
		public Form addField(FormFieldPost fieldToAdd) {
			this.fields.add(fieldToAdd);
			return this;
		}
	}
	
	@Data()
	@EqualsAndHashCode(callSuper=false)
	@AllArgsConstructor
	public static abstract class FormFieldPost {
		@Pattern(regexp="(Text)|(String)|(Number)|(Radio)|(Choice)|(Date)|(Time)", message="Please supply a supported 'type' property: "
				+ " was '${validatedValue}' but must match {regexp} ")
		@NotNull
		private String type;

		FormFieldPost(String type) {
			super();
			this.type = type;
		}
		
		private Long id;

		@NotNull
	    @Size(min=1)
		private String name;

		// utility method for radoio/choice
		@JsonIgnore
		String getOptionsStringFromList(List<String> optionsList) {
			List<String> optionParts = new ArrayList<>();
			for (String option : optionsList) {
				optionParts.add("fieldChoices=" + option);
			}
			String options = StringUtils.join(optionParts, "&");
			return options;
		}

		public FormFieldPost( String type, String name) {
			this.name = name;
			this.type = type;
		}
	}
	
	@Data()
	@EqualsAndHashCode(callSuper = false)
	public static class ChoiceFieldPost extends FormFieldPost {
	
		@Builder
		private ChoiceFieldPost(String name, boolean multipleChoice, List<String> options,  List<String> defaultOptions) {
			super("Choice", name);
			this.multipleChoice = multipleChoice;
			this.options = options;
			this.defaultOptions = defaultOptions;
		}

		private boolean multipleChoice;

		@Size(min = 1, message = "Please provide at least one option")
		private List<String> options = new ArrayList<>();
		
		private List<String> defaultOptions = new ArrayList<>();		
	}
	
	@Data()
	@EqualsAndHashCode(callSuper = false)
	public static class RadioFieldPost extends FormFieldPost {
		@Builder
		private RadioFieldPost(String name, boolean multipleChoice, List<String> options,  String defaultOption) {
			super("Radio", name);
			this.options = options;
			this.defaultOption = defaultOption;
		}

		@Size(min = 1, message = "Please provide at least one option")
		private List<String> options = new ArrayList<>();

		@Size(min=1)
		private String defaultOption;	
	}
	
	@Data()
	@EqualsAndHashCode(callSuper=false)
	public static  class TextFieldPost  extends FormFieldPost {
		@Builder
		private TextFieldPost(String name, boolean multipleChoice, List<String> options,  String defaultValue) {
			super("Text", name);
			this.defaultValue = defaultValue;
		}
		
		private String defaultValue = "";	
	}
	
	@Data()
	@EqualsAndHashCode(callSuper=false)	
	public static  class StringFieldPost  extends FormFieldPost {
		@Builder
		private StringFieldPost(String name,   String defaultValue) {
			super("String", name);
			this.defaultValue = defaultValue;
		}
		
		@Size(max=255)
		private String defaultValue = "";			
	}
	
	@Data()
	@EqualsAndHashCode(callSuper=false)
	public static  class DateFieldPost  extends FormFieldPost{
		@Builder
		private DateFieldPost(String name,   Date min, Date max, Date defaultValue) {
			super("Date", name);
			this.min = min ==null?null:new Date(min.getTime());
			this.max = max ==null?null:new Date(max.getTime());
			this.defaultValue = defaultValue ==null?null:new Date(defaultValue.getTime());
		}


		@JsonSerialize(using = ISO8601DateSerialiser.class)
		private Date defaultValue;

		@JsonSerialize(using = ISO8601DateSerialiser.class)
		private Date min;
		@JsonSerialize(using = ISO8601DateSerialiser.class)
		private Date max;	
	}
	
	@Data()
	@EqualsAndHashCode(callSuper=false)
	public static  class NumberFieldPost  extends FormFieldPost {
		@Builder
		private NumberFieldPost(String name,   Double min, Double max, Double defaultValue, Byte decimalPlaces) {
			super("Number", name);
			this.min = min;
			this.max = max;
			this.defaultValue = defaultValue;
			this.decimalPlaces = decimalPlaces;
		}
	
		private Double min;
		private Double max;
		@Min(0)
		private Byte decimalPlaces;
		// there is now no default default value, see RSPAC-65
		private Double defaultValue = null;				
	}

	@Data
	@EqualsAndHashCode(callSuper = false)
	public static class  TimeFieldPost extends FormFieldPost{
		private Long defaultValue;
		@Builder
		private TimeFieldPost(String name, Long defaultValue) {
			super("Time", name);
			this.defaultValue = defaultValue;
		}
	}
}
