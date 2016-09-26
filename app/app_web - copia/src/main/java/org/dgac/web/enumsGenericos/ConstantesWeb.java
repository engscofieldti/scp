package org.dgac.web.enumsGenericos;

public class ConstantesWeb {
	
	// SELECCION DE OPCIONES DEL MENU USUARIO
	
	// SUBTITULOS DE LA COLECCION
	public static final String SELECCION_SUBTITULO21="Subtítulo 21 ";
	public static final String SELECCION_SUBTITULO22="Subtítulo 22 ";
	public static final String SELECCION_SUBTITULO23="Subtítulo 23 ";
	//ITEMS DE LA COLECCION
	public static final String ITEM_REM_VAR="Remuneración Variable ";
	public static final String ITEM_OTR_REM="Otras Remuneraciones";
	public static final String ITEM_OTR_GAS_PER="Otros Gastos En Personal";
	//ASIGNACIONES DE LA COLECCION
	public static final String ASIG_HOR_EXT="Horas Extras";
	public static final String ASIG_VIA="Viáticos";
	public static final String ASIG_HONO="Honorarios";
	public static final String ASIG_REMU="Remuneraciones";
	public static final String ASIG_TRAS="Asignación Traslado";
	
	public static final String SELECCION_PERIODO="";
	public static final String SELECCION_TIPO="";
	public static final String SELECCION_PERIODO_AÑO="";
	
	// SELECCION DE OPCIONES CON CHECKBOX
	
	
	public static final boolean REMUNERACION_VARIABLE=false;
	public static final boolean OTRAS_REMUNERACIONES=false;
	public static final boolean OTROS_GASTOS_EN_PERSONAL=false;
	// SELECCION DE ASIGNACIONES CHECKBOX
	public static final boolean HORAS_EXTRAS=false;
	public static final boolean VIATICOS=false;
	public static final boolean HONORARIOS=false;
	public static final boolean REMUNERACIONES=false;
	public static final boolean ASIGNACION_TRASLADO=false;
    // SELECCION DE ZONAS CHECKBOX
	public static final boolean TODAS=false;
	public static final boolean AMB=false;
	public static final boolean DMC=false;
	public static final boolean LOGISTICA_STGO=false;
	public static final boolean DASA=false;
	public static final boolean ZONA_NORTE=false;
	public static final boolean ZONA_CENTRO=false;
	public static final boolean ZONA_SUR=false;
	public static final boolean ZONA_AUSTRAL=false;
	
	// SELECCION DE UNIDADES EJECUTORAS
	
//	public static final boolean UE178_RRHH=false;
//	public static final boolean UE179_CAPACITACION=false;
//	public static final boolean UE180_BENEFICIOS_MEDICOS=false;
//	public static final boolean UE183_ETA=false;
//	public static final boolean UE184_SUBDEPTO_PERSONAL=false;
//	public static final boolean UE185_REMUNERACIONES=false;
//	public static final boolean UE187_PREVENCION_RIESGOS=false;
	
	public static final String UE178="178 - Recursos Humanos";
	public static final String UE179="179 - Capacitación";
	public static final String UE180="180 - Beneficios Médicos";
	public static final String UE183="183 - ETA";
	public static final String UE184="184 - Subdepto.Personal";
	public static final String UE185="185 - Remuneraciones";
	public static final String UE187="187 - Prevención de Riesgos";
			
	//SELECCION DE MESES 1-12
	
	public static final Integer ENERO=1;
	public static final Integer FEBRERO=2;
	public static final Integer MARZO=3;
	public static final Integer ABRIL=4;
	public static final Integer MAYO=5;
	public static final Integer JUNIO=6;
	public static final Integer JULIO=7;
	public static final Integer AGOSTO=8;
	public static final Integer SEPTIEMBRE=9;
	public static final Integer OCTUBRE=10;
	public static final Integer NOVIEMBRE=11;
	public static final Integer DICIEMBRE=12;
	//SELECCION DE AÑO
	public static final Integer ANNO_2012=2012;
	public static final Integer ANNO_2013=2013;
	public static final Integer ANNO_2014=2014;
	public static final Integer ANNO_2015=2015;
	public static final Integer ANNO_2016=2016;
	
	
	// REVISARLAS
	
