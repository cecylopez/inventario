package org.inventario.data;

import lombok.ToString;

@ToString
public class Status {
	private char code;
	public void setCode(char code) {
		this.code = code;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private String description;
}
