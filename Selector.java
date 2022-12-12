import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Selector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Selector extends Actor
{
    int opcion=0;
    
    /**
     * Act - do whatever the Selector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    //Constructor
    public Selector(){
        GreenfootImage myImage = getImage();
        myImage.scale(50,50);
        setImage(myImage);
    }
}
