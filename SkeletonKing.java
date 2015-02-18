import greenfoot.*;
import java.util.*;
/**
 * Write a description of class SkeletonKing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SkeletonKing extends Actor
{
    public int hitPoints = 5;
    public int invinsibility;
    public int direction = 3;
    
    
    public void act() 
    {
        // Add your action code here.
        fightPlayer();
        if( invinsibility > 0 )
        {
            invinsibility--;
            //add red version of hit point images with if hitpoint statements
        }
        else
        {
            death();
        }
        setDirection();
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
    public void fightPlayer()
    {
      //Follows player around to fight -- Heather
      //Need to find a way to make actor rotate and move but not image
        int heroX, heroY;
      List<Character> hero = getObjectsInRange(200, Character.class);
      if(hero.size()!= 0)
      { 
          heroX = hero.get(0).getX();
          heroY = hero.get(0).getY();
          turnTowards(hero.get(0).getX(), hero.get(0).getY());  
          //getImage().rotate(0);
          super.move(1);
          setRotation (0);
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
                setLocation(getX(), getY() - 200);
            }
            if( direction == 2)
            {
                //right
                setLocation(getX() + 200, getY());
            }
            if(direction == 3)
            {
                //down
                setLocation(getX(), getY() + 200);
            }
            if(direction == 4)
            {
                // left
                setLocation(getX() - 200, getY());
            }
            hitPoints = hitPoints -1;
            invinsibility = 100;
            
        }
        //add hit point images
        if (hitPoints <= 0)
        {
            World world;
            world = getWorld();
            world.removeObject(this);
        }
    }
}
