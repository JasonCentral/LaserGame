import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ObstacleGrid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ObstacleGrid extends Actor
{
    static String[][] map = new String[12][8];
    static ObstacleTile[][] actualMap = new ObstacleTile[12][8];
    public ObstacleGrid(){
        //Populates the tile arrays
        for(int x=0;x<12;x++){
            for(int y=0;y<8;y++){
                map[x][y] = "";
            }
        }
        for(int x=0;x<12;x++){
            for(int y=0;y<8;y++){
                //Tiles are all 80 by 80
                actualMap[x][y] = new ObstacleTile(x*80,y*80);
            }
        }
    }

    /**
     * Act - do whatever the ObstacleGrid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        addObstacles();
    }   

    public void move(){
        for(int x=0;x<12;x++){
            for(int y=0;y<8;y++){
                if(map[x][y].equals("a") && actualMap[x][y].isReady()){
                    if(x < 11){
                        actualMap[x+1][y].resetReady(50);
                        map[x][y] = "z";
                        map[x+1][y] = "a";
                    }
                }
                else if(map[x][y].equals("b")&& actualMap[x][y].isReady()){
                                        if(y < 6){
                        actualMap[x][y+1].resetReady(50);
                        map[x][y] = "z";
                        map[x][y+1] = "b";
                    }
                }
                else if(map[x][y].equals("c")&& actualMap[x][y].isReady()){

                }
                else if(map[x][y].equals("d")&& actualMap[x][y].isReady()){

                }
            }
        }
    }

    public void addedToWorld(World w){
        //add tiles to world
        for(int x=0;x<12;x++){
            for(int y=0;y<8;y++){
                getWorld().addObject(actualMap[x][y],actualMap[x][y].getMidX(),actualMap[x][y].getMidY());
            }
        }
    }

    public void addObstacles(){
        //Delete other objects
        String[][] emptyMap = new String[12][8];

        for (int i=0; i<12; i++)
        {
            for (int j=0; j<8; j++)
            {
                int kind = "abcd".indexOf("" + map[i][j]);
                if (kind == 0) actualMap[i][j].makeA();
                else if (kind == 1) actualMap[i][j].makeB();
                else if (kind == 2) actualMap[i][j].makeC();
                else if (kind == 3) actualMap[i][j].makeD();
                else actualMap[i][j].makeDefault();

            }
        }
    }
    //Sets map based on a new array
    public static void setMap(String[][] newMap){
        map = newMap;
    }
    //Returns tile based on array
    public static ObstacleTile getRealObstacleTile(int x, int y){
        return actualMap[x][y];
    }

    public static boolean checkObstacle(int i, int j){
        //Checks if there is an obstacle in that position on the map.
        int kind = "abcd".indexOf("" + map[i][j]);

        if (kind == 0) return true;
        if (kind == 1) return true;
        if (kind == 2) return true;
        if (kind == 3) return true;
        else return false;
    }
}
