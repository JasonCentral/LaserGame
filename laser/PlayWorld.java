import greenfoot.*;

/**
 * Write a description of class TestWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayWorld extends World
{
    static Grid mainGrid = new Grid();
    /**
     * Constructor for objects of class TestWorld.
     * 
     */
    public PlayWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 640, 1); 
        //Adds grid
        addObject(mainGrid,getWidth()/2,getHeight()/2);
        addObject(new Laser1(),50,50);
    }
    public static Grid getGrid(){
        return mainGrid;
    }
}
