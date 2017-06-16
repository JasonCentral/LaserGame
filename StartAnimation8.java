import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartAnimation8 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartAnimation8 extends StartAnimation
{
    private int delayCount = 15;
    /**
     * Constructor for objects of class StartAnimation1.
     * 
     */
    public StartAnimation8()
    {
    }

    public void act()
    {
        
        if (delayCount > 0) 
        {
            delayCount--;
        }
        if (delayCount == 0) 
        {
            Greenfoot.setWorld(new StartAnimation9()); //Changes the world to StartScreen after the delay
        }
    }
}
