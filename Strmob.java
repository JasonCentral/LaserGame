import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Strmob here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Strmob extends Enemies
{
    public Strmob(int h)
    {
        super(h);
        health = h;
        setSpeed(1);
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