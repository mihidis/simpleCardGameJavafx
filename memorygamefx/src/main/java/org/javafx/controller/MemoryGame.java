package org.javafx.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.javafx.Card;
import org.javafx.Deck;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

public class MemoryGame implements Initializable{

    private Deck deck;
    private int numOfGuesses;
    private int numOfMatches;
    private Card card1,card2;


    @FXML
    private Label correctLabel;

    @FXML
    private Label guessesLabel;

    @FXML
    private FlowPane imagesFlowPane;

    @FXML
    void playAgain(ActionEvent event) {
        card1 = null;
        card2 = null;
        numOfGuesses = 0;
        numOfMatches = 0;
        deck = new Deck();
        deck.shuffle();
        for(Card temp:deck.getDeck()){
            temp.notMatched();
        }
        flipAllCards();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        initializeImageView();
        playAgain(null);
    }

    // this method will initialize the image view and add the image of cards
    private void initializeImageView(){
        for(int i=0; i < imagesFlowPane.getChildren().size();i++){
            ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(i);
            imageView.setImage(new Image(Card.class.getResourceAsStream("images/back.png")));
            imageView.setUserData(i);

            imageView.setOnMouseClicked(event -> {
                flipCard((int) imageView.getUserData());
            });
        }
    }

    private void flipCard(int index){
        if(card1==null && card2 ==null){
            flipAllCards();
        }

        ImageView imageView =(ImageView) imagesFlowPane.getChildren().get(index);
        if(card1 ==null){
            card1 = deck.getDeck().get(index);        
            imageView.setImage(card1.getImage());
        }else if (card2 == null){
            numOfGuesses++;
            card2 = deck.getDeck().get(index);
            imageView.setImage(card2.getImage());
            checkForMatch();
            updateLabels();
        }
    }

    private void updateLabels(){
        correctLabel.setText(Integer.toString(numOfMatches));
        guessesLabel.setText(Integer.toString(numOfGuesses));
    }

    public void flipAllCards(){
        for (int i=0; i < deck.getDeck().size();i++){
            ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(i);
            if(!deck.getDeck().get(i).isMatched()){
                imageView.setImage(deck.getDeck().get(i).getBackImage());
            }
        }
    }

    public void checkForMatch(){
        if(card1.isSameCard(card2)){
            numOfMatches++;
            card1.gotMatched();
            card2.gotMatched();
        }
        card1 = null;
        card2 = null;
    }
}

