import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartAnimation6 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartAnimation6 extends StartAnimation
{
    private int delayCount = 30;
    /**
     * Constructor for objects of class StartAnimation1.
     * 
     */
    public StartAnimation6()
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
            Greenfoot.setWorld(new StartAnimation7()); //Changes the world to StartScreen after the delay
        }
    }
}
