package lms.gui;

import lms.logistics.Item;
import lms.logistics.Path;
import lms.logistics.Transport;
import lms.logistics.container.Receiver;
import lms.logistics.container.Producer;
import lms.grid.Coordinate;
import lms.grid.GameGrid;
import lms.grid.GridComponent;
import lms.grid.Orientation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

/**
 * A JPanel that provides a graphics context for drawing the grid
 * This class is intended for use as a canvas for 2Dgraphics.
 */
class GraphicsCanvas extends JPanel {
    /**
     * Stores the hexagons in a List of DrawnElements
     */
    private final List<DrawnElement> hexagons;

    /**
     * Stores the hover polygon
     */
    private Polygon hoverPolygon;

    /**
     * Draws the grid and Coordinates
     */
    private static class DrawnElement {

        /**
         * Stores the coordinate
         */
        private Coordinate coordinate;
        // [getCoordinate]

        /**
         * Stores the polygon
         */
        private Polygon polygon;
        // [getPolygon]

        /**
         * Stores the x coordinate
         */
        private int cordX;

        /**
         * Stores the y coordinate
         */
        private int cordY;

        /**
         * Stores the MapComponent
         */
        private GridComponent component;
        //  method [getComponent]

        public DrawnElement(Coordinate coordinate, Polygon polygon, int x, int y,
                            GridComponent component) {
            this.coordinate = coordinate;
            this.polygon = polygon;
            this.cordX = x;
        
        }

    /**
     * Creates a new GraphicsCanvas with the specified preferred width and height.
     *
     * @param prefWidth  the preferred width of the canvas
     * @param prefHeight the preferred height of the canvas
     */
    public GraphicsCanvas(int prefWidth, int prefHeight) {
        super();
        this.setPreferredSize(new Dimension(prefWidth, prefHeight));
        hexagons = new ArrayList<>();
        hoverPolygon = null;
        
        addMouseMotionListener(new MouseAdapter() {
            /**
             * This is a method implementation for the mouseMoved method,
             * which is part of a MouseAdapter object being used in a
             * GraphicsCanvas class. The mouseMoved method is called when
             * the user moves the mouse within the canvas.
             * <p>
             * The purpose of this method is to determine whether the mouse
             * is currently hovering over any of the hexagons that have been
             * added to the GraphicsCanvas. Here's how it works:
             * <p>
             */
            @Override
            public void mouseMoved(MouseEvent e) {
                hexagons.stream()
                        .map(el -> el.polygon)
                        .filter(p -> p.contains(e.getPoint()))
                        .findFirst()
                        .ifPresentOrElse(p -> hoverPolygon = p, () -> hoverPolygon = null);
                repaint();
            }
        });

        /**
         * Draws a game map by generating a hexagonal grid based on the MapComponents
         * of the provided GameGrid. The generated grid is centered on the JPanel that
         * this method is called from, unless its dimensions are (0,0), in which case
         * the grid is centered on the preferred size of the JPanel. The hexagonal
         * grid is generated using a slow algorithm that iterates over all the
         * MapComponents and their connections, drawing the hexagons on a canvas as it
         * goes.
         *
         * @param map the GameGrid to draw
         */
        public void drawMap(GameGrid map) {
            int x = getWidth() / 2;
            int y = getHeight() / 2;
            if (x == 0 && y == 0) {
                Dimension dimensions = getPreferredSize();
                x = dimensions.width / 2;
                y = dimensions.height / 2;
            }

            Map<Coordinate, GridComponent> grid = map.getGrid();
            setLayout(null);

            List<Coordinate> tasklist = new ArrayList<>();

            Coordinate origin = new Coordinate();

            hexagons.add(new DrawnElement(origin, drawHexagon(x, y), x, y, grid.get(origin)));
            tasklist.add(origin);

            int size = getHexagonSize();
            int half = size / 2;
            int threeQuart = size * 3 / 4;

        while (!tasklist.isEmpty()) {
            Coordinate target = tasklist.remove(0);
            grid.remove(target);
            // if item != null do something (drawing)

            DrawnElement element =
                    hexagons.stream()
                            .filter(e -> e.coordinate.equals(target))
                            .findFirst().orElseThrow(IllegalArgumentException::new);
            for (Coordinate c : grid.keySet()) {
                if (tasklist.contains(c)) {
                    continue;
                }
                if (target.isNeighbour(c)) {
                    Orientation direction = target.getDirection(c);
                    x = element.cordX;
                    y = element.cordY;
                    switch (direction) {
                        case TOP_LEFT -> {
                            x -= half;
                            y -= threeQuart;
                        }
                        case TOP_RIGHT -> {
                            x += half;
                            y -= threeQuart;
                        }
                        case RIGHT -> {
                            x += size;
                        }
                        case BOTTOM_RIGHT -> {
                            x += half;
                            y += threeQuart;
                        }
                        case BOTTOM_LEFT -> {
                            x -= half;
                            y += threeQuart;
                        }
                        case LEFT -> {
                            x -= size;
                        }
                    }
                    hexagons.add(new DrawnElement(c, drawHexagon(x, y), x, y,
                            grid.getOrDefault(c, () -> "ERROR")));
                    System.out.println("Drew " + c + " as " + grid.getOrDefault(c, () -> "ERROR")
                            .getEncoding() + " : from - " + target + " - as " + direction);
                    tasklist.add(c);
                }
            }
        }


    private void drawLine(Graphics2D graphics2D, Polygon polygon, int x, int y,
                          Orientation orientation) {
    }

}