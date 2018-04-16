
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
	
	JPanel east, center, buttonPanel, containerPanel;
	
	protected String[] figureItems;
	protected Color[] colors;
	protected String selectedShape;
	protected Color selectedColor;
	protected JMenuBar bar1;
	protected JMenu figuresMenu, colorsMenu;
	protected JButton paintButton, fillDrawMode, multipleMode, mode, disposeShape;
	protected ButtonGroup buttonGroup;
	protected JRadioButton colorsRadio;
	protected JMenuItem[] figuresArr;
	protected JRadioButtonMenuItem[] colorsArr;
	protected PaintOnPanel paintPanel = new PaintOnPanel();
	protected boolean firstTime = true;
	
	public Menus(String[] figures, Color[] colors) {
		super("Shape drawing coloring thing.exe");
		
		// Menus
		buildFigures(figures);
		buildColors(colors);
		
		// Menu bar
		buildJMenuBar();
		
		// Builds the window
		buildWindow();
	}
	
	public void buildWindow() {
		east = new JPanel();
		center = new JPanel();
		buttonPanel = new JPanel();
		containerPanel = new JPanel();
		
		// Sets the pane to "window"
		Container window = getContentPane();
		
		// Instantiates menu bar
		bar1 = new JMenuBar();
		
		// Creates the button groups
		colorsRadio = new JRadioButton();
		buttonGroup = new ButtonGroup();
		
		buttonPanel.setLayout(new GridLayout(0,4));
		buttonPanel.add(paintButton = new JButton("PAINTBUTTON"), BorderLayout.NORTH);
		buttonPanel.add(disposeShape = new JButton("DISPOSE_SHAPE"), BorderLayout.NORTH);
		buttonPanel.add(fillDrawMode = new JButton("FILL_DRAW_MODE"), BorderLayout.NORTH);
		buttonPanel.add(multipleMode = new JButton("MULTIPLE_MODE"), BorderLayout.NORTH);
		
		paintButton.addActionListener(this);
		disposeShape.addActionListener(this);
		fillDrawMode.addActionListener(this);
		multipleMode.addActionListener(this);
		
		containerPanel.setLayout(new BorderLayout(10,0));
		containerPanel.add(buttonPanel, BorderLayout.NORTH);
		paintPanel.repaint();
		containerPanel.add(paintPanel, BorderLayout.CENTER);
		east.add(containerPanel);
		
		east.setBackground(Color.YELLOW);
		center.setBackground(Color.GREEN);
		window.setBackground(Color.BLACK);
		
		//window.setLayout(new BorderLayout(0,10));
		
		window.add(east, BorderLayout.EAST);
		window.add(center, BorderLayout.CENTER);
		
		setSize(700, 650);
		setLocation(400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("A button was pressed");
		if(e.getActionCommand() == "PAINTBUTTON") {
			if(selectedShape == null) {
				JOptionPane.showMessageDialog(null, "Please select the shape");
			}
			else if(selectedColor == null) {
				JOptionPane.showMessageDialog(null, "Please select the color");
			}
			else {
			firstTime = true;
			paintPanel.repaint();
			}
		}
		else if(e.getActionCommand() == "DISPOSE_SHAPE") {
			
		}
		else if(e.getActionCommand() == "FILL_DRAW_MODE") {
			
		}
		else if(e.getActionCommand() == "MULTIPLE_MODE") {
			
		}
	}
	
	public void buildFigures(String[] figures) {
		
		figuresArr = new JMenuItem[figures.length];
		figuresMenu = new JMenu("Figures");
		for(int k = 0; k < figures.length; k++) {
			figuresMenu.addSeparator();
			figuresArr[k] = (new JMenuItem(figures[k]));
			figuresMenu.add(figuresArr[k]);
		}
		
	}
	
	public void buildColors(Color[] colors) {
		
		colorsArr = new JRadioButtonMenuItem[colors.length];
		colorsMenu = new JMenu("Colors");
		for(int k = 0; k < colors.length; k++) {
			colorsArr[k] = new JRadioButtonMenuItem();
			colorsMenu.addSeparator();
			colorsArr[k].setBackground(colors[k]);
			buttonGroup.add(colorsArr[k]);
			colorsMenu.add(colorsArr[k]);
		}
	}
	
	public void buildJMenuBar() {
		JMenuBar bar1 = new JMenuBar();
		setJMenuBar(bar1);
		bar1.add(figuresMenu);
		bar1.add(colorsMenu);
	}
	
	class FigureListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			selectedShape = ((JMenuItem) e.getSource()).getText();
			System.out.println("Memes");
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
			setBackground(Color.MAGENTA);
			super.paintComponent(g);
			
			if(selectedShape != null && selectedColor != null) {

				setBackground(Color.CYAN);
				
				switch(selectedShape) {
				case "Rectangle":
					g.drawRect(200, 200, 80, 60);
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
	
}
