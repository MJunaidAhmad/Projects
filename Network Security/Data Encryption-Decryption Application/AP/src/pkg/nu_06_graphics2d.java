package pkg;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

public class nu_06_graphics2d extends JFrame 
{
  public nu_06_graphics2d()
  {	
	setSize(500,500);
	setTitle("Hello Graphics 2D");
	setDefaultCloseOperation(EXIT_ON_CLOSE);

	//add(new nu_06_graphics2DIntro());
	add(new nu_06_basicStrokes());
	//add(new nu_06_curves());
	//add(new nu_06_generalPath());
	//nu_06_pakistan obj = new nu_06_pakistan();
	//add(new nu_08_mandelbrot());
	//add(new nu_08_spiral());

	setVisible(true);
  }

  public static void main(String[] args)
  {
	nu_06_graphics2d win = new nu_06_graphics2d();	
  }
}
