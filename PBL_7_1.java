import java.util.Scanner;

public class PBL_7_1 {
    static Scanner sc = new Scanner(System.in);

    static long gcd(long a, long b) {
        if (a == 0)
            return b;
        else if (b == 0)
            return a;
        if (a < b)
            return gcd(a, b % a);
        else
            return gcd(b, a % b);
    }

    static void toFraction(double d) {
        double intVal = Math.floor(d);
        double fVal = d - intVal;
        final int pVal = 10000;
        long gcdVal = gcd(Math.round(fVal * pVal), pVal);
        long num = Math.round(fVal * pVal) / gcdVal;
        long deno = pVal / gcdVal;
        System.out.print((long) (intVal * deno) + num + "/" + deno);
    }

    static void toDouble(double num) {
        double a = num;
        System.out.println("Value of A: " + a);
        System.out.println(a);
        if (a > 1) {
            int d = 0;
            while (a > 10) {
                a /= 10.0;
                d++;
            }
            System.out.print(a + " * " + "10^" + d);
        }
        else if (a > 0 && a < 1) {
            int d = 0;
            while (true) {
                a *= 10.0;
                d++;
                if (a > 0)
                    break;
            }
            System.out.print(a + " * " + "10^ -" + d);
        }
        else {
            a *= -1;
            int d = 0;
            while (a > 10) {
                a /= 10.0;
                d++;
            }
            System.out.print("-" + a + " * " + "10^" + d);
        }
        System.out.println();
    }

    static void result(Double a, double b, Double c, Double d) {
        double res = 0;
        int ch;

        System.out.println("\n\nR1 & R2 are Rational Numbers");
        System.out.println("1 - Add [R1+R2]");
        System.out.println("2 - Subtract [R1+R2]");
        System.out.println("3 - Multiply [R1+R2]");
        System.out.println("4 - Divide [R1/R2]");
        System.out.println("5 - Convert to floating point");
        System.out.print("Enter Choice : ");
        
        ch = sc.nextInt();

        switch (ch) {
            case 1:
                res = (a * d + b * c) / (b * d);
                System.out.println("SUM OF [ " + a + "/" + b + " ] + [" + c + "/" + d + " ] = ");
                toFraction(res);
                System.out.print("[" + res + " ]");
                break;
            case 2:
                res = (a * d - b * c) / (b * d);
                System.out.println("DIFFERENCE OF [ " + a + "/" + b + " ] - [" + c + "/" + d + " ] = ");
                toFraction(res);
                System.out.print("[" + res + " ]");
                break;
            case 3:
                res = (a * c) / (b * d);
                System.out.println("PRODUCT OF [ " + a + "/" + b + " ] * [" + c + "/" + d + " ] = ");
                toFraction(res);
                System.out.print("[" + res + " ]");
                break;
            case 4:
                res = (a * d) / (c * b);
                System.out.println("DIVISION OF [ " + a + "/" + b + " ] ÷ [" + c + "/" + d + " ] = ");
                toFraction(res);
                System.out.print("[" + res + " ]");
                break;
            case 5:
                System.out.println("CONVERTING TO FLOATING POINT [ " + a + "/" + b + " ] = ");
                toDouble(a / b);
                System.out.print("[ " + c + "/" + d + " ] =");
                toDouble(c / d);
                break;
            default:
                System.out.println("! -- TERMINATING PROGRAM -- !");
                System.exit(0);
                break;
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Arthemetic Operaton On Rational Numbers");
            System.out.print("Enter Rational Number 1 : ");

            double a = Integer.parseInt(sc.next());
            double b = Integer.parseInt(sc.next());

            if (b == 0)
                throw new ArithmeticException("Denominator can not be equal to 0");
            
            System.err.print("Enter Rational Number 2 : ");
            
            double c = Integer.parseInt(sc.next());
            double d = Integer.parseInt(sc.next());
            
            if (d == 0)
                throw new ArithmeticException("Denominator can not be equal to 0");
            while (true)
                result(a, b, c, d);
        }
        catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}