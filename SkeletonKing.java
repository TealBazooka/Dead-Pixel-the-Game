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
    
    /**
     * Act - do whatever the SkeletonKing wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        fightPlayer();
        death();
        //kill will give an error when death occurs
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
            World world;
            world = getWorld();
            world.removeObject(this);
        }
    } 
}
