package org.inventario.data.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the SolicitudAsignacion database table.
 * 
 */
@Entity
@NamedQuery(name="SolicitudAsignacion.findAll", query="SELECT s FROM SolicitudAsignacion s")
public class SolicitudAsignacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAutorizacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaSolicitud;

	//bi-directional many-to-one association to AsignacionItem
	@ManyToOne
	@JoinColumn(name="AsignacionItemID")
	private AsignacionItem asignacionItem;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="RolAutorizadorID")
	private Rol rol;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="UsuarioID")
	private Usuario usuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="UsuarioAutorizadorID")
	private Usuario usuario2;

	public SolicitudAsignacion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaAutorizacion() {
		return this.fechaAutorizacion;
	}

	public void setFechaAutorizacion(Date fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
	}

	public Date getFechaSolicitud() {
		return this.fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public AsignacionItem getAsignacionItem() {
		return this.asignacionItem;
	}

	public void setAsignacionItem(AsignacionItem asignacionItem) {
		this.asignacionItem = asignacionItem;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

}