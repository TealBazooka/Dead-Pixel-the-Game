import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Room2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Room2 extends World
{

    /**
     * Constructor for objects of class Room2.
     * 
     */
    public Room2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        prepare();
    }
    public void act()
    {
        if(Greenfoot.getRandomNumber(1000) < 20) {
            Spider spider = new Spider();
            addObject(spider, Greenfoot.getRandomNumber(getWidth()-20) + 10, -30);
        }
    }
    private void prepare()
    {
        SkeletonKing skeletonking = new SkeletonKing();
        addObject(skeletonking, 303, 87);
        Character character = new Character();
        addObject(character, 304, 365);
    }
}
