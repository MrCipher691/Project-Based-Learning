public class Stud_data {
    private String name;
    private int rollNo;
    private double mark1, mark2, mark3, mark4, mark5;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRollNo() {
        return rollNo;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    public double getMark1() {
        return mark1;
    }
    public void setMark1(double mark1) {
        this.mark1 = mark1;
    }
    public double getMark2() {
        return mark2;
    }
    public void setMark2(double mark2) {
        this.mark2 = mark2;
    }
    public double getMark3() {
        return mark3;
    }
    public void setMark3(double mark3) {
        this.mark3 = mark3;
    }
    public double getMark4() {
        return mark4;
    }
    public void setMark4(double mark4) {
        this.mark4 = mark4;
    }
    public double getMark5() {
        return mark5;
    }
    public void setMark5(double mark5) {
        this.mark5 = mark5;
    }
    
    public Stud_data() {
        this.name = "NA";
        this.rollNo = -1;
        this.mark1 = -1;
        this.mark2 = -1;
        this.mark3 = -1;
        this.mark4 = -1;
        this.mark5 = -1;
    }
    
    @Override
    public String toString() {
        return String.format("Student Name: %1$s\tRoll No.: %2$d\tSubject I: %3$.2f\tSubject II: %4$.2f\tSubject III: %5$.2f\tSubject IV: %6$.2f\tSubject V: %7$.2f", name, rollNo, mark1, mark2, mark3, mark4, mark5);
    }
}