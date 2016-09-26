package org.dgac.app.web.bean;
import java.util.ArrayList;
import java.util.List;

import org.dgac.app.web.enumsSubt21.RemuVarEnum;


public class RemuServiceImpl implements RemuService {

	@Override
	public List<RemuVariables> getVariablesRemuPorCod(String codRemu) {
		
		RemuVarEnum rv= RemuVarEnum.remuVariableEnumByCod(codRemu);
		switch(rv){
		
				
		case SUELDO:{
			return getListaSueldo();
			
		}
		case BENEF_MODER:{
			return getListaBenefModer();
			
		}
		case GRADO_EFECTIVO:{
			return getListaGradoEfec();
			
		}
		case CRECIM_VEGE:{
			return getListaCrecimVeg();
			
		}
		case HORAS_EXTRAS:{
			return getListaHorasExtras();
			
		}
		case ESP_NOCIV_PELI:{
			return getListaEspNocivPeli();
			
		}
		case MAQUINA:{
			return getListaMaquina();
			
		}
		case BONOS:{
			return getListaBonos();
			
		}
		case ISLA_DE_PASCUA:{
			return getListaIslaPascua();
			
		}
		
		case ZONA_EXTREMA:{
			return getListaZonaExtrema();
			
		}
		case ANTARTICA:{
			return getListaAntartica();
			
		}
		case HONORARIOS:{
			return getListaHonorarios();
			
		}
		case HORAS_PROFE_ETA:{
			return getListaHorasProfeEta();
			
		}
		case MEDICOS:{
			return getListaMedicos();
			
		}
		case TODAS :{
			return getListaTodas();		
			      
		}
					
		default:
			return new ArrayList<RemuVariables>();
		}
	}
	



	private List<RemuVariables> getListaTodas() {
		List<RemuVariables> unidadTodas = new ArrayList<RemuVariables>();
		
		//unidadTodas.add(new RemuVariables("0","TODAS"));
		unidadTodas.addAll(getListaSueldo());
		unidadTodas.addAll(getListaBenefModer());
		unidadTodas.addAll(getListaGradoEfec());
		unidadTodas.addAll(getListaCrecimVeg());
		unidadTodas.addAll(getListaHorasExtras());
		unidadTodas.addAll(getListaEspNocivPeli());
		unidadTodas.addAll(getListaMaquina());
		unidadTodas.addAll(getListaBonos());
		unidadTodas.addAll(getListaIslaPascua());
		unidadTodas.addAll(getListaZonaExtrema());
		unidadTodas.addAll(getListaAntartica());
		unidadTodas.addAll(getListaHonorarios());
		unidadTodas.addAll(getListaHorasProfeEta());
		unidadTodas.addAll(getListaMedicos());
		return unidadTodas;
	}
	
	private List<RemuVariables> getListaZonaExtrema() {
		List<RemuVariables>remuZonaExtrema= new ArrayList<RemuVariables>();
		remuZonaExtrema.add(new RemuVariables("HCGIMPZEX","BONIFICACION IMPONIBILIDAD ZONA EXTREMA CONTRATA GLOBAL"));
		remuZonaExtrema.add(new RemuVariables("HCGZONEX","BONIFICACION ZONA EXTREMA CONTRATA GLOBAL"));
		remuZonaExtrema.add(new RemuVariables("HCSIMPZEX","BONIFICACION IMPONIBILIDAD ZONA EXTREMA CONTRATA SIMPLE"));
		remuZonaExtrema.add(new RemuVariables("HCSZONEX","BONIFICACION ZONA EXTREMA CONTRATA SIMPLE"));
		remuZonaExtrema.add(new RemuVariables("HPAIMPZEX","BONIFICACION IMPONIBILIDAD ZONA EXTREMA P.A.S.M"));
		remuZonaExtrema.add(new RemuVariables("HPAZONEX","BONIFICACION ZONA EXTREMA P.A.S.M"));
		remuZonaExtrema.add(new RemuVariables("HPTIMPZEX","BONIFICACION IMPONIBILIDAD ZONA EXTREMA PLANTA"));
		remuZonaExtrema.add(new RemuVariables("HPTZONEX","BONIFICACION ZONA EXTREMA PLANTA"));
		return remuZonaExtrema;
	}





