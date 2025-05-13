package lms.gui;

import lms.exceptions.FileFormatException;
import lms.grid.GameGrid;
import lms.io.GameLoader;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;

/**
 * Main application class which starts the application and sets the root frame.
 *
 */
public class MainApplication {
    /**
     * maintains the screen Width
     */
    private final int SCREEN_WIDTH;

    /**
     * maintains the screen height
     */
    private final int SCREEN_HEIGHT;

    /**
     * Instantiates the view and controller for this application.
     *
     * @param title  String setting the title for the panel
     * @param width  int setting the width for the panel
     * @param height int setting the height for the panel
     * @param save   String setting the save file to load
     */
    public MainApplication(String title, int width, int height, String save)
            throws FileFormatException {
        this.SCREEN_WIDTH = width;
        this.SCREEN_HEIGHT = height;

        /* Defines the gameGrid */
        GameGrid gameGrid;

        /*
         * Try and load the save file into gameGrid object
         */
        try {

            /* Loads and initialises the gameGrid object from save file data */
            gameGrid = GameLoader.load(new FileReader(save));
        } catch (IOException e) {
            throw new FileFormatException(e);
        }

        /*
         * Created the main window and adds close operation
         */
        JFrame mainFrame = new JFrame(title);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
         * Created the view and controller for this application
         */
        ViewModel viewModel = new ViewModel(mainFrame, gameGrid);
        final Controller controller = new Controller(viewModel); // Thread

        /* add frame prepared by the view to the mainFrame JFrame */
        mainFrame.add(viewModel.getPanel());


}
