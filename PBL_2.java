import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
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

    static float[] common (float[] arr1, float[] arr2, float [] arr3) {
        float[] length = new float[3];
        length[0] = arr1.length;
        length[1] = arr2.length;
        length[2] = arr3.length;
        System.out.println("Length of common array = " + (int)sorter(length)[0]);
        float[] comm = new float[(int)sorter(length)[0]];
        return comm;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch, cond = 1;
        do {
            System.out.println("| ----- MENU ----- |");
            System.out.println("1 - Odd/Even Assigner");
            System.out.println("2 - Find Second Smallest Element in an Array");
            System.out.println("3 - Convert Array to Array List");
            System.out.println("4 - Convert Array List to Array");
            //System.out.println("5 - Find Common Elemets from 3 Arrays");
            System.out.print("Enter Choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    int cnt = 0;
                    System.out.print("Enter no. of elements: ");
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
                    System.out.print("Enter no. of elements: ");
                    cnt = sc.nextInt();
                    float[] sort = dataEntry(cnt);
                    System.out.println("Second smallest element of array is " + sorter(sort)[1]);
                    break;
                case 3:
                    System.out.print("Enter no. of elements: ");
                    cnt = sc.nextInt();
                    float[] conv = dataEntry(cnt);
                    arrayList(conv);
                    break;
                case 4:
                    System.out.print("Enter no. of elements: ");
                    cnt = sc.nextInt();
                    ArrayList <Float> arrli = new ArrayList<Float>(cnt);
                    for (int i = 0; i < cnt; i++) {
                        System.out.print("Enter " + (i+1) + " Element: ");
                        arrli.add(sc.nextFloat());
                    }
                    float[] vnoc = new float[cnt];
                    for (int i = 0; i < cnt; i++)
                        vnoc[i] = arrli.get(i);
                    System.out.print("Array List -> Array: ");
                    for (int i = 0; i < cnt; i++)
                        System.out.print(vnoc[i] + " ");
                    System.out.println("");
                    break;
                default:
                    break;
            }
            System.out.print("\nPress 1 to continue; Any other key to exit: ");
            cond = sc.nextInt();
        } while (cond == 1);
    }
}