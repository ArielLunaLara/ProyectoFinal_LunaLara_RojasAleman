import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stage3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stage3 extends World
{

    /**
     * Constructor for objects of class Stage3.
     * 
     */
    public Stage3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 375, 1); 
        //Arturito arturito = new Arturito();
        //addObject(arturito,90,290);
        Heart heart = new Heart();
        addObject(heart,400,30);
        Coin coin = new Coin();
        addObject(coin,500,30);  
        Skelleton skelleton = new Skelleton();
        addObject(skelleton,520,280);
        Skelleton skelleton1 = new Skelleton();
        addObject(skelleton1,360,260);
    }
}
