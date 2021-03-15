import java.util.Scanner;

public class PBL_4 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Deck pack = new Deck();
        String house, rank1, rank2;
        int menu;
        pack.createDeck();
        System.out.println("-- NEW DECK CREATED --");
        while (pack.getNoOfCards() != 0) {
            System.out.println("| ------- MENU ------- |");
            System.out.println("1 - Print Deck");
            System.out.println("2 - Search Card");
            System.out.println("3 - Deal Card");
            System.out.println("4 - Shuffle Deck");
            System.out.println("5 - Number of Cards in Deck");
            System.out.println("6 - Compare 2 Cards");
            System.out.println("7 - Sort Cards");
            System.out.println("8 - Restart");
            System.out.println("9 - End Game");
            System.out.print("Enter Choice Here: ");
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    pack.printDeck();
                    break;
                case 2:
                    System.out.print("Enter House: ");
                    sc.nextLine();
                    house = sc.nextLine();
                    System.out.print("Enter Rank: ");
                    rank1 = sc.nextLine();
                    if(pack.findCard(rank1, house))
                        System.out.println(rank1 + " OF " + house + " FOUND IN DECK");
                    else
                        System.out.println(rank1 + " OF " + house + " NOT FOUND IN DECK");
                    break;
                case 3:
                    System.out.println("-- DEAL 5 RANDOM CARDS --");
                    pack.dealCards();
                    break;
                case 4:
                    System.out.println("-- SHUFFLING CARDS --");
                    pack.shuffleCard();
                    break;
                case 5:
                    System.out.println("Number of cards in deck: " + pack.getNoOfCards());
                    break;
                case 6:
                    System.out.println("Enter House: ");
                    sc.nextLine();
                    house = sc.nextLine();
                    if (Card.housestrtoint(house) == -1) {
                        System.out.println("INVALID HOUSE");
                        continue;
                    }
                    System.out.print("Enter Rank of 1st Card: ");
                    rank1 = sc.nextLine();
                    System.out.print("Enter Rank of 2nd Card: ");
                    rank2 = sc.nextLine();
                    pack.compareCard(rank1, rank2, house);
                    break;
                case 7:
                    pack.sortCard();
                    pack.printDeck();
                    break;
                case 8:
                    System.out.println("-- BEFORE GARBAGE COLLECTION --");
                    System.out.println("UNIQUE ID: " + pack.getHashCode());
                    pack.reboot();
                    pack.createDeck();
                    System.out.println("-- AFTER GARBAGE COLLECTION --");
                    System.out.println("UNIQUE ID: " + pack.getHashCode());
                    break;
                case 9:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("-- DEFAULT CASE: INVALID INPUT --");
                    break;
            }
        }
    }
}