	private List<RemuVariables> getListaSueldo() {
		List<RemuVariables> remuSueldo = new ArrayList<RemuVariables>();
				remuSueldo.add(new RemuVariables("ADPUBLIC","ASIGNACION ALTA DIRECCION PUBLICA"));
				remuSueldo.add(new RemuVariables("AF","ASIGNACION FAMILIAR NMAL"));
				remuSueldo.add(new RemuVariables("DEVLICME","DEVOLUCION LICENCIA MEDICA"));
				remuSueldo.add(new RemuVariables("HCGAERO","ASIGNACION AERONAUTICA CONTRATA GLOBAL"));
				remuSueldo.add(new RemuVariables("HCGAGEI","ASIGNACION DE ESPECIALIDAD AL GRADO EFECTIVO TECNICO CONTRATA GLOBAL"));
				remuSueldo.add(new RemuVariables("HCGBASE","SUELDO BASE CONTRATA GLOBAL"));
				remuSueldo.add(new RemuVariables("HCGBONO","BONO ESPECIAL CONTRATA GLOBAL"));
				remuSueldo.add(new RemuVariables("HCGCOMP","BONIFICACION COMPENSATIA CONTRATA GLOBAL"));
				remuSueldo.add(new RemuVariables("HCGDELTA","INCREMENTO LEY 19.261 CONTRATA GLOBAL"));
				remuSueldo.add(new RemuVariables("HCGMANDO","BONIFICACIÓN DE MANDO CONTRATA GLOBAL"));
				remuSueldo.add(new RemuVariables("HCGMOV1","ASIGNACION MOVILIZACIÓN CONTRATA GLOBAL"));
				remuSueldo.add(new RemuVariables("HCGPROI","ASIGNACION PROFESIONAL CONTRATA GLOBAL"));
				remuSueldo.add(new RemuVariables("HCGRAN1","ASIGNACION RANCHO CONTRATA GLOBAL"));
				remuSueldo.add(new RemuVariables("HCGSALU","BONIFICACION 4,5% DE SALUD CONTRATA GLOBAL"));
				remuSueldo.add(new RemuVariables("HCGSVUE","SOBRESUELDO DE VUELO PILOTOS  CONTRATO GLOBAL"));
				remuSueldo.add(new RemuVariables("HCGZONA","ASIGNACION ZONA CONTRATA GLOBAL"));
				remuSueldo.add(new RemuVariables("HCSAERO","ASIGNACION AERONAUTICA  CONTRATA SIMPLE"));
				remuSueldo.add(new RemuVariables("HCSAGEI","ASIGNACION DE ESPECIALIDAD AL GRADO EFECTIVO TECNICO CONTRATA SIMPLE"));
				remuSueldo.add(new RemuVariables("HCSBASE","SUELDO BASE CONTRATA SIMPLE"));
				remuSueldo.add(new RemuVariables("HCSBONO","BONO ESPECIAL CONTRATA SIMPLE"));
				remuSueldo.add(new RemuVariables("HCSCAJA","ASIGNACION PERDIDA DE CAJA"));
				remuSueldo.add(new RemuVariables("HCSCOMP","BONIFICACION COMPENSATIA CONTRATA SIMPLE"));
				remuSueldo.add(new RemuVariables("HCSDELTA","INCREMENTO LEY 19261 CONTRATA SIMPLE"));
				remuSueldo.add(new RemuVariables("HCSESPE","BONO ESPECIAL 14% CONTRATA SIMPLE"));
				remuSueldo.add(new RemuVariables("HCGESPE","BONO ESPECIAL 14% CONTRATA GLOBAL"));
				remuSueldo.add(new RemuVariables("HCSGVUE","GRATIFICACION DE VUELO PILOTOS  CONTRATA SIMPLE"));
				remuSueldo.add(new RemuVariables("HCSMANDO","BONIFICACIÓN DE MANDO CONTRATA SIMPLE"));
				remuSueldo.add(new RemuVariables("HCSMOV1","ASIGNACION MOVILIZACION CONTRATA SIMPLE"));
				remuSueldo.add(new RemuVariables("HCSPROI","ASIGNACION PROFESIONAL CONTRATA SIMPLE"));
				remuSueldo.add(new RemuVariables("HCSRAN1","ASIGNACION RANCHO CONTRATA SIMPLE"));
				remuSueldo.add(new RemuVariables("HCSSALU","BONIFICACION 4,5% DE SALUD CONTRATA SIMPLE"));
				remuSueldo.add(new RemuVariables("HCSSVUE","SOBRESUELDO DE VUELO PILOTOS  CONTRATA SIMPLE"));
				remuSueldo.add(new RemuVariables("HCSZONA","ASIGNACION ZONA CONTRATA SIMPLE"));
				remuSueldo.add(new RemuVariables("HDIFNINT","HABERES RETROACTIVOS NO IMPONIBLES Y NO TRIBUTABLES"));
				remuSueldo.add(new RemuVariables("HPABASE","SUELDO BASE P.A.SM"));
				remuSueldo.add(new RemuVariables("HPABONO","BONO ESPECIAL P.A.S.M"));
				remuSueldo.add(new RemuVariables("HPAZONA","ASIGNACION ZONA PERSONAL ADMINISTRATIVO DE SERVICIOS MENES"));
				remuSueldo.add(new RemuVariables("HPTAERO","ASIGNACION AERONAUTICA  CONTRATA PLANTA"));
				remuSueldo.add(new RemuVariables("HPTAGEI","ASIGNACION DE ESPECIALIDAD AL GRADO EFECTIVO TECNICO CONTRATA PLANTA"));
				remuSueldo.add(new RemuVariables("HPTBASE","SUELDO BASE PLANTA"));
				remuSueldo.add(new RemuVariables("HPTBONO","BONO ESPECIAL PLANTA"));
				remuSueldo.add(new RemuVariables("HPTCASA","ASIGNACION DE CASA"));
				remuSueldo.add(new RemuVariables("HPTCOMP","BONIFICACION COMPENSATIA PLANTA"));
				remuSueldo.add(new RemuVariables("HPTDELTA","INCREMENTO LEY 19.261 PLANTA"));
				remuSueldo.add(new RemuVariables("HPTESPE","BONO ESPECIAL 14% PLANTA"));
				remuSueldo.add(new RemuVariables("HPTGVUE","GRATIFICACION DEVUELO PILOTOS  CONTRATO GLOBAL"));
				remuSueldo.add(new RemuVariables("HPTMANDO","BONIFICACIÓN DE MANDO PLANTA"));
				remuSueldo.add(new RemuVariables("HPTMOV1","ASIGNACION MOVILIZACION PLANTA"));
				remuSueldo.add(new RemuVariables("HPTPROI","ASIGNACION PROFESIONAL PLANTA"));
				remuSueldo.add(new RemuVariables("HPTRAN1","ASIGNACION RANCHO PLANTA"));
				remuSueldo.add(new RemuVariables("HPTRES1","ANTICIPO CAMBIO DE RESIDENCIA"));
				remuSueldo.add(new RemuVariables("HPTRES2","ASIGNACION POR CAMBIO RESIDENCIA"));
				remuSueldo.add(new RemuVariables("HPTRES3","ASIGNACION POR CAMBIO RESIDENCIA 25%"));
				remuSueldo.add(new RemuVariables("HPTSALU","BONIFICACION 4,5% DE SALUD PLANTA"));
				remuSueldo.add(new RemuVariables("HPTSVUE","SOBRESUELDO DEVUELO PILOTOS  CONTRATO GLOBAL"));
				remuSueldo.add(new RemuVariables("HPTZONA","ASIGNACION ZONA PLANTA"));
				remuSueldo.add(new RemuVariables("PASMESP","ASIGNACION ESPECIAL PASM"));
				remuSueldo.add(new RemuVariables("VUELONIM","SOBRESUELDO DE VUELO PILOTOS NO IMPONIBLE"));
				
				return remuSueldo;
	}
	private List<RemuVariables> getListaBenefModer() {
		List<RemuVariables> remuBenefModer = new ArrayList<RemuVariables>();
		remuBenefModer.add(new RemuVariables("HCGDCOLE","INCREMENTO COLECTIVO CONTRATA GLOBAL"));
		remuBenefModer.add(new RemuVariables("HCGIMPMO","BONIFICACION IMPONIBLE ASIGNACION DE MODERNIZACION CONTRATA GLOBAL"));
		remuBenefModer.add(new RemuVariables("HCGININS","INCREMENTO INSITUCIONAL DE MODERNICACION CONTRATA GLOBAL"));
		remuBenefModer.add(new RemuVariables("HCGMODE","COMPONENTE BASE MODERNIZACION CONTRATA GLOBAL"));
		remuBenefModer.add(new RemuVariables("HCSDCOLE","INCREMENTO COLECTIVO CONTRATA SIMPLE"));
		remuBenefModer.add(new RemuVariables("HCSIMPMO","BONIFICACION IMPONIBLE ASIGNACION DE MODERNIZACION CONTRATA SIMPLE"));
		remuBenefModer.add(new RemuVariables("HCSININS","INCREMENTO INSTITUCIONAL DE MODERNIZACION CONTRATA SIMPLE"));
		remuBenefModer.add(new RemuVariables("HCSMODE","COMPONENTE BASE MODERNIZACION CONTRATA SIMPLE"));
		remuBenefModer.add(new RemuVariables("HMCDESB","COMPONENTE BASE DE DESEMPEÑO CONTRATA MEDICO"));
		remuBenefModer.add(new RemuVariables("HMCDESV","COMPONENTE VARIABLE DE DESEMPEÑO CONTRATA MEDICO"));
		remuBenefModer.add(new RemuVariables("HMCIMPD","BONIFICACION IMPONIBLE DESEMPEÑO MEDICO CONTRATA"));
		remuBenefModer.add(new RemuVariables("HMPDESB","COMPONENTE BASE DE DESEMPEÑO PLANTA MEDICO"));
		remuBenefModer.add(new RemuVariables("HMPDESV","COMPONENTE VARIABLE DE DESEMPEÑO PLANTA MEDICO"));
		remuBenefModer.add(new RemuVariables("HMPIMPD","BONO IMPONIBLE DESEMPEÑO"));
		remuBenefModer.add(new RemuVariables("HPADCOLE","INCREMENTO COLECTIVO P.A.S.M"));
		remuBenefModer.add(new RemuVariables("HPAIMPMO","BONIFICACION IMPONIBLE ASIGNACION DE MODERNIZACION CONTRATA P.A.S.M"));
		remuBenefModer.add(new RemuVariables("HPAININS","INCREMENTO INSTITUCIONAL DE MODERNIZACION P.A.S.M"));
		remuBenefModer.add(new RemuVariables("HPAMODE","COMPONENTE BASE MODERNIZACION P.A.S.M"));
		remuBenefModer.add(new RemuVariables("HPCIMPMO","BONIFICACION IMPONIBLE ASIGNACION DE MODERNIZACION PROFESOR CON TITULO"));
		remuBenefModer.add(new RemuVariables("HPCININS","INCREMENTO INSTITUCIONAL MODERNIZACION PROFESOR CON TITULO"));
		remuBenefModer.add(new RemuVariables("HPCMODE","COMPONENTE BASE MODERNIZACION PROFES"));
		remuBenefModer.add(new RemuVariables("HPTDCOLE","INCREMENTO COLECTIVO PLANTA"));
		remuBenefModer.add(new RemuVariables("HPTIMPMO","BONIFICACION IMPONIBLE ASIGNACION DE MODERNIZACION PLANTA"));
		remuBenefModer.add(new RemuVariables("HPTININS","INCREMENTO INSITUCIONAL DE MODERNICACION PLANTA"));
		remuBenefModer.add(new RemuVariables("HPTMODE","COMPONENTE BASE MODERNIZACION PLANTA"));
		return remuBenefModer;
		
	}
	private List<RemuVariables> getListaGradoEfec() {
		List<RemuVariables>remuGradoEfec= new ArrayList<RemuVariables>();
		remuGradoEfec.add(new RemuVariables("HCGPGEI","ASIGNACION DE ESPECIALIDAD AL GRADO EFECTIVO PROFESIONAL CONTRATA GLOBAL"));
		remuGradoEfec.add(new RemuVariables("HCSPGEI","ASIGNACION DE ESPECIALIDAD AL GRADO EFECTIVO PROFESIONAL CONTRATA SIMPLE"));
		remuGradoEfec.add(new RemuVariables("HCSSUPGF","PLANILLA SUPLEMENTARIA GRADO EFECTIVO CONTRATA SIMPLE"));
		remuGradoEfec.add(new RemuVariables("HPTPGEI","ASIGNACION DE ESPECIALIDAD AL GRADO EFECTIVO PROFESIONAL PLANTA"));
		remuGradoEfec.add(new RemuVariables("HPTSUPGF","PLANILLA SUPLEMENTARIA GRADO EFECTIVO PLANTA"));
		remuGradoEfec.add(new RemuVariables("HPTSUPLE","PLANILLA SUPLEMENTARIA PLANTA"));
		return remuGradoEfec;
	}
	private List<RemuVariables> getListaCrecimVeg() {
		List<RemuVariables>remuCrecimVeg= new ArrayList<RemuVariables>();

		remuCrecimVeg.add(new RemuVariables("HCGBGEI","BONIFICACION GRADO EFECTIVO IMPONIBLE CONTRATA GLOBAL"));
		remuCrecimVeg.add(new RemuVariables("HPTBGEI","BONIFICACION GRADO EFECTIVO IMPONIBLE PLANTA"));
		remuCrecimVeg.add(new RemuVariables("HCGPERM","BONIFICACION PERMANENCIA CONTRATA GLOBAL"));
		remuCrecimVeg.add(new RemuVariables("HCGTRIE","TRIENIOS CONTRATA GLOBAL"));
		remuCrecimVeg.add(new RemuVariables("HCSBGEI","BONIFICACION GRADO EFECTIVO IMPONIBLE CONTRATA SIMPLE"));
		remuCrecimVeg.add(new RemuVariables("HCSTRIE","TRIENIO CONTRATA SIMPLE"));
		remuCrecimVeg.add(new RemuVariables("HMCTRIE","TRIENIOS MEDICO CONTRATA"));
		remuCrecimVeg.add(new RemuVariables("HMPTRIE","TRIENIOS MEDICO PLANTA"));
		remuCrecimVeg.add(new RemuVariables("HPCTRIE","TRIENIOS PROFES CON TITULO"));
		remuCrecimVeg.add(new RemuVariables("HPSTRIE","TRIENIOS PROFES SIN TITULO"));
		remuCrecimVeg.add(new RemuVariables("HPTBGEI","BONIFICACION GRADO EFECTIVO IMPONIBLE PLANTA"));
		remuCrecimVeg.add(new RemuVariables("HPTPERM","BONIFICACION PERMANENCIA PLANTA"));
		remuCrecimVeg.add(new RemuVariables("HPTSSUP","SUELDO SUPERIOR"));
		remuCrecimVeg.add(new RemuVariables("HPTTRIE","TRIENIOS PLANTA"));
		return remuCrecimVeg;
	}
	private List<RemuVariables> getListaHorasExtras() {
		List<RemuVariables> remuHorasExtras = new ArrayList<RemuVariables>();

		remuHorasExtras.add(new RemuVariables("HCGHLYF","HORAS PROMEDIO CONTRATA GLOBAL"));
		remuHorasExtras.add(new RemuVariables("HCGHTCOM","HORAS TURNO CONTRATA GLOBAL"));
		remuHorasExtras.add(new RemuVariables("HCSHLYF","HORAS PROMEDIO CONTRATA SIMPLE"));
		remuHorasExtras.add(new RemuVariables("HCSHTCOM","HORAS TURNO CONTRATA SIMPLE"));
		remuHorasExtras.add(new RemuVariables("HPTHLYF","HORAS PROMEDIO PLANTA"));
		remuHorasExtras.add(new RemuVariables("HPTHTCOM","HORAS TURNO PLANTA"));
		return remuHorasExtras;
	}

	private List<RemuVariables> getListaEspNocivPeli() {
		List<RemuVariables> remuEspNociPeli = new ArrayList<RemuVariables>();
		remuEspNociPeli.add(new RemuVariables("HCGNOC25","25% ESPECIALIDADES PELIGROSAS O NOCIVAS PARA LA SALUD CONTRATA GLOBAL"));
		remuEspNociPeli.add(new RemuVariables("HCGNOC30","30% ESPECIALIDADES PELIGROSAS O NOCIVAS PARA LA SALUD CONTRATA GLOBAL"));
		remuEspNociPeli.add(new RemuVariables("HCGNOCI","ESPECIALIDADES NOCIVA PELIGROSA CONTRATA GLOBAL"));
		remuEspNociPeli.add(new RemuVariables("HCSNOC25","25% ESPECIALIDADES PELIGROSAS O NOCIVAS PARA LA SALUD CONTRATA SIMPLE"));
		remuEspNociPeli.add(new RemuVariables("HCSNOC30","30% ESPECIALIDADES PELIGROSAS O NOCIVAS PARA LA SALUD CONTRATA SIMPLE"));
		remuEspNociPeli.add(new RemuVariables("HCSNOCI","ESPECIALIDADES NOCIVA PELIGROSA CONTRATA SIMPLE"));
		remuEspNociPeli.add(new RemuVariables("HPTNOC25","25% ESPECIALIDADES PELIGROSAS O NOCIVAS PARA LA SALUD PLANTA"));
		remuEspNociPeli.add(new RemuVariables("HPTNOC30","30% ESPECIALIDADES PELIGROSAS O NOCIVAS PARA LA SALUD CONTRATA PLANTA"));
		remuEspNociPeli.add(new RemuVariables("HPTNOCI","ESPECIALIDADES NOCIVA PELIGROSA CONTRATA PLANTA"));
		
		return remuEspNociPeli;
	}
	
	
	private List<RemuVariables> getListaMaquina() {
		List<RemuVariables>remuMaquina= new ArrayList<RemuVariables>();
		remuMaquina.add(new RemuVariables("HCGMAQU","ASIGNACION MAQUINA CONTRATA GLOBAL"));
		remuMaquina.add(new RemuVariables("HCSMAQU","ASIGNACION MAQUINA CONTRATA SIMPLE"));
		remuMaquina.add(new RemuVariables("HPTMAQU","ASIGNACION MAQUINA PLANTA"));
		return remuMaquina;
	}

	
	
