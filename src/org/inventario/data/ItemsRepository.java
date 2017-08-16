package org.inventario.data;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.inventario.data.entities.Item;

public class ItemsRepository
  extends BaseRepository<Item>
{
  public ItemsRepository()
  {
    super(Item.class);
  }
  
  public List<Item> get(Long departamentoId)
  {
    List<Item> items = new ArrayList(0);
    TypedQuery<Item> qry = this.eMgr.createQuery("SELECT i FROM Item i INNER JOIN AsignacionItem a ON i.id=a.item.id WHERE a.departamento.id=:id", Item.class);
    qry.setParameter("id", departamentoId);
    items = qry.getResultList();
    return items;
  }
  
  public List<Item> get(Long departamentoId, String nombreItem)
  {
    List<Item> items = new ArrayList(0);
    TypedQuery<Item> qry = null;
    if ((nombreItem != null) && (nombreItem.trim().length() > 0))
    {
      qry = this.eMgr.createQuery("SELECT i FROM Item i INNER JOIN AsignacionItem a ON i.id=a.item.id WHERE a.departamento.id=:id AND i.nombre LIKE :nombre", Item.class);
      qry.setParameter("nombre", "%" + nombreItem + "%");
    }
    else
    {
      qry = this.eMgr.createQuery("SELECT i FROM Item i INNER JOIN AsignacionItem a ON i.id=a.item.id WHERE a.departamento.id=:id", Item.class);
    }
    qry.setParameter("id", departamentoId);
    qry.setParameter("nombre", "%" + nombreItem + "%");
    items = qry.getResultList();
    return items;
  }
  
  public List<Item> get(Long departamentoId, String nombreItem, int startIndex, int pageSize)
  {
    List<Item> items = new ArrayList(0);
    TypedQuery<Item> qry = null;
    if ((nombreItem != null) && (nombreItem.trim().length() > 0))
    {
      qry = this.eMgr.createQuery("SELECT i FROM Item i INNER JOIN AsignacionItem a ON i.id=a.item.id WHERE a.departamento.id=:id AND i.nombre LIKE :nombre ORDER BY i.id", Item.class);
      qry.setParameter("nombre", "%" + nombreItem + "%");
    }
    else
    {
      qry = this.eMgr.createQuery("SELECT i FROM Item i INNER JOIN AsignacionItem a ON i.id=a.item.id WHERE a.departamento.id=:id ORDER BY i.id", Item.class);
    }
    qry.setParameter("id", departamentoId);
    qry.setFirstResult(startIndex);
    qry.setMaxResults(pageSize);
    items = qry.getResultList();
    return items;
  }
  

}