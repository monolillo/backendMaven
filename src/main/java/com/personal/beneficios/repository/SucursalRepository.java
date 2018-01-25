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

import com.personal.beneficios.entity.Sucursal;

/**
 * The class SucursalRepository
 *
 */
@Service("sucursalRepository")
@Transactional(propagation=Propagation.REQUIRED)
public class SucursalRepository {

	@PersistenceContext
	public EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public ArrayList<Sucursal> getSucursales() {
		
	Query query  = entityManager.createQuery("SELECT sucursal FROM Sucursal sucursal");
	return (ArrayList<Sucursal>) query.getResultList();
		
	}
	
	@Transactional(readOnly=true)
	public Sucursal getSucursalPorID(Integer idSucursal) {
	
	Query query  = entityManager.createQuery("SELECT sucursal FROM Sucursal sucursal where sucursal.id=:id");
	query.setParameter("id", idSucursal);
	return  (Sucursal) query.getSingleResult();
	}	
	
	@Transactional(readOnly=true)
	public void agregarSucursal(Sucursal sucursal){
		entityManager.persist(sucursal);
	}
	
	@Transactional(readOnly=true)
	public void editarSucursal(Sucursal sucursal){
		entityManager.persist(sucursal);
	}
	
	@Transactional(readOnly=true)
	public void eliminarSucursal(Sucursal sucursal){
		entityManager.remove(sucursal);
	}
}
