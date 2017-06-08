import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.ArrayList;
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
    //For colour
    protected static int r = 255;
    protected static int g = 255;
    protected static int b = 255;
    /**
     * Constructs a basic beam with default delay at 20
     */
    private Beam(){
        beamImage = new GreenfootImage(81,81);
        Color beamColor = new Color(r,g,b);
        beamImage.setColor(beamColor);
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
        actMethods();
    }    
    //Decreases delay to 0, then disappears
    public void checkDisappear(){
        if(fireDelay <= 0){
            getWorld().removeObject(this);
        }
        fireDelay --;        
    }
    public void checkEnemy(){
        ArrayList<Enemies> enemyList = new ArrayList<Enemies>();
        enemyList = (ArrayList)getIntersectingObjects(Enemies.class);
        for(Enemies e: enemyList){
            e.damage(1);
        }
    }
    public void actMethods(){
        checkEnemy();
        checkDisappear();
    }
    public static void changeColor(int red, int green, int blue){
        r = red;
        g = green;
        b = blue;
    }
}
