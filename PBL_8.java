import com.mysql.cj.xdevapi.Statement;
import com.sun.jdi.connect.spi.Connection;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class EmployeeData {
    int empno;
    String ename, department, job;
    float salary;

    public EmployeeData(int empno, String ename, String department, String job, float salary) {
        this.empno = empno;
        this.ename = ename;
        this.department = department;
        this.job = job;
        this.salary = salary;
    }
}

class Table {
    Table(ArrayList<EmployeeData> d) throws Exception {
        truncate();
        for (int i = 0; i < 5; i++) {
            EmployeeData e = d.get(i);
            insert(e);
        }

    }

    void UpdateSalary(float newsal, String empno) throws Exception {
        java.sql.Connection con = null;
        PreparedStatement ps = null;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Ayush@123");

        String sql1 = "UPDATE empdata SET salary='" + newsal + "' WHERE empno='" + empno + "'";
        ps = con.prepareStatement(sql1);

        ps.execute();
    }

    void Display() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        ResultSet s = null;
        java.sql.Connection con = null;
        PreparedStatement ps = null;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Ayush@123");
        String sql = "Select * FROM empdata";
        ps = con.prepareStatement(sql);

        s = ps.executeQuery();
        if (s.next())
            System.out.println("Employee ID" + "     " + "Name" + "      " + "Department");
        while (s.next())
            System.out.println(s.getInt("empno") + "            " + s.getString("ename") + "       " + s.getString("department"));
    }

    void delete(int empno) throws ClassNotFoundException, SQLException {
        java.sql.Connection con = null;
        PreparedStatement ps = null;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Ayush@123");
        String sql = "DELETE FROM empdata WHERE empno=?";
        ps = con.prepareStatement(sql);
        ps.setInt(1, empno);

        int i = ps.executeUpdate();
        if (i > 0)
            System.out.println("Record Deleted");
        else
            System.out.println("Record not Found");
    }

    void search(String name) throws Exception {

        java.sql.Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Ayush@123");

        String sql = "SELECT * FROM empdata WHERE ename=?";
        ps = con.prepareStatement(sql);

        ps.setString(1, name);
        rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("Record Found - \n");
            System.out.println("Employee ID         - " + rs.getString("empno"));
            System.out.println("Employee Name       - " + rs.getString("ename"));
            System.out.println("Employee Department - " + rs.getString("department"));
            System.out.println("Employee Job        - " + rs.getString("job"));
            System.out.println("Employee Salary     - " + rs.getString("salary") + "\n");
        }
        else
            System.out.println("Record not found\n");
    }

    void truncate() throws Exception {
        java.sql.Connection con = null;
        PreparedStatement ps = null;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "");
        String sql = "TRUNCATE TABLE empdata";
        ps = con.prepareStatement(sql);
        ps.executeUpdate();
    }

    boolean insert(EmployeeData e) {

        java.sql.Connection con = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "");
            String sql = "INSERT INTO empdata (empno, ename, department, job, salary) VALUES (?,?,?,?,?)";
            ps = con.prepareStatement(sql);

            ps.setInt(1, e.empno);
            ps.setString(2, e.ename);
            ps.setString(3, e.department);
            ps.setString(4, e.job);
            ps.setFloat(5, e.salary);

            int i = ps.executeUpdate();
            if (i > 0)
                return true;
            else
                return false;
        } 
        catch (Exception er) {
            System.out.println("There has been a error " + er.getMessage());
        }
        return false;
    }
}

public class PBL_8 {

    public static void menu() {
        System.out.println("\n\n| -------- MENU -------- |");
        System.out.println("1 - Create a new Table");
        System.out.println("2 - Insert a new Record ");
        System.out.println("3 - Display Records");
        System.out.println("4 - Search  Record");
        System.out.println("5 - Update Record");
        System.out.println("6 - Delete a Record");
        System.out.println("7 - Clear the Table");
        System.out.println("8 - Exit");

    }

    public static void main(String[] args) throws Exception {
        EmployeeData e = new EmployeeData(102, "Aryan", "Finance", "CEO", (float) 5.589);

        ArrayList<EmployeeData> D = new ArrayList<EmployeeData>();
        D.add(new EmployeeData(8369, "Smith", "Manager", "IT", (float) 80000.00));
        D.add(new EmployeeData(8654, "Momin", "Salesman", "Sales", (float) 12050.00));
        D.add(new EmployeeData(8839, "Amir", "Sales", "President", (float) 150000.00));
        D.add(new EmployeeData(8934, "Mita", "HR", "Clerk", (float) 23000.00));
        D.add(new EmployeeData(8900, "Jatin", "HR", "Clerk", (float) 25050.00));

        Table t = new Table(D);
        int chc = 0;
        while (chc != 8) {
            menu();

            Scanner input = new Scanner(System.in);
            chc = input.nextInt();

            switch (chc) {
                case 1:
                    // Create new
                    System.out.println("Table Created - ");
                    t = new Table(D);
                    break;
                case 2:
                    // Insert
                    String name, depar, job;
                    int emp;
                    float salary;

                    System.out.print("Enter Employee ID :");
                    emp = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter Employee Name :");
                    name = input.nextLine();
                    System.out.print("Enter Employee Department :");
                    depar = input.nextLine();
                    System.out.print("Enter Employee Job :");
                    job = input.nextLine();
                    System.out.print("Enter Employee Salary :");
                    salary = input.nextFloat();

                    EmployeeData e1 = new EmployeeData(emp, name, depar, job, salary);
                    boolean flag = t.insert(e1);
                    
                    if (flag)
                        System.out.println("Record Added Successfuly");
                    else
                        System.out.println("Theres been a error.");

                    break;
                case 3:
                    // Display
                    System.out.println("Table - ");
                    t.Display();
                    break;
                case 4:
                    // Search
                    System.out.print("Enter name of the employee to be searched :");
                    String name;
                    input.nextLine();
                    name = input.nextLine();
                    t.search(name);
                    System.out.println("");
                    break;
                case 5:
                    // Update Salary
                    float newsal;
                    String empno;
                    System.out.print("Enter Employee ID -");
                    input.nextLine();
                    empno = input.nextLine();
                    System.out.print("Enter New Salary -");
                    newsal = input.nextFloat();

                    t.UpdateSalary((float) newsal, empno);
                    break;
                case 6:
                    // Delete Record
                    System.out.println("Enter Employee ID to be Deleted - ");
                    int empid = input.nextInt();
                    System.out.print("");
                    t.delete(empid);
                    break;
                case 7:
                    t.truncate();
                    System.out.print("Table has been Cleared\n");
                    break;
                case 8:
                    System.out.println("! -- TERMINATING PROGRAM -- !");
                    System.exit(0);
                    break;
            }
        }
    }
}