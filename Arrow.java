import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrow extends Actor
{
    /**
     * Act - do whatever the Arrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static final int MAX_THROWEN_DELAY = 1;
    private static final int MAX_ARROW_STAY = 4;
    
    private int throwenDelay;
    private int arrowStay;
    
    public void act()
    {
        if(isAtEdgeBootom()){
            arrowStay++;
            if(arrowStay < MAX_ARROW_STAY){
                return;
            }
            getWorld().removeObject(this);
        }else{
             throwen();   
        }   
    }
    public void throwen(){
        throwenDelay++;
        if(throwenDelay < MAX_THROWEN_DELAY){
            return;
        }
        throwenDelay = 0;
        setLocation(getX()-10,getY()+2);
        setRotation(getRotation()-1);
    }
    public boolean isAtEdgeBootom(){
        int y = getY();
        if(y > 340){
            return true;
        }
        return false;
    }
}
