import java.util.*;

class Player {

    LinkedList<Integer> cards;
    Integer roundsWon;

    public Player(LinkedList<Integer> cards) {
        this.cards = cards;
        roundsWon = 0;
    }

    public void wonARound() {
        roundsWon++;
    }
}

class Solution {

    public static void main(String args[]) {

        LinkedList<Integer> player1Cards = new LinkedList<>();
        LinkedList<Integer> player2Cards = new LinkedList<>();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of cards for player 1

        for (int i = 0; i < n; i++) {
            String card = in.next(); // the n cards of player 1
            player1Cards.add(getCardValue(card));
        }
        int m = in.nextInt(); // the number of cards for player 2
        for (int i = 0; i < m; i++) {
            String card = in.next(); // the m cards of player 2
            player2Cards.add(getCardValue(card));
        }

        Player p1 = new Player(player1Cards);
        Player p2 = new Player(player2Cards);

        LinkedList<Integer> warCardsP1 = new LinkedList<>();
        LinkedList<Integer> warCardsP2 = new LinkedList<>();

        boolean isWar = false;

        while (p1.cards.size() > 0 && p2.cards.size() > 0) {
            //Step 1 : the fight

            warCardsP1.addFirst(p1.cards.pollFirst());
            warCardsP2.addFirst(p2.cards.pollFirst());

            if (warCardsP1.peekFirst() > warCardsP2.peekFirst()) {
                p1.cards.addAll(warCardsP1);
                p1.cards.addAll(warCardsP2);
                warCardsP1.clear();
                warCardsP2.clear();
                p1.wonARound();
                isWar = false;
            } else if (warCardsP1.peekFirst() < warCardsP2.peekFirst()) {
                p2.cards.addAll(warCardsP1);
                p2.cards.addAll(warCardsP2);
                warCardsP1.clear();
                warCardsP2.clear();
                p2.wonARound();
                isWar = false;
            } else {
                //Step 2 : war
                for (int i = 0; i < 3; i++) {
                    if (warCardsP1.size() > 0) {
                        warCardsP1.addFirst(p1.cards.pollFirst());
                    }
                    if (warCardsP2.size() > 0) {
                        warCardsP2.addFirst(p2.cards.pollFirst());
                    }
                }
                isWar = true;
            }
        }

        if (isWar) {
            System.out.println("PAT");
        } else {

            int sum = p1.roundsWon + p2.roundsWon;
            if (p1.roundsWon > p2.roundsWon) {
                System.out.println("1 " + sum);
            } else {
                System.out.println("2 " + sum);
            }
        }
    }

    private static Integer getCardValue(String cardInString) {
        cardInString = cardInString.substring(0, cardInString.length() - 1);
        switch (cardInString) {

            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return Integer.parseInt(cardInString);
        }
    }
}