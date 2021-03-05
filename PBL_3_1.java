import java.util.Arrays;
import java.util.Scanner;

public class PBL_3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfStudents = 5;
        int studentCount = 5;
        int contiue = 1;

        System.out.print("Enter Total no of Students: ");
        noOfStudents = sc.nextInt();
        Student[] stud = new Student[noOfStudents];
        stud[0] = new Student("Tom", 41, "16/1/2002", "A", 92);
        stud[1] = new Student("Strange", 40, "11/12/2023", "C", 23);
        stud[2] = new Student("Clint", 53, "15/10/2002", "F", 2);
        stud[3] = new Student("Hans", 21, "1/1/2027", "B", 42);
        stud[4] = new Student("Zimmer", 67, "18/4/2001", "A", 98);
        //for(int i = 0; i < noOfStudents; i++)
        //    stud[i] = new Student();

        do{
            int menuChoice;
            System.out.println("| -------- MENU -------- |");
            System.out.println("1 - Add Student Data");
            System.out.println("2 - Display Student Data");
            System.out.println("3 - Search by Student Data");
            System.out.println("4 - Update Student Data");
            System.out.println("5 - Delete Student Data");
            System.out.println("6 - Sorted Output");
            System.out.print("Enter Choice Here: ");
            menuChoice = sc.nextInt();

            switch (menuChoice) {
                case 1:
                    if (studentCount > noOfStudents)
                        System.out.println("Number of Students Reached");
                    else {
                        stud[studentCount].getPRN();
                        stud[studentCount].getName();
                        stud[studentCount].getDOB();
                        stud[studentCount].getMarks();
                        studentCount++;
                    }
                    break;
                case 2:
                    if (studentCount > 0) {
                        System.out.println("| ----- Student Data ----- |");
                        Arrays.sort(stud);
                        for(int i = 0; i < studentCount; i++)
                            System.out.println("Name: " + stud[i].name + " PRN: " + stud[i].prn + " DOB: " + stud[i].dob + " Marks: " + stud[i].marks);
                    }
                    else
                        System.out.println("No Student Data Present");
                    break;
                case 3:
                    if (studentCount > 0) {
                        int searchBy;
                        int found = 0;
                        System.out.println("1 - Search by Name");
                        System.out.println("2 - Search by PRN");
                        System.out.println("3 - Search by Position");
                        System.out.print("Enter Choice: ");
                        searchBy = sc.nextInt();

                        switch (searchBy) {
                            case 1:
                                String name;
                                System.out.print("Enter Name: ");
                                sc.nextLine();
                                name = sc.nextLine();;
                                for(int i = 0; i < studentCount; i++) {
                                    if((stud[i].name).equals(name)) {
                                        found = 1;
                                        System.out.println("-- Student Found --");
                                        System.out.println("Name: " + stud[i].name + " PRN: " + stud[i].prn + " DOB: " + stud[i].dob + " Marks: " + stud[i].marks);
                                    }
                                }
                                if (found == 0)
                                    System.out.println("Student Not Found");
                                break;
                            case 2:
                                double prn;
                                System.out.print("Enter PRN: ");
                                prn = sc.nextDouble();
                                for(int i = 0; i < studentCount; i++) {
                                    if(stud[i].prn == prn) {
                                        found = 1;
                                        System.out.println("-- Student Found --");
                                        System.out.println("Name: " + stud[i].name + " PRN: " + stud[i].prn + " DOB: " + stud[i].dob + " Marks: " + stud[i].marks);
                                    }
                                }
                                if (found == 0)
                                    System.out.println("Student Not Found");
                                break;
                            case 3:
                                int pos;
                                System.out.print("Enter Position: ");
                                pos = sc.nextInt();
                                if (pos <= studentCount) {
                                    System.out.println("Name: " + stud[pos].name + " PRN: " + String.format("%.0f", stud[pos].prn) + " DOB: " + stud[pos].dob + " Marks: " + stud[pos].marks);
                                }
                                break;
                            default:
                                System.out.println("Default Case");
                                break;
                        }
                    }
                    else
                        System.out.println("No Student Data Present");
                    break;
                case 4:
                    if (studentCount > 0) {
                        System.out.println("| ----- Student Data ----- |");
                        for(int i = 0; i < studentCount; i++)
                            System.out.println(i + " -> " + "Name: " + stud[i].name + " PRN: " + stud[i].prn + " DOB: " + stud[i].dob + " Marks: " + stud[i].marks);
                        int rec;
                        int recField;
                        System.out.print("Enter Record no. to be Updated: ");
                        rec = sc.nextInt();
                        if(rec < 0 || rec > studentCount-1) {
                            System.out.println("Invalid Record Number");
                            break;
                        }
                        System.out.println("Enter Field to be Updated:\n1 - Name\t2 - PRN\n3 - Mark\t4 - DOB");
                        System.out.print("Enter Here: ");
                        recField = sc.nextInt();
                        switch(recField) {
                            case 1:
                                stud[rec].getName();
                                break;
                            case 2:
                                stud[rec].getPRN();
                                break;
                            case 3:
                                stud[rec].getMarks();
                                break;
                            case 4:
                                stud[rec].getDOB();
                                break;
                            default:
                                System.out.println("Invalid Field Number");
                                break;
                        }
                    }
                    else
                        System.out.println("No Student Data Present");
                    break;
                case 5:
                    if (studentCount > 0) {
                        System.out.println("| ----- Student Data ----- |");
                        for(int i = 0; i < studentCount; i++)
                            System.out.println(i + " -> " + "Name: " + stud[i].name + " PRN: " + stud[i].prn + " DOB: " + stud[i].dob + " Marks: " + stud[i].marks);
                        int rec;
                        System.out.print("Enter Record no. to be Deleted: ");
                        rec = sc.nextInt();
                        if(rec < 0 || rec > studentCount-1) {
                            System.out.println("Invalid Record Number");
                            break;
                        }
                        if(rec == (studentCount-1))
                            studentCount--;
                        else {
                            for(int i = rec; i < studentCount-1; i++)
                                stud[i] = stud[i+1];
                            studentCount--;
                        }
                    }
                    else
                        System.out.println("No Student Data Present");
                    break;
                default:
                    System.out.println("Default Case");
                    break;
            }
            System.out.print("Press 1 to Continue; Press Any Key to Exit: ");
            contiue = sc.nextInt();
        }while(contiue == 1);
        sc.close();
    }
}