/**
 * 
 */
package com.personal.beneficios.repository;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.personal.beneficios.entity.Provincia;

/**
 * The class ProvinciaRepository
 *
 */
@Service("provinciaRepository")
@Transactional(propagation=Propagation.REQUIRED)
public class ProvinciaRepository {

	@PersistenceContext
	public EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public ArrayList<Provincia> getProvincias() {
		
	Query query  = entityManager.createQuery("SELECT provincia FROM Provincia provincia");
	return (ArrayList<Provincia>) query.getResultList();
		
	}
}
