package org.inventario.tests;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.inventario.data.entities.Rol;
import org.junit.Before;
import org.junit.Test;

public class JPATest {
	private EntityManager eMgr;

	@Before
	public void setUp() throws Exception {
		eMgr = Persistence.createEntityManagerFactory("inventario").createEntityManager();

	}

	@Test
	public void test() {
		TypedQuery<Rol> qry = eMgr.createQuery("select r from Rol r", Rol.class);
		List<Rol> listaRoles = qry.getResultList();
		assertNotNull("**Lista de roles no nula**", listaRoles ); 
		assertNotEquals("**Lista debe tener al menos un elemento**", 0, listaRoles.size());
	}

}
