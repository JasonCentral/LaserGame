import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jumper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jumper extends Enemies
{
    private int whichSide = 0;
    private int howOften = 0;
    private boolean jumped = false;

    public Jumper(int h)
    {
        super(h);
        health = h;
        setSpeed(2);
    }

    public void act() 
    {   
        whichSide = Greenfoot.getRandomNumber(4);
        howOften = Greenfoot.getRandomNumber(200);

        if(howOften == 1)
        {
            jumps();
        }
        else
        {
            movement(this);
        }
    }
    
    /**
     * moves the actor by a set amount closer to bottom each actor of this type can only do this once
     */
    public void jumps()
    {
        if (!jumped)
        {
            setLocation(this.getX(), this.getY() + 125);
            jumped = true;
        }
    }
    public void addedToWorld(World world){
        super.addedToWorld(getWorld());
        healthBar.update(health,true);
    }
}