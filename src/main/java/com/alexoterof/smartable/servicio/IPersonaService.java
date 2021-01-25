package com.alexoterof.smartable.servicio;

import com.alexoterof.smartable.dto.input.PersonaInputDto;
import com.alexoterof.smartable.dto.response.PersonaDto;

public interface IPersonaService {
	public Iterable<PersonaDto> findAll();
	public PersonaDto findById(Long id);
	public PersonaDto createOrUpdate(PersonaInputDto input);
	public void deleteById(Long id);
}
