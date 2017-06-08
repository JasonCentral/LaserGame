import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Charger here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Charger extends Enemies
{
    private int pauseCounter = 0;
    
    public Charger(int h)
    {
       super(h);
       health = h;
        setSpeed(1);
    }
    
    public void act() 
    {
        if (this.getY() == 220)
        {
            setSpeed(0);
            pauseCounter++;
            if (pauseCounter == 50)
            {
                setSpeed(8);
            }
        }
        movement(this);
    }
    public void addedToWorld(World world){
        super.addedToWorld(getWorld());
        healthBar.update(health,true);
    }
}