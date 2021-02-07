import java.util.Scanner;

public class PBL_1 {
    static void fibonacci (int x) {
        int ini = 0, next = 1;
        if (x<=0)
            System.out.println("Invalid Input; Should be an integer and more then 0");
        else if (x>0 && x<=2)
            System.out.println("Fibonacci Series: " + ini + " " + next + " ");
        else {
            System.out.print("Fibonacci Series: " + ini + " " + next + " ");
            while(x-2 > 0) {
                int temp = next;
                next += ini;
                ini = temp;
                System.out.print(next + " ");
                x--;
            }
            System.out.println();
        }
    }

    public static void main (String[] args) {
        int cond = 1, ch;
        try (Scanner sc = new Scanner(System.in)) {
            do {
                System.out.println("| -------- MENU -------- |");
                System.out.println("1 - Command Line Arguments\n2 - Scanner\n3 - Buffer Reader\n4 - Data Input Stream\n5 - Console");
                System.out.print("Enter your choice: ");
                ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        int x = Integer.parseInt(args[0]);
                        fibonacci(x);
                        break;
                    case 2:
                        System.out.print("Enter no. of elements: ");
                        int y = sc.nextInt();
                        fibonacci(y);
                        break;
                    case 3:
                        System.out.println("Under Construction 3");
                        break;
                    case 4:
                        System.out.println("Under Construction 4");
                        break;
                    case 5:
                        System.out.println("Under Construction 5");
                        break;
                    default:
                        System.out.println("Invalid Input");
                        break;
                }
                System.out.print("Press 1 to continue; Any other key to exit: ");
                cond = sc.nextInt();
            } while(cond == 1);
        } catch (Exception e) {
            System.out.println("Error Encountered");
        }
    }
}