	public static final String QUERYDINAMICADOCUNO = " SELECT 	documento.doc_id, 	documento.doc_ano, 	documento.des_id, 	documento.desc_id, 	documento.doc_materia, 	documento.doc_fecha_ingreso, 	documento.doc_numero, 	documento.tpo_id, 	documento.doc_resumen, 	documento.doc_abogado, 	documento.doc_nombre_archivo, 	documento.doc_id_alfresco, 	documento.doc_usr_insert, 	documento.doc_usr_mod, 	documento.doc_fecha_mod, 	documento.doc_estado , destinatario.des_nombre_small , descriptor.desc_nombre_small, tipo_documento.tpo_nombre_small FROM 	documento,destinatario,descriptor,tipo_documento ";
	public static final String QUERYDINAMICADOCDOS =" documento.des_id=destinatario.des_id and documento.desc_id=descriptor.desc_id and documento.tpo_id=tipo_documento.tpo_id ";
	public static final String QUERYDINAMICADOCESTADO=" AND documento.doc_estado=1 ";
	public static final String QUERYDINAMICADOCWHERE = " where ";
	public static final String QUERYDINAMICADOCAND = " and ";
	public static final String QUERYDINAMICODOCLIKE = " like ";
	public static final String QUERYDINAMICODONOMTABL ="documento";
	public static final String CONTADOR = "contador";
	
