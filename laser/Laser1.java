import greenfoot.*;

/**
 * Write a description of class Laser1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laser1 extends Laser
{
    public Laser1(){
        maxSquares = 10;
    }
    /**
     * Act - do whatever the Laser1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        check();
    }    
}
