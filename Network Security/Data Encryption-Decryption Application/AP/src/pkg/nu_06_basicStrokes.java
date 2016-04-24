package pkg;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Polygon;
import java.util.Random;
import java.awt.BasicStroke;

@SuppressWarnings("serial")
public class nu_06_basicStrokes extends JPanel
{
	 public void paintComponent(Graphics g)
	  {
		int[] xValues = {20, 40, 50, 30, 20, 15};
		int[] yValues = {50, 50, 60, 80, 80, 60};

		Polygon myPoli = new Polygon(xValues, yValues, 6);
		g.drawPolygon(myPoli);


		int[] xValues2 = { 70, 90, 100, 80, 70, 65, 60};
		int[] yValues2 = { 100, 100, 110, 110, 130, 110, 90};
		g.drawPolyline(xValues2, yValues2, 7);

		int[] xValues3 = {120, 140, 160, 190};
		int[] yValues3 = {40, 70, 80, 60};
		g.fillPolygon(xValues3, yValues3, 4);
	  }
	 }
