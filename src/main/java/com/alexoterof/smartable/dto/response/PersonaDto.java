package com.alexoterof.smartable.dto.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class PersonaDto implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -5091084665062761834L;

	private Long id;
	
	private String fullname;
	
	private String username;
	
	private String email; 
	
	private String cargo;
	
	private boolean xhoras;
	
}
