import greenfoot.*;

/**
 * Write a description of class Spider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spider extends Actor
{
    /**
     * Act - do whatever the Spider wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY() + 3);
        byeBye();
    }   
    public void byeBye()
    {
        if(getY() >= 395)
        {
            World Room2;
            Room2 = getWorld();
            Room2.removeObject(this);
        }
    }
}
