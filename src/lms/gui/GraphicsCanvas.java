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



}