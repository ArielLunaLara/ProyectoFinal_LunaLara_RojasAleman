import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    private int opcion = 0;
    private Selector selector = new Selector();
    private static boolean playingMusic = false;

    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 375, 1);
        if(playingMusic == false){
            Greenfoot.playSound("base.mp3");
            playingMusic = true;
        }
        starOptions();
        prepare();
    }
    //Refactorizar arrow
    public void act(){
        int y = selector.getY();
        Greenfoot.delay(8); //bloquea todo 
        if (Greenfoot.isKeyDown("w") && opcion>=0){
            opcion--;
            selector.setLocation(37,y-25);
        }   
        if (Greenfoot.isKeyDown("s") && opcion<=3){
            opcion++;
            selector.setLocation(37,y+25);
        }

        //selector.setLocation(37,260+(opcion*10));

        //Refactorizar case
        if (Greenfoot.isKeyDown("space")){
            switch(opcion){
                case 0:
                    Bosque bosque = new Bosque();
                    Arturito arturito = new Arturito();
                    bosque.addObject(arturito,90,290);
                    Greenfoot.setWorld(bosque);                 
                    break;
                case 1:
                    Greenfoot.setWorld(new Record());
                    break;
                case 2:
                    Greenfoot.setWorld(new ComoJugar());
                    break;
                case 3:
                    Greenfoot.stop();
                    break;
            }
        }
    }
    //modificar nombre
    public void starOptions(){
        Jugar jugar = new Jugar();
        addObject(jugar, 90, 290);  
        Records records = new Records();
        addObject(records,90,292);
        Tutorial tutorial = new Tutorial();
        addObject(tutorial,140,450);
        Salir salir = new Salir();
        addObject(salir,55,325);
        addObject(selector,37,260);

    } 
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
    
    

