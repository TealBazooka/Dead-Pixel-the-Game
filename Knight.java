import greenfoot.*;

/**
 * Write a description of class Knight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knight extends Actor
{
    public int movementCountDown = 5;
    public int hitPoints = 3;
    public int direction;
    
    public void act() 
    {
        if( movementCountDown > 0 )
        {
            movementCountDown--;
        }
        else
        {
            movement();
            movementCountDown = 5;
        }
        move(2);
        setDirection();
        death();
    }    
    public void movement()
    {
        if(Greenfoot.getRandomNumber(15) == 0)
        {
            setRotation(0);
            setImage("rightarrow.png");
        }
        if(Greenfoot.getRandomNumber(15) == 1)
        {
            setRotation(90);
            setImage("downarrow.png");
        }
        if(Greenfoot.getRandomNumber(15) == 2)
        {
            setRotation(-90);
            setImage("uparrow.png");
        }
        if(Greenfoot.getRandomNumber(15) == 3)
        {
            setRotation(180);
            setImage("leftarrow.png");
        }
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
        }
        if (hitPoints <= 0)
        {
            World world;
            world = getWorld();
            world.removeObject(this);
        }
    }
}

