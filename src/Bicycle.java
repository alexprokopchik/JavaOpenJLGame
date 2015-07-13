import java.util.Map;

/*
 *Alex Prokopchik
 * Apr 18, 2013
 *Bicycle.java
 */

/**
 * @author alexpro
 * @version 1.0
 */
public class Bicycle extends AbstractVehicle {
  
  /**
   * Creates a Bicycle using the specified values.
   * 
   * @param the_x the x coordinate of Bicycle starting point
   * @param the_y the y coordinate of Bicycle starting point
   * @param the_direction the direction of Bicycle 
   */
  public Bicycle(final int the_x, final int the_y, final Direction the_direction) {
    super(the_x, the_y, the_direction);
  }
  
  /**
   * This method states that if the terrain of the Bike is a street,light, or trail 
     * and the light is equal to green or yellow, then is can pass otherwise is doesnt pass.
     * 
     * @param the_terrain the terrain of the Bike
     * @param the_light the light characteristics of the Bike
     * @return true if specifications are met, false otherwise
     * 
   */
  @Override
  public boolean canPass(final Terrain the_terrain, final Light the_light) {
    boolean passes = false;
    
    if (the_terrain == Terrain.STREET || the_terrain == Terrain.TRAIL 
        || (the_terrain == Terrain.LIGHT) && the_light == Light.GREEN) {
      passes = true;
    } 
    return passes;
      
  }
  
  /**
   * This method gives the specifications of the movement behavior of the Bike.
   * 
   * @param the_neighbors the neighboring areas around the Bike
   * @param the_light an enumeration of traffic light statuses
   * @return a random direction if certain movement behaviors arent met
   */
  @Override
  public Direction chooseDirection(final Map<Direction, Terrain> the_neighbors, 
                                   final Light the_light) {
    Direction dir = Direction.random();
    
    if (the_neighbors.get(getDirection()) == Terrain.STREET 
        || the_neighbors.get(getDirection()) == Terrain.LIGHT 
        || the_neighbors.get(getDirection()) == Terrain.TRAIL 
        || the_neighbors.get(getDirection().left()) == Terrain.STREET 
        || the_neighbors.get(getDirection().left()) == Terrain.LIGHT 
        || the_neighbors.get(getDirection().left()) == Terrain.TRAIL 
        || the_neighbors.get(getDirection().right()) == Terrain.STREET 
        || the_neighbors.get(getDirection().right()) == Terrain.LIGHT 
        || the_neighbors.get(getDirection().right()) == Terrain.TRAIL) {
        
      while (dir == getDirection().reverse() 
        || (the_neighbors.get(dir) != Terrain.STREET
        && the_neighbors.get(dir) != Terrain.LIGHT
        && the_neighbors.get(dir) != Terrain.TRAIL)) {
        dir = Direction.random();
      }
    } 
    return dir;
  }
}
