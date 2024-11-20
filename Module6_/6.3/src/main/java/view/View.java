package view;

import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class View extends Application {
    private static final int CELL_SIZE = 20;

    private Canvas canvas;
    private GraphicsContext gc;
    private Controller controller;

    @Override
    public void start(Stage primaryStage) {
        controller = new Controller(this);
        int gridSize = controller.getGridSize();
        int canvasSize = gridSize * CELL_SIZE;

        canvas = new Canvas(canvasSize, canvasSize);
        gc = canvas.getGraphicsContext2D();

        canvas.setOnMouseMoved(event -> {
            int x = (int) event.getX();
            int y = (int) event.getY();
            controller.handleMove(x, y, CELL_SIZE);
            System.out.println("Mouse moved to (" + x + ", " + y + ")");
            System.out.println(controller.getPetX() + " " + controller.getPetY());
        });

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, canvasSize, canvasSize);
        primaryStage.setTitle("Graphics Demo");
        primaryStage.setScene(scene);
        primaryStage.show();

        updateCanvas(controller.getPetX(), controller.getPetY());
    }

    public void updateCanvas(int petX, int petY) {
        int gridSize = controller.getGridSize();
        int canvasSize = gridSize * CELL_SIZE;

        gc.clearRect(0, 0, canvasSize, canvasSize);

        gc.setFill(Color.BLUE);
        int x = petX * CELL_SIZE;
        int y = petY * CELL_SIZE;
        gc.fillRect(x, y, CELL_SIZE, CELL_SIZE);
        System.out.println("Pet x: " + petX + " y: " + petY);
        System.out.println("Cell size: " + CELL_SIZE);
        System.out.println("Canvas size: " + canvasSize);
    }
}