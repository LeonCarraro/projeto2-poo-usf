package com.usf.swing.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_beer")
public class Beer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String sku;
    private String name;
    private String description;
    private Integer volume;
    private BigDecimal value;
    private Integer alcoholContent;
    
    @Deprecated
    public Beer() {}
    
	public Beer(String sku, String name, String description, Integer volume, BigDecimal value,
			Integer alcoholContent) {
		this.id = null;
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.volume = volume;
		this.value = value;
		this.alcoholContent = alcoholContent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Integer getAlcoholContent() {
		return alcoholContent;
	}

	public void setAlcoholContent(Integer alcoholContent) {
		this.alcoholContent = alcoholContent;
	}
}
