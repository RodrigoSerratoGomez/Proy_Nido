package com.usmp.persistencia.models.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usmp.persistencia.models.dao.CustomIAlumnoDao;
import com.usmp.persistencia.models.entities.ReporteMatriculados;
@Repository
public class CustomIAlumnoDaoImpl implements CustomIAlumnoDao {
//implementamos el CustomDao del package dao
	
	@Autowired
	private EntityManager em; //PARA ACCEDER A LA BDD
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ReporteMatriculados> listaParaReporte() {
		System.out.println("listaParaReporte - INI");
		//CREAMOS MANUALMENTE EL QUERY TAL CUAL EN EL SQL  
		String sql = "SELECT  TO_CHAR(M.FECMATRI,'YYYY') AS AÑO, N.NOMNIVEL,  COUNT (TO_CHAR(M.FECMATRI,'YYYY')) "
				+ "AS \"CANTIDAD MATRICULADOS\" FROM MATRICULA M, NIVEL N WHERE M.NIVEL_IDNIVEL = N.IDNIVEL GROUP BY N.NOMNIVEL, "
				+ "TO_CHAR(M.FECMATRI,'YYYY') ORDER BY TO_CHAR(M.FECMATRI,'YYYY')";
		
		//HIBERNATE CREA Y EJECUTA EL QUERY
		Query q = em.createNativeQuery(sql);
		List<Object[]> lRes = q.getResultList(); //QUERY LO DEVUELVE COMO UNA LISTA DE OBJETO
		List<ReporteMatriculados> lRespuesta = null ;
		
		if( lRes != null ) {
			System.out.println("listaParaReporte - resultadosobtenidos = " + lRes.size() );
			lRespuesta = new ArrayList<>() ;
			ReporteMatriculados objTemp = null;
			for( Object[] obj :lRes) {
				objTemp = new ReporteMatriculados();
				objTemp.setAnio(obj[0]+""); //seteo manual de los datos siguiendo el orden del query
				objTemp.setNomNivel( obj[1]+"");
				objTemp.setCantidadMatriculados( Integer.parseInt( obj[2]+""));
				lRespuesta.add(objTemp);
			}
		}
		
		System.out.println("listaParaReporte - FIN");
		return lRespuesta;
	}

}
