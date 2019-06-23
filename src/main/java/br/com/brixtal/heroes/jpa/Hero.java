package br.com.brixtal.heroes.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "hero")
public class Hero implements Serializable {

	protected static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_hero")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Column(name = "tx_name")
	protected String name;

	@Column(name = "ts_created_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", locale = "pt-BR", timezone = "Brazil/East")
	protected Date createdAt;

	@ManyToMany
	@JoinTable(name = "hero_power", joinColumns = { @JoinColumn(name = "fk_hero") }, inverseJoinColumns = {
			@JoinColumn(name = "fk_power") })
	protected List<Power> powerList;

	@ManyToOne
	@JoinColumn(name = "fk_universe")
	protected Universe universe;

	@Column(name = "bo_active")
	protected Boolean active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<Power> getPowerList() {
		return powerList;
	}

	public void setPowerList(List<Power> powerList) {
		this.powerList = powerList;
	}

	public Universe getUniverse() {
		return universe;
	}

	public void setUniverse(Universe universe) {
		this.universe = universe;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