	private List<RemuVariables> getListaBonos() {
		List<RemuVariables> remuBonos = new ArrayList<RemuVariables>();
   	//remuBonos.add(new RemuVariables("",""))HAY UNOS BONOS SIN CODIGO;
   		remuBonos.add(new RemuVariables("HCGAGDIC","DIFERENCIA DE AGUINALDO DICIEMBRE CONTRATA GLOBAL"));
   		remuBonos.add(new RemuVariables("HCGAGSEP","DIFERENCIA AGUINALDO SEPTIEMBRE CONTRATA GLOBAL"));
   		remuBonos.add(new RemuVariables("HCGAGUI","AGUINALDO CONTRATA GLOBAL"));
   		remuBonos.add(new RemuVariables("HCGESCO","BONO ESCOLARIDAD CONTRATA GLOBAL"));
   		remuBonos.add(new RemuVariables("HCSAGDIC","DIFERENCIA DE AGUINALDO DICIEMBRE CONTRATA SIMPLE"));
   		remuBonos.add(new RemuVariables("HCSAGSEP","DIFERENCIA AGUINALDO SEPTIEMBRE CONTRATA SIMPLE"));
   		remuBonos.add(new RemuVariables("HCSAGUI","AGUINALDO CONTRATA SIMPLE"));
   		remuBonos.add(new RemuVariables("HCSBONO","BONO ESPECIAL (VACACIONES) CONTRATA SIMPLE"));
   		remuBonos.add(new RemuVariables("HCSESCO","BONO ESCOLARIDAD CONTRATA SIMPLE"));
   		remuBonos.add(new RemuVariables("HPAAGSEP","DIFERENCIA AGUINALDO SEPTIEMBRE P.A.S.M"));
   		remuBonos.add(new RemuVariables("HPAAGUI","AGUINALDO P.A.S.M"));
   		remuBonos.add(new RemuVariables("HPABONO","BONO ESPECIAL (VACACIONES) P.A.S.M"));
   		remuBonos.add(new RemuVariables("HPAESCO","BONO ESCOLARIDAD P.A.S.M"));
   		remuBonos.add(new RemuVariables("HPTAGSEP","DIFERENCIA AGUINALDO SEPTIEMBRE PLANTA"));
   		remuBonos.add(new RemuVariables("HPTAGUI","AGUINALDO PLANTA"));
   		remuBonos.add(new RemuVariables("HPTBONO","BONO ESPECIAL (VACACIONES) PLANTA"));
   		remuBonos.add(new RemuVariables("HPTESCO","BONO ESCOLARIDAD PLANTA"));
		return remuBonos;
	}
	private List<RemuVariables> getListaIslaPascua() {
		List<RemuVariables> remuIslaPascua = new ArrayList<RemuVariables>();
  		remuIslaPascua.add(new RemuVariables("HCGISLA","ASIGNACION ISLA DE PASCUA CONTRATA GLOBAL"));
  		remuIslaPascua.add(new RemuVariables("HCSISLA","ASIGNACION ISLA DE PASCUA CONTRATA SIMPLE"));
  		remuIslaPascua.add(new RemuVariables("HPAISLA","ASIGNACION ISLA DE PASCUA PERSONAL ADMINISTRATIVO DE SERVICIOS MENORES"));
  		remuIslaPascua.add(new RemuVariables("HPTISLA","ASIGNACION ISLA DE PASCUA PLANTA"));
  		return remuIslaPascua;
	}
	private List<RemuVariables> getListaAntartica() {
		List<RemuVariables>remuAntartica = new ArrayList<RemuVariables>();
		remuAntartica.add(new RemuVariables("HCSANTA","GRATIFICACION ANTARTICA CONTRATA SIMPLE"));
		remuAntartica.add(new RemuVariables("HPTANTA","GRATIFICACION ANTARTICA PLANTA"));
		return remuAntartica;
	}


	private List<RemuVariables> getListaHonorarios() {
		List<RemuVariables>remuHonorarios= new ArrayList<RemuVariables>();
		remuHonorarios.add(new RemuVariables("HHOHONO","HONORARIO"));
		remuHonorarios.add(new RemuVariables("HHOHTOT","HONORARIO TOTAL"));
		return remuHonorarios;
	}
	

	private List<RemuVariables> getListaHorasProfeEta() {
		List<RemuVariables>remuHorasProfeEta = new ArrayList<RemuVariables>();
		remuHorasProfeEta.add(new RemuVariables("HPCACAD","ASIGNACION ACADEMICA PROFESOR CON TITULO"));
		remuHorasProfeEta.add(new RemuVariables("HPCBASE","SUELDO BASE PROFESOR CON TITULO"));
		remuHorasProfeEta.add(new RemuVariables("HPCDOCE","BONIFICACION DOCENTE PREOFESOR CON TITULO"));
		remuHorasProfeEta.add(new RemuVariables("HPCMOVP","ASIGNACION MOVILIZACION PROFESOR"));
		remuHorasProfeEta.add(new RemuVariables("HPCSALU","BONIFICACION 4,5% SALUD PROFESORES"));
		remuHorasProfeEta.add(new RemuVariables("HPSBASE","SUELDO BASE PROFESOR SIN TITULO"));
		remuHorasProfeEta.add(new RemuVariables("HPCMOVP","ASIGNACION MOVILIZACION PROFESOR"));
		remuHorasProfeEta.add(new RemuVariables("HPSDOCE","BONIFICACION DOCENTE PROFESOR SIN TITULO"));
		remuHorasProfeEta.add(new RemuVariables("HPCSALU","BONIFICACION 4,5% SALUD PROFESORES"));
		remuHorasProfeEta.add(new RemuVariables("HPSBASE","SUELDO BASE PROFESOR SIN TITULO"));
		remuHorasProfeEta.add(new RemuVariables("HPSDOCE","BONIFICACION DOCENTE PROFESOR SIN TITULO"));
		remuHorasProfeEta.add(new RemuVariables("HPTPRON","ASIGNACION PROFESOR PLANILLA SUMPLEMENTARIA PLANTA"));
		return remuHorasProfeEta;
	}

