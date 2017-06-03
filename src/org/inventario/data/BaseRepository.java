package org.inventario.data;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

//Usando generic 
public class BaseRepository<T> {
	// constante
	public static final String PERSISTENCE_UNIT = "inventario";
	protected EntityManager eMgr;

	public BaseRepository() {
		refresh();
	}

	public T get(long id) {
		T t = null;

		return t;
	}

	public void close() {
		if (eMgr != null) {
			if (eMgr.isOpen()) {
				eMgr.close();
			}
			eMgr=null;
		}
	}

	public void refresh() {
		close();
		eMgr = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();

	}

}
