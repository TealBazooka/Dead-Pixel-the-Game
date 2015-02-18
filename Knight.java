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
}

