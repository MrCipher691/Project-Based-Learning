import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Deck {
    private Card cards[];
    private int noOfCards;

    Deck() {
        noOfCards = 52;
        cards = new Card[noOfCards];
    }

    public int getNoOfCards() {
        return noOfCards;
    }

    public int getHashCode() {
        return cards[0].hashCode();
    }

    public void reboot() {
        System.out.println("-- RELOADING GAME --");
        Arrays.fill(cards, null);
        noOfCards = 0;
        Runtime.getRuntime().gc();
    }
    
    public void createDeck() {
        int cardsInDeck = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 14; j++) {
                cards[cardsInDeck] = new Card(j, i);
                cardsInDeck++;
            }
        }
        noOfCards = cardsInDeck;
    }

    public boolean findCard(String rank, String house) {
        int i = Card.rankstrtoint(rank);
        int j = Card.housestrtoint(house);

        if(i == -1) {
            System.out.println("INVALID RANK");
            return false;
        }
        if(j == -1) {
            System.out.println("INVALID HOUSE");
            return false;
        }

        Card traverser = new Card(i, j);
        for (int k = 0; k < noOfCards; k++) {
            if (cards[i] != null) {
                if (cards[k].sameCard(traverser)) {
                    cards[i] = null;
                    noOfCards--;
                    return true;
                }
            }
        }
        return false;
    }

    public void compareCard(String r1, String r2, String house) {
        if(!findCard(r1, house))
        {
            System.out.println("-- CARD 1 NOT FOUND --");
            if(!findCard(r2, house))
            {
                System.out.println("-- CARD 2 NOT FOUND --");
                return;
            }
            return;
        }

        int i = Card.rankstrtoint(r1);
        int j = Card.rankstrtoint(r2);

        if (i > j)
            System.out.println("CARD 1 IS HIGHER");
        else if (i < j)
            System.out.println("CARD 2 IS HIGHER");
        else
            System.out.println("BOTH CARDS ARE SAME");
    }

    public void dealCards() {
        int i = 0;
        while (i < 5) {
            if (getNoOfCards() == 0) {
                System.out.println("NO MORE CARDS TO DEAL");
                break;
            }
            Random random = new Random();
            int j = random.nextInt(cards.length);
            while (cards[j] == null)
                j = random.nextInt(cards.length);
            i++;
            System.out.println("CARD: " + i + ": ");
            cards[j].printCard();
            cards[j] = null;
            noOfCards--;
        }
    }

    public void printDeck() {
        System.out.println("DECK HAS " + getNoOfCards() + " CARDS");
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != null)
                cards[i].printCard();
        }
    }

    public void sortCard() {
        Comparator<Card> comp = Comparator.nullsLast(Comparator.comparing(Card::getHouse, Comparator.nullsLast(Comparator.naturalOrder())))
        .thenComparing(Card::getRank, Comparator.nullsLast(Comparator.naturalOrder()));
        Arrays.sort(cards, comp);
    }

    public void shuffleCard() {
        Card temp;
        Random random = new Random();
        for (int i = 0; i < cards.length; i++) {
            int j = random.nextInt(cards.length - 1);
            int k = random.nextInt(cards.length - 1);

            if (j == k)
                continue;
            temp = cards[k];
            cards[k] = cards[j];
            cards[j] = temp;
        }
    }
}