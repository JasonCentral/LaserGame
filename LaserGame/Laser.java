import greenfoot.*;

/**
 * Write a description of class Laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Laser extends Actor
{
    MouseInfo mouse;
    protected int maxSquares = 10;
    /**
     * Act - do whatever the Laser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        check();
    }    
    protected void check(){
        if(leftDown()){
            //If it's the first one, you can click anywhere on the first rank
            if(Grid.getNumHighlighted() == 0){
                Tile mouseGrid = getMouseGrid();
                if(mouseGrid.getMidY() == 600){
                    mouseGrid.highlight();
                    PlayWorld.getGrid().showGrid();
                }
            }
            //If it's not, only allow sides to prevent diagonal and skipping (TOO MUCH TIME BETWEEN ACTS!!)
            //And also only if the number already highlighted is less than max
            else if(Grid.getNumHighlighted() < maxSquares){
                Tile mouseGrid = getMouseGrid();
                if(Grid.isSideHighlighted(mouseGrid)){
                    mouseGrid.highlight();
                    PlayWorld.getGrid().showGrid();
                }
            }
        }
        if(Greenfoot.mouseClicked(null)){
            Grid.clearTiles();
            PlayWorld.getGrid().hideGrid();
        }
    }
    /**
     * Returns the grid that the mouse is currently on
     */
    protected Tile getMouseGrid(){
        mouse = Greenfoot.getMouseInfo();
        int mouseX = -1;
        int mouseY = -1;
        if(mouse!=null) {
            mouseX = mouse.getX();
            mouseY = mouse.getY();
        }
        //if mouse is within the field
        if(mouseX > 0 && mouseX < 960 && mouseY > 0 && mouseY < 640){
            return Grid.getTile(mouseX/80,mouseY/80);
        }
        else{
            //Returns a dud
            return new Tile(1000,1000);
        }
    }
    protected boolean leftDown(){
        mouse = Greenfoot.getMouseInfo();
        int down = -1;
        if(mouse!=null){
            down = mouse.getButton();
        }
        //If left button pressed
        if(down == 1){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Changes the max amount of squares the user can draw
     * @param max   new max amount
     */
    public void changeMax(int max){
        if(max>=1){
            maxSquares = max;
        }
    }
}
