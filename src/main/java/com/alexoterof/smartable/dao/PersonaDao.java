package com.alexoterof.smartable.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexoterof.smartable.modelo.Persona;

public interface PersonaDao extends JpaRepository<Persona, Long>{

}
