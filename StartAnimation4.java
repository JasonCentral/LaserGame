import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartAnimation4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartAnimation4 extends StartAnimation
{
    private int delayCount = 30;
    /**
     * Constructor for objects of class StartAnimation1.
     * 
     */
    public StartAnimation4()
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
            Greenfoot.setWorld(new StartAnimation5()); 
        }
    }
}
