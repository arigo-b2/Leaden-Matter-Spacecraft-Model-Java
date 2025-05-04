package lms.grid;

import java.util.HashMap;
import java.util.Map;

/**
 * The GameGrid is responsible for managing the state and initialisation of the game's grid.
 * It provides the Map structure to hold the coordinates of each node in the grid. It also
 * maintains the size of the grid using a range variable. The range value donates how many
 * nodes each hexagonal grid node extends to.
 *
 * Summary: Initializes a grid of the game.
 *
 */
public class GameGrid {
    /***
     * An integer denoting the range of the grid.
     */
    private final int range;
    /***
     * A HashMap denoting a copy of the grid of the game.
     */
    private Map<Coordinate, GridComponent> grid;

    /***
     * Create a new GameGrid with the given range, stored in a Map.
     * @param range The range of the grid.
     * @ensure range more than 0.
     */
    public GameGrid(int range) {
        this.range = range;
        if (this.range <= 0) {
            throw new IllegalArgumentException("Range must be greater than 0");
        }
        this.grid = generate(range);
    }

    /**
     * Helper method:
     * Generates a grid with the given range, starting from the origin (the centre) and maintaining a
     * balanced shape for the entire mapping structure.
     * This has been provided to support you with the hexagonal coordinate logic.
     * @param range The range of the map.
     * @provided
     */
    private Map<Coordinate, GridComponent> generate(int range) {
        Map<Coordinate, GridComponent> tempGrid = new HashMap<>();
        for (int q = -range; q <= range; q++) { // From negative to positive (inclusive)
            for (int r = -range; r <= range; r++) { // From negative to positive (inclusive)
                for (int s = -range; s <= range; s++) { // From negative to positive (inclusive)
                    if (q + r + s == 0) {
                        // Useful to default to error
                        tempGrid.put(new Coordinate(q, r, s), () -> "ERROR");
                    }
                }
            }
        }
        return tempGrid;
    }

    /***
     * Get a copy of the grid of the game.
     * @return Map&lt;Coordinate, GridComponent&gt; A copy of the grid of the game.
     */
    public Map<Coordinate, GridComponent> getGrid() {
        return new HashMap<>(grid);
    }
