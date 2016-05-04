package com.BCAA.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Optimus
 *
 */
public enum InputType {
	TEXT_BOX("textBox"), DROPDOWN("dropDown"), CHECK_CHECKBOX("checkCheckBox"), UNCHECK_CHECKBOX(
			"uncheckCheckBox"), RADIOBUTTON("radioButton"), BUTTON("button");

	private String value;

	private static Map<String, InputType> lookup = new HashMap<String, InputType>();

	static {
		for (InputType inputType : InputType.values()) {
			lookup.put(inputType.getValue(), inputType);
		}
	}

	/**
	 * assigning the enum value
	 */
	InputType(String value) {
		this.value = value;
	}

	/**
	 * This method is used to get the enum value
	 * 
	 * @return the enum value
	 */
	public String getValue() {
		return value;
	}

	public static InputType getKey(String value) {
		return lookup.get(value);
	}

}
