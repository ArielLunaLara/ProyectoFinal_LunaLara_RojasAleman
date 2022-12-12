import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stage1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stage1 extends World
{

    /**
     * Constructor for objects of class Stage1.
     * 
     */
    public Stage1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 375, 1); 
        //Arturito arturito = new Arturito();
        //addObject(arturito,90,290);
        Heart heart = new Heart();
        addObject(heart,400,30);
        Coin coin = new Coin();
        addObject(coin,500,30);
        UsefulCoin throwedCoin1 = new UsefulCoin();
        addObject(throwedCoin1,400,320);
        UsefulCoin throwedCoin2 = new UsefulCoin();
        addObject(throwedCoin2,200,320);
        UsefulCoin throwedCoin3 = new UsefulCoin();
        addObject(throwedCoin3,300,170);
        Skelleton skelleton = new Skelleton();
        addObject(skelleton,520,280);
    }
}
