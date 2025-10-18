import java.awt.Color;
import princetonLibs.*;

public class Fade {
    public static void main(String[] args) {
        Picture source = new Picture(args[0]);
        Picture target = new Picture(args[1]);
        int n = Integer.parseInt(args[2]);

        int width = source.width();
        int height = source.height();

        Picture pic = new Picture(width, height);

        for (int i = 0; i <= n; i++) {
            double alpha = (double) i / n;

            for (int col = 0; col < width; col++) {
                for (int row = 0; row < height; row++) {
                    Color c1 = source.get(col, row);
                    Color c2 = target.get(col, row);
                    Color blended = blend(c1, c2, alpha);
                    pic.set(col, row, blended);
                }
            }

            pic.show(); 
            StdDraw.pause(1000); 

        }
    }

    public static Color blend(Color c1, Color c2, double alpha) {
        double r = (1 - alpha) * c1.getRed() + alpha * c2.getRed();
        double g = (1 - alpha) * c1.getGreen() + alpha * c2.getGreen();
        double b = (1 - alpha) * c1.getBlue() + alpha * c2.getBlue();
        return new Color((int) r, (int) g, (int) b);
    }
}
