import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class PBL_3_2 {
    static void display(Vector<Employee> emp) {
        System.out.println("-- EMPLOYEE DATA --");
        for(int i = 0; i < emp.size(); i++)
            System.out.println(i + " -> " + (emp.get(i)).toString());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cond = 1;
        Vector <Employee> emp = new Vector<Employee>();

        //emp.add(new Employee(40, 40000, "Tim", "M", "Dev", "TCS"));
        //emp.add(new Employee(41, 63240, "Harry", "M", "Designer", "AT&T"));
        //emp.add(new Employee(42, 76000, "Charles", "M", "Manager", "Lenovo"));
        //emp.add(new Employee(43, 60340, "Leo", "M", "HR", "Tata"));
        //emp.add(new Employee(44, 63200, "Mathew", "M", "Editor", "Forbes"));

        do{
            int menu;
            System.out.println("| ------- MENU ------- |");
            System.out.println("1 - Add Employee");
            System.out.println("2 - Delete Employee");
            System.out.println("3 - Compare Employees");
            System.out.println("4 - Search Employee");
            System.out.println("5 - Sort Employee");
            System.out.print("Enter Choice Here: ");
            menu = sc.nextInt();

            switch (menu) {
                case 1:
                    int id, salary;
                    String name, gender, jobTitle, organization;
                    System.out.println("-- ENTER EMPLOYEE DETAILS --");
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();
                    System.out.print("Enter Name: ");
                    sc.nextLine();
                    name = sc.nextLine();
                    System.out.print("Enter Gender: ");
                    gender = sc.nextLine();
                    System.out.print("Enter Job Title: ");
                    jobTitle = sc.nextLine();
                    System.out.print("Enter Organization: ");
                    organization = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    salary = sc.nextInt();
                    emp.add(new Employee(id, salary, name, gender, jobTitle, organization));
                    break;
                case 2:
                    if (emp.size() > 0) {
                        display(emp);
                        int tbd;
                        System.out.print("Enter Record No.: ");
                        tbd = sc.nextInt();
                        emp.remove(tbd);
                        System.out.println("EMPLOYEE RECORD DELETED SUCCESSFULLY");
                    }
                    else
                        System.out.println("NO EMPLOYEE(S) IN DATA BASE");
                    break;
                case 3:
                    if (emp.size() > 0) {
                        display(emp);
                        int ch1, ch2;
                        System.out.print("Enter Employee 1 No.: ");
                        ch1 = sc.nextInt();
                        System.out.print("Enter Employee 2 No.: ");
                        ch2 = sc.nextInt();
                        System.out.println("-- EMPLOYEE DATA --");
                        System.out.println((emp.get(ch1)).toString());
                        System.out.println((emp.get(ch2)).toString());
                        System.out.println("-- RESULT --");
                        if ((emp.get(ch1)).getSalary() > (emp.get(ch2)).getSalary())
                            System.out.println((emp.get(ch1)).getName() + " who earns $" + (emp.get(ch1)).getSalary() + " earns more then " + (emp.get(ch2)).getName() + " who earns $" + (emp.get(ch2)).getSalary() + " by " + ((emp.get(ch1)).getSalary() - (emp.get(ch2)).getSalary()));
                        else if ((emp.get(ch1)).getSalary() == (emp.get(ch2)).getSalary())
                            System.out.println((emp.get(ch1)).getName() + " who earns $" + (emp.get(ch1)).getSalary() + " and " + (emp.get(ch2)).getName() + " who earns $" + (emp.get(ch2)).getSalary() + " earn equal");
                        else
                            System.out.println((emp.get(ch1)).getName() + " who earns $" + (emp.get(ch1)).getSalary() + " earns less then " + (emp.get(ch2)).getName() + " who earns $" + (emp.get(ch2)).getSalary() + " by " + ((emp.get(ch2)).getSalary() - (emp.get(ch1)).getSalary()));
                    }
                    else
                        System.out.println("NO EMPLOYEE(S) IN DATA BASE");
                    break;
                case 4:
                    if (emp.size() > 0) {
                        int ch3;
                        int found = 0;
                        System.out.println("-- SEARCH EMPLOYEE BY --");
                        System.out.println("1 - ID\t2 - Name");
                        System.out.print("Enter Choice Here: ");
                        ch3 = sc.nextInt();
                        switch (ch3) {
                            case 1:
                                display(emp);
                                System.out.print("Enter ID: ");
                                int ch4 = sc.nextInt();
                                for (int i = 0; i < emp.size(); i++) {
                                    if ((emp.get(i)).getId() == ch4) {
                                        System.out.println("-- EMPLOYEE FOUND --");
                                        System.out.println(emp.get(i));
                                        found++;
                                        break;
                                    }
                                }
                                if (found == 0)
                                    System.out.println("-- EMPLOYEE NOT FOUND --");
                                break;
                            case 2:
                                display(emp);
                                System.out.print("Enter Name: ");
                                sc.nextLine();
                                String ch5 = sc.nextLine();
                                for (int i = 0; i < emp.size(); i++) {
                                    if (((emp.get(i)).getName().toLowerCase()).equals(ch5.toLowerCase())) {
                                        System.out.println("-- EMPLOYEE FOUND --");
                                        System.out.println(emp.get(i));
                                        found++;
                                        break;
                                    }
                                }
                                if (found == 0)
                                    System.out.println("-- EMPLOYEE NOT FOUND --");
                                break;
                            default:
                                System.out.println("INVALID INPUT");
                                break;
                        }
                    }
                    else
                        System.out.println("NO EMPLOYEE(S) IN DATA BASE");
                    break;
                case 5:
                    if (emp.size() > 0) {
                        Collections.sort(emp);
                        display(emp);
                    }
                    else
                        System.out.println("NO EMPLOYEE(S) IN DATA BASE");
                    break;
                default:
                    if (emp.size() > 0) {
                        System.out.println("Number of Employees Created = " + emp.get(0).getCount());
                        display(emp);
                    }
                    else
                        System.out.println("NO EMPLOYEE(S) IN DATA BASE");
                    break;
            }

            System.out.print("Press 1 to Continue; Press Any Key to Exit: ");
            cond = sc.nextInt();
        } while(cond == 1);

        sc.close();
    }
}