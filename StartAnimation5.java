import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartAnimation5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartAnimation5 extends StartAnimation
{
    private int delayCount = 60;
    /**
     * Constructor for objects of class StartAnimation1.
     * 
     */
    public StartAnimation5()
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
            Greenfoot.setWorld(new StartAnimation6());
        }
    }
}
