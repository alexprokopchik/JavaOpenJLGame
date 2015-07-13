import java.util.Map;

/*
 *Alex Prokopchik
 * Apr 18, 2013
 *Human.java
 */

/**
 * @author alexpro
 * @version 1.0
 */
public class Human extends AbstractVehicle {
 
  /** All Humans have a terrain. */
  private final Terrain my_terrain; // final since this will never change

  /**
   * This is the constructor of the Human Vehicle.
   * 
   * @param the_x the x coordinate of Human starting point
   * @param the_y the y coordinate of Human starting point
   * @param the_direction the direction of Human 
   * @param the_terrain the terrain acceptable to human
   */
  public Human(final int the_x, final int the_y, final Direction the_direction, 
               final Terrain the_terrain) {
    super(the_x, the_y, the_direction);
    my_terrain = the_terrain;
  }

  /**
   * This method states that if the terrain of the Humans initial position is a 
   * street,light, or trail, then is can pass otherwise is doesnt pass.
   * 
   * @param the_terrain the terrain of the Human
   * @param the_light the light characteristics of the Human
   * @return true if specifications are met
   */
  @Override
  public boolean canPass(final Terrain the_terrain, final Light the_light) {
    boolean passes = false;
    
    if (the_terrain.equals(my_terrain)) { 
      passes = true;
    }
    if ((my_terrain == Terrain.STREET || my_terrain == Terrain.LIGHT)
        && (the_terrain == Terrain.STREET || the_terrain == Terrain.LIGHT)) {
      passes = true;
    } 
    return passes;
  }

  /**
   * This method gives the specifications of the movement behavior of the Human.
   * 
   * @param the_neighbors the neighboring areas around the Human
   * @param the_light an enumeration of traffic light statuses
   * @return a random direction if certain movement behaviors arent met
   */
  @Override
  public Direction chooseDirection(final Map<Direction, Terrain> the_neighbors, 
                                   final Light the_light) {
    Direction dir = Direction.random();
    
    if (the_neighbors.get(getDirection()) == Terrain.STREET 
        || the_neighbors.get(getDirection()) == Terrain.LIGHT 
        || the_neighbors.get(getDirection()) == Terrain.GRASS
        || the_neighbors.get(getDirection()) == Terrain.TRAIL) {
        
      while (dir == getDirection().reverse() 
        || (the_neighbors.get(dir) != Terrain.STREET
        && the_neighbors.get(dir) != Terrain.LIGHT
        && the_neighbors.get(dir) != Terrain.GRASS
        && the_neighbors.get(dir) != Terrain.TRAIL)) {
        dir = Direction.random();
      }
    } 
    return dir;
    
  }
}