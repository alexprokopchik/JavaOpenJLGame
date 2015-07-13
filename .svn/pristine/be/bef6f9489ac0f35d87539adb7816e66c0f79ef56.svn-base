/*
 *Alex Prokopchik
 * Apr 18, 2013
 *Bicycle.java
 */

/**
 * @author alexpro
 * @version 1.0
 */
public abstract class AbstractVehicle implements Vehicle {
  
  /** All Trucks have a death time of 0. */
  private static final int TRUCK_DEATH_TIME = 0;
  
  /** All Cars have a death time of 10. */
  private static final int CAR_DEATH_TIME = 10;
  
  /** All Bikes have a death time of 20. */
  private static final int BICYCLE_DEATH_TIME = 20;
  
  /** All Humans have a death time of 50. */
  private static final int HUMAN_DEATH_TIME = 50;
  
  // instance fields
  /** All Vehicles have a x. */
  protected int my_x; // final since this will never change
  
  /** All Vehicles have a y. */
  private int my_y; // final since this will never change
  
  /** All Vehicles have a direction. */
  private Direction my_direction; // final since this will never change
  
  /** Determines the initial direction for reset. */
  private final Direction my_direction2; // final since this will never change
  
  /** Determines the initial x for reset. */
  private final int my_x2; // final since this will never change
  
  /** Determines the initial y for reset. */
  private final int my_y2; // final since this will never change
  
  /** Determines whether the Vehicle is dead. */
  private boolean my_dead;
  
  /** Determines whether the Vehicle is alive. */
  private boolean my_alive = true;
  
  /** Counts the amount of updates the Vehicle has until becomes alive. */
  private int my_watcher;
  
  /** Makes sure that the counter my_watcher isn't reset every time a 
   * vehicle runs over Vehicle when dead. */
  private boolean my_resetwatcher; 
  
  /**
   * The constructor for AbstractVehicle.
   * 
   * @param the_x the x position of the vehicle
   * @param the_y the y position of the vehicle
   * @param the_direction the direction of the vehicle
   */
  public AbstractVehicle(final int the_x, final int the_y, final Direction the_direction) {
    my_x = the_x;
    my_y = the_y;
    my_direction = the_direction;
    
    my_x2 = the_x;
    my_y2 = the_y;
    my_direction2 = the_direction;

  }

  /** {@inheritDoc} */
  @Override
  public void poke() {  
    my_watcher += 1;
  
  }
  
 /**
  * A method that determines if the death time of a certain vehicle is greater 
  * than another vehicle, then the vehicle is not alive or dead.
  * @param the_other is the other vehicle that each vehicle collides with
  */
  @Override
  public void collide(final Vehicle the_other) {
    if (getDeathTime() > the_other.getDeathTime()) {
      if (my_resetwatcher == false) {
        my_watcher = 0;
        my_resetwatcher =  true;
      }
      my_dead = true;
    }

  }

  /**
   * This method determines if the vehicle has collided with another or not
   * and also revives the vehicle after a certain amount of time.
   * @return if the vehicle is alive or not.
   */
  @Override
  public boolean isAlive() {
    if (my_watcher >= getDeathTime()) {
      my_dead = false;  
    }
    if (my_dead == true) {
      my_alive = false;
    } else {
      my_alive = true;
      my_resetwatcher = false;
    }
    return my_alive;
  
  }

  /** {@inheritDoc} */
  @Override
  public int getDeathTime() {
    int deathtime = 0;
    if ("Car".equals(getClass().getName())) {
      deathtime = CAR_DEATH_TIME;
    }
    if ("Bicycle".equals(getClass().getName())) {
      deathtime = BICYCLE_DEATH_TIME;
    }
    if ("Human".equals(getClass().getName())) {
      deathtime = HUMAN_DEATH_TIME;
    } 
    if ("Truck".equals(getClass().getName())) {
      deathtime = TRUCK_DEATH_TIME;
    }
    return deathtime;

  }

  /** {@inheritDoc} */
  @Override
  public Direction getDirection() {
    return my_direction;

  }

  /** {@inheritDoc} */
  @Override
  public int getX() {
    return my_x;

  }

/** {@inheritDoc} */
  @Override
  public int getY() {
    return my_y;

  }

  /** {@inheritDoc} */
  @Override
  public void reset() {
    setX(my_x2);
    setY(my_y2);
    setDirection(my_direction2); 
    my_dead = false;
 
  }

  /** {@inheritDoc} */
  @Override
  public void setDirection(final Direction the_dir) {
    my_direction = the_dir;

  }

  /** {@inheritDoc} */
  @Override
  public void setX(final int the_x) {
    my_x = the_x;
  }

  /** {@inheritDoc} */
  @Override
  public void setY(final int the_y) {
    my_y = the_y;

  }
  
  /** {@inheritDoc} */
  @Override
  public String getImageFileName() {
    String humanstring = "something went wrong";
    if (isAlive()) {
      humanstring = getClass().getName().toLowerCase() + ".gif"; 
    } else {
      humanstring = getClass().getName().toLowerCase() + "_dead.gif";
    }
    return humanstring;
    
  }

}