package com.tlglearning.playingcards;

import com.tlglearning.playingcards.model.Card;
import com.tlglearning.playingcards.model.Deck;

import java.util.Deque;

public class CardTrick {

    private Deque<Card> blackPile;
    private Deque<Card> redPile;


    public static void main(String[] args) {
        // TODO Create an instance of Deck and shuffle it (or not).
        Deck deck = new Deck();
        deck.shuffle();
        // TODO Draw cards from the deck, according to the instructions, placing every other card into a red deque and a
        //  black deque.
        // TODO (Optional: Shuffle the red deque and black deque.)
        // TODO Generate a random integer between 0 and the smaller of the two deque sizes, and swap that number of
        //  cards between the two.
        // TODO Count the red cards in the red deque and the black cards in the black deque, and compare them. THEY MUST
        //  BE EQUAL.
        // TODO Sort each deque by color, suit, and rank, and print them out, along with the counts from the previous
        //  step.

    }

}
