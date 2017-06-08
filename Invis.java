import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Invis here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Invis extends Enemies
{
    public Invis(int h)
    {
       super(h);
       health = h;
        setSpeed(2);
        this.getImage().setTransparency(50);
    }
    
    public void act() 
    {
        transparent();
        movement(this); 
    }
    
    public void transparent()
    {
        if (this.getY()> 300)
        {
            this.getImage().setTransparency(255);
            setSpeed(4);
        }
    }
    public void addedToWorld(World world){
        super.addedToWorld(getWorld());
        healthBar.update(health,true);
    }
}