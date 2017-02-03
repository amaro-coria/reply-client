package com.teknei.service.assembler;

import org.springframework.stereotype.Component;

import com.teknei.dto.SbopAcceSaliDTO;
import com.teknei.dto.SbopAsgnTurnDTO;
import com.teknei.dto.SbopTurnDTO;
import com.teknei.persistence.entities.disp.SbopAcceSali;
import com.teknei.persistence.entities.disp.SbopAsgnTurn;
import com.teknei.persistence.entities.disp.SbopTurn;

@Component
public class TKNAssembler {

	public Assembler<SbopTurnDTO, SbopTurn> getAssemblerSbopTurn() {
		return new Assembler<>(SbopTurnDTO.class, SbopTurn.class);
	}

	public Assembler<SbopAsgnTurnDTO, SbopAsgnTurn> getAssemblerSbopAsgnTurn() {
		return new Assembler<>(SbopAsgnTurnDTO.class, SbopAsgnTurn.class);
	}

	public Assembler<SbopAcceSaliDTO, SbopAcceSali> getAssemblerSbopAcceSali() {
		return new Assembler<>(SbopAcceSaliDTO.class, SbopAcceSali.class);
	}

}
