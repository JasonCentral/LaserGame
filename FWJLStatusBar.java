import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * A bar that is meant to display any stat as a value. It is a modular/re-usable class that can be
 * implemented in your program. It can be used as a health, bar, progress bar, or any other type of
 * measurement in the form of a visual bar. It is useful as long as the program has some kind of
 * actor within it. The base length is adjusted based on the actor the bar is assigned to.
 * It is customizable after initially constructing the bar and assigning it
 * to an actor with the methods in the class. To construct a basic bar which can then be customized,
 * use one of the constructors, then put the addToWorld method into the assigned actor's
 * addedToWorld method.
 * 
 * Note: Currently, test code is set up in the world and the 'Thing' class
 * Some test buttons are in a comment in the top of the 'Thing' class.
 * 
 * @author Felix Wang, Jason Li
 * @version March 27, 2017
 */
public class FWJLStatusBar extends Actor
{
    //Instance variables
    private int current, max;
    //Instance image for bar
    private GreenfootImage bar;
    //Variables that change the look of the bar
    private Color color = new Color(0,255,0);
    private Color lossColor;
    private int height, length;
    private int heightIncrease = 1;
    private int lengthIncrease = 1;
    //Regarding the name
    private String name;
    private boolean isName = false;
    //Instance images for numbers
    private GreenfootImage numbersBox;
    private GreenfootImage numbers;
    private Color numColor = Color.WHITE;
    //Tells whether the numbers should be displayed or not
    private boolean displayNums = true;
    //Instance variables for flash
    private boolean flashing = false;
    private int flashDelayNum = 2;
    private int flashDelay = 2;
    private int flashCountNum = 3;
    private int flashCount = 3;
    //Instance variables for vibration
    private int vibrationDelay = 7;
    private int vibrationDuration;
    private boolean vibrating = false;
    //Other instance variables
    private Actor target;
    
    private boolean transparent = false;
    /**
     * Creates a green healthbar that follows an actor with default maximum value at 100
     * @param target    The object for the bar to follow
     */
    public FWJLStatusBar(Actor target){
        max = 100;
        current = 100;
        bar = new GreenfootImage(target.getImage().getWidth()+20,7);
        this.target = target;
        //Creates a black border around the bar
        bar.setColor(Color.BLACK);
        bar.drawRect(0, 0, bar.getWidth()-1,bar.getHeight()-1);
        //Fills the inside of the bar with green
        bar.setColor(Color.GREEN);
        bar.fillRect(1,1,bar.getWidth()-2,bar.getHeight()-2);
        //Sets the image
        createNumbers();
        this.setImage(bar);
   
        //initializes the properties of the bar
        lossColor = new Color(255,0,0);
        
    }
    /**
     * Creates a full bar with a max value
     * @param max   An integer for the maximum value for the bar to be filled with
     * @param target    The object for the bar to follow
     */
    public FWJLStatusBar(int max, Actor target){
        this(target);
        this.max = max;
        this.current = max;
    }
    /**
     * Creates a bar with a max value and a current value. This is for a user who does not
     * want the bar to be fully filled.
     * @param max   A positive integer for the maximum value for the bar
     * @param current   A positive integer for the current value of the bar
     * @param target    The object for the bar to follow
     */
    public FWJLStatusBar(int max, int current, Actor target){
        this(target);
        this.max = max;
        if(current > max){
            current = max;
        }
        this.current = current;
    }
    /**
     * Act - do whatever the FWJLStatusBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(target.getWorld() != null){
        update();
        flashGraphic();
        vibrateGraphic();
        }
        else{
           getWorld().removeObject(this);
        }   
    }
    /**
     * For quick implementation, use this method in the target's addedToWorld method
     */
    public void addToWorld(){
        setImage(bar);
        if(target != null){
            target.getWorld().addObject(this,target.getX(),target.getY()-target.getImage().getHeight()/2-10);
        }
        if(transparent == true){
            getImage().setTransparency(0);
        }
    }
    /**
     * Makes the bar follow the actor
     */
    private void update(){
        setImage(bar);
        if(target != null){
            this.setLocation(target.getX(),target.getY()-target.getImage().getHeight()/2-10);
        }
    }
    /**
     * Changes the color of the inside of the bar
     * @param red   integer value for red (0 - 255)
     * @param green integer value for green (0 - 255)
     * @param blue  integer value for blue (0 - 255)
     */
    public void changeColor(int red, int green, int blue){
        color = new Color(red, green, blue);
        createBar();
    }
    /**
     * Changes the color displayed as the bar decreases
     * @param red   integer value for red (0 - 255)
     * @param green integer value for green (0 - 255)
     * @param blue  integer value for blue (0 - 255)
     */
    public void changeLossColor(int red, int green, int blue){
        lossColor = new Color(red, green, blue);
    }
    /**
     * Creates the look of the bar: meant to be used by other methods
     */
    private void createBar(){
        //Creates the 'filled up' portion of the bar
        length = target.getImage().getWidth()+20+lengthIncrease;
        height = 6 + heightIncrease;
        bar = new GreenfootImage(length,height);
        bar.setColor(color);
        bar.fillRect(1,1,bar.getWidth()-2,bar.getHeight()-2);
        bar.setColor(Color.BLACK);
        bar.drawRect(0, 0, bar.getWidth()-1,bar.getHeight()-1);
        //Creates the 'decreased' portion of the bar
        bar.setColor(lossColor);
        //Fills the rectangle with color for losing bar value in the portion lost (if bar is not max)
        if(current != max){
            //Calculates how much percent of the bar is lost
            double percentLost = (double)1 - (double)(current)/(double)(max);
            //Fills in the bar with whatever color
            bar.fillRect((int)Math.ceil((double)length - (double)length * percentLost)+1,1,bar.getWidth()-2,bar.getHeight()-2);
        }
        //Displays current over max value
        if(displayNums){
            createNumbers();
        }
        //If there is a name, display the name
        if(isName){
            createName();
        }
        //Update in the world
        addToWorld();
    }
    /**
     * Creates the display for current / max
     */
    private void createNumbers(){
        //Creates an image with current / max as the text
        String text = " " + current + "/" + max + " ";
        numbers = new GreenfootImage(text, 12, numColor, new Color(0,0,0));
        numbersBox = new GreenfootImage(numbers.getWidth()+1,12);
        numbersBox.setColor(Color.WHITE);
        numbersBox.drawImage(numbers,0,0);
        numbersBox.drawRect(0,0,numbersBox.getWidth()-1,numbersBox.getHeight()-1);
        //Cerates a new image with the numbers box above the bar
        GreenfootImage temp = new GreenfootImage(bar.getWidth(),bar.getHeight()+numbersBox.getHeight()+3);
        temp.drawImage(numbersBox,0,0);
        temp.drawImage(bar,0,numbersBox.getHeight());
        //sets the bar to be that image
        bar = new GreenfootImage(temp);
    }
    /**
     *  Hides the current / max numbers display 
     */
    public void hideNumbers(){
        displayNums = false;
        createBar();
    }
    /**
     * Changes the color of the text of the current over max number display
     * @param red   integer value for red (0 - 255)
     * @param green integer value for green (0 - 255)
     * @param blue  integer value for blue (0 - 255)
     */
    public void changeNumberColor(int red, int green, int blue){
        numColor = new Color(red,green,blue);
        createBar();
    }
    /**
     * Sets the name of the stat for the bar to be displayed above the bar. Try to use shorter words.
     * @param name  The name of the stat. 10 or more characters will start to look messy
     */
    public void setName(String name){
        this.name = name;
        //Tells program that the name now should be shown
        isName = true;
        createBar();
    }
    /**
     * Actually displays the name
     */
    private void createName(){
        //Creates text box with the name in it
        GreenfootImage nameText = new GreenfootImage(" " + name + " ", 12, Color.WHITE, null);
        GreenfootImage nameBox = new GreenfootImage(nameText.getWidth(),nameText.getHeight()+3);
        nameBox.setColor(Color.BLUE);
        nameBox.fillOval(0,0,nameBox.getWidth(),nameBox.getHeight()-4);
        nameBox.drawImage(nameText,0,0);
        nameBox.setColor(Color.BLACK);
        nameBox.drawOval(0,0,nameBox.getWidth(),nameBox.getHeight()-4);
            //Fallback rectangle
        //nameBox.drawRect(0,0,nameBox.getWidth()-1,nameBox.getHeight()-2);
        int heightUp;
        //set the final image's height to be the height of the bar plus any difference between the 
        //textbox size and the bar
        if(nameText.getHeight()-bar.getHeight() < 0){
            heightUp = 0;
        }
        else{
            heightUp = nameText.getHeight()-bar.getHeight();
        }
        GreenfootImage temp = new GreenfootImage(bar.getWidth()+nameText.getWidth(),bar.getHeight()+heightUp);
        //Adds the name to the left of the bar
        //Calculations are different depending on if there are numbers as well
        if(displayNums){
            temp.drawImage(nameBox,0,temp.getHeight()/2-nameBox.getHeight()/2+numbersBox.getHeight()/2);
            temp.drawImage(bar,nameBox.getWidth()-2,heightUp/2);
        }
        else{
            temp.drawImage(nameBox,0,temp.getHeight()/2-nameBox.getHeight()/2);
            temp.drawImage(bar,nameBox.getWidth()-2,heightUp/2);
        }
        bar = new GreenfootImage(temp);
    }
    /**
     * Updates the max value of the bar
     * @param max   A positive integer for the new maximum value
     * @param filled    True if the bar is to be filled, false if current value is to stay the same
     */
    public void update(int max, boolean filled){
        this.max = max;
        if(filled){
            this.current = max;
        }
        createBar();
    }
    /**
     * updates the size of the bar
     * @param length Changes the length, a positive integer: 50 or less is recommended (default is 1). Note:
     * a number below 0 may produce unwanted results.
     * @param height  Changes the height, a positive integer: 7 or less is recommended (default is 1). Note:
     * a number below 0 will likely produce unwanted results.
     */
    public void update(int length, int height){
        lengthIncrease = length;
        heightIncrease = height;
        createBar();
    }
    /**
     * Decreases the value of the bar by a certain amount
     * @param decreaseNum  A positive integer for the bar's current value to be decreased by
     */
    public void decrease(int decreaseNum){
        if(decreaseNum > current){
            current = 0;
        }
        else{
            current -= decreaseNum;
        }
        createBar();
    }
    /** Increases the value of the bar by a certain amount
     * @param decreaseNum  A positive integer for the bar's current value to be increased by
     */
    public void increase(int increaseNum){
        if(increaseNum > max - current){
            current = max;
        }
        else{
            current += increaseNum;
        }
        createBar();
    }
    /**
     * Changes the current value of the bar to a certain amount
     * @param changeNum   An integer value for the bar's current value to be set to. A value
     * greater than the maximum will be considered the maximum and a value lower than 0 will be 0.
     */
    public void changeTo(int changeNum){
        if(changeNum > max){
            changeNum = max;
        }
        else if(changeNum < 0){
            changeNum = 0;
        }
        current = changeNum;
        createBar();
    }
    /**
     * Removes the bar from the world
     */
    public void remove(){
        getWorld().removeObject(this);
    }
    /**
     * Returns the current integer value of the bar
     * @return  The current value
     */
    public int getCurrent(){
        return current;
    }
    /**
     * Returns the max integer value of the bar
     * @return  The max value
     */
    public int getMax(){
        return max;
    }
    /**
     * Returns the percentage of the stat that is remaining
     * @return  The percentage that is remaining as a decimal
     */
    public double getPercent(){
        return (double)current / (double)max;
    }
    /**
     * Takes in user input and creates a custom flashing effect
     * @param delay Delay between each flash, in acts. For best results use 5 or lower
     * @param flashNum  Total number of flashes
     */
    public void flash(int delay, int flashNum){
        //Make sure to set the initial delay if the bar is not in animation
        //If it is in animation, this delay will surely be set by the flashGraphic method after it ends
        if(!flashing){
            flashDelay = delay;
        }
        //The system is now meant to flash
        flashing = true;
        //Set all the variables to that the user inputs
        flashDelayNum = delay;
        flashCountNum = flashNum;
        flashCount = flashNum;
    }
    /**
     * Quickly flashes the bar
     */
    public void flash(){
        if(!flashing){
            flashDelay = 2;
        }
        flashing = true;
        flashDelayNum = 2;
        flashCountNum = 3;
        flashCount = 3;
    }
    //Meant to be put in the act method, will run if flashing is true
    private void flashGraphic(){
        if(flashing){
            if(flashDelay > 0){
                //Returns the bar back to normal
                bar.setTransparency(100);       
                createBar();
                //Decreases the delay
                flashDelay --;
            }
            else if(flashDelay == 0){
                //Makes the bar invisible (when the delay ends)
                bar.setTransparency(0);
                //Decreases number of flashes
                flashCount --;
                flashDelay = flashDelayNum;
            }
            if(flashCount == 0){
                flashing = false;
                flashCount = flashCountNum;
                createBar();
            }
        }
    }
    /**
     * Makes the bar vibrate
     * @param duration  The amount of acts the bar will vibrate for. Pick a positive integer
     * that is at least 2. Note: Around 10 is a short vibration while around 60 is a long one
     */
    public void vibrate(int duration){
        vibrationDuration = duration;
        vibrating = true;
    }
    /**
     * The actual method containing code that makes the bar vibrate
     */
    private void vibrateGraphic(){
        if(vibrating){
            //The bar basically loops through an animation while the delay decreases
            if(vibrationDelay == 7){
                setRotation(2);
                vibrationDelay --;
            }
            else if(vibrationDelay == 6){
                setRotation(4);
                vibrationDelay --;
            }
            else if(vibrationDelay == 5){
                setRotation(2);
                vibrationDelay --;
            }
            else if(vibrationDelay == 4){
                setRotation(0);
                vibrationDelay --;
            }
            else if(vibrationDelay == 3){
                setRotation(-2);
                vibrationDelay --;
            }
            else if(vibrationDelay == 2){
                setRotation(-4);
                vibrationDelay --;
            }
            else if(vibrationDelay == 1){
                setRotation(-2);
                vibrationDelay --;
            }
            else if(vibrationDelay == 0){
                setRotation(0);
                vibrationDelay = 7;
            }
            vibrationDuration --;
            if(vibrationDuration == 0){
                vibrating = false;
                vibrationDelay = 7;
                setRotation(0);
            }
        }
    }
    public void hideBar(){
        getImage().setTransparency(0);
        transparent = true;
    }
    public void showBar(){
        getImage().setTransparency(255);
        transparent = false;
    }
}