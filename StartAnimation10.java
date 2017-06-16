import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartAnimation10 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartAnimation10 extends StartAnimation
{
    private int delayCount = 45;
    /**
     * Constructor for objects of class StartAnimation1.
     * 
     */
    public StartAnimation10()
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
            Greenfoot.setWorld(new StartScreen()); //Changes the world to StartScreen after the delay
        }
    }
}
