package org.inventario.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

//Usando generic 
public class BaseRepository<T> {
	// constante
	public static final String PERSISTENCE_UNIT = "inventario";
	protected EntityManager eMgr;
	protected Class<T> clase;
	protected Logger logger;

	public BaseRepository(Class<T> clase) {
		this.logger= Logger.getLogger(this.getClass());
		this.clase= clase;
		refresh();
	}

	public T get(long id) {
		T t = null;
		
		TypedQuery<T> qry= eMgr.createQuery("SELECT o FROM "+ clase.getSimpleName() + " o WHERE o.id= :id", clase);
		qry.setParameter("id", id);
		t=qry.getSingleResult();
		
		return t;
	}
	
	public List<T> getAll(){
		List<T> listaT = new ArrayList<>(0);
		TypedQuery<T> qry= eMgr.createQuery("SELECT o FROM "+ clase.getSimpleName(), clase);
		listaT =qry.getResultList();
		return listaT;
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
