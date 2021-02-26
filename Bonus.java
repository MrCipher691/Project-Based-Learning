import java.util.*;

class explain {
    public void Method() {
        System.out.println("Inside Method");
    }
    
    public void Method(int a, int b) {
        System.out.println("Inside Method With Parameters");
        System.out.println("Sum of Parameters = " + (a+b));
    }

    public int Method1() {
        int a = 5;
        System.out.println("Inside Method1: No parameters, but Return");
        System.out.print("Return:");
        return a;
    }

    public int Method(int a) {
        System.out.println("Inside Method with Parameters and Return");
        System.out.print("Return:");
        return a;
    }

    public void arrayList() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inside ArrayList");
        System.out.print("Enter Size of ArrayList: ");
        int n = sc.nextInt();
        ArrayList<Integer> intlist = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            System.out.print("Enter " + (i+1) + " : ");
            int a = sc.nextInt();
            intlist.add(a);
        }
        System.out.println("Elemetnts Insiide List:" + intlist);
        sc.close();
    }
}

public class Bonus {
    public static void main (String[] args) {
        Bonus gcobj = new Bonus();
        explain exp1 = new explain();
        explain exp2 = new explain();
        explain exp3 = new explain();

        explain [] arrObj = new explain [10];
        for (int i = 0; i  < 10; i++)
            arrObj[i] = new explain();

        System.out.println("Calling Method Using Single Object exp1:");
        exp1.Method();
        System.out.println("Calling Method Using Single Object exp2:");
        exp2.Method();
        System.out.println("Calling Method Using Single Object exp3:");
        exp3.Method();
        System.out.println("Calling Method Using Array of Objects:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Object " + (i+1));
            arrObj[i].Method();
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Parameters to be entered: ");
        System.out.print("Enter A: ");
        int a = sc.nextInt();
        System.out.print("Enter B: ");
        int b = sc.nextInt();
        arrObj[3].Method(a, b);
        System.out.println(arrObj[4].Method1());
        System.out.println(arrObj[5].Method(a));
        arrObj[6].arrayList();
        System.out.println("");

        gcobj = null;
        System.gc();
        System.runFinalization();
        sc.close();
    }

    public void finalize () throws Throwable {
        System.out.println("Garbage Collected : " + this);
    }
}