package org.inventario.data.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.ToString;

import java.util.List;


/**
 * The persistent class for the Usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
@ToString
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String clave;

	private String estado;

	private String nombre;

	//bi-directional many-to-one association to SolicitudAsignacion
	@OneToMany(mappedBy="usuario1")
	private List<SolicitudAsignacion> solicitudAsignacions1;

	//bi-directional many-to-one association to SolicitudAsignacion
	@OneToMany(mappedBy="usuario2")
	private List<SolicitudAsignacion> solicitudAsignacions2;

	//bi-directional many-to-one association to SolicitudMovimiento
	@OneToMany(mappedBy="usuario")
	private List<SolicitudMovimiento> solicitudMovimientos;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="DepartamentoID")
	private Departamento departamento;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="RolID")
	private Rol rol;

	public Usuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
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

	public List<SolicitudAsignacion> getSolicitudAsignacions1() {
		return this.solicitudAsignacions1;
	}

	public void setSolicitudAsignacions1(List<SolicitudAsignacion> solicitudAsignacions1) {
		this.solicitudAsignacions1 = solicitudAsignacions1;
	}

	public SolicitudAsignacion addSolicitudAsignacions1(SolicitudAsignacion solicitudAsignacions1) {
		getSolicitudAsignacions1().add(solicitudAsignacions1);
		solicitudAsignacions1.setUsuario1(this);

		return solicitudAsignacions1;
	}

	public SolicitudAsignacion removeSolicitudAsignacions1(SolicitudAsignacion solicitudAsignacions1) {
		getSolicitudAsignacions1().remove(solicitudAsignacions1);
		solicitudAsignacions1.setUsuario1(null);

		return solicitudAsignacions1;
	}

	public List<SolicitudAsignacion> getSolicitudAsignacions2() {
		return this.solicitudAsignacions2;
	}

	public void setSolicitudAsignacions2(List<SolicitudAsignacion> solicitudAsignacions2) {
		this.solicitudAsignacions2 = solicitudAsignacions2;
	}

	public SolicitudAsignacion addSolicitudAsignacions2(SolicitudAsignacion solicitudAsignacions2) {
		getSolicitudAsignacions2().add(solicitudAsignacions2);
		solicitudAsignacions2.setUsuario2(this);

		return solicitudAsignacions2;
	}

	public SolicitudAsignacion removeSolicitudAsignacions2(SolicitudAsignacion solicitudAsignacions2) {
		getSolicitudAsignacions2().remove(solicitudAsignacions2);
		solicitudAsignacions2.setUsuario2(null);

		return solicitudAsignacions2;
	}

	public List<SolicitudMovimiento> getSolicitudMovimientos() {
		return this.solicitudMovimientos;
	}

	public void setSolicitudMovimientos(List<SolicitudMovimiento> solicitudMovimientos) {
		this.solicitudMovimientos = solicitudMovimientos;
	}

	public SolicitudMovimiento addSolicitudMovimiento(SolicitudMovimiento solicitudMovimiento) {
		getSolicitudMovimientos().add(solicitudMovimiento);
		solicitudMovimiento.setUsuario(this);

		return solicitudMovimiento;
	}

	public SolicitudMovimiento removeSolicitudMovimiento(SolicitudMovimiento solicitudMovimiento) {
		getSolicitudMovimientos().remove(solicitudMovimiento);
		solicitudMovimiento.setUsuario(null);

		return solicitudMovimiento;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}