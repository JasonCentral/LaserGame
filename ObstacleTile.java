import greenfoot.*;

/**
 * Write a description of class Tiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ObstacleTile extends Actor
{
    int botLeftX, botLeftY;
    //Regular image
    private GreenfootImage transparent = new GreenfootImage(80,80);
    //Highlighted tile
    private GreenfootImage highlighted;
    boolean isHighlighted = false;
    
    BasicBlocker basic = new BasicBlocker();
    VerticalBlocker vertical = new VerticalBlocker();
    HorizontalBlocker horizontal = new HorizontalBlocker();
    Cherries cherries = new Cherries();
    /**
     * Constructs a tile based on its bottom left corner (relative to the world)
     * @param bLx    bottom left x coordinate
     * @param bR    bottom left y coordinate
     */
    public ObstacleTile(int bLX, int bLY){
        botLeftX = bLX;
        botLeftY = bLY;
        setImage(transparent);
    }
    public int getMidX(){
        return botLeftX + 40;
    }
    public int getMidY(){
        return botLeftY + 40;
    }
    public void makeDefault(){
        setImage(transparent);
        isHighlighted = false;
    }
    public void makeA(){
        setImage(basic.getImage());
    }
    public void makeB(){
        setImage(vertical.getImage());
    }
    public void makeC(){
        setImage(horizontal.getImage());
    }
    public void makeD(){
        setImage(cherries.getImage());
    }
}