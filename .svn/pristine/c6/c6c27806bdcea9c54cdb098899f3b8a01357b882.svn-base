import java.util.Map;

/*
 *Alex Prokopchik
 * Apr 18, 2013
 *Truck.java
 */

/**
 * @author alexpro
 * @version 1.0
 */
public class Truck extends AbstractVehicle {

  /**
   * The constructor for Truck.
   * 
   * @param the_x the x coordinate of Truck starting point
   * @param the_y the y coordinate of Truck starting point
   * @param the_direction the direction of Truck 
   */
  public Truck(final int the_x, final int the_y, final Direction the_direction) {
    super(the_x, the_y, the_direction);
    
  }

  /**
   * This method states that if the terrain of the Truck is a street or light 
     * then is can pass otherwise is doesnt pass.
     * 
     * @param the_terrain the terrain of the Truck
     * @param the_light the light characteristics of the Truck
     * @return true if specifications are met, false otherwise
     * 
   */
  @Override
  public boolean canPass(final Terrain the_terrain, final Light the_light) {
    boolean passes = false;
    
    if (the_terrain == Terrain.STREET || (the_terrain == Terrain.LIGHT)) {
      passes = true;
    }
    return passes;
    
  }

  /**
   * This method gives the specifications of the movement behavior of the Truck.
   * 
   * @param the_neighbors the neighboring areas around the Truck
   * @param the_light an enumeration of traffic light statuses
   * @return a random direction if certain movement behaviors arent met
   */
  @Override
  public Direction chooseDirection(final Map<Direction, Terrain> the_neighbors, 
                                   final Light the_light) {
    Direction dir = Direction.random();
    
    if (the_neighbors.get(getDirection()) == Terrain.STREET 
        || the_neighbors.get(getDirection()) == Terrain.LIGHT) {
        
      while (dir == getDirection().reverse() 
        || (the_neighbors.get(dir) != Terrain.STREET
        && the_neighbors.get(dir) != Terrain.LIGHT)) {
        dir = Direction.random();
      }
    }
    return dir;
    
  }
}