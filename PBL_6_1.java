import java.util.Scanner;
import java.util.Vector;

interface Exam {
    public static double percentCal(double mark1, double mark2, double mark3, double mark4, double mark5) {return -1.1;};
}

public class PBL_6_1 extends Stud_data implements Exam {
    public static double percentCal(double mark1, double mark2, double mark3, double mark4, double mark5) {
        return ((mark1 + mark2 + mark3 + mark4 + mark5)*100/500);
    }

    static void display(Vector<Stud_data> stud) {
        System.out.println("| --------------------------------------------------------------- STUDENT DATA --------------------------------------------------------------- |\n");
        for(int i = 0; i < stud.size(); i++)
            System.out.println(i + " -> " + (stud.get(i)).toString());
    }

    static double marksChecker(int n) {
        Scanner sc = new Scanner(System.in);
        
        boolean flag = false;
        double marks;
        
        do {
            System.out.print("Subject " + n + " : ");
            marks = sc.nextDouble();
            if (marks < 0 || marks > 100) {
                System.out.println("! INVALID MARKS !");
                flag = true;
            }
            else
                flag = false;
        } while(flag);
        return marks;
    }

    public static void main(String[] args) {
        int ch;
        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        Vector <Stud_data> stud = new Vector<Stud_data>();
        
        /*START OF DEFAULT ENTRIES*/
        stud.add(new Stud_data());
        stud.get(stud.size()-1).setRollNo(40);
        stud.get(stud.size()-1).setName("ayush");
        stud.get(stud.size()-1).setMark1(50);
        stud.get(stud.size()-1).setMark2(31);
        stud.get(stud.size()-1).setMark3(52);
        stud.get(stud.size()-1).setMark4(70);
        stud.get(stud.size()-1).setMark5(80);

        stud.add(new Stud_data());
        stud.get(stud.size()-1).setRollNo(41);
        stud.get(stud.size()-1).setName("ayush");
        stud.get(stud.size()-1).setMark1(40);
        stud.get(stud.size()-1).setMark2(61);
        stud.get(stud.size()-1).setMark3(12);
        stud.get(stud.size()-1).setMark4(78);
        stud.get(stud.size()-1).setMark5(50);

        stud.add(new Stud_data());
        stud.get(stud.size()-1).setRollNo(42);
        stud.get(stud.size()-1).setName("ayush");
        stud.get(stud.size()-1).setMark1(30);
        stud.get(stud.size()-1).setMark2(71);
        stud.get(stud.size()-1).setMark3(55);
        stud.get(stud.size()-1).setMark4(72);
        stud.get(stud.size()-1).setMark5(81);

        stud.add(new Stud_data());
        stud.get(stud.size()-1).setRollNo(43);
        stud.get(stud.size()-1).setName("adarsh");
        stud.get(stud.size()-1).setMark1(10);
        stud.get(stud.size()-1).setMark2(51);
        stud.get(stud.size()-1).setMark3(22);
        stud.get(stud.size()-1).setMark4(90);
        stud.get(stud.size()-1).setMark5(60);

        stud.add(new Stud_data());
        stud.get(stud.size()-1).setRollNo(45);
        stud.get(stud.size()-1).setName("karan");
        stud.get(stud.size()-1).setMark1(50);
        stud.get(stud.size()-1).setMark2(71);
        stud.get(stud.size()-1).setMark3(52);
        stud.get(stud.size()-1).setMark4(78);
        stud.get(stud.size()-1).setMark5(20);

        stud.add(new Stud_data());
        stud.get(stud.size()-1).setRollNo(46);
        stud.get(stud.size()-1).setName("abhinav");
        stud.get(stud.size()-1).setMark1(52);
        stud.get(stud.size()-1).setMark2(76);
        stud.get(stud.size()-1).setMark3(12);
        stud.get(stud.size()-1).setMark4(79);
        stud.get(stud.size()-1).setMark5(70);
        /*END OF DEFAULT ENTRIES*/

        do {
            boolean flag = false;
            int rollNo;

            System.out.println("\n| ---- MENU ---- |");
            System.out.println("1 - Create Record");
            System.out.println("2 - Delete Record");
            System.out.println("3 - Change Marks");
            System.out.println("4 - Calculate Percentage");
            System.out.println("9 - Display");
            System.out.print("Enter Here: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    stud.add(new Stud_data());
                    do {
                        System.out.print("Enter Roll No.(Int): ");
                        rollNo = sc.nextInt();
                        for (int i = 0; i < stud.size(); i++) {
                            if (rollNo == stud.get(i).getRollNo()) {
                                System.out.println("! ROLL NO ALREADY PRESENT !");
                                flag = true;
                                break;
                            }
                            else
                                flag = false;
                        }
                    } while(flag);
                    stud.get(stud.size()-1).setRollNo(rollNo);
                    System.out.print("Enter Name: ");
                    sc.nextLine();
                    stud.get(stud.size()-1).setName(sc.nextLine());
                    System.out.println("\t! - ENTER MARKS (0-100; DOUBLE) - !");
                    stud.get(stud.size()-1).setMark1(marksChecker(1));
                    stud.get(stud.size()-1).setMark2(marksChecker(2));
                    stud.get(stud.size()-1).setMark3(marksChecker(3));
                    stud.get(stud.size()-1).setMark4(marksChecker(4));
                    stud.get(stud.size()-1).setMark5(marksChecker(5));
                    break;
                case 2:
                    //Checking if there are records in vector
                    if (stud.size() > 0) {
                        int delCh;
                        int tbd;
                        flag = false;

                        System.out.println("1 - Delete by Name");
                        System.out.println("2 - Delete by Roll No.");
                        System.out.println("3 - Delete by Index no.");
                        System.out.print("Enter Here: ");
                        delCh = sc.nextInt();

                        switch (delCh) {
                            case 1:
                                int cnt = 0;
                                String stud_name;
                                System.out.print("Enter Name: ");
                                sc.nextLine();
                                stud_name = sc.nextLine();
                                //Counting for number of entries with same name
                                for (int i = 0; i < stud.size(); i++) {
                                    if ((stud_name.toLowerCase()).equals(stud.get(i).getName().toLowerCase()))
                                        cnt++;
                                }
                                //If no entries, negative result
                                if (cnt == 0)
                                    System.out.println("! NO SUCH STUDENT FOUND !");
                                //If only 1 entry, that is deleted and program continues
                                else if (cnt == 1)
                                    for (int i = 0; i < stud.size(); i++) {
                                        if ((stud_name.toLowerCase()).equals(stud.get(i).getName().toLowerCase())) {
                                            stud.remove(i);
                                            flag = true;
                                            System.out.println("STUDENT RECORD DELETED SUCCESSFULLY");
                                            break;
                                        }
                                    }
                                //If more then 1 entires, program asks for roll number for confirmation
                                else {
                                    System.out.print("Enter Roll No.: ");
                                    tbd = sc.nextInt();
                                    //Checks if roll number exists
                                    for (int i = 0; i < stud.size(); i++) {
                                        //If yes, that record is deleted
                                        if ((stud_name.toLowerCase()).equals(stud.get(i).getName().toLowerCase()) && tbd == stud.get(i).   getRollNo()) {
                                            stud.remove(i);
                                            flag = true;
                                            System.out.println("STUDENT RECORD DELETED SUCCESSFULLY");
                                            break;
                                        }
                                    }
                                    //If not, negative result
                                    if (!flag)
                                        System.out.println("! NO SUCH STUDENT FOUND !");
                                }
                                break;
                            case 2:
                                System.out.print("Enter Roll No.: ");
                                tbd = sc.nextInt();
                                //Checks if roll number exists
                                for (int i = 0; i < stud.size(); i++) {
                                    //If yes, that record is deleted
                                    if (tbd == stud.get(i).getRollNo()) {
                                        stud.remove(i);
                                        flag = true;
                                        System.out.println("STUDENT RECORD DELETED SUCCESSFULLY");
                                        break;
                                    }
                                }
                                //If not, negative result
                                if (!flag)
                                    System.out.println("! NO SUCH STUDENT FOUND !");
                                break;
                            case 3:
                                display(stud);
                                System.out.print("Enter Record No.: ");
                                tbd = sc.nextInt();
                                //Checks if valid number is entered, if yes record deleted, if not negative result
                                if (tbd >= stud.size() || tbd < 0)
                                    System.out.println("! INVALID NO. | NO RECORDS DELETED !");
                                else {
                                    stud.remove(tbd);
                                    flag = true;
                                    System.out.println("STUDENT RECORD DELETED SUCCESSFULLY");
                                }
                                break;
                            default:
                                System.out.println("! INVALID CHOICE !");
                                break;
                        }
                    }
                    else
                        System.out.println("! NO STUDENTS !");
                    break;
                case 3:
                    if (stud.size() > 0) {
                        flag = false;
                        int subCh;
        
                        do {
                            System.out.print("Enter Roll no.: ");
                            subCh = sc.nextInt();
                            for (int i = 0; i < stud.size(); i++) {
                                if (subCh == stud.get(i).getRollNo()) {
                                    System.out.println("\n| ---- MENU ---- |");
                                    System.out.println("1 - Subject I");
                                    System.out.println("2 - Subject II");
                                    System.out.println("3 - Subject III");
                                    System.out.println("4 - Subject IV");
                                    System.out.println("5 - Subject V");
                                    System.out.print("Enter Here: ");
                                    subCh = sc.nextInt();

                                    switch (subCh) {
                                        case 1:
                                            stud.get(i).setMark1(marksChecker(1));
                                            break;
                                        case 2:
                                            stud.get(i).setMark2(marksChecker(2));
                                            break;
                                        case 3:
                                            stud.get(i).setMark3(marksChecker(3));
                                            break;
                                        case 4:
                                            stud.get(i).setMark4(marksChecker(4));
                                            break;
                                        case 5:
                                            stud.get(i).setMark5(marksChecker(5));
                                            break;
                                        default:
                                            System.out.println("! INVALID CHOICE !");
                                            break;
                                    }
                                    flag = false;
                                    break;
                                }
                                else
                                    flag = true;
                            }
                        } while(flag);
                    }
                    else
                        System.out.println("! NO STUDENTS !");
                    break;
                case 4:
                    if (stud.size() > 0) {
                        flag = false;
                        int perCh;
        
                        do {
                            System.out.print("Enter Roll no.: ");
                            perCh = sc.nextInt();
                            for (int i = 0; i < stud.size(); i++) {
                                if (perCh == stud.get(i).getRollNo()) {
                                    System.out.println(stud.get(i).getName().toUpperCase() + "'S PERCENTAGE = " + percentCal(stud.get(i).getMark1(), stud.get(i).getMark2(), stud.get(i).getMark3(), stud.get(i).getMark4(), stud.get(i).getMark5()) + "%");
                                    flag = false;
                                    break;
                                }
                                else
                                    flag = true;
                            }
                        } while(flag);
                    }
                    else
                        System.out.println("! NO STUDENTS !");
                    break;
                case 9:
                    //Checking if there are records in vector
                    if (stud.size() > 0)
                        //Simple display function call
                        display(stud);
                    else
                        System.out.println("! NO STUDENTS !");
                    break;
                default:
                    exit = true;
                    break;
            }
        } while(exit == false);
        sc.close();
    }
}