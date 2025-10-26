import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class DrawingTriangle {

    public static void main(String[] args) {
        System.out.println("Drawing a triangle");

//        createFrame();
        int a[];
        int []c;
       
    }
    
    
    //----------------- createFrame Method  --------------------
    public static void createFrame () {
    	
    	JFrame frame = new JFrame("Triangle");
    	
    	// create frame
    	frame.setTitle("Triangle");
    	frame.setSize(480, 480);
    	frame.setResizable(false);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	// set background color using
    	setBackgroudClor(frame);
    	
    	
    	
    	
    	frame.add(new DrawPanel());
    	
    	frame.setVisible(true);
    }
   
  //----------------- setBackgroudClor Method  --------------------
    public static void setBackgroudClor (JFrame frame) {
    	// set the background color
    	Color bgColor = new Color (238, 238, 238);
    	frame.getContentPane().setBackground(bgColor);
    }
    
    
  //----------------- DrawPanel Class  --------------------
    static class DrawPanel extends JPanel {
    	
    	@Override
    	protected void paintComponent(Graphics g) {
    		
    		// clears the background before drawing
    		super.paintComponent(g);
    		
    		// draw  a triangle    		
    		drawTriangle(g);
    	}
    	
    	private void drawTriangle (Graphics g) {
    		 g.setColor(Color.DARK_GRAY);
             int[] x = {100, 380, 220};
             int[] y = {400, 400, 150};
             g.fillPolygon(x, y, 3);
    		
    	}

    }
}
