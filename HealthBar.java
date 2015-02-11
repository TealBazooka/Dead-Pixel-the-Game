import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    public int health = 5;
    GreenfootImage health5 = new GreenfootImage ("healthbar.png");
    GreenfootImage health4 = new GreenfootImage( "healthbar1.png");
    GreenfootImage health3 = new GreenfootImage ("healthbar2.png");
    GreenfootImage health2 = new GreenfootImage( "healthbar3.png");
    GreenfootImage health1 = new GreenfootImage( "healthbar4.png");
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

    }    

    protected void addedToWorld(World w)
    {
        updateHealthBar(0);        
    }

    public int updateHealthBar(int healthChange)
    {
        health = health - healthChange;  // Note: you can add health by passing in a negative change
        if( health <= 0 )
        {
            return 0;  // Let's caller know we died
        } else if( health == 5)
        {
            health = 5;  
            // can't have more than the max health
        }
        if(health == 5)
        {
            setImage(health5);
        }
        if(health == 4)
        {
            setImage(health4);
        }
        if(health == 3)
        {
            setImage(health3);
        }
        if(health == 2)
        {
            setImage(health2);
        }
        if(health == 1)
        {
            setImage(health1);
        }

        return health;
    }
}
