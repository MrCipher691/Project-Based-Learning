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
        return (date + "/" + month + "/" + year);
    }
}

class Marks {
    int pbl;
    int ds;
    int os;
    int em3;

    Marks() {
        pbl = ds = os = em3 = 0;
    }

    Marks(int pbl, int ds, int os, int em3) {
        this.pbl = pbl;
        this.ds = ds;
        this.os = os;
        this.em3 = em3;
    }

    public String grader() {
        if (pbl < 0 || pbl > 100 || ds < 0 || ds > 100 || os < 0 || os > 100 || em3 < 0 || em3 > 100)
            return "Invalid Value Entered";
        else {
            int total = (int)((pbl + ds + os + em3) / 4);
            if (total <= 100 && total > 80)
                return "A";
            else if (total <= 80 && total > 60)
                return "B+";
            else if (total <= 60 && total > 40)
                return "B";
            else if (total <= 40 && total > 20)// Logic Error in Question; Hence Improvised
                return "C";
            else
                return "F";
        }
    }
}

public class Student implements Comparable<Student> {
    Scanner sc = new Scanner(System.in);

    public String name;
    public int prn;
    public String dob;
    public String marks;
    public int points;

    Student() {
        this.name = "Testing";
        this.prn = 101;
        this.dob = "2/7/2027";
        this.marks = "T";
        this.points = 0;
    }

    public Student(String name, int prn, String dob, String marks, int points) {
        this.name = name;
        this.prn = prn;
        this.dob = dob;
        this.marks = marks;
        this.points = points;
    }

    public void getName() {
        sc.nextLine();
        System.out.print("Enter Name: ");
        this.name = sc.nextLine();
    }

    public void getPRN() {
        System.out.print("Enter PRN: ");
        this.prn = sc.nextInt();
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
        int[] temp = new int[4];
        System.out.print("Enter PBL Marks: ");
        temp[0] = sc.nextInt();
        System.out.print("Enter DS Marks: ");
        temp[1] = sc.nextInt();
        System.out.print("Enter OS Marks: ");
        temp[2] = sc.nextInt();
        System.out.print("Enter EM3 Marks: ");
        temp[3] = sc.nextInt();

        Marks markObj = new Marks(temp[0], temp[1], temp[2], temp[3]);
        marks = markObj.grader();
        points = (int)(temp[0] + temp[1] + temp[2] + temp[3]) / 4;
    }

    @Override
    public int compareTo(Student o) {
        return o.points - this.points;
    }

    @Override
    public String toString() {
        return String.format("Name: %1$10s\tPRN: %2$4d\tDOB: %3$10s\tMarks: %4$s", name, prn, dob, marks);
    }
}