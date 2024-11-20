package controller;

import model.Pet;
import view.View;

public class Controller {
    private Pet pet;
    private View gui;

    public Controller(View gui) {
        this.pet = new Pet(0, 0);
        this.gui = gui;
    }

    public void handleMove(int x, int y, int gridSize) {
        // Snap to grid
        int gridX = x / gridSize;
        int gridY = y / gridSize;

        // Ensure the pet doesn't move outside the grid
        gridX = Math.min(Math.max(gridX, 0), pet.getGridSize() - 1);
        gridY = Math.min(Math.max(gridY, 0), pet.getGridSize() - 1);

        pet.move(gridX, gridY);
        gui.updateCanvas(pet.getX(), pet.getY());
    }


    public int getPetX() {
        return pet.getX();
    }

    public int getPetY() {
        return pet.getY();
    }

    public int getGridSize() {
        return pet.getGridSize();
    }
}