import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stage2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stage2 extends World
{

    /**
     * Constructor for objects of class Stage2.
     * 
     */
    public Stage2()
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
        addObject(throwedCoin1,200,220);
        Skelleton skelleton = new Skelleton();
        addObject(skelleton,540,230);
        Skelleton skelleton1 = new Skelleton();
        addObject(skelleton1,450,290);
    }
}
