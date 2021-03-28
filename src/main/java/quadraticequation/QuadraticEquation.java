package quadraticequation;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class QuadraticEquation {
    public static Roots findRoots(double a, double b, double c) {
        // If a is 0, then equation is not
        // quadratic, but linear

        if (a == 0) {
            System.out.println("Invalid");
            return null;
        }

        int d = (int) (b * b - 4 * a * c);
        double sqrt_val = sqrt(abs(d));

        if (d > 0) {
            System.out.println(
                    "Roots are real and different \n");
            return new Roots((-b + sqrt_val) / (2 * a), (-b - sqrt_val) / (2 * a));
//            System.out.println(
//                    (double)(-b + sqrt_val) / (2 * a) + "\n"
//                            + (double)(-b - sqrt_val) / (2 * a));
        }
        else if (d == 0) {
            System.out.println(
                    "Roots are real and same \n");
            return new Roots(-(double)b / (2 * a), -(double)b / (2 * a));
//            System.out.println(-(double)b / (2 * a) + "\n"
//                    + -(double)b / (2 * a));
        }
        else // d < 0
        {
            System.out.println("Roots are complex \n");
            return null;
            //new Roots(-(double)b / (2 * a) + " + i" + sqrt_val, -(double)b / (2 * a) + " - i" + sqrt_val);
//            System.out.println(-(double)b / (2 * a) + " + i"
//                    + sqrt_val + "\n"
//                    + -(double)b / (2 * a)
//                    + " - i" + sqrt_val);
        }
        //throw new UnsupportedOperationException("Waiting to be implemented.");
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
