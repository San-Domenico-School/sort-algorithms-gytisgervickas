import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card extends Actor
{
    private GreenfootImage image;
    private String imageFile;
    private int value;
    
    public Card(String imageFile, int cardValue)
    {
        this.imageFile = imageFile;
        image = new GreenfootImage(imageFile);
        value = cardValue;  
        setImage(image);
    }
    
    public String getImageFile()
    {
        return imageFile;
    }
    
    public int getValue()
    {
        return value;
    }
    
    

}
