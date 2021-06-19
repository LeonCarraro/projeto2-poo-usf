package com.leoncarraro.swing;

import java.awt.EventQueue;

import com.leoncarraro.swing.controller.BeerController;
import com.leoncarraro.swing.dao.BeerDAO;
import com.leoncarraro.swing.view.MainView;

public class Application {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BeerDAO beerDAO = new BeerDAO();
					BeerController beerController = new BeerController(beerDAO);
					new MainView(beerController);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
