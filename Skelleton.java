import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sekelleton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skelleton extends Enemy
{
    /**
     * Act - do whatever the Sekelleton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static final int MAX_SHOT_DELAY = 70;
    
    
    private int health = 100;
    private int shotDelay;
    
    public void act()
    {
        if(isRecivinDamage()){
            health-=10;
        }
        shot();
        death();
    }
    public void shot(){
        shotDelay++;
        if(shotDelay < MAX_SHOT_DELAY){
            return;
        }
        shotDelay = 0;
        Arrow arrow = new Arrow();
        getWorld().addObject(arrow,getX(),getY());
    }
    public boolean isRecivinDamage(){
         Actor arturito= getOneIntersectingObject(Arturito.class);
         if(arturito != null && Greenfoot.isKeyDown("h")){
             return true;
         }
         return false;
    }
    public void death(){
        if(health <= 0){
            getWorld().removeObject(this);
        }
    }
}
