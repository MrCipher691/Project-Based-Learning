public class accDetail extends savingAcc {
    private double deposit;
    private double withdrawal;

    public double getDeposit() {
        return deposit;
    }
    public void setDeposit(double deposit) {
        this.deposit = deposit;
        setSav_balance(getSav_balance() + deposit);
    }
    public double getWithdrawal() {
        return withdrawal;
    }
    public void setWithdrawal(double withdrawal) {
        this.withdrawal = withdrawal;
        setSav_balance(getSav_balance() - withdrawal);
    }

    public accDetail(String cust_name, int account_number, double min_balance, double sav_balance, double deposit,
            double withdrawal) {
        super(cust_name, account_number, min_balance, sav_balance);
        this.deposit = deposit;
        this.withdrawal = withdrawal;
    }

    @Override
    public String toString() {
        return String.format("Customer Name: %1$s\tAcc. No.: %2$d\tMin. Bal.: %3$f\tAcc. Bal.: %4$f\tDeposit Amt.: %5$f\tWithdrawal Amt.: %6$f", getCust_name(), getAccount_number(), getMin_balance(), getSav_balance(), getDeposit(), getWithdrawal());
    }
}