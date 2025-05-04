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
    