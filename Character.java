import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Actor
{
    public int direction;
    public int collisionCountdown = 0;
    public int swordTimer;
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        movement();
        nextScreen();
        if( collisionCountdown > 0 )
        {
            collisionCountdown--;
        }
        else
        {
            handleCollisions();
        }
        if( swordTimer > 0 )
        {
            swordTimer--;
        }
        else
        {
            stab();
        }
    }    

    public void movement()
    {
        // allows the arrow keys to control the movement
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY() - 4);
            setImage("IronArmor_U_N.png");
            direction = 1;
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + 4);
            setImage("IronArmor_D_N.png");
            direction = 3;
        }
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - 4, getY());
            setImage("IronArmor_L_N.png");
            direction = 4;
        }
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + 4, getY());
            setImage("IronArmor_R_N.png");
            direction = 2;
        }
    }
    
    public void nextScreen()
    {
        if(getY() <= 5)
        {
            //switch to next world -- Heather
            // need to change later for multiple screens & different directions
            Sandzone world = (Sandzone) getWorld();
            world.switchScreen();
        }
    }

    public void stab()
    {
        // makes space call the ironsword actor, sets the direction which the ironsword actor then uses to sellect the image, 
        //then adds the actor to the world in the place coresponding to the character. (this actor)
        if(Greenfoot.isKeyDown("space"))
        {
            if(direction == 1)
            {
                IronSword ironsword = new IronSword();
                ironsword.setDirection(1);
                ironsword.imageSetter();
                getWorld().addObject(ironsword, getX() + 1, getY() - 22);
                swordTimer = 30;
            }
            else if(direction == 2)
            {
                IronSword ironsword = new IronSword();
                ironsword.setDirection(2);
                ironsword.imageSetter();
                getWorld().addObject(ironsword, getX() + 15, getY() + 9);
                swordTimer = 30;
            }
            else if(direction == 3)
            {
                IronSword ironsword = new IronSword();
                ironsword.setDirection(3);
                ironsword.imageSetter();
                getWorld().addObject(ironsword, getX(), getY() + 20);
                swordTimer = 30;
            }
            else if(direction == 4)
            {
                IronSword ironsword = new IronSword();
                ironsword.setDirection(4);
                ironsword.imageSetter();
                getWorld().addObject(ironsword, getX() -15, getY() + 9);
                swordTimer = 30;
            }
        }
    }

    private void handleCollisions()
    {
        Actor skeleton = getOneIntersectingObject(Skeleton.class);
        if( skeleton != null )
        {
            Sandzone sandzone = (Sandzone) getWorld();
            sandzone.subtractHealth(1);
            if( direction == 3)
            {
                //up
                setLocation(getX(), getY() - 50);
            }
            if( direction == 4)
            {
                //right
                setLocation(getX() + 50, getY());
            }
            if(direction == 1)
            {
                //down
                setLocation(getX(), getY() + 50);
            }
            if(direction == 2)
            {
                // left
                setLocation(getX() - 50, getY());
            }
            collisionCountdown = 50;
        }
    }

}
