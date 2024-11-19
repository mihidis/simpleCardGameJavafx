package org.javafx;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;

    public Deck(){
        this.deck = new ArrayList<Card>();
        for(int i=0;i<2;i++){
            deck.add(new Card("dog"));
            deck.add(new Card("cat"));
            deck.add(new Card("bird"));
            deck.add(new Card("panda"));
            deck.add(new Card("bunny"));
            deck.add(new Card("mouse"));
            deck.add(new Card("bee"));
            deck.add(new Card("turtle"));
            deck.add(new Card("elephant"));
        } 
    }

    //this method shuffles the deck          
    public void shuffle(){
        Collections.shuffle(deck);
    }

    public boolean hasCard(){
        if(deck.size()>0){
            return true;
        }else{
            return false;
        }
    }

    public Card dealTopCard(){
        if(deck.size()>0){
            return deck.remove(0);
        }else{
            return  null;
        }   
    }

    public ArrayList<Card> getDeck(){
        return deck;
    }
}
