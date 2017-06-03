package org.inventario.tests;

import static org.junit.Assert.*;

import org.inventario.data.BaseRepository;
import org.inventario.data.entities.Rol;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BaseRepositoryTest {
	private BaseRepository<Rol> repo;

	@Before
	public void setUp() throws Exception {
		repo=new BaseRepository<>(Rol.class);
	}

	@After
	public void tearDown() throws Exception {
		repo.close();
	}

	@Test
	public void test() {
		Rol r=repo.get(1);
		assertNotNull("El rol no debe ser nulo", r);
		assertEquals("El rol debe llamarse admin", "admin", r.getNombre());
	}

}
