import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Beam here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Beam extends Actor
{
    //default beam
    protected GreenfootImage beamImage;
    protected int fireDelay = 20;
    /**
     * Constructs a basic beam with default delay at 20
     */
    private Beam(){
        beamImage = new GreenfootImage(81,81);
        beamImage.setColor(Color.WHITE);
        beamImage.fillRect(0,0,81,81);
        setImage(beamImage);
    }
    /**
     * Constructs a beam with user input fire delay
     */
    public Beam(int fDelay){
        this();
        fireDelay = fDelay;
    }
    /**
     * Act - do whatever the Beam wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        //Decreases delay to 0, then disappears
        checkDisappear();
    }    
    public void checkDisappear(){
        if(fireDelay <= 0){
            getWorld().removeObject(this);
        }
        fireDelay --;        
    }
}
