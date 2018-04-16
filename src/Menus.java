
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
	
	JPanel east, center;
	
	protected String[] figureItems;
	protected Color[] colors;
	protected String selectedShape;
	protected Color selectedColor;
	protected JMenuBar bar1;
	protected JMenu figuresMenu, colorsMenu;
	protected JButton paintButton, fillDrawMode, multipleMode, mode, disposeShape;
	protected ButtonGroup buttonGroup;
	protected JRadioButton colorsRadio;
	
	public Menus(String[] figures, Color[] colors) {
		super("Shape drawing coloring thing.exe");
		
		colorsRadio = new JRadioButton();
		buttonGroup = new ButtonGroup();
		
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
			item2 = new JRadioButtonMenuItem();
			item2.addActionListener(this);
			item2.setBackground(colors[k]);
			buttonGroup.add(item2);
			colorsMenu.add(item2);
		}
		
		// Menu bar
		JMenuBar bar1 = new JMenuBar();
		setJMenuBar(bar1);
		bar1.add(figuresMenu);
		bar1.add(colorsMenu);
		
		buildWindow();
	}
	
	public void buildWindow() {
		east = new JPanel();
		center = new JPanel();
		PaintOnPanel paintPanel = new PaintOnPanel();
		
		Container pane = getContentPane();
		
		bar1 = new JMenuBar();
		
		center.setLayout(new GridLayout(0,4));
		center.add(paintButton = new JButton("PAINTBUTTON"), BorderLayout.NORTH);
		center.add(disposeShape = new JButton("DISPOSE_SHAPE"), BorderLayout.NORTH);
		center.add(fillDrawMode = new JButton("FILL_DRAW_MODE"), BorderLayout.NORTH);
		center.add(multipleMode = new JButton("MULTIPLE_MODE"), BorderLayout.NORTH);
		east.setBackground(Color.green);
		
		pane.add(east, BorderLayout.CENTER);
		pane.add(center, BorderLayout.NORTH);
		//pane.add(paintPanel);
		
		setSize(500, 250);
		setLocation(400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == "PAINTBUTTON") {
			
		}
		else if(e.getSource() == "DISPOSE_SHAPE") {
			
		}
		else if(e.getSource() == "FILL_DRAW_MODE") {
			
		}
		else if(e.getSource() == "MULTIPLE_MODE") {
			
		}
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
	
	@SuppressWarnings("serial")
	class PaintOnPanel extends JPanel {
		
		public void paintComponent(Graphics g) {
			setBackground(Color.magenta);
			super.paintComponent(g);
			
			switch(selectedShape) {
			case "Rectangle":
				g.drawRect(20, 20, 8, 6);
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
			
			g.setColor(selectedColor);
			
		}
	}
	
}
