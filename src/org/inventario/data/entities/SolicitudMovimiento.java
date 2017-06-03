package org.inventario.data.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.ToString;

import java.util.Date;


/**
 * The persistent class for the SolicitudMovimiento database table.
 * 
 */
@Entity
@Table (name= "`SolicitudAsignacion`")
@NamedQuery(name="SolicitudMovimiento.findAll", query="SELECT s FROM SolicitudMovimiento s")
@ToString
public class SolicitudMovimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaSolicitud;

	//bi-directional many-to-one association to MovimientoItem
	@ManyToOne
	@JoinColumn(name="MovimientoItemID")
	private MovimientoItem movimientoItem;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="RolAutorizadorID")
	private Rol rol;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="UsuarioAutorizadorID")
	private Usuario usuario;

	public SolicitudMovimiento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaSolicitud() {
		return this.fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public MovimientoItem getMovimientoItem() {
		return this.movimientoItem;
	}

	public void setMovimientoItem(MovimientoItem movimientoItem) {
		this.movimientoItem = movimientoItem;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}