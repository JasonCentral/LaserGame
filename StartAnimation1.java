import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartAnimation1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartAnimation1 extends StartAnimation
{
    private int delayCount = 30; 
    /**
     * Constructor for objects of class StartAnimation1.
     * 
     */
    public StartAnimation1()
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
            Greenfoot.setWorld(new StartAnimation2()); 
        }
    }
}