import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Greenfoot;
/**
 * Write a description of class ObstacleWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ObstacleWorld extends PlayWorld
{
    /** ********************      MAP LEGEND     *********************** */
    //      a = block        b = monster         c = floating platform
    //      d = platform     k = key             w = wall
    public static String[][] setFields()
    {
        String map[][] =  { {"a","b","c","d","z","z","z","z"},
                             {"z","z","z","z","z","z","z","z"},
                             {"z","z","z","z","z","z","z","z"},
                             {"z","z","z","z","z","z","z","z"},
                             {"z","z","z","z","z","z","z","z"},
                             {"z","z","z","z","z","z","z","z"},
                             {"z","z","z","z","z","z","z","z"},
                             {"z","z","z","z","z","z","z","z"},
                             {"z","z","z","z","z","z","z","z"},
                             {"z","z","z","z","z","z","z","z"},
                             {"z","z","z","z","z","z","z","z"},
                            {"z","z","z","z","z","z","z","z"}};
        return map;
    }
    /**
     * Constructor for objects of class ObstacleWorld.
     * 
     */
    public ObstacleWorld()
    {
    }
}
