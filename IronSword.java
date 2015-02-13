import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IronSword here.
 *
 * @author Dead-Pixel
 * @version (a version number or a date)
 */
public class IronSword extends Actor
{
    int pause = 5;
    int direction;
    /**
     * Act - do whatever the IronSword wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        imageSetter();
        //the if statement following this comment removes the iron sword after 2 runs of act
        if(pause>0)
        {
           pause--;
        }
        if(pause == 0)
        {
           getWorld().removeObject(this);
        }
    }
    public void imageSetter()
    {
        //gets the direction from the stab() function in the character class and sets the image that coresponds to it
        if(direction == 1)
        {
            setImage("IronSword_U.png");
        }
        if(direction == 3)
        {
            setImage("IronSword_D.png");
        }
        if(direction == 4)
        {
            setImage("IronSword_L.png");
        }
        if(direction == 2)
        {
            setImage("IronSword_R.png");
        }
    }
    public void setDirection(int d)
    {
        //allows the direction to be set in character class
        direction = d;
    }
    
}
