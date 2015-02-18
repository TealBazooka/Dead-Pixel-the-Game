import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sandzone here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sandzone extends World
{
    private HealthBar healthbar;
    /**
     * Constructor for objects of class Sandzone.
     * 
     */
    public Sandzone()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        prepare();
    }

    public void switchScreen()
    {
        Room2 go = new Room2();
        Greenfoot.setWorld(go);
    }
    
    public void subtractHealth(int num)
    {
        int health = healthbar.updateHealthBar(num);
        if( health <= 0 ) Greenfoot.stop();
    }

    public void addHealth(int num)
    {
        healthbar.updateHealthBar(-num);
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Character character = new Character();
        addObject(character, 276, 217);
        Skeleton skeleton = new Skeleton();
        addObject(skeleton, 95, 204);
        character.setLocation(505, 225);
        skeleton.setLocation(302, 197);
        character.setLocation(512, 217);
        skeleton.setLocation(100, 81);

        
        skeleton.setLocation(120, 199);
        Skeleton skeleton2 = new Skeleton();
        addObject(skeleton2, 126, 277);
        Skeleton skeleton3 = new Skeleton();
        addObject(skeleton3, 127, 133);
        Skeleton skeleton4 = new Skeleton();
        addObject(skeleton4, 206, 139);
        Skeleton skeleton5 = new Skeleton();
        addObject(skeleton5, 212, 209);
        Skeleton skeleton6 = new Skeleton();
        addObject(skeleton6, 212, 277);
        Skeleton skeleton7 = new Skeleton();
        addObject(skeleton7, 26, 144);
        Skeleton skeleton8 = new Skeleton();
        addObject(skeleton8, 33, 210);
        Skeleton skeleton9 = new Skeleton();
        addObject(skeleton9, 35, 289);
        skeleton6.setLocation(210, 272);
        skeleton5.setLocation(209, 209);
        skeleton4.setLocation(212, 148);
        skeleton3.setLocation(148, 149);
        skeleton.setLocation(149, 211);
        skeleton2.setLocation(148, 272);
        skeleton9.setLocation(88, 270);
        skeleton8.setLocation(86, 210);
        skeleton7.setLocation(88, 150);
        
        healthbar = new HealthBar();
        addObject(healthbar, 120, 40);
    }

}

