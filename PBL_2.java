import java.util.ArrayList;
import java.util.Scanner;

public class PBL_2 {
    static float[] dataEntry (int n) {
        Scanner sc = new Scanner(System.in);
        float[] arr = new float[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter " + (i+1) + " Element: ");
            arr[i] = sc.nextFloat();
        }
        return arr;
    }

    static void arrPrinter (float[] arr, int n) {
        if (n < 1)
            System.out.println("! ARRAY IS EMPTY !");
        else
            for (int i = 0; i < n; i++)
                System.out.println("Element no " + (i + 1) + " = " + arr[i] + " ");
    }

    static float[] sorter (float[] arr) {
        for (int i = 0; i < (arr.length - 1); i++) {
            for (int j = 0; j < (arr.length - 1); j++) {
                if (arr[j] > arr[j + 1]) {
                    float temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    static void arrayList (float[] arr) {
        ArrayList <Float> arrli = new ArrayList<Float>(arr.length);
        for (int i = 0; i < arr.length; i++)
            arrli.add(arr[i]);
        System.out.println("Array -> ArrayList: " + arrli);
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch, cond = 1;
        do {
            System.out.println("| ----- MENU ----- |");
            System.out.println("1 - Odd/Even Assigner");
            System.out.println("2 - Find Second Smallest Element in an Array");
            System.out.println("3 - Convert Array to Array List");
            System.out.print("Enter Choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    int cnt = 0;
                    System.out.print("Enter no. of number: ");
                    cnt = sc.nextInt();
                    int cntEven, cntOdd, indEven, indOdd;
                    cntEven = cntOdd = indEven = indOdd = 0;
                    float[] arr = dataEntry(cnt);
                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] % 2 == 0)
                            cntEven++;
                        else
                            cntOdd++;
                    }
                    float[] even = new float[cntEven];
                    float[] odd = new float[cntOdd];
                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] % 2 == 0) {
                            even[indEven] = arr[i];
                            indEven++;
                        }
                        else {
                            odd[indOdd] = arr[i];
                            indOdd++;
                        }
                    }
                    System.out.println("\nEVEN ARRAY:");
                    arrPrinter(even, cntEven);
                    System.out.println("NO OF ELEMENTS IN EVEN: " + cntEven);
                    System.out.println("\nODD ARRAY:");
                    arrPrinter(odd, cntOdd);
                    System.out.println("NO OF ELEMENTS IN ODD: " + cntOdd);
                    break;
                case 2:
                    System.out.print("Enter no. of number: ");
                    cnt = sc.nextInt();
                    float[] sort = dataEntry(cnt);
                    sort = sorter(sort);
                    System.out.println("Second smallest element of array is " + sort[1]);
                case 3:
                    System.out.print("Enter no. of number: ");
                    cnt = sc.nextInt();
                    float[] conv = dataEntry(cnt);
                    arrayList(conv);
                    break;
                default:
                    break;
            }
            System.out.print("\nPress 1 to continue; Any other key to exit: ");
            cond = sc.nextInt();
        } while (cond == 1);
    }
}