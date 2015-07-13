import java.util.Map;

/*
 *Alex Prokopchik
 * Apr 18, 2013
 *Car.java
 */

/**
 * @author alexpro
 * @version 1.0
 */
public class Car extends AbstractVehicle {

  /**
   * Creates a Car using the specified values.
   * 
   * @param the_x the x coordinate of Car starting point
   * @param the_y the y coordinate of Car starting point
   * @param the_direction the direction of Car 
   */
  public Car(final int the_x, final int the_y, final Direction the_direction) {
    super(the_x, the_y, the_direction);
  }

/**
 * This method states that if the terrain of the Car is a street or light, 
   * and the light is equal to green or yellow, then is can pass otherwise is doesnt pass.
   * 
   * @param the_terrain the terrain of the Car
   * @param the_light the light characteristics of the Car
   * @return true if specifications are met, false otherwise
   * 
 */
  @Override
  public boolean canPass(final Terrain the_terrain, final Light the_light) {
    boolean passes = false;
    
    if (the_terrain == Terrain.STREET || (the_terrain == Terrain.LIGHT)
        && the_light == Light.GREEN || the_light == Light.YELLOW) {
      passes = true;
    }
    return passes;
    
  }

  /**
   * This method gives the specifications of the movement behavior of the Car.
   * 
   * @param the_neighbors the neighboring areas around the Car
   * @param the_light an enumeration of traffic light statuses
   * @return a random direction if certain movement behaviors arent met
   */
  @Override
  public Direction chooseDirection(final Map<Direction, Terrain> the_neighbors, 
                                   final Light the_light) {
    Direction dir = Direction.random();
    
    if (the_neighbors.get(getDirection()) == Terrain.STREET 
        || the_neighbors.get(getDirection()) == Terrain.LIGHT 
        || the_neighbors.get(getDirection().left()) == Terrain.STREET 
        || the_neighbors.get(getDirection().left()) == Terrain.LIGHT  
        || the_neighbors.get(getDirection().right()) == Terrain.STREET 
        || the_neighbors.get(getDirection().right()) == Terrain.LIGHT) {
        
      while (dir == getDirection().reverse() 
        || (the_neighbors.get(dir) != Terrain.STREET
        && the_neighbors.get(dir) != Terrain.LIGHT)) {
        dir = Direction.random();
      }
    }
    return dir;
  }
}