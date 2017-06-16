import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayButton extends Actor
{
    /**
     * Act - do whatever the PlayButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage button1 = new GreenfootImage("start1.png");
    private GreenfootImage button2 = new GreenfootImage("start2.png");
    public GreenfootSound music2 = new GreenfootSound("gameSong.mp3");

    private boolean mouseHovering;
    int timer = 0; 
    int transparency;

    public void act() 
    {
        if (transparency < 255)
        {
            fade();
        } 
        if (!mouseHovering && Greenfoot.mouseMoved(this))
        {
            setImage(button2);
            mouseHovering = true;
        }
        if (mouseHovering && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage(button1);
            mouseHovering = false;
        }  
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new MyWorld()); 
            music2.playLoop();
        }
    }  

    public void fade()
    {
        transparency = timer++;
        getImage().setTransparency(transparency);
    }
}
