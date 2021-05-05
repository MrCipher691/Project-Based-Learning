package PBL_6_2.src;

import java.util.Scanner;

import PBL_6_2.lib.Interface_STK;

class Fixed_stk implements Interface_STK {
    private int stk[], top;

    Fixed_stk(int size) {
        this.stk = new int[size];
        top = -1;
    }

    @Override
    public void push(int item) {
        if (this.isFull())
            System.out.println("STACK IS FULL");
        else {
            System.out.println("Inserting: " + item);
            this.stk[++top] = item;
        }
    }

    @Override
    public int pop() {
        if (this.isEmpty())
            System.out.println("STACK IS EMPTY");
        else {
            int data = this.stk[top--];
            System.out.println("Deleting: " + data);
            return data;
        }
        return -1;
    }

    @Override
    public void display() {
        System.out.println("! ---- ---- FIXED STACK ---- ---- !");
        System.out.println("Capacity: " + stk.length);
        System.out.println("Top: " + stk[top]);
        System.out.println("\t! - STACK CONTENTS - !");
        for (int i = top; i >= 0; i--)
            System.out.print(this.stk[i] + "\t");
    }

    @Override
    public boolean isEmpty() {
        if (this.top == -1)
            return true;
        return false;
    }

    @Override
    public boolean isFull() {
        if (this.top == (stk.length - 1))
            return true;
        return false;
    }
}

class Growable_stk implements Interface_STK {
    private int stk[], top;

    Growable_stk(int size) {
        this.stk = new int[size];
        top = -1;
    }

    public void increaseSTK() {
        int temp[] = new int[this.stk.length * 2];
        for (int i = 0; i < this.stk.length; i++)
            temp[i] = this.stk[i];
        this.stk = temp;
    }

    @Override
    public void push(int item) {
        if (this.isFull()) {
            System.out.println(("STACK IS FULL"));
            this.increaseSTK();
        }
        System.out.println("Inserting: " + item);
        this.stk[++top] = item;
    }

    @Override
    public int pop() {
        if (this.isEmpty())
            System.out.println("STACK IS EMPTY");
        else {
            int data = this.stk[top--];
            System.out.println("Deleting: " + data);
            return data;
        }
        return -1;
    }

    @Override
    public void display() {
        System.out.println("! ---- ---- GROWING STACK ---- ---- !");
        System.out.println("Capacity: " + stk.length);
        System.out.println("Top: " + this.stk[top]);
        System.out.println("\t! - STACK CONTENTS - !");
        for (int i = this.top; i >= 0; i--)
            System.out.print(this.stk[i] + "\t");
    }

    @Override
    public boolean isEmpty() {
        if (this.top == -1)
            return true;
        return false;
    }

    @Override
    public boolean isFull() {
        if (this.top == (stk.length - 1))
            return true;
        return false;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Interface_STK mySTK = null;
        Fixed_stk fSTK = null;
        Growable_stk gSTK = null;
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        int ch;

        do {
            System.out.println("\n| ---- MENU ---- |");
            System.out.println("1 - Select Stack");
            System.out.println("2 - Mode Push");
            System.out.println("3 - Mode Pop");
            System.out.println("9 - Display");
            System.out.print("Enter Here: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    int stkch;
                    System.out.print("PRESS 1 FOR FIXED STACK | 2 FOR GROWING STACK: ");
                    stkch = sc.nextInt();

                    switch (stkch) {
                        case 1:
                            if (fSTK == null) {
                                System.out.print("Enter size: ");
                                int size = sc.nextInt();
                                fSTK = new Fixed_stk(size);
                            }
                            mySTK = fSTK;
                            break;
                        case 2:
                            if (gSTK == null) {
                                System.out.print("Enter size: ");
                                int size = sc.nextInt();
                                gSTK = new Growable_stk(size);
                            }
                            mySTK = gSTK;
                            break;
                        default:
                            System.out.println("! INVALID CHOICE !");
                            break;
                    }
                    break;
                case 2:
                    if (mySTK != null) {
                        System.out.print("Enter Data (INT): ");
                        mySTK.push(sc.nextInt());
                    }
                    else
                        System.out.println("! NO STACK SELECTED !");
                    break;
                case 3:
                    if (mySTK != null)
                        mySTK.pop();
                    else
                        System.out.println("! NO STACK SELECTED !");
                    break;
                case 9:
                    if (mySTK != null)
                        mySTK.display();
                    else
                        System.out.println("! NO STACK SELECTED !");
                    break;
                default:
                    exit = true;
                    break;
            }
        } while(exit == false);

        sc.close();
    }
}