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
    //Have a type of beam selected
    protected int beamSelected = 1;
    protected int maxSquares = 10;
    /**
     * Constructs laser with defaults
     */
    public Laser(){
        
    }
    /**
     * Constructs laser based on beam
     */
    public Laser(int b){
        beamSelected = b;
    }
    /**
     * Act - do whatever the Laser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        actMethods();
    }    
    /**
     * Put all act methods here to easily deal with inheritance
     */
    protected void actMethods(){
        check();
    }
    protected void check(){
        if(leftDown()){
            //If it's the first one, you can click anywhere on the first rank
            if(Grid.getNumHighlighted() == 0){
                Tile mouseGrid = getMouseGrid();
                if(mouseGrid.getMidY() == 600){
                    mouseGrid.highlight();
                    Grid.setLastHighlighted(mouseGrid);
                    PlayWorld.getGrid().showGrid();
                }
            }
            //If it's not, only allow sides to prevent diagonal and skipping (TOO MUCH TIME BETWEEN ACTS!!)
            //And also only if the number already highlighted is less than max
            //And also only if the last tile is one next to it
            else if(Grid.getNumHighlighted() < maxSquares){
                Tile mouseGrid = getMouseGrid();
                if(Grid.isSideLastHighlighted(mouseGrid)){
                    if(!mouseGrid.isHighlighted()){
                        Grid.setLastHighlighted(mouseGrid);
                    }
                    mouseGrid.highlight();
                    PlayWorld.getGrid().showGrid();
                }
            }
        }
        if(Greenfoot.mouseClicked(null)){
            fireBeam();
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
    /**
     * Spawns the beam on the tile
     */
    public void fire(Tile t){
        getWorld().addObject(new Beam(50), t.getX(), t.getY());
        //Note: disappears in beam class
    }
    /**
     * Fires the entire beam
     */
    public void fireBeam(){
        Tile[] highlighted = Grid.getHighlighted();
        for(int i = 0;i<highlighted.length;i++){
            //If there is an obstacle
            if(Grid.isObstacle(highlighted[i])){
            }
            else{
                fire(highlighted[i]);
            }
        }
    }
}
