import java.util.Scanner;
import java.util.Vector;

public class PBL_5_2 {
    //General Data Printing Function
    static void display(Vector<accDetail> cust) {
        System.out.println("| --------------------------------------------------------------- CUSTOMER DATA --------------------------------------------------------------- |\n");
        for(int i = 0; i < cust.size(); i++)
            System.out.println(i + " -> " + (cust.get(i)).toString());
    }

    //Main Function
    public static void main (String[] args) {
        int ch;
        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        Vector <accDetail> cust = new Vector<accDetail>();

        cust.add(new accDetail("Ayush", 41, 0, 0, 0, 0));
        cust.add(new accDetail("Ayush", 42, 0, 0, 0, 0));
        cust.add(new accDetail("Ayush", 43, 0, 0, 0, 0));
        cust.add(new accDetail("Agarwal", 44, 0, 0, 0, 0));
        cust.add(new accDetail("Namibiar", 45, 0, 0, 0, 0));
        cust.add(new accDetail("Tripathi", 46, 0, 0, 0, 0));
        cust.add(new accDetail("Choudhary", 47, 0, 0, 0, 0));
        cust.add(new accDetail("Someone Somewhere", 48, 0, 0, 0, 0));
        
        do {
            boolean flag = false;
            String cust_name;
            int account_number;
            double min_balance, deposit, withdrawal;

            System.out.println("\n| ---- MENU ---- |");
            System.out.println("1 - Create Account");
            System.out.println("2 - Delete Account");
            System.out.println("3 - Set Minimum Balace");
            System.out.println("4 - Deposit Amount");
            System.out.println("5 - Withdraw Amount");
            System.out.println("9 - Display");
            System.out.print("Enter Here: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Cust. Name: ");
                    sc.nextLine();
                    cust_name = sc.nextLine();
                    //Cross check loop to avoid duplicate account numbers
                    do {
                        System.out.print("Enter Cust. Acc. No.: ");
                        account_number = sc.nextInt();
                        //Traversing through vector to check for duplicated
                        for (int i = 0; i < cust.size(); i++) {
                            //If account number already exists then loop is called again; thus repeating the process
                            if (account_number == cust.get(i).getAccount_number()) {
                                System.out.println("! DUPLICATE CUST ID NOT ALLOWED !");
                                flag = true;
                                break;
                            }
                            //If account number does not exist, program continues
                            else
                                flag = false;
                        }
                    } while(flag);
                    //Finally creating object in vector
                    cust.add(new accDetail(cust_name, account_number, 0.0, 0.0, 0.0, 0.0));
                    break;
                case 2:
                    //Checking if there are records in vector
                    if (cust.size() > 0) {
                        int delCh;
                        int tbd;
                        flag = false;

                        System.out.println("1 - Delete by Name");
                        System.out.println("2 - Delete by Cust ID");
                        System.out.println("3 - Delete by Index no.");
                        System.out.print("Enter Here: ");
                        delCh = sc.nextInt();

                        switch (delCh) {
                            case 1:
                                int cnt = 0;
                                System.out.print("Enter Cust. Name: ");
                                sc.nextLine();
                                cust_name = sc.nextLine();
                                //Counting for number of entries with same name
                                for (int i = 0; i < cust.size(); i++) {
                                    if ((cust_name.toLowerCase()).equals(cust.get(i).getCust_name().toLowerCase()))
                                        cnt++;
                                }
                                //If no entries, negative result
                                if (cnt == 0)
                                    System.out.println("! NO SUCH CUSTOMER FOUND !");
                                //If only 1 entry, that is deleted and program continues
                                else if (cnt == 1)
                                    for (int i = 0; i < cust.size(); i++) {
                                        if ((cust_name.toLowerCase()).equals(cust.get(i).getCust_name().toLowerCase())) {
                                            cust.remove(i);
                                            flag = true;
                                            System.out.println("CUSTOMER RECORD DELETED SUCCESSFULLY");
                                            break;
                                        }
                                    }
                                //If more then 1 entires, program asks for account number for confirmation
                                else {
                                    System.out.print("Enter Cust. Acc. No.: ");
                                    tbd = sc.nextInt();
                                    //Checks if account number exists
                                    for (int i = 0; i < cust.size(); i++) {
                                        //If yes, that record is deleted
                                        if ((cust_name.toLowerCase()).equals(cust.get(i).getCust_name().toLowerCase()) && tbd == cust.get(i).getAccount_number()) {
                                            cust.remove(i);
                                            flag = true;
                                            System.out.println("CUSTOMER RECORD DELETED SUCCESSFULLY");
                                            break;
                                        }
                                    }
                                    //If not, negative result
                                    if (!flag)
                                        System.out.println("! NO SUCH CUSTOMER FOUND !");
                                }
                                break;
                            case 2:
                                System.out.print("Enter Cust. Acc. No.: ");
                                tbd = sc.nextInt();
                                //Checks if account number exists
                                for (int i = 0; i < cust.size(); i++) {
                                    //If yes, that record is deleted
                                    if (tbd == cust.get(i).getAccount_number()) {
                                        cust.remove(i);
                                        flag = true;
                                        System.out.println("CUSTOMER RECORD DELETED SUCCESSFULLY");
                                        break;
                                    }
                                }
                                //If not, negative result
                                if (!flag)
                                    System.out.println("! NO SUCH CUSTOMER FOUND !");
                                break;
                            case 3:
                                display(cust);
                                System.out.print("Enter Record No.: ");
                                tbd = sc.nextInt();
                                //Checks if valid number is entered, if yes record deleted, if not negative result
                                if (tbd >= cust.size() || tbd < 0)
                                    System.out.println("! INVALID NO. | NO RECORDS DELETED !");
                                else {
                                    cust.remove(tbd);
                                    flag = true;
                                    System.out.println("CUSTOMER RECORD DELETED SUCCESSFULLY");
                                }
                                break;
                            default:
                                System.out.println("! INVALID CHOICE !");
                                break;
                        }
                    }
                    else
                        System.out.println("! WE DO NOT HAVE CUSTOMERS !");
                    break;
                case 3:
                    flag = true;
                    //Checking if there are records in vector
                    if (cust.size() > 0) {
                        //Loop to checkk if valid account number is entered
                        do {
                            System.out.print("Enter Cust. Acc. No.: ");
                            account_number = sc.nextInt();
                            //Traversal to check account no
                            for (int i = 0; i < cust.size(); i++) {
                                //If account number found, break loop, lower flag
                                if (account_number == cust.get(i).getAccount_number()) {
                                    flag = false;
                                    break;
                                }
                            }
                            //If flag is high, print retry message and runs loop again
                            if (flag)
                                System.out.println("! ACCOUNT NUMBER NOT FOUND | TRY AGAIN !");
                        } while(flag);
                        //Loop to part whose record is to be updated
                        for (int i = 0; i < cust.size(); i++) {
                            //Getiing object to be modified
                            if (account_number == cust.get(i).getAccount_number()) {
                                do {
                                    System.out.print("Enter Min. Bal. Amt.: ");
                                    min_balance = sc.nextDouble();
                                    //If invalid amount is entered, raises flag and runs loop again
                                    if (min_balance < 0) {
                                        System.out.println("! INVALID AMOUNT ENTERED !");
                                        flag = true;
                                    }
                                    //If value is valid, update value
                                    else {
                                        cust.get(i).setMin_balance(min_balance);
                                        flag = false;
                                    }
                                } while(flag);
                            }
                        }
                    }
                    else
                        System.out.println("! WE DO NOT HAVE CUSTOMERS !");
                    break;
                case 4:
                    flag = true;
                    //Checking if there are records in vector
                    if (cust.size() > 0) {
                        //Loop to checkk if valid account number is entered
                        do {
                            System.out.print("Enter Cust. Acc. No.: ");
                            account_number = sc.nextInt();
                            //Traversal to check account no
                            for (int i = 0; i < cust.size(); i++) {
                                //If account number found, break loop, lower flag
                                if (account_number == cust.get(i).getAccount_number()) {
                                    flag = false;
                                    break;
                                }
                            }
                            //If flag is high, print retry message and runs loop again
                            if (flag)
                                System.out.println("! ACCOUNT NUMBER NOT FOUND | TRY AGAIN !");
                        } while(flag);
                        //Loop to part whose record is to be updated
                        for (int i = 0; i < cust.size(); i++) {
                            //Getiing object to be modified
                            if (account_number == cust.get(i).getAccount_number()) {
                                do {
                                    System.out.print("Enter Deposit Amt.: ");
                                    deposit = sc.nextDouble();
                                    //If invalid amount is entered, raises flag and runs loop again
                                    if (deposit < 0) {
                                        System.out.println("! INVALID AMOUNT ENTERED !");
                                        flag = true;
                                    }
                                    //If value is valid, update value
                                    else {
                                        cust.get(i).setDeposit(deposit);
                                        flag = false;
                                    }
                                } while(flag);
                            }
                        }
                    }
                    else
                        System.out.println("! WE DO NOT HAVE CUSTOMERS !");
                    break;
                case 5:
                    flag = true;
                    //Checking if there are records in vector
                    if (cust.size() > 0) {
                        //Loop to checkk if valid account number is entered
                        do {
                            System.out.print("Enter Cust. Acc. No.: ");
                            account_number = sc.nextInt();
                            //Traversal to check account no
                            for (int i = 0; i < cust.size(); i++) {
                                //If account number found, break loop, lower flag
                                if (account_number == cust.get(i).getAccount_number()) {
                                    flag = false;
                                    break;
                                }
                            }
                            //If flag is high, print retry message and runs loop again
                            if (flag)
                                System.out.println("! ACCOUNT NUMBER NOT FOUND | TRY AGAIN !");
                        } while(flag);
                        //Loop to part whose record is to be updated
                        for (int i = 0; i < cust.size(); i++) {
                            //Getiing object to be modified
                            if (account_number == cust.get(i).getAccount_number()) {
                                do {
                                    System.out.print("Enter Withdrawal Amt.: ");
                                    withdrawal = sc.nextDouble();
                                    //If invalid amount is entered, raises flag and runs loop again
                                    if (withdrawal < 0 || withdrawal > cust.get(i).getSav_balance()) {
                                        System.out.println("! INVALID AMOUNT ENTERED !");
                                        flag = true;
                                    }
                                    //If value is valid, update value
                                    else {
                                        cust.get(i).setWithdrawal(withdrawal);;
                                        flag = false;
                                    }
                                } while(flag);
                            }
                        }
                    }
                    else
                        System.out.println("! WE DO NOT HAVE CUSTOMERS !");
                    break;
                case 9:
                    //Checking if there are records in vector
                    if (cust.size() > 0)
                        //Simple display function call
                        display(cust);
                    else
                        System.out.println("! WE DO NOT HAVE CUSTOMERS !");
                    break;
                default:
                    exit = true;
                    break;
            }
        } while (exit == false);
        sc.close();
    }
}