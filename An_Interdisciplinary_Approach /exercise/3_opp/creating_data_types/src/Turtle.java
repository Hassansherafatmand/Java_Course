import princetonLibs.*;

public class Turtle {

    private double x, y;
    private double angle;
    
    public Turtle(double x0, double y0, double a0) {
        this.x = x0;
        this.y = y0;
        this.angle = a0;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getAngle() {
        return angle;
    }

   

    public void turnLeft(double delta) {
        this.angle += delta;
    }
    
    public void goForward(double step) {
        double oldX = x, oldY = y;
        this.x += step * Math.cos(Math.toRadians(angle));
        this.y += step * Math.sin(Math.toRadians(angle));
        System.out.printf("(%.1f, %.1f, %.1f)%n", getX(), getY(), getAngle());
        StdDraw.line(oldX, oldY, x, y);
    }
    
    
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + getAngle() + ")";
    }
    
    
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double angle = 360.0 / n;
        double step = Math.sin(Math.toRadians(angle / 2.0));
        
        Turtle turtle = new Turtle(0.5, 0.0, angle / 2);
        for (int i = 0; i < n; i++) {
            System.out.println(turtle.toString());
            turtle.goForward(step);
            turtle.turnLeft(angle);
        }
    }
}
