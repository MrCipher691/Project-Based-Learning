public class Card {
    private int rank;
    private int house;

    private static String[] House = {"CLUBS", "DIAMONDS", "HEARTS", "SPADES"};
    private static String[] Rank = {null, "ACE", "1", "2", "3", "4", "5", "6", "7", "8", "9", "JACK", "QUEEN", "KING"};
    
    public Card(int rank, int house) {
        this.rank = rank;
        this.house = house;
    }

    protected int getRank() {
        return rank;
    }
    
    protected int getHouse() {
        return house;
    }

    protected static int rankstrtoint(String rank) {
        for (int i = 0; i < Rank.length; i++) {
            if (rank.equals(Rank[i]))
                return i;
        }
        return -1;
    }

    protected static int housestrtoint(String house) {
        for (int i = 0; i < House.length; i++) {
            if (house.equals(House[i]))
                return i;
        }
        return -1;
    }

    protected boolean sameCard(Card shown) {
        return this.rank == shown.rank && this.house == shown.house;
    }

    protected void printCard() {
        System.out.println(Rank[rank] + " OF " + House[house]);
    }
}