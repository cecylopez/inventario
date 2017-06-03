package org.inventario.data.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.ToString;

import java.util.List;


/**
 * The persistent class for the TipoMovimiento database table.
 * 
 */
@Entity
@Table (name="`TipoMovimiento`")
@NamedQuery(name="TipoMovimiento.findAll", query="SELECT t FROM TipoMovimiento t")
@ToString
public class TipoMovimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to MovimientoItem
	@OneToMany(mappedBy="tipoMovimiento")
	private List<MovimientoItem> movimientoItems;

	public TipoMovimiento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<MovimientoItem> getMovimientoItems() {
		return this.movimientoItems;
	}

	public void setMovimientoItems(List<MovimientoItem> movimientoItems) {
		this.movimientoItems = movimientoItems;
	}

	public MovimientoItem addMovimientoItem(MovimientoItem movimientoItem) {
		getMovimientoItems().add(movimientoItem);
		movimientoItem.setTipoMovimiento(this);

		return movimientoItem;
	}

	public MovimientoItem removeMovimientoItem(MovimientoItem movimientoItem) {
		getMovimientoItems().remove(movimientoItem);
		movimientoItem.setTipoMovimiento(null);

		return movimientoItem;
	}

}