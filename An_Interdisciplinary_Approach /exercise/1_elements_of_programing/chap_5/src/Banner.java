import java.awt.Font;

public class Banner {

    public static void main(String[] args) {

        System.out.println("Banner App");
        // for test:
//        String word = "Willamina";
//        double speed =  0.02;
        
        String word = args[0];
        double speed = Double.parseDouble(args[1]);
        
        
        // Setup canvas
        StdDraw.setCanvasSize(400, 200);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);

        // Font and color
        Font font = new Font("Arial", Font.BOLD, 60);
        StdDraw.setFont(font);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.enableDoubleBuffering();

        // Animation
        for (double i = 0.0; true; i += speed) {
            StdDraw.clear(StdDraw.BLACK);

            StdDraw.text((i % 1.0),       0.5, word);
            StdDraw.text((i % 1.0) - 1.0, 0.5, word);
            StdDraw.text((i % 1.0) + 1.0, 0.5, word);

            StdDraw.show();
            StdDraw.pause(60);
        }
    }
}