
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menus extends JFrame implements ActionListener {
	
	/*
	 * Taylor Large
	 * CS161
	 * Spring 2018
	 * Lab 9-10
	 */
	
	/*
	 * This is the main GUI class
	 * This is the main code
	 */
	
	JPanel north, east, south, west, center;
	
	protected String[] figureItems;
	protected Color[] colors;
	protected String selectedShape;
	protected Color selectedColor;
	protected JMenuBar bar1;
	protected JMenu figuresMenu, colorsMenu;
	
	public Menus(String[] figures, Color[] colors) {
		super("Shape drawing coloring thing.exe");
		figuresMenu = new JMenu("Figures");
		colorsMenu = new JMenu("Colors");
		
		buildWindow();
	}
	
	public void buildWindow() {
		north = new JPanel();
		east = new JPanel();
		south = new JPanel();
		west = new JPanel();
		center = new JPanel();
		
		setSize(500, 250);
		setLocation(400, 400);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void buildFigures(String[] fig) {
		JMenuItem[] menuItemArr = new JMenuItem[fig.length]; // Create menuItemArr
		
		for(int k = 0; k < fig.length; k++) { // Instantiates each menu item
			menuItemArr[k] = new JMenuItem(fig[k]);
			menuItemArr[k].addActionListener(this);
			figuresMenu.add(menuItemArr[k]);
		}
	}
	
	public void buildColors(Color[] col) {
		JMenuItem[] menuItemArr = new JMenuItem[col.length];
		
		for(int k = 0; k < col.length; k++) {
			menuItemArr[k] = new JMenuItem();
			menuItemArr[k].setBackground(col[k]);
			figuresMenu.add(menuItemArr[k]);
		}
	}
	
	public void buildJMenuBar() {
		
	}
	
	class FigureListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			selectedShape = ((JMenuItem) e.getSource()).getText();
		}
		
	}

	class ColorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			selectedColor = ((JRadioButtonMenuItem) e.getSource()).getBackground();
			
		}
		
	}
	
}
