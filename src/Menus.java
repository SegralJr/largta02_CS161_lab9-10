
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
	protected JButton paintButton, fillDrawMode, multipleMode, mode, disposeShape;
	
	public Menus(String[] figures, Color[] colors) {
		super("Shape drawing coloring thing.exe");
		
		// Menus
		figuresMenu = new JMenu("Figures");
		JMenuItem item;
		for(int k = 0; k < figures.length; k++) {
			figuresMenu.addSeparator();
			item = new JMenuItem(figures[k]);
			item.addActionListener(this);
			figuresMenu.add(item);
		}
		
		colorsMenu = new JMenu("Colors");
		JMenuItem item2;
		for(int k = 0; k < colors.length; k++) {
			colorsMenu.addSeparator();
			item2 = new JMenuItem();
		}
		
		// Menu bar
		JMenuBar bar1 = new JMenuBar();
		setJMenuBar(bar1);
		bar1.add(figuresMenu);
		bar1.add(colorsMenu);
		
		buildWindow();
	}
	
	public void buildWindow() {
		north = new JPanel();
		east = new JPanel();
		south = new JPanel();
		west = new JPanel();
		center = new JPanel();
		
		Container pane = getContentPane();
		
		//paintButton = new JButton("PAINTBUTTON");
		disposeShape = new JButton("DISPOSE_SHAPE");
		fillDrawMode = new JButton("FILL_DRAW_MODE");
		multipleMode = new JButton("MULTIPLE_MODE");
		
		bar1 = new JMenuBar();
		
		north.setLayout(new GridLayout(0,4));
		north.add(paintButton = new JButton("PAINTBUTTON"));
		north.add(disposeShape);
		north.add(fillDrawMode);
		north.add(multipleMode);
		
		pane.add(north);
		
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
	
	class PaintOnPanel extends JPanel {
		
		public void paintComponent(Graphics g) {
			switch(selectedShape) {
			case "Rectangle":
				break;
			case "Oval":
				break;
			case "Circle":
				break;
			case "Triangle":
				break;
			case "Line":
				break;
			case "Segment":
				break;
			case "Arc":
				break;
			}
		}
	}
	
}
