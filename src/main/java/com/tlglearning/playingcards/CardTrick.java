package com.tlglearning.playingcards;

import com.tlglearning.playingcards.model.Card;
import com.tlglearning.playingcards.model.Deck;
import com.tlglearning.playingcards.model.Suit;

import java.util.*;
import java.util.stream.Collectors;

public class CardTrick {

    private final Deque<Card> blackPile = new LinkedList<>();
    private final Deque<Card> redPile = new LinkedList<>();
    private final Comparator<Card> displayComparator = Comparator
            .comparing((Card c) -> c.getSuit().getColor())
            .thenComparing(Card::getSuit)
            .thenComparing(Card::getRank);

    public static void main(String[] args) {

        Deck deck = new Deck();
        deck.shuffle();

        CardTrick trick = new CardTrick();
        trick.splitDeck(deck);

        // TODO (Optional: Shuffle the red deque and black deque. Note that deck was already shuffled, so this is of
        //  little value.)

        trick.swapCards();
        trick.tally();
    }

    public void splitDeck(Deck deck) {
        while (deck.getRemaining() > 0) {
            Card indicator = deck.draw();
            Card next = deck.draw();
            if (indicator.getSuit().getColor() == Suit.Color.BLACK) {
                blackPile.add(next);
            } else {
                redPile.add(next);
            }
        }
    }

    public void swapCards() {
        Random rng = new Random();
        int swapSize = rng.nextInt(1 + Math.min(blackPile.size(), redPile.size()));
        for (int i = 0; i < swapSize; i++) {
            redPile.add(blackPile.remove());
            blackPile.add(redPile.remove());
        }
    }

    public void tally() {
        tallyPile(blackPile, Suit.Color.BLACK);
        tallyPile(redPile, Suit.Color.RED);
    }

    private void tallyPile(Collection<Card> pile, Suit.Color color) {
        long count = pile.stream().filter((c) -> c.getSuit().getColor() == color).count();
        System.out.printf("%1$s pile: cards=%2$s; count of %1$s cards=%3$d.%n",
                color, pile.stream().sorted(displayComparator).collect(Collectors.toList()), count);
    }

}
