package org.javafx;

import java.util.Arrays;
import java.util.List;

import javafx.scene.image.Image;

public class Card {
    private String faceName;
    private boolean matched;
    public Card (String faceName){
        setFaceName(faceName);
        this.matched = false;
    }


    //Valid choices for the card 
    public static List<String> getValidFaceName(){
        return Arrays.asList("dog","cat","bird","bunny","panda","mouse","bee","turtle","elephant");
    }

    public boolean isSameCard(Card otherCard){
        if(this.getFaceName().equals(otherCard.getFaceName())){
            return true;
        }else{
            return false;
        }
    }


    //SETTER
    public void setFaceName(String faceName){
        faceName =faceName.toLowerCase();
        if(getValidFaceName().contains(faceName)){
            this.faceName=faceName;
        }else{
            throw new IllegalArgumentException(faceName+" invalid, must be one of "+getValidFaceName());
        }    
    }

    public void gotMatched(){
        this.matched = true;
    }

    public void notMatched(){
        this.matched = false;
    }

    //GETTER
    public String getFaceName(){
        return faceName;
    }

    public boolean isMatched(){
        return matched;
    }

    public Image getImage(){
        String pathName = "images/"+faceName+".png";
        return new Image(Card.class.getResourceAsStream(pathName));
    }

    public Image getBackImage(){
        return new Image(Card.class.getResourceAsStream("images/back.png"));
    }
}
