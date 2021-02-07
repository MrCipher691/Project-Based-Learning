import java.util.Scanner;

public class PBL_2_2 {
    static float eculid (float a, float b) {
        if (b==0)
            return a;
        return eculid(b, a%b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.console().reader());
        System.out.print("Enter 1st no.: ");
        float a = sc.nextFloat();
        System.out.print("Enter 2nd no.: ");
        float b = sc.nextFloat();
        if (a>b)
            System.out.println("GCD of " + a + " & " + b + " = " + eculid(a, b));
        else
            System.out.println("GCD of " + a + " & " + b + " = " + eculid(b, a));
    }
}