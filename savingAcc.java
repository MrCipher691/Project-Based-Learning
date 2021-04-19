public class savingAcc extends Account {
    private double min_balance;
    private double sav_balance;

    public double getMin_balance() {
        return min_balance;
    }
    public void setMin_balance(double min_balance) {
        if (min_balance > getSav_balance()) {
            System.out.println("          ! ALERT !");
            System.out.println("! NOT ENOUGH  ACCOUNT BALANCE !");
            System.out.println(" ! REQESTED OPERATION DENIED !");
            System.out.println("          ! ALERT !");
            return;
        }
        else {
            this.min_balance = min_balance;
            System.out.println("MINIMUM BALANCE FOR " + getCust_name().toUpperCase() + " UPDATED SUCCESSFULLY");
        }
    }
    public double getSav_balance() {
        return sav_balance;
    }
    public void setSav_balance(double sav_balance) {
        if (sav_balance < getMin_balance()) {
            System.out.println("                    ! ALERT !");
            System.out.println("! ACCOUNT BALANCE WILL GO BELOW MINIMUM BALANCE !");
            System.out.println("          ! REQESTED OPERATION DENIED !");
            System.out.println("                    ! ALERT !");
            return;
        }
        else {
            this.sav_balance = sav_balance;
            System.out.println(getCust_name().toUpperCase() + "'S UPDATED BALANCE: " + sav_balance);
        }
    }

    public savingAcc(String cust_name, int account_number, double min_balance, double sav_balance) {
        super(cust_name, account_number);
        this.min_balance = min_balance;
        this.sav_balance = sav_balance;
    }
}