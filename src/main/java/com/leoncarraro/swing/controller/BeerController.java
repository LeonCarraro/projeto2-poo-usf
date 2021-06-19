package com.leoncarraro.swing.controller;

import java.math.BigDecimal;
import java.util.List;

import com.leoncarraro.swing.dao.BeerDAO;
import com.leoncarraro.swing.model.Beer;

public class BeerController {

	private final BeerDAO beerDAO;
	
	public BeerController(BeerDAO beerDAO) {
		this.beerDAO = beerDAO;
	}
	
	public void save(String sku, String name, String description, Integer volume, BigDecimal value,
			Integer alcoholContent) {
		Beer beer = new Beer(sku, name, description, volume, value, alcoholContent);
		beerDAO.save(beer);
	}
	
	public void deleteBySku(String sku) {
		beerDAO.deleteBySku(sku);
	}
	
	public List<Beer> findAll() {
		return beerDAO.findAll();
	}
}
