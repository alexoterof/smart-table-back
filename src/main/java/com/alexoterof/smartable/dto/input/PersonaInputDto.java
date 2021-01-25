package com.alexoterof.smartable.dto.input;

import java.io.Serializable;

import lombok.Data;

@Data
public class PersonaInputDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6940991131895454383L;

	private Long id;
	
	private String fullname;
	
	private String username;
	
	private String email; 
	
	private String cargo;
	
	private boolean xhoras;
}
