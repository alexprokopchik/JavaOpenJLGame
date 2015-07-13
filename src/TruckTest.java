/*
 *Alex Prokopchik
 * Apr 25, 2013
 *TruckTest.java
 */

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Unit tests for class Truck.
 * 
 * @author alexpro
 * @version 1.0
 */
public class TruckTest {
  
  /**
   * The number of times to repeat a test to have a high probability
   * that all random possibilities have been explored.
   */
  private static final int TRIES_FOR_RANDOMNESS = 50;

  /**
   * Test method for {@link Truck#canPass(Terrain, Light)}.
   */
  @Test
  public void testCanPass() {
    final Truck truck = new Truck(0, 0, Direction.CENTER);
    for (Terrain t : Terrain.values()) {
      for (Light l : Light.values()) {
        if ((t == Terrain.LIGHT && t == Terrain.STREET) 
            || (t == Terrain.LIGHT || t == Terrain.STREET)) {
          //Trucks can pass through street/lights, streets, and lights.

          assertTrue("Truck should be able to pass " + t
                       + ", with light " + l, truck.canPass(t, l));
        } else {
            // Truck can not pass terrain other than street and light

          assertFalse("Test should NOT be able to pass "
                        + t + ", with light " + l, truck.canPass(t, l));
        }
      }
    }
  }

  /**
   * Test method for {@link Truck#chooseDirection(java.util.Map, Light)}.
   */
  @Test
  public void testChooseDirection() {
    // Trucks need to stay on their own terrain, but otherwise can
    // do anything
    // Trucks can not choose Center. Choosing Center would result in no movement.

    final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
    neighbors.put(Direction.WEST, Terrain.WALL);
    neighbors.put(Direction.NORTH, Terrain.WALL);

    for (Terrain t : Terrain.values()) {
      if (t != Terrain.WALL && t != Terrain.GRASS && t != Terrain.TRAIL) { 
        neighbors.put(Direction.CENTER, t);
        neighbors.put(Direction.EAST, t);
        neighbors.put(Direction.SOUTH, t);
        final Truck truck = new Truck(0, 0, Direction.CENTER);
        for (Light l : Light.values()) {
          int tries = 0;
          boolean seen_south = false;
          boolean seen_east = false;
          while (tries < TRIES_FOR_RANDOMNESS && (!seen_south || !seen_east)) {
            tries = tries + 1;
            final Direction dir = truck.chooseDirection(neighbors, l);
            assertTrue("invalid dir chosen, should be east or south, was " + dir,
                       dir == Direction.EAST || dir == Direction.SOUTH);
            seen_south = seen_south || dir == Direction.SOUTH;
            seen_east = seen_east || dir == Direction.EAST;
          }
          assertTrue("truck randomness", seen_south && seen_east);
        }
      }
    }
  }

}
