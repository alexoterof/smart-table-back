package com.alexoterof.smartable.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String fullname;
	
	private String username;
	
	private String email;
	
	private String cargo;
	
	private boolean xhoras;
	
	public Persona() {
		super();
	}

	public Persona(String fullname, String username, String email, String cargo, boolean xhoras) {
		super();
		this.fullname = fullname;
		this.username = username;
		this.email = email;
		this.cargo = cargo;
		this.xhoras = xhoras;
	}
}
