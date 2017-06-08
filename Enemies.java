import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemies extends Actor
{
    protected int move = 0;
    protected int health = 0;
    FWJLStatusBar healthBar;
    
    protected void addedToWorld(World world)
    {
       healthBar.addToWorld();
       healthBar.hideBar();
    }
    
    public Enemies(int h)
    {
       healthBar = new FWJLStatusBar(h,this);
    }
    
    /**
     * set the speeds for the enemies
     * 
     * @param integer for how fast
     */
    public void setSpeed(int n)
    {
        move = n;
    }

    /**
     * the movment of the enemies
     * 
     * @param mob actor for which the moving is applied to
     */
    public void movement(Actor mob)
    {
        mob.setLocation(mob.getX(), mob.getY() + move);
        atEdge(mob);
    }
    
    /**
     * checks if the actor has reached the edge 
     * 
     * @param x actor to check
     */
    public void atEdge(Actor x)
    {
        if (x.getY() > getWorld().getHeight()- 81)
        {
            getWorld().removeObject(x);
        }
    }
    
    public void damage(int d)
    {
        healthBar.showBar();
        if(health > d)
        {
            health = health - d;
            healthBar.decrease(d);
        }
        else
        {
            Overlay.addScore(1);
            getWorld().removeObject(this);
        }
    }
}