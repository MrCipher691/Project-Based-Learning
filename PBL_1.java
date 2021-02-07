import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
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
                        FileReader fr = new FileReader("input.txt");
                        BufferedReader br = new BufferedReader(fr);
                        int z;
                        while((z = br.read())!=-1) {
                            z = Character.getNumericValue(z);
                            fibonacci(z);
                        }
                        br.close();
                        fr.close();
                        break;
                    case 4:
                        InputStreamReader r = new InputStreamReader(System.in);  
                        BufferedReader isr = new BufferedReader(r);  
                        System.out.print("Enter no. of elements: ");
                        String elements = isr.readLine();
                        int ele = Integer.parseInt(elements);
                        fibonacci(ele);
                        break;
                    case 5:
                        System.out.print("Enter no. of elements: ");
                        String number = System.console().readLine();
                        int num = Integer.parseInt(number);
                        fibonacci(num);
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
