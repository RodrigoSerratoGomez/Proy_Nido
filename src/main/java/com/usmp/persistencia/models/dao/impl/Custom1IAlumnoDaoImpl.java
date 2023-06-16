package com.usmp.persistencia.models.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usmp.persistencia.models.dao.Custom1IAlumnoDao;
import com.usmp.persistencia.models.entities.entitiesBORRAR.ReporteVacantes;
@Repository
public class Custom1IAlumnoDaoImpl implements Custom1IAlumnoDao {
//implementamos el CustomDao del package dao
	
	@Autowired
	private EntityManager em; //PARA ACCEDER A LA BDD
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ReporteVacantes> listaParaReporte1() {
		System.out.println("listaParaReporte - INI");
		//CREAMOS MANUALMENTE EL QUERY TAL CUAL EN EL SQL  
	
		String sql = "SELECT nomnivel , '30' AS \\\"VACANTES OFERTADAS\\\",30-COUNT(NIVEL_IDNIVEL) as \\\"VACANTES DISPONIBLES\\\" FROM MATRICULA M, NIVEL N WHERE m.nivel_idnivel=n.idnivel AND TO_CHAR(FECMATRI,'YYYY')='2022' GROUP by n.nomnivel ORDER BY n.nomnivel";
		//HIBERNATE CREA Y EJECUTA EL QUERY
		Query q = em.createNativeQuery(sql);
		List<Object[]> lRes = q.getResultList(); //QUERY LO DEVUELVE COMO UNA LISTA DE OBJETO
		List<ReporteVacantes> lRespuesta = null ;
		
		if( lRes != null ) {
			System.out.println("listaParaReporte - resultadosobtenidos = " + lRes.size() );
			lRespuesta = new ArrayList<>() ;
			ReporteVacantes objTemp = null;
			for( Object[] obj :lRes) {
				objTemp = new ReporteVacantes();
				objTemp.setNomNivel(obj[0]+"");
				objTemp.setVacantesOfertadas(Integer.parseInt( obj[1]+""));
				objTemp.setVacantesDisponibles( Integer.parseInt( obj[2]+""));
				lRespuesta.add(objTemp);
			}
		}
		
		System.out.println("listaParaReporte - FIN");
		return lRespuesta;
	}



}
