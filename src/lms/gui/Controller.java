package lms.gui;

import lms.exceptions.BadStateException;
import lms.logistics.Path;
import lms.logistics.Transport;
import lms.grid.GameGrid;
import lms.grid.GridComponent;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller class for the GUI.
 * <p>
 * Used to control the solution.View based on user input.
 */
public class Controller {

    /**
     * View for the canvas application.
     */
    private final ViewModel viewModel;

    /**
     * Create a new Controller for the given view, adding ActionListener to
     * the view.
     *
     * @param viewModel The view to be managed by this controller.
     */
    public Controller(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void run() {
        Timer timer = new Timer(1000, e -> {
            if (viewModel.isPaused()) {
                return;
            }

}
