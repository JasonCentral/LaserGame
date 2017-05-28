import greenfoot.*;
/**
 * Write a description of class Grid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Grid extends Actor
{
    private static GreenfootImage grid;
    //12 by 8 2d array
    private static Tile[][] tiles = new Tile[12][8];
    public Grid(){
        grid = new GreenfootImage(960,640);
        grid.drawLine(0,560,960,560);
        for(int x = 0;x<960;x+=80){
            grid.drawLine(x,560,x,640);
        }
        setImage(grid);
        
        //Populates the tile array
        for(int x=0;x<12;x++){
            for(int y=0;y<8;y++){
                //Tiles are all 80 by 80
                tiles[x][y] = new Tile(x*80,y*80);
            }
        }
    }
    /**
     * Returns a tile based on the grid coordinate system (x, then y)
     * @param x The x coordinate of grid starting from left (0-11)
     * @param y The y coordinate of grid starting from top  (0-7)
     */
    public static Tile getTile(int x, int y){
        return tiles[x][y];
    }
    public void addedToWorld(World w){
        //add tiles to world
        for(int x=0;x<12;x++){
            for(int y=0;y<8;y++){
                getWorld().addObject(tiles[x][y],tiles[x][y].getMidX(),tiles[x][y].getMidY());
            }
        }
    }
    /**
     * Resets tiles to default transparent style
     */
    public static void clearTiles(){
        for(int x=0;x<12;x++){
            for(int y=0;y<8;y++){
                tiles[x][y].makeDefault();
            }
        }
    }
    /**
     * Returns how many tiles are highlighted
     */
    public static int getNumHighlighted(){
        int numHighlighted = 0;
        for(int x=0;x<12;x++){
            for(int y=0;y<8;y++){
                if(tiles[x][y].isHighlighted){
                    numHighlighted ++;
                }
            }
        }
        return numHighlighted;
    }
    /**
     * Returns if one of the tiles to the side is highlighted
     * @param tile  The tile to be checked
     */
    public static boolean isSideHighlighted(Tile tile){
        //Check left tile
        int checkX = tile.getMidX() - 80;
        int checkY = tile.getMidY();
        //Make sure it's not out of bounds
        if(checkX > 0 && checkX < 960 && checkY > 0 && checkY < 640){
            if(getTile(checkX/80,checkY/80).isHighlighted){
                return true;
            }
        }
        //Check right tile
        checkX = tile.getMidX() + 80;
        checkY = tile.getMidY();
        //Make sure it's not out of bounds
        if(checkX > 0 && checkX < 960 && checkY > 0 && checkY < 640){
            if(getTile(checkX/80,checkY/80).isHighlighted){
                return true;
            }
        }
        //Check top tile
        checkX = tile.getMidX();
        checkY = tile.getMidY() + 80;
        //Make sure it's not out of bounds
        if(checkX > 0 && checkX < 960 && checkY > 0 && checkY < 640){
            if(getTile(checkX/80,checkY/80).isHighlighted){
                return true;
            }
        }
        //Check bottom tile
        checkX = tile.getMidX();
        checkY = tile.getMidY() - 80;
        //Make sure it's not out of bounds
        if(checkX > 0 && checkX < 960 && checkY > 0 && checkY < 640){
            if(getTile(checkX/80,checkY/80).isHighlighted){
                return true;
            }
        }
        //If all checks fail, return false
        return false;
    }
    /**
     * Hides the grid and only shows the bottom line (where user can start drawing)
     */
    public void hideGrid(){
        grid = new GreenfootImage(960,640);
        grid.drawLine(0,560,960,560);
        for(int x = 0;x<960;x+=80){
            grid.drawLine(x,560,x,640);
        }
        setImage(grid);
    }
    /**
     * Shows the entire grid
     */
    public void showGrid(){
        grid = new GreenfootImage(960,640);
        for(int x = 0;x<960;x+=80){
            grid.drawLine(x,0,x,640);
        }
        for(int y = 0;y<640;y+=80){
            grid.drawLine(0,y,960,y);
        }
        setImage(grid);
        getImage().setTransparency(170);
    }
}
