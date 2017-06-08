import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Target here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Basic extends Enemies
{
    public Basic(int h)
    {
        super(h);
        health = h;
        setSpeed(2);
    }
    
    public void act() 
    {
        movement(this);
    }
    public void addedToWorld(World world){
        super.addedToWorld(getWorld());
        healthBar.update(health,true);
    }
}