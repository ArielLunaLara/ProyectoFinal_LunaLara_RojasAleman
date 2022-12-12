import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arturito here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arturito extends Actor
{   
    //Constantes; static 
    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int MAX_JUMP_DELAY = 1;
    private static final int MAX_JUMP_STEPS = 16;
    private static final int JUMP_STEP_SIZE = 5;
    
    private int health = 100;
    private int coins = 0;
    private int points = 0;
    private int jumpContador;
    private boolean jump; //false por defecto
    private int jumpDirection;
    private int jumpStep;
    private int jumpDelay;
    private int stage = 0;
    /**
     * Act - do whatever the Arturito wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(getX(),getY());
        showHud();
        changeStage();
        takeCoin();
        if(jump){
            jump();
        }
        recivingArrows();
        if(isAttaking()){
            points+=5;
        }
        death();
    }
    private void jump(){
        jumpDelay++;
        if(jumpDelay < MAX_JUMP_DELAY){
            return;
        }
        jumpDelay = 0;
        if(jumpDirection == UP){
            setLocation(getX(),getY()-JUMP_STEP_SIZE); 
            jumpStep++;
            if(jumpStep == MAX_JUMP_STEPS){
                jumpDirection = DOWN;    
            }
        }else{
            setLocation(getX(),getY()+JUMP_STEP_SIZE);
            jumpStep--;
            if(jumpStep == 0){
                jump = false;   
            }
            
        }
    }
    private void move(int x,int y){
        if(Greenfoot.isKeyDown("a")){
            setLocation(x-5,y);
            setImage("images/arturito_Izquierda.png");
        }
        if(Greenfoot.isKeyDown("d")){
            setLocation(x+5,y);
            setImage("images/arturito_Derecha.png");
        }
        if(Greenfoot.isKeyDown("w") && !jump){
            jump = true;
            jumpDirection = UP;
        }
    }
    
    private void showHud(){
        getWorld().showText(String.format("%d",health),450,30);
        getWorld().showText(String.format("%d",coins),550,30);
        getWorld().showText(String.format("%s","Points"),300,30);
        getWorld().showText(String.format("%d",points),350,30);
    }
    public void changeStage(){
        
        if(isAtEdgeLeft()){
            switch(stage){
                case 0:
                    break;
                case 1:
                    Bosque bosque = new Bosque();
                    bosque.addObject(this,550,290);
                    Greenfoot.setWorld(bosque);
                    stage = 0;
                    break;
                case 2:
                    Stage1 scenario1 = new Stage1();
                    scenario1.addObject(this,550,290);
                    Greenfoot.setWorld(scenario1);
                    stage = 1;
                    break;
                case 3:       
                    Stage2 scenario2 = new Stage2();
                    scenario2.addObject(this,550,290);
                    Greenfoot.setWorld(scenario2);
                    stage = 2;
                    break;
            }
        }
        if(isAtEdgeRight()){
            switch(stage){
                case 0:
                    Stage1 scenario1 = new Stage1();
                    scenario1.addObject(this,60,290);
                    Greenfoot.setWorld(scenario1);
                    stage = 1;
                    break;
                case 1:
                    Stage2 scenario2 = new Stage2();
                    scenario2.addObject(this,60,290);
                    Greenfoot.setWorld(scenario2);
                    stage = 2;
                    break;
                case 2:
                    Stage3 scenario3 = new Stage3();
                    scenario3.addObject(this,60,290);
                    Greenfoot.setWorld(scenario3);
                    stage = 3;
                    break;
                case 3:
                    FinalStage finalStage = new FinalStage();
                    //scenario3.addObject(this,60,290);
                    Greenfoot.setWorld(finalStage);
                    stage = 4;
                    World record = getWorld();
                    GameRecord gameRecord = new GameRecord("Arturito", points); 
                    
                    break;
            }
        }
    }
    public boolean isAtEdgeLeft(){
        int x = getX();
        if(x < 5){
            return true;
        }
        return false;
    }
     public boolean isAtEdgeRight(){
        int x = getX();
        if(x > 595){
            return true;
        }
        return false;
    }

    
    public void takeCoin(){
         Actor coin = getOneIntersectingObject(UsefulCoin.class);
         if(coin != null && Greenfoot.isKeyDown("s")){
             coins+=10;
             getWorld().removeObject(coin);
         }
    }
    public void recivingArrows(){
        Actor arrow = getOneIntersectingObject(Arrow.class);
        
        if(arrow != null){
            if(Greenfoot.isKeyDown("u")){
                getWorld().removeObject(arrow);
                points++;
            }else{
                getWorld().removeObject(arrow);  
                health-=10;  
            }   
        }
    }
    public boolean isAttaking(){
        Actor skelleton = getOneIntersectingObject(Skelleton.class);
        if(skelleton != null && Greenfoot.isKeyDown("h")){
            return true;
        }
        return false;
    }
    public void death(){
        if(health <= 0){
            getWorld().removeObject(this);
            Greenfoot.setWorld(new Death());
        }
    } 
}
