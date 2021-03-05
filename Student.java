import java.util.Comparator;
import java.util.Scanner;

class DOB {
    int date;
    int month;
    int year;

    DOB() {
        date = 1;
        month = 1;
        year = 2021;
    }

    DOB(int date, int month, int year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public String printDOB() {
        return (date + "/" + month  + "/" + year);
    }
}

class Marks {
    double pbl;
    double ds;
    double os;
    double em3;

    Marks() {
        pbl = ds = os = em3 = 0.0;
    }

    Marks(double pbl, double ds, double os, double em3) {
        this.pbl = pbl;
        this.ds = ds;
        this.os = os;
        this.em3 = em3;
    }

    public String grader() {
        if(pbl<0 || pbl>100 || ds<0 || ds>100 || os<0 || os>100 || em3<0 || em3>100)
            return "Invalid Value Entered";
        else {
            double total = ((pbl + ds + os + em3)/400)*100;
            if(total<=100 && total>80)
                return "A";
            else if(total<=80 && total>60)
                return "B+";
            else if(total<=60 && total>40)
                return "B";
            else if(total<=40 && total>20)//Logic Error in Question; Hence Improvised
                return "C";
            else
                return "F";
        }
    }
}

public class Student {
    Scanner sc = new Scanner(System.in);

    public String name;
    public double prn;
    public String dob;
    public String marks;
    public double points;
    public int temp;

    Student() {
        this.name = "Testing";
        this.prn = 101.101;
        this.dob = "1/1/2027";
        this.marks = "T";
        this.points = 101.101;
        this.temp = (int)this.prn;
    }

    public void getName() {
        sc.nextLine();
        System.out.print("Enter Name: ");
        this.name = sc.nextLine();
    }
    public void getPRN() {
        System.out.print("Enter PRN: ");
        this.prn = sc.nextDouble();
        this.temp = (int)prn;
    }
    public void getDOB() {
        System.out.println("-- Enter DOB Details --");
        int[] temp = new int[3];
        System.out.print("Enter Date: ");
        temp[0] = sc.nextInt();
        System.out.print("Enter Month: ");
        temp[1] = sc.nextInt();
        System.out.print("Enter Year: ");
        temp[2] = sc.nextInt();

        DOB dobj = new DOB(temp[0], temp[1], temp[2]);
        dob = dobj.printDOB();
    }
    public void getMarks() {
        System.out.println("-- Enter Marks (<=100 & >0) --");
        double[] temp = new double[4];
        System.out.print("Enter PBL Marks: ");
        temp[0] = sc.nextDouble();
        System.out.print("Enter DS Marks: ");
        temp[1] = sc.nextDouble();
        System.out.print("Enter OS Marks: ");
        temp[2] = sc.nextDouble();
        System.out.print("Enter EM3 Marks: ");
        temp[3] = sc.nextDouble();

        Marks markObj = new Marks(temp[0], temp[1], temp[2], temp[3]);
        marks = markObj.grader();
        points = (temp[0] + temp[1] + temp[2] + temp[3])/4;
    }
}

class Sorter implements Comparator<Student> {
    public int compare(Student a, Student b) {
        return (a.temp - b.temp);
    }
}