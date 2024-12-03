package view;

import controller.CurrencyController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

import java.util.ArrayList;

public class CurrencyView extends Application {
    private CurrencyController currencyController;
    private Label initialAmountLabel = new Label("Initial Amount");
    private Label targetAmountLabel = new Label("Target Amount");
    private Label initialCurrencyLabel = new Label("Initial Currency");
    private Label targetCurrencyLabel = new Label("Target Currency");
    private Label buttonLabel = new Label("Press the button to convert");
    private TextField initialAmount = new TextField();
    private TextField targetAmount = new TextField();
    private ChoiceBox<String> initialCurrencyChoiceBox = new ChoiceBox<>();
    private ChoiceBox<String> targetCurrencyChoiceBox = new ChoiceBox<>();

    @Override
    public void start(Stage stage) throws Exception {
        Button convertButton = new Button("Convert");
        HBox initialAmountAndCurrencyContainer = new HBox();
        HBox targetAmountAndCurrencyContainer = new HBox();
        VBox initialAmountContainer = new VBox();
        VBox targetAmountContainer = new VBox();
        VBox initialChoiceContainer = new VBox();
        VBox targetChoiceContainer = new VBox();
        VBox buttonContainer = new VBox();
        TilePane container = new TilePane();
        StackPane centerContainer = new StackPane();
        BorderPane layout = new BorderPane();
        ArrayList<String> abbreviations = currencyController.getAbbreviations();
        populateTheChoiceBoxes(abbreviations);
        // Create a filter to allow only digits and one decimal point
        TextFormatter<Double> initialAmountFormatter = new TextFormatter<>(new DoubleStringConverter(), 0.0, c ->
                // Allow digits and one decimal point
                c.getControlNewText().matches("[0-9]*\\.?[0-9]*") ? c : null);

        TextFormatter<Double> targetAmountFormatter = new TextFormatter<>(new DoubleStringConverter(), 0.0, c ->
                // Allow digits and one decimal point
                c.getControlNewText().matches("[0-9]*\\.?[0-9]*") ? c : null);
        // Apply the text formatter to the TextField
        initialAmount.setTextFormatter(initialAmountFormatter);
        targetAmount.setTextFormatter(targetAmountFormatter);

        initialCurrencyChoiceBox.setOnAction(event -> {
            String selected = initialCurrencyChoiceBox.getValue();
            System.out.println("Selected: " + selected);
        });
        targetCurrencyChoiceBox.setOnAction(event -> {
            String selected = targetCurrencyChoiceBox.getValue();
            System.out.println("Selected 2: " + selected);
        });


        initialAmountContainer.getChildren().add(initialAmountLabel);
        initialAmountContainer.getChildren().add(initialAmount);
        initialChoiceContainer.getChildren().add(initialCurrencyLabel);
        initialChoiceContainer.getChildren().add(initialCurrencyChoiceBox);

        targetAmountContainer.getChildren().add(targetAmountLabel);
        targetAmountContainer.getChildren().add(targetAmount);
        targetChoiceContainer.getChildren().add(targetCurrencyLabel);
        targetChoiceContainer.getChildren().add(targetCurrencyChoiceBox);

        buttonContainer.getChildren().add(buttonLabel);
        buttonContainer.getChildren().add(convertButton);

        initialAmountAndCurrencyContainer.getChildren().add(initialAmountContainer);
        initialAmountAndCurrencyContainer.getChildren().add(initialChoiceContainer);

        targetAmountAndCurrencyContainer.getChildren().add(targetAmountContainer);
        targetAmountAndCurrencyContainer.getChildren().add(targetChoiceContainer);

        container.getChildren().add(initialAmountAndCurrencyContainer);
        container.getChildren().add(targetAmountAndCurrencyContainer);
        container.getChildren().add(buttonContainer);

        Insets insets = new Insets(10, 10, 10, 10);
        container.setMargin(initialAmountAndCurrencyContainer, insets);
        container.setMargin(targetAmountAndCurrencyContainer, insets);
        container.setMargin(buttonContainer, insets);
        centerContainer.getChildren().add(container);
        layout.setCenter(centerContainer);

        Scene view = new Scene(layout, 400, 400);

        view.getStylesheets().add("styles.css");
        stage.setScene(view);
        stage.setMaxHeight(400);
        stage.setMaxWidth(400);
        stage.setMinHeight(400);
        stage.setMinWidth(400);
        stage.setTitle("Currency Converter");
        stage.show();

        convertButton.setOnAction(e -> {
            String initialCurrency = initialCurrencyChoiceBox.getValue();
            String targetCurrency = targetCurrencyChoiceBox.getValue();
            // Check if either currency is null
            if (initialCurrency == null || targetCurrency == null) {
                // Display an alert to the user
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Selection Error");
                alert.setHeaderText("Currency Selection Missing");
                alert.setContentText("Please select both an initial and a target currency.");
                alert.showAndWait();
                return; // Stop execution if a selection is missing
            }
            double amount = Double.parseDouble(initialAmount.getText());
            double result = currencyController.convertCurrency(initialCurrency, targetCurrency, amount);
            setResult(result);
        });
    }

    public void init() {
        currencyController = new CurrencyController(this);
    }

    public void populateTheChoiceBoxes(ArrayList<String> abbreviations) {
        initialCurrencyChoiceBox.getItems().addAll(abbreviations);
        targetCurrencyChoiceBox.getItems().addAll(abbreviations);
    }

    public void setResult(double result) {
        targetAmount.setText(String.format("%.3f", result));
    }


}
