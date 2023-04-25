import java.lang.Math;

public class QuadraticEquation {
    public static Roots findRoots(double a, double b, double c) {
      double root = Math.sqrt(b*b - 4*a*c);
      double denominator = 2 * a;
      double x1 = (-b + root) / denominator;
      double x2 = (-b - root) / denominator;
      
      Roots answer = new Roots(x1,x2);
      return answer;
    }
    
    public static void main(String[] args) {
        Roots roots = QuadraticEquation.findRoots(2, 10, 8);
        System.out.println("Roots: " + roots.x1 + ", " + roots.x2);
    }
}

class Roots {
    public final double x1, x2;

    public Roots(double x1, double x2) {         
        this.x1 = x1;
        this.x2 = x2;
    }
}
