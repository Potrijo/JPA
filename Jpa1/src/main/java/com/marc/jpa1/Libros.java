package com.marc.jpa1;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "libros")
@NamedQueries({
	@NamedQuery(name = "Libros.findAll",
			query = "SELECT l FROM Libros l"),
	@NamedQuery(name = "Libros.findById", 
	query = "SELECT l FROM Libros l WHERE l.id = :id"),
	@NamedQuery(name = "Libros.findByTitulo",
	query = "SELECT l FROM Libros l WHERE l.titulo = :titulo"),
	@NamedQuery(name = "Libros.findByAutor",
	query = "SELECT l FROM Libros l WHERE l.autor = :autor")})
public class Libros implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "autor")
	private String autor;
	public Libros() {
	}
	public Libros(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}
	@Override
	public boolean equals(Object object) {

		if (!(object instanceof Libros)) {
			return false;
		}
		Libros other = (Libros) object;
		if ((this.id == null && other.id != null) || (this.id != null &&
				!this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "com.marc.jpa1.Libros[ id=" + id + " ]";
	} 
}