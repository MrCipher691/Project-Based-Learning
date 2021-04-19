public class Account {
    private String cust_name;
    private int account_number;
    
    
    public String getCust_name() {
        return cust_name;
    }
    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }
    public int getAccount_number() {
        return account_number;
    }
    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public Account(String cust_name, int account_number) {
        this.cust_name = cust_name;
        this.account_number = account_number;
    }
}