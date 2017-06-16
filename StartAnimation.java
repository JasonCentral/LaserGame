import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartAnimation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartAnimation extends World
{
    private int delayCount = 30;
    private int timer = 1;
    public GreenfootSound music1 = new GreenfootSound("song1.wav");
    /**
     * Constructor for objects of class StartAnimation.
     * 
     */
    public StartAnimation()
    {    
        super(697, 401, 1);
    }

    public void act()
    {
        if (timer == 1)
        {
            playMusic(); 
        }        
        if (delayCount > 0) 
        {
            delayCount--;
        }
        if (delayCount == 0) 
        {
            Greenfoot.setWorld(new StartAnimation1()); //Delay to switch worlds to StartAnimation1
        }
    }

    public void playMusic()
    {
        music1.play(); //Starts playing Music1  
        music1.setVolume(100); //Sets Music1 volume to 100%
    }
}

