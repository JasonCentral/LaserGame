import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class Tiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tile extends Actor
{
    int botLeftX, botLeftY;
    //Regular image
    private GreenfootImage transparent = new GreenfootImage(80,80);
    //Highlighted tile
    private GreenfootImage highlighted;
    private boolean isHighlighted = false;
    /**
     * Constructs a tile based on its bottom left corner (relative to the world)
     * @param bLx    bottom left x coordinate
     * @param bR    bottom left y coordinate
     */
    public Tile(int bLX, int bLY){
        botLeftX = bLX;
        botLeftY = bLY;
        setImage(transparent);
    }
    public void highlight(){
        //Green highlight
        highlighted = new GreenfootImage(80,80);   
        highlighted.setColor(Color.GREEN);
        highlighted.fillRect(1,1,80,80);
        setImage(highlighted);
        isHighlighted = true;
    }
    public void makeDefault(){
        setImage(transparent);
        isHighlighted = false;
    }
    public int getMidX(){
        return botLeftX + 40;
    }
    public int getMidY(){
        return botLeftY + 40;
    }
    public boolean isHighlighted(){
        return isHighlighted;
    }
}
