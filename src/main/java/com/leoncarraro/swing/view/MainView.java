package com.leoncarraro.swing.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import com.leoncarraro.swing.controller.BeerController;
import com.leoncarraro.swing.model.Beer;

public class MainView {

	private JFrame frame;
	
	private JTextField inputSKU;
	private JTextField inputName;
	private JTextField inputDescription;
	private JSpinner inputVolume;
	private JSpinner inputValue;
	private JSpinner inputAlcoholContent;
	
	private JTable table;
	
	private JButton btnDelete;
	
	private final BeerController beerController;

	public MainView(BeerController beerController) {
		this.beerController = beerController;
		initialize();
		show();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Sistema de controle de vendas de bebidas");
		frame.setBounds(100, 100, 800, 559);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblSKU = new JLabel("SKU");
		lblSKU.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSKU.setBounds(10, 11, 90, 14);
		
		inputSKU = new JTextField();
		inputSKU.setBounds(110, 8, 100, 20);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(11, 86, 89, 23);
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				save();
			}
		});
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(684, 489, 89, 23);
		btnDelete.setEnabled(false);
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				delete();
			}
		});
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(getData());
		table.setBounds(10, 36, 325, 37);
		table.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				enableDeleteButton();
			}
		});
		
		JScrollPane scrollTable = new JScrollPane(table);
		scrollTable.setBounds(10, 120, 763, 358);
		scrollTable.setVisible(true);

		frame.getContentPane().add(lblSKU);
		frame.getContentPane().add(inputSKU);
		frame.getContentPane().add(scrollTable);
		frame.getContentPane().add(btnSave);
		frame.getContentPane().add(btnDelete);
		
		JLabel lblName = new JLabel("Nome");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(220, 11, 90, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblDescription = new JLabel("Descri\u00E7\u00E3o");
		lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescription.setBounds(10, 36, 90, 14);
		frame.getContentPane().add(lblDescription);
		
		JLabel lblVolume = new JLabel("Volume (ml)");
		lblVolume.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVolume.setBounds(10, 61, 90, 14);
		frame.getContentPane().add(lblVolume);
		
		JLabel lblValue = new JLabel("Valor");
		lblValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValue.setBounds(220, 61, 90, 14);
		frame.getContentPane().add(lblValue);
		
		JLabel lblAlcoholContent = new JLabel("Teor Alco\u00F3lico");
		lblAlcoholContent.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlcoholContent.setBounds(483, 61, 90, 14);
		frame.getContentPane().add(lblAlcoholContent);
		
		inputName = new JTextField();
		inputName.setBounds(320, 8, 453, 20);
		frame.getContentPane().add(inputName);
		inputName.setColumns(10);
		
		inputDescription = new JTextField();
		inputDescription.setBounds(110, 33, 663, 20);
		frame.getContentPane().add(inputDescription);
		inputDescription.setColumns(10);
		
        SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
		inputVolume = new JSpinner(model);
		inputVolume.setBounds(110, 58, 86, 20);
		frame.getContentPane().add(inputVolume);
		
        SpinnerNumberModel valueSpinnerModel = new SpinnerNumberModel(0.01, 0.01, Double.MAX_VALUE, 0.01);
		inputValue = new JSpinner(valueSpinnerModel);
		inputValue.setBounds(320, 58, 86, 20);
		frame.getContentPane().add(inputValue);

        SpinnerNumberModel alcoholContentSpinnerModel = new SpinnerNumberModel(0, 0, 100, 1);
		inputAlcoholContent = new JSpinner(alcoholContentSpinnerModel);
		inputAlcoholContent.setBounds(583, 58, 86, 20);
		frame.getContentPane().add(inputAlcoholContent);
	}
	
	private void show() {
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	private void save() {
		String sku = inputSKU.getText();
		String name = inputName.getText();
		String description = inputDescription.getText();
		Integer volume = (Integer) inputVolume.getModel().getValue();
		BigDecimal value = BigDecimal.valueOf((Double) inputValue.getModel().getValue());
		Integer alcoholContent = (Integer) inputAlcoholContent.getModel().getValue();
		
		beerController.save(sku, name, description, volume, value, alcoholContent);
		resetWindowState();

		JOptionPane.showMessageDialog(null, "Cerveja de código " + sku + "  salva com sucesso!");
	}
	
	private void delete() {
		int selectedRow = table.getSelectedRow();
		
		if (btnDelete.isEnabled()) {
			String sku = (String) table.getModel().getValueAt(selectedRow, 0);
			beerController.deleteBySku(sku);
			resetWindowState();
			JOptionPane.showMessageDialog(null, "Cerveja excluida com sucesso!");
		}
	}
	
	private void enableDeleteButton() {
		btnDelete.setEnabled(true);
	}
	
	private void resetWindowState() {
		table.setModel(getData());
		inputSKU.setText("");
		inputName.setText("");
		inputDescription.setText("");
		inputVolume.getModel().setValue(1);
		inputValue.getModel().setValue(0.01);
		inputAlcoholContent.getModel().setValue(1);
		btnDelete.setEnabled(false);
	}
	
	private DefaultTableModel getData() {
		List<Beer> beers = beerController.findAll();
		
		Object[][] data = new Object[beers.size()][6];
		for (int i = 0; i < beers.size(); i++) {
			data[i][0] = beers.get(i).getSku();
			data[i][1] = beers.get(i).getName();
			data[i][2] = beers.get(i).getDescription();
			data[i][3] = beers.get(i).getVolume();
			data[i][4] = beers.get(i).getValue();
			data[i][5] = beers.get(i).getAlcoholContent();
		}
		
		Object[] columns = new Object[] {"SKU", "Nome", "Descrição", "Volume (ml)", "Valor Unitário", "Teor Alcoólico (%)"};
		
		return new DefaultTableModel(data, columns);
	}
}