	public static final String CONSULTADINAMICAREPORTES="SELECT UNI.ANO, UNI.MES, UNI.UNIDAD AS CODIGO_UNIDAD,"+
      "UNI.UNIDAD_DESC AS NOMBRE_UNIDAD,"+
       "SUM(UNI.MONTO_DIFER) AS PAGO_DEL_MES"+
       "FROM (SELECT TRAB.ANO, TRAB.MES, TRAB.RUT, TRAB.NOMBRE,"+
             "DECODE(TRAB.TIPO_CONTRATO, 1, 'PLANTA',"+
                                        "2, 'C.SIMPLE',"+
                                        "10, 'C.GLOBAL', TRAB.TIPO_CONTRATO) AS C_JURIDICA,"+
             "TRAB.ID_CONTRATO,"+
             "TRAB.UNIDAD,"+
             "UNI.UNIDAD_DESC,"+
             "FN.DESCRIP AS CARGO,"+
             "Row_Number() Over(Partition By TRAB.RUT, TRAB.ID_CONTRATO"+
                               "Order By TRAB.RUT, TRAB.ID_CONTRATO, TRAB.ID_CONTRATO,"+
                                        "RET.ANO_CALCULO, RET.MES_CALCULO) AS SEC,"+
             "NVL(RESU.HCGHLYF_R, 0) +"+
             "NVL(RESU.HCSHLYF_R, 0) +"+
             "NVL(RESU.HPTHLYF_R, 0) AS HORAS_PROMEDIO,"+
             "RET.ANO_CALCULO AS ANO_C,"+
             "RET.MES_CALCULO AS MES_C,"+
            "RET.MONTO_ANTER, RET.MONTO_NUEVO, RET.MONTO_DIFER"+
      "FROM NOMINA_DGAC.PROCESOS_TRABAJADORES TRAB,"+
           "NOMINA_DGAC.PROCESOS_RESULTADOS RESU,"+
          "(SELECT CODIGO, DESCRIP FROM NOMINA_DGAC.TABLAS WHERE ID_TABLA = 189) FN,"+
          "(SELECT RP.RUT,"+
                  "RP.ID_EMPRESA,"+
                  "RP.ID_CONTRATO,"+
                  "DIF.ANO_CALCULO,"+
                  "DIF.MES_CALCULO,"+
                  "DIF.FIELD_NAME,"+
                  "DIF.MONTO_ANTER,"+
                  "DIF.MONTO_NUEVO,"+
                  "DIF.MONTO_DIFER,"+
                  "RP.ANO_PROCESO,"+
                  "RP.MES_PROCESO"+
          "FROM NOMINA_DGAC.REM_RELIQ_PROCESOS RP, NOMINA_DGAC.REM_RELIQ_PROCESOS_DIFER DIF"+
          "WHERE RP.ID_PROCESO = DIF.ID_PROCESO"+
          "AND   RP.ANO_PROCESO = $P{ano_param}"+
          "AND   RP.MES_PROCESO IN ($P{mes_param},$P{mes_param2},$P{mes_param3},$P{mes_param4},$P{mes_param5},"+
          "$P{mes_param6},$P{mes_param7},$P{mes_param8},$P{mes_param9},$P{mes_param10},$P{mes_param11},$P{mes_param12})"+
         "AND   DIF.FIELD_NAME IN ('hpthtcom', 'hcshtcom', 'hcghtcom','hcghlyf', 'hcshlyf', 'hpthlyf')) RET,"+
         "(SELECT CODIGO, TRIM(DESCRIP) AS UNIDAD_DESC FROM NOMINA_DGAC.TABLAS WHERE ID_TABLA = 69) UNI"+
          "WHERE TRAB.RUT         = RESU.RUT"+
          "AND   TRAB.ID_EMPRESA  = RESU.ID_EMPRESA"+
          "AND   TRAB.ID_CONTRATO = RESU.ID_CONTRATO"+
          "AND   TRAB.ID_PROCESO  = RESU.ID_PROCESO"+
          "AND   TRAB.ANO         = RESU.ANO"+
          "AND   TRAB.MES         = RESU.MES"+
          "AND   TRAB.ANO         = $P{ano_param}"+
          "AND   TRAB.MES        IN ($P{mes_param},$P{mes_param2},$P{mes_param3},$P{mes_param4},$P{mes_param5},"+
          "$P{mes_param6},$P{mes_param7},$P{mes_param8},$P{mes_param9},$P{mes_param10},$P{mes_param11},$P{mes_param12})"+
          "AND   TRAB.ID_PROCESO  = 0"+
          "AND   TRAB.RUT         = RET.RUT"+
          "AND   TRAB.ID_EMPRESA  = RET.ID_EMPRESA"+
          "AND   TRAB.ID_CONTRATO = RET.ID_CONTRATO"+
          "AND   TRAB.ANO         = RET.ANO_PROCESO"+
          "AND   TRAB.MES         = RET.MES_PROCESO"+
          "AND   TRAB.UNIDAD      = UNI.CODIGO(+)"+
          "AND   TRAB.ID_CARGO    = FN.CODIGO(+)"+
          "AND   TRAB.ID_EMPRESA  = 1"+
          "AND   TRAB.ACTIVO      = 1"+
	"AND TRAB.UNIDAD =      $P{codigouni_param}"+
          "AND   (NVL(RESU.HCGHLYF_R, 0) +"+
               "  NVL(RESU.HCSHLYF_R, 0) +"+
                " NVL(RESU.HPTHLYF_R, 0)) != 0"+
          "ORDER BY TRAB.ANO, TRAB.MES, TRAB.NOMBRE, TRAB.TIPO_CONTRATO, TRAB.ID_CONTRATO) UNI"+
"GROUP BY UNI.ANO, UNI.MES, UNI.UNIDAD, UNI.UNIDAD_DESC"+
"ORDER BY 1, 2, 3;";	
	
//	SELECT UNI.ANO, UNI.MES, UNI.UNIDAD AS CODIGO_UNIDAD,
//    UNI.UNIDAD_DESC AS NOMBRE_UNIDAD,
//    SUM(UNI.MONTO_DIFER) AS PAGO_DEL_MES
//
//FROM (SELECT TRAB.ANO, TRAB.MES, TRAB.RUT, TRAB.NOMBRE,
//          DECODE(TRAB.TIPO_CONTRATO, 1, 'PLANTA',
//                                     2, 'C.SIMPLE',
//                                     10, 'C.GLOBAL', TRAB.TIPO_CONTRATO) AS C_JURIDICA,
//          TRAB.ID_CONTRATO,
//          TRAB.UNIDAD,
//          UNI.UNIDAD_DESC,
//          FN.DESCRIP AS CARGO,
//          Row_Number() Over(Partition By TRAB.RUT, TRAB.ID_CONTRATO
//                            Order By TRAB.RUT, TRAB.ID_CONTRATO, TRAB.ID_CONTRATO,
//                                     RET.ANO_CALCULO, RET.MES_CALCULO) AS SEC,
//
//
//          NVL(RESU.HCGHLYF_R, 0) +
//          NVL(RESU.HCSHLYF_R, 0) +
//          NVL(RESU.HPTHLYF_R, 0) AS HORAS_PROMEDIO,
//          RET.ANO_CALCULO AS ANO_C,
//          RET.MES_CALCULO AS MES_C,
//          RET.MONTO_ANTER, RET.MONTO_NUEVO, RET.MONTO_DIFER
//   FROM NOMINA_DGAC.PROCESOS_TRABAJADORES TRAB,
//        NOMINA_DGAC.PROCESOS_RESULTADOS RESU,
//       (SELECT CODIGO, DESCRIP FROM NOMINA_DGAC.TABLAS WHERE ID_TABLA = 189) FN,
//       (SELECT RP.RUT,
//               RP.ID_EMPRESA,
//               RP.ID_CONTRATO,
//               DIF.ANO_CALCULO,
//               DIF.MES_CALCULO,
//               DIF.FIELD_NAME,
//               DIF.MONTO_ANTER,
//               DIF.MONTO_NUEVO,
//               DIF.MONTO_DIFER,
//               RP.ANO_PROCESO,
//               RP.MES_PROCESO
//       FROM NOMINA_DGAC.REM_RELIQ_PROCESOS RP, NOMINA_DGAC.REM_RELIQ_PROCESOS_DIFER DIF
//       WHERE RP.ID_PROCESO = DIF.ID_PROCESO
//
//       AND   RP.ANO_PROCESO = $P{ano_param}
//       AND   RP.MES_PROCESO IN ($P{mes_param},$P{mes_param2},$P{mes_param3},$P{mes_param4},$P{mes_param5},
//       $P{mes_param6},$P{mes_param7},$P{mes_param8},$P{mes_param9},$P{mes_param10},$P{mes_param11},$P{mes_param12})
//       AND   DIF.FIELD_NAME IN ('hpthtcom', 'hcshtcom', 'hcghtcom','hcghlyf', 'hcshlyf', 'hpthlyf')) RET,
//      (SELECT CODIGO, TRIM(DESCRIP) AS UNIDAD_DESC FROM NOMINA_DGAC.TABLAS WHERE ID_TABLA = 69) UNI
//       WHERE TRAB.RUT         = RESU.RUT
//
//       AND   TRAB.ID_EMPRESA  = RESU.ID_EMPRESA
//       AND   TRAB.ID_CONTRATO = RESU.ID_CONTRATO
//       AND   TRAB.ID_PROCESO  = RESU.ID_PROCESO
//       AND   TRAB.ANO         = RESU.ANO
//       AND   TRAB.MES         = RESU.MES
//       AND   TRAB.ANO         = $P{ano_param}
//       AND   TRAB.MES        IN ($P{mes_param},$P{mes_param2},$P{mes_param3},$P{mes_param4},$P{mes_param5},
//       $P{mes_param6},$P{mes_param7},$P{mes_param8},$P{mes_param9},$P{mes_param10},$P{mes_param11},$P{mes_param12})
//       AND   TRAB.ID_PROCESO  = 0
//       AND   TRAB.RUT         = RET.RUT
//       AND   TRAB.ID_EMPRESA  = RET.ID_EMPRESA
//       AND   TRAB.ID_CONTRATO = RET.ID_CONTRATO
//       AND   TRAB.ANO         = RET.ANO_PROCESO
//       AND   TRAB.MES         = RET.MES_PROCESO
//       AND   TRAB.UNIDAD      = UNI.CODIGO(+)
//       AND   TRAB.ID_CARGO    = FN.CODIGO(+)
//       AND   TRAB.ID_EMPRESA  = 1
//       AND   TRAB.ACTIVO      = 1
//	AND TRAB.UNIDAD =      $P{codigouni_param}
//
//       AND   (NVL(RESU.HCGHLYF_R, 0) +
//              NVL(RESU.HCSHLYF_R, 0) +
//              NVL(RESU.HPTHLYF_R, 0)) != 0
//       ORDER BY TRAB.ANO, TRAB.MES, TRAB.NOMBRE, TRAB.TIPO_CONTRATO, TRAB.ID_CONTRATO) UNI
//GROUP BY UNI.ANO, UNI.MES, UNI.UNIDAD, UNI.UNIDAD_DESC
//ORDER BY 1, 2, 3
//	
	
		
}
