/**
 * Teknei 2016
 */
package com.teknei.service.assembler;

import org.springframework.stereotype.Component;

import com.teknei.dto.CaupTranDTO;
import com.teknei.dto.SbopAcceSaliDTO;
import com.teknei.dto.SbopAsgnTurnDTO;
import com.teknei.dto.SbopContAcceDTO;
import com.teknei.dto.SbopContReplDTO;
import com.teknei.dto.SbopRecaDTO;
import com.teknei.dto.SbopRecaDiviDTO;
import com.teknei.dto.SbopTranDTO;
import com.teknei.dto.SbopTranDiviDTO;
import com.teknei.dto.SbopTurnDTO;
import com.teknei.dto.SfmoHistReceNaveDTO;
import com.teknei.dto.SfopEquiAlarDTO;
import com.teknei.dto.SfopMsgCondDTO;
import com.teknei.dto.SfruAsgnDTO;
import com.teknei.dto.SfvhDataDiaDTO;
import com.teknei.persistence.entities.disp.CaupTran;
import com.teknei.persistence.entities.disp.SbopAcceSali;
import com.teknei.persistence.entities.disp.SbopAsgnTurn;
import com.teknei.persistence.entities.disp.SbopContAcce;
import com.teknei.persistence.entities.disp.SbopContRepl;
import com.teknei.persistence.entities.disp.SbopReca;
import com.teknei.persistence.entities.disp.SbopRecaDivi;
import com.teknei.persistence.entities.disp.SbopTran;
import com.teknei.persistence.entities.disp.SbopTranDivi;
import com.teknei.persistence.entities.disp.SbopTurn;
import com.teknei.persistence.entities.disp.SfmoHistReceNave;
import com.teknei.persistence.entities.disp.SfopEquiAlar;
import com.teknei.persistence.entities.disp.SfopMsgCond;
import com.teknei.persistence.entities.disp.SfruAsgn;
import com.teknei.persistence.entities.disp.SfvhDataDia;

/**
 * Factory assembler for business entities and DTO's
 * 
 * @author Jorge Amaro Coria
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Component
public class TKNAssembler {

	/**
	 * Returns {@code Assembler} for SbopTurn related classes
	 * 
	 * @return the assembler built
	 */
	public Assembler<SbopTurnDTO, SbopTurn> getAssemblerSbopTurn() {
		return new Assembler<>(SbopTurnDTO.class, SbopTurn.class);
	}

	/**
	 * Returns {@code Assembler} for SbopAsgnTurn related classes
	 * 
	 * @return the assembler built
	 */
	public Assembler<SbopAsgnTurnDTO, SbopAsgnTurn> getAssemblerSbopAsgnTurn() {
		return new Assembler<>(SbopAsgnTurnDTO.class, SbopAsgnTurn.class);
	}

	/**
	 * Returns {@code Assembler} for SbopAcceSali related classes
	 * 
	 * @return the assembler built
	 */
	public Assembler<SbopAcceSaliDTO, SbopAcceSali> getAssemblerSbopAcceSali() {
		return new Assembler<>(SbopAcceSaliDTO.class, SbopAcceSali.class);
	}

	/**
	 * Returns {@code Assembler} for SbopTran related classes
	 * 
	 * @return the assembler built
	 */
	public Assembler<SbopTranDTO, SbopTran> getAssemblerSbopTran() {
		return new Assembler<>(SbopTranDTO.class, SbopTran.class);
	}

	/**
	 * Returns {@code Assembler} for SbopTranDivi related classes
	 * 
	 * @return the assembler built
	 */
	public Assembler<SbopTranDiviDTO, SbopTranDivi> getAssemblerSbopTranDivi() {
		return new Assembler<>(SbopTranDiviDTO.class, SbopTranDivi.class);
	}

	/**
	 * Returns {@code Assembler} for SbopReca related classes
	 * 
	 * @return the assembler built
	 */
	public Assembler<SbopRecaDTO, SbopReca> getAssemblerSbopReca() {
		return new Assembler<>(SbopRecaDTO.class, SbopReca.class);
	}

	/**
	 * Returns {@code Assembler} for SbopRecaDivi related classes
	 * 
	 * @return the assembler built
	 */
	public Assembler<SbopRecaDiviDTO, SbopRecaDivi> getAssemblerSbopRecaDivi() {
		return new Assembler<>(SbopRecaDiviDTO.class, SbopRecaDivi.class);
	}

	/**
	 * Returns {@code Assembler} for SbopContAcce related classes
	 * 
	 * @return the assembler built
	 */
	public Assembler<SbopContAcceDTO, SbopContAcce> getAssemblerSbopContAcce() {
		return new Assembler<>(SbopContAcceDTO.class, SbopContAcce.class);
	}

	/**
	 * Returns {@code Assembler} for SfopEquiAlar related classes
	 * 
	 * @return the assembler built
	 */
	public Assembler<SfopEquiAlarDTO, SfopEquiAlar> getAssemblerSfopEquiAlar() {
		return new Assembler<>(SfopEquiAlarDTO.class, SfopEquiAlar.class);
	}

	/**
	 * Returns {@code Assembler} for SfopMsgCond related classes
	 * 
	 * @return the assembler built
	 */
	public Assembler<SfopMsgCondDTO, SfopMsgCond> getAssemblerSfopMsgCond() {
		return new Assembler<>(SfopMsgCondDTO.class, SfopMsgCond.class);
	}

	/**
	 * Returns {@code Assembler} for SfruAsgn related classes
	 * 
	 * @return the assembler built
	 */
	public Assembler<SfruAsgnDTO, SfruAsgn> getAssemblerSfruAsgn() {
		return new Assembler<>(SfruAsgnDTO.class, SfruAsgn.class);
	}

	/**
	 * Returns {@code Assembler} for SfruAsgn related classes
	 * 
	 * @return the assembler built
	 */
	public Assembler<SfvhDataDiaDTO, SfvhDataDia> getAssemblerSfvhDataDia() {
		return new Assembler<>(SfvhDataDiaDTO.class, SfvhDataDia.class);
	}
	
	/**
	 * Returns {@code Assembler} for SfmoHistReceNave related classes
	 * 
	 * @return the assembler built
	 */
	public Assembler<SfmoHistReceNaveDTO, SfmoHistReceNave> getAssemblerSfmoHistReceNave() {
		return new Assembler<>(SfmoHistReceNaveDTO.class, SfmoHistReceNave.class);
	}
	
	/**
	 * Returns {@code Assembler} for CaupTran related classes
	 * 
	 * @return the assembler built
	 */
	public Assembler<CaupTranDTO, CaupTran> getAssemblerCaupTran() {
		return new Assembler<>(CaupTranDTO.class, CaupTran.class);
	}
	
	/**
	 * Returns {@code Assembler} for SbopContRepl related classes
	 * 
	 * @return the assembler built
	 */
	public Assembler<SbopContReplDTO, SbopContRepl> getAssemblerContRepl(){
		return new Assembler<>(SbopContReplDTO.class, SbopContRepl.class);
	}

}
