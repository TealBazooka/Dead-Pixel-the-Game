import greenfoot.*;

/**
 * Write a description of class Skeleton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skeleton extends Actor
{
    int wait = 1;
    int direction;
    int hitPoints = 2;
    /**
     * Act - do whatever the Skeleton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        setDirection();
        randomMovement();
        death();
        //kill will give an error when death occurs
    }    

    public void setDirection()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            direction = 1;
        }
        if(Greenfoot.isKeyDown("down"))
        {
            direction = 3;
        }
        if(Greenfoot.isKeyDown("left"))
        {
            direction = 4;
        }
        if(Greenfoot.isKeyDown("right"))
        {
            direction = 2;
        }
    }
    public void randomMovement()
    {
        //Poorly executed random movement function
        int i = 0;
        if( Greenfoot.getRandomNumber(50) == 0)
        {
            //up
            setLocation(getX(), getY() - 10);
        }
        if( Greenfoot.getRandomNumber(50) == 1)
        {
            //right
            setLocation(getX() + 10, getY());
        }
        if(Greenfoot.getRandomNumber(50) == 2)
        {
            //down
            setLocation(getX(), getY() + 10);
        }
        if(Greenfoot.getRandomNumber(50) == 3)
        {
            // left
            setLocation(getX() - 10, getY());
        }
    }

    public void death()
    {
        // Death: if the iron sword touches this actor it is removed.
        Actor ironsword;
        ironsword = getOneObjectAtOffset(0, 0, IronSword.class);
        if (isTouching(IronSword.class) == true)
        {
            if( direction == 1)
            {
                //up
                setLocation(getX(), getY() - 75);
            }
            if( direction == 2)
            {
                //right
                setLocation(getX() + 75, getY());
            }
            if(direction == 3)
            {
                //down
                setLocation(getX(), getY() + 75);
            }
            if(direction == 4)
            {
                // left
                setLocation(getX() - 75, getY());
            }
            hitPoints = hitPoints -1;
            setImage("skeleton2.png");
        }
        if (hitPoints <= 0)
        {
            World world;
            world = getWorld();
            world.removeObject(this);
        }
    }
}
