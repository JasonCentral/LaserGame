import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Overlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Overlay extends Actor
{
    private static int score = 0;
    private GreenfootImage scoreBar = new GreenfootImage(100,20);
    public Overlay(){
        update();
    }
    /**
     * Act - do whatever the Overlay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        update();
    }    
    public static void changeScore(int newScore){
        score = newScore;
    }
    public static void addScore(int scoreNum){
        score += scoreNum;
    }
    public void update(){
        GreenfootImage temp = new GreenfootImage(150,25);
        temp.setColor(new Color(0,180,180));
        temp.fill();
        temp.setColor(Color.WHITE);
        temp.drawRect(0,0,149,24);
        //Spawn rate controls
        String text = "POINTS: " + score;
        GreenfootImage textImage = new GreenfootImage(text,25,Color.BLACK,null);
        temp.drawImage(textImage,4,0);
        scoreBar = new GreenfootImage(temp);
        setImage(scoreBar);
    }
}
