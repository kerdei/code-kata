import java.util.*;

class Player {

    LinkedList<Card> cards;
    Integer roundsWon;

    public Player(LinkedList<Card> cards) {
        this.cards = cards;
        roundsWon = 0;
    }

    public void wonARound() {
        roundsWon++;
    }

    @Override
    public String toString() {

        String actualCards = "";

        for (Card card : cards) {
            actualCards = actualCards.concat(" " + card.value.getCardValue() + card.suit);
        }

        return "Player{" +
                "cards=" + actualCards +
                ", roundsWon=" + roundsWon +
                '}';
    }
}

class Card {

    public enum CardValue {
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13),
        ACE(14);

        private int cardValue;

        CardValue(int value) {
            this.cardValue = value;
        }

        public int getCardValue() {
            return cardValue;
        }
    }

    CardValue value;
    char suit;

    public Card(CardValue value, char suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value.getCardValue() +
                ", suit=" + suit +
                '}';
    }
}

class Solution {

    public static void main(String args[]) {

        LinkedList<Card> player1Cards = new LinkedList<>();
        LinkedList<Card> player2Cards = new LinkedList<>();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of cards for player 1

        for (int i = 0; i < n; i++) {
            String card = in.next(); // the n cards of player 1
            char suit = card.charAt(card.length() - 1);
            Card.CardValue cardValue = getCardValue(card);
            player1Cards.add(new Card(cardValue, suit));
        }
        int m = in.nextInt(); // the number of cards for player 2
        for (int i = 0; i < m; i++) {
            String card = in.next(); // the m cards of player 2
            char suit = card.charAt(card.length() - 1);
            Card.CardValue cardValue = getCardValue(card);
            player2Cards.add(new Card(cardValue, suit));
        }

        Player p1 = new Player(player1Cards);
        Player p2 = new Player(player2Cards);

        LinkedList<Card> warCardsP1 = new LinkedList<>();
        LinkedList<Card> warCardsP2 = new LinkedList<>();


        while (player1Cards.size() > 0 && player2Cards.size() > 0) {
            //Step 1 : the fight

            warCardsP1.addFirst(p1.cards.pollFirst());
            warCardsP2.addFirst(p2.cards.pollFirst());

            if (warCardsP1.peekFirst().value.getCardValue() > warCardsP2.peekFirst().value.getCardValue()) {
                p1.cards.addAll(warCardsP1);
                p1.cards.addAll(warCardsP2);
                p1.wonARound();
            } else if (warCardsP1.peekFirst().value.getCardValue() < warCardsP2.peekFirst().value.getCardValue()) {
                p2.cards.addAll(warCardsP2);
                p2.cards.addAll(warCardsP1);
                p2.wonARound();
            } else {
                //Step 2 : war
                warCardsP1.addFirst(p1.cards.pollFirst());
                warCardsP1.addFirst(p1.cards.pollFirst());
                warCardsP1.addFirst(p1.cards.pollFirst());
                warCardsP2.addFirst(p2.cards.pollFirst());
                warCardsP2.addFirst(p2.cards.pollFirst());
                warCardsP2.addFirst(p2.cards.pollFirst());
            }

        }

        if (p1.roundsWon > p2.roundsWon) {
            System.out.println("1 " + p1.roundsWon);
        } else {
            System.out.println("2 " + p2.roundsWon);
        }

        // TODO PAT
        // TODO Optimize
    }

    private static Card.CardValue getCardValue(String cardInString) {

        Card.CardValue cardValue;
        cardInString = cardInString.substring(0, cardInString.length() - 1);

        switch (cardInString) {
            case "2":
                cardValue = Card.CardValue.TWO;
                break;
            case "3":
                cardValue = Card.CardValue.THREE;
                break;
            case "4":
                cardValue = Card.CardValue.FOUR;
                break;
            case "5":
                cardValue = Card.CardValue.FIVE;
                break;
            case "6":
                cardValue = Card.CardValue.SIX;
                break;
            case "7":
                cardValue = Card.CardValue.SEVEN;
                break;
            case "8":
                cardValue = Card.CardValue.EIGHT;
                break;
            case "9":
                cardValue = Card.CardValue.NINE;
                break;
            case "10":
                cardValue = Card.CardValue.TEN;
                break;
            case "J":
                cardValue = Card.CardValue.JACK;
                break;
            case "Q":
                cardValue = Card.CardValue.QUEEN;
                break;
            case "K":
                cardValue = Card.CardValue.KING;
                break;
            case "A":
                cardValue = Card.CardValue.ACE;
                break;
            default:
                cardValue = Card.CardValue.TWO;
        }
        return cardValue;
    }
}