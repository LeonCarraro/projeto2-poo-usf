package com.usf.swing;

import java.awt.EventQueue;

import com.usf.swing.controller.BeerController;
import com.usf.swing.dao.BeerDAO;
import com.usf.swing.view.MainView;

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
