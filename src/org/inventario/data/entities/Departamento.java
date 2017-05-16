package org.inventario.data.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Departamento database table.
 * 
 */
@Entity
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripcion;

	private String estado;

	private String nombre;

	//bi-directional many-to-one association to AsignacionItem
	@OneToMany(mappedBy="departamento")
	private List<AsignacionItem> asignacionItems;

	//bi-directional many-to-one association to MovimientoItem
	@OneToMany(mappedBy="departamento")
	private List<MovimientoItem> movimientoItems;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="departamento")
	private List<Usuario> usuarios;

	public Departamento() {
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

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<AsignacionItem> getAsignacionItems() {
		return this.asignacionItems;
	}

	public void setAsignacionItems(List<AsignacionItem> asignacionItems) {
		this.asignacionItems = asignacionItems;
	}

	public AsignacionItem addAsignacionItem(AsignacionItem asignacionItem) {
		getAsignacionItems().add(asignacionItem);
		asignacionItem.setDepartamento(this);

		return asignacionItem;
	}

	public AsignacionItem removeAsignacionItem(AsignacionItem asignacionItem) {
		getAsignacionItems().remove(asignacionItem);
		asignacionItem.setDepartamento(null);

		return asignacionItem;
	}

	public List<MovimientoItem> getMovimientoItems() {
		return this.movimientoItems;
	}

	public void setMovimientoItems(List<MovimientoItem> movimientoItems) {
		this.movimientoItems = movimientoItems;
	}

	public MovimientoItem addMovimientoItem(MovimientoItem movimientoItem) {
		getMovimientoItems().add(movimientoItem);
		movimientoItem.setDepartamento(this);

		return movimientoItem;
	}

	public MovimientoItem removeMovimientoItem(MovimientoItem movimientoItem) {
		getMovimientoItems().remove(movimientoItem);
		movimientoItem.setDepartamento(null);

		return movimientoItem;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setDepartamento(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setDepartamento(null);

		return usuario;
	}

}