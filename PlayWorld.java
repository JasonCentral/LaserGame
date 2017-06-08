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
    static Overlay score = new Overlay();
    
    protected int spawn = 0;
    protected int spawnPoint = 0;
    protected int spawnRate = 500;
    protected int level = 0;
    public void act(){
        spawn();
    }
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
        addObject(score,800,600);
    }
    public static Grid getGrid(){
        return mainGrid;
    }
    public void spawn(){
        spawn = Greenfoot.getRandomNumber(spawnRate);
        spawnPoint = Greenfoot.getRandomNumber(960);
        if(spawn == 1)
        {
            addObject(new Basic(10),spawnPoint, 1);
        }
        else if (spawn == 2)
        {
            addObject(new Strmob(40), spawnPoint, 1);
        }
        else if (spawn == 3)
        {
            addObject (new Jumper(20), spawnPoint, 1);
        }
        else if (spawn == 4)
        {
            addObject (new Charger(30), spawnPoint, 1);
        }
        level++;
        if (level > 900)
        {
            spawnRate = spawnRate - 20;
            level = 0;
        }
        else if (spawnRate < 80)
        {
            spawnRate = 80;
        }
    }
}
