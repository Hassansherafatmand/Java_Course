package quiz;

import java.util.Scanner;
import princetonLibs.StdDraw;

public class SierpinskiTriangles {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Please enter the depth: ");
        int n = console.nextInt();
        console.close();


        // draw the outer triangle
        double[] x = {0.0, 1.0, 0.5};
        double[] y = {0.0, 0.0, Math.sqrt(3) /2}; //Math.sqrt(3) / 2 = 0.866
        StdDraw.polygon(x, y);

        // start recursion
        drawSierpinski(n, 0.5, 0.0, 0.5);
    }

    // draw the triangle
    public static void filledTriangle(double x, double y, double size) {
        double[] xCoords = {x, x - size / 2, x + size / 2};
        double[] yCoords = {y + size * Math.sqrt(3) / 2, y, y};
        StdDraw.filledPolygon(xCoords, yCoords);
    }

    // recursive Sierpinski
    public static void drawSierpinski(int n, double x, double y, double size) {
        if (n == 0) return;

        // draw single filled triangle
        filledTriangle(x, y, size);

        // recursive calls for the small triangles
        drawSierpinski(n - 1, x - size / 2, y, size / 2);                    // left
        drawSierpinski(n - 1, x + size / 2, y, size / 2);                    // right
        drawSierpinski(n - 1, x, y + size * (Math.sqrt(3) / 2), size / 2);     // top
    }
}
