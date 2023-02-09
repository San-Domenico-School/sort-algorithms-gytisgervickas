import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board extends World
{

    /**
     * Constructor for objects of class Board.
     * 
     */
    public Board()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(480, 580, 1, false); 
        prepare();

    }
    
    private void prepare()
    {
        addObject(new Dealer(),-30, -30);
    }
}
