/**
 * Teknei 2016
 */
package com.teknei.service.assembler;

import org.springframework.stereotype.Component;

import com.teknei.dto.SbopAcceSaliDTO;
import com.teknei.dto.SbopAsgnTurnDTO;
import com.teknei.dto.SbopContAcceDTO;
import com.teknei.dto.SbopRecaDTO;
import com.teknei.dto.SbopRecaDiviDTO;
import com.teknei.dto.SbopTranDTO;
import com.teknei.dto.SbopTranDiviDTO;
import com.teknei.dto.SbopTurnDTO;
import com.teknei.persistence.entities.disp.SbopAcceSali;
import com.teknei.persistence.entities.disp.SbopAsgnTurn;
import com.teknei.persistence.entities.disp.SbopContAcce;
import com.teknei.persistence.entities.disp.SbopReca;
import com.teknei.persistence.entities.disp.SbopRecaDivi;
import com.teknei.persistence.entities.disp.SbopTran;
import com.teknei.persistence.entities.disp.SbopTranDivi;
import com.teknei.persistence.entities.disp.SbopTurn;

/**
 * Factory assembler for business entities and DTO's
 * @author Jorge Amaro Coria
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Component
public class TKNAssembler {

	/**
	 * Returns {@code Assembler} for SbopTurn related classes
	 * @return the assembler built
	 */
	public Assembler<SbopTurnDTO, SbopTurn> getAssemblerSbopTurn() {
		return new Assembler<>(SbopTurnDTO.class, SbopTurn.class);
	}

	/**
	 * Returns {@code Assembler} for SbopAsgnTurn related classes
	 * @return the assembler built
	 */
	public Assembler<SbopAsgnTurnDTO, SbopAsgnTurn> getAssemblerSbopAsgnTurn() {
		return new Assembler<>(SbopAsgnTurnDTO.class, SbopAsgnTurn.class);
	}

	/**
	 * Returns {@code Assembler} for SbopAcceSali related classes
	 * @return the assembler built
	 */
	public Assembler<SbopAcceSaliDTO, SbopAcceSali> getAssemblerSbopAcceSali() {
		return new Assembler<>(SbopAcceSaliDTO.class, SbopAcceSali.class);
	}

	/**
	 * Returns {@code Assembler} for SbopTran related classes
	 * @return the assembler built
	 */
	public Assembler<SbopTranDTO, SbopTran> getAssemblerSbopTran() {
		return new Assembler<>(SbopTranDTO.class, SbopTran.class);
	}

	/**
	 * Returns {@code Assembler} for SbopTranDivi related classes
	 * @return the assembler built
	 */
	public Assembler<SbopTranDiviDTO, SbopTranDivi> getAssemblerSbopTranDivi() {
		return new Assembler<>(SbopTranDiviDTO.class, SbopTranDivi.class);
	}

	/**
	 * Returns {@code Assembler} for SbopReca related classes
	 * @return the assembler built
	 */
	public Assembler<SbopRecaDTO, SbopReca> getAssemblerSbopReca() {
		return new Assembler<>(SbopRecaDTO.class, SbopReca.class);
	}

	/**
	 * Returns {@code Assembler} for SbopRecaDivi related classes
	 * @return the assembler built
	 */
	public Assembler<SbopRecaDiviDTO, SbopRecaDivi> getAssemblerSbopRecaDivi() {
		return new Assembler<>(SbopRecaDiviDTO.class, SbopRecaDivi.class);
	}
	
	/**
	 * Returns {@code Assembler} for SbopContAcce related classes
	 * @return the assembler built
	 */
	public Assembler<SbopContAcceDTO, SbopContAcce> getAssemblerSbopContAcce() {
		return new Assembler<>(SbopContAcceDTO.class, SbopContAcce.class);
	}

}
