
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test {
	
	/*
	 * Taylor Large
	 * CS161
	 * Spring 2018
	 * Lab 9-10
	 */
	
	/*
	 * This is the test method
	 * This basically "runs" the program
	 */
	
	public static void main(String args[]) {
		
		String[] figures = {"Ranctangle", "Oval", "Circle", "Triangle", "Line", "Segment", "Arc"};
		Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.PINK, Color.MAGENTA, Color.ORANGE, Color.CYAN, Color.BLACK, Color.WHITE};
		new Menus(figures, colors);
	}
}