	private List<RemuVariables> getListaMedicos() {
	List<RemuVariables>remuMedicos= new ArrayList<RemuVariables>();
	remuMedicos.add(new RemuVariables("HMCDS24", "8% BONIFICACION DS24 MEDICO CONTRATA"));
	remuMedicos.add(new RemuVariables("HMCCOLAC", "ASIGNACION COLACION MEDICO CONTRATA"));
	remuMedicos.add(new RemuVariables("HMPCOLAC", "ASIGNACION COLACION MEDICO PLANTA")); 
	remuMedicos.add(new RemuVariables("HMCESPE", "ASIGNACION ESPECIAL DL 3551 MEDICO CONTRATA")); 
	remuMedicos.add(new RemuVariables("HMPESPE", "ASIGNACION ESPECIAL DL 3551 MEDICO PLANTA"));
	remuMedicos.add(new RemuVariables("HMCESTAP", "ASIGNACION ESTIMULO AP MEDICO CONTRATA"));
	remuMedicos.add(new RemuVariables("HMPESTAP", "ASIGNACION ESTIMULO AP MEDICO PLANTA"));
	remuMedicos.add(new RemuVariables("HMC18482", "ASIGNACION ESTIMULO LEY 18.842 MEDICO CONTRATA"));
	remuMedicos.add(new RemuVariables("HMP18482", "ASIGNACION ESTIMULO LEY 18.842 MEDICO PLANTA"));
	remuMedicos.add(new RemuVariables("HMCMOV1", "ASIGNACION MOVILIZACION MEDICO CONTRATA"));
	remuMedicos.add(new RemuVariables("HMPMOV1", "ASIGNACION MOVILIZACION MEDICO PLANTA"));
	remuMedicos.add(new RemuVariables("HMC19112", "ASIGNACION PERMANENTE LEY 19112 MEDICO CONTRATA"));
	remuMedicos.add(new RemuVariables("HMP19112", "ASIGNACION PERMANENTE LEY 19112 MEDICO PLANTA"));
	remuMedicos.add(new RemuVariables("HMCRESP", "ASIGNACION RESPONSABILIDAD MEDICO CONTRATA"));
	remuMedicos.add(new RemuVariables("HMPRESP", "ASIGNACION RESPONSABILIDAD MEDICO PLANTA"));
	remuMedicos.add(new RemuVariables("HMPZONA", "ASIGNACION ZONA MEDICO PLANTA"));
	remuMedicos.add(new RemuVariables("HMCSALU", "BONIFICACION 4,5% DE SALUD MEDICO CONTRATA"));
	remuMedicos.add(new RemuVariables("HMCART10", "BONIFICACION LEY 18.675  ARTICULO 10 MEDICO CONTRATA"));
	remuMedicos.add(new RemuVariables("HMPART10", "BONIFICACION LEY 18.675  ARTICULO 10 MEDICO PLANTA"));
	remuMedicos.add(new RemuVariables("HMC18566", "BONIFICACION LEY 18566 ARTICULO 3 MEDICO CONTRATA"));
	remuMedicos.add(new RemuVariables("HMP18566", "BONIFICACION LEY 18566 ARTICULO 3 MEDICO PLANTA"));
	remuMedicos.add(new RemuVariables("HMC75AP", "75% HORAS ASISTENCIA PUBLICA MEDICO CONTRATA"));
	remuMedicos.add(new RemuVariables("HMP75AP", "75% HORAS ASISTENCIA PUBLICA MEDICO PLANTA"));
	remuMedicos.add(new RemuVariables("HMCINCR", "INCREMENTO PREVISIONAL D.L 3501  MEDICO CONTRATA"));
	remuMedicos.add(new RemuVariables("HMPINCR", "INCREMENTO PREVISIONAL D.L 3501  MEDICO PLANTA"));
	remuMedicos.add(new RemuVariables("HMCESTMD", "ASIGNACION ESTIMULO MEDICO CONSULTORIO"));
	remuMedicos.add(new RemuVariables("HMPESTMD", "ASIGNACION ESTIMULO MEDICO CONSULTORIO PLANTA"));
	remuMedicos.add(new RemuVariables("HMCBASE", "SUELDO BASE MEDICOS CONTRATA"));
	remuMedicos.add(new RemuVariables("HMPBASE", "SUELDO BASE MEDICOS PLANTA"));
	
	return remuMedicos;
	}

	
	
}
