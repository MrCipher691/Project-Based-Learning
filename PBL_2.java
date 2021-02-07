import java.util.Scanner;

public class PBL_2 extends Calculator {
    static float[] getInput(int n) {
        Scanner sc = new Scanner(System.console().reader());
        float[] num = new float[10];
        for(int cnt = 0; cnt<n; cnt++) {
            System.out.print("Enter no.: ");
            num[cnt] = sc.nextFloat();
        }
        return num;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.console().reader());
        int cond = 1, ch, ter;
        do {
            System.out.println("| ---- MENU ---- |");
            System.out.println("1 - Add | 2 - Sub\n3 - Mul | 4 - Div\n5 - Sqt | 6 - Pow\n7 - Mean| 8 - Var");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();
            switch(ch) {
                case 1:
                    System.out.print("Enter no. of terms: ");
                    ter = sc.nextInt();
                    System.out.println("Answer: " + add(getInput(ter)));
                    break;
                case 2:
                    System.out.print("Enter no. of terms: ");
                    ter = sc.nextInt();
                    System.out.println("Answer: " + sub(getInput(ter)));
                    break;
                case 3:
                    System.out.print("Enter no. of terms: ");
                    ter = sc.nextInt();
                    System.out.println("Answer: " + mul(getInput(ter), ter));
                    break;
                case 4:
                    System.out.print("Enter no. of terms: ");
                    ter = sc.nextInt();
                    System.out.println("Answer: " + div(getInput(ter), ter));
                    break;
                case 5:
                    System.out.print("Enter no. of terms: ");
                    ter = sc.nextInt();
                    sqrt(getInput(ter), ter);
                    break;
                case 6:
                    System.out.print("Enter no. of terms: ");
                    ter = sc.nextInt();
                    ter *= 2;
                    pow(getInput(ter), ter);
                    break;
                case 7:
                    System.out.print("Enter no. of terms: ");
                    ter = sc.nextInt();
                    System.out.println("Mean = " + avg(ter));
                    break;
                case 8:
                    System.out.print("Enter no. of terms: ");
                    ter = sc.nextInt();
                    System.out.println("Variance = " + var(getInput(ter), ter));
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
            System.out.print("Press 1 to continue; Any other key to exit: ");
            cond = sc.nextInt();
        } while (cond == 1);
    }  
}
