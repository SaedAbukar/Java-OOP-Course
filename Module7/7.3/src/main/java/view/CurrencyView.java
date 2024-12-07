package view;

import controller.CurrencyController;
import entity.Currency;
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
    private Label errorLabel = new Label();
    private TextField initialAmount = new TextField();
    private TextField targetAmount = new TextField();
    private ChoiceBox<String> initialCurrencyChoiceBox = new ChoiceBox<>();
    private ChoiceBox<String> targetCurrencyChoiceBox = new ChoiceBox<>();
    private Button addCurrencyButton = new Button("Add Currency");
    private Label newCurrencyLabel = new Label("Add new currency");
    private TextField newCurrencyAbbr = new TextField();
    private TextField newCurrencyName = new TextField();
    private TextField newCurrencyExchangeRate = new TextField();
    private Button addCurrency = new Button("Add Currency");

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
        ArrayList<String> abbreviations;
        try {
            abbreviations = currencyController.getAbbreviations();
            populateTheChoiceBoxes(abbreviations);
        } catch (Exception e) {
            String error = currencyController.getErrorMessage();
            e.printStackTrace();
            displayError(error);
        }
        // Create a filter to allow only digits and one decimal point
        TextFormatter<Double> initialAmountFormatter = new TextFormatter<>(new DoubleStringConverter(), 0.0, c ->
                // Allow digits and one decimal point
                c.getControlNewText().matches("[0-9]*\\.?[0-9]*") ? c : null);

        TextFormatter<Double> targetAmountFormatter = new TextFormatter<>(new DoubleStringConverter(), 0.0, c ->
                // Allow digits and one decimal point
                c.getControlNewText().matches("[0-9]*\\.?[0-9]*") ? c : null);

        TextFormatter<Double> newCurrencyFormatter = new TextFormatter<>(new DoubleStringConverter(), 0.0, c ->
                // Allow digits and one decimal point
                c.getControlNewText().matches("[0-9]*\\.?[0-9]*") ? c : null);

        // Apply the text formatter to the TextField
        initialAmount.setTextFormatter(initialAmountFormatter);
        targetAmount.setTextFormatter(targetAmountFormatter);
        newCurrencyExchangeRate.setTextFormatter(newCurrencyFormatter);

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
        buttonContainer.getChildren().add(addCurrencyButton);

        initialAmountAndCurrencyContainer.getChildren().add(initialAmountContainer);
        initialAmountAndCurrencyContainer.getChildren().add(initialChoiceContainer);

        targetAmountAndCurrencyContainer.getChildren().add(targetAmountContainer);
        targetAmountAndCurrencyContainer.getChildren().add(targetChoiceContainer);

        container.getChildren().add(initialAmountAndCurrencyContainer);
        container.getChildren().add(targetAmountAndCurrencyContainer);
        container.getChildren().add(buttonContainer);
        container.getChildren().add(errorLabel);

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

        addCurrencyButton.setOnAction(e -> {
            Stage newStage = new Stage();
            HBox newCurrencyContainer = new HBox();
            VBox newCurrency = new VBox();
            newCurrencyContainer.getChildren().addAll(newCurrencyAbbr, newCurrencyName, newCurrencyExchangeRate, addCurrency);
            newCurrency.getChildren().addAll(newCurrencyLabel, newCurrencyContainer);

            Scene view1 = new Scene(newCurrency, 400, 400);

            view1.getStylesheets().add("styles.css");
            newStage.setScene(view1);
            newStage.setMaxHeight(400);
            newStage.setMaxWidth(400);
            newStage.setMinHeight(400);
            newStage.setMinWidth(400);
            newStage.setTitle("Currency Converter");
            newStage.showAndWait();

            newCurrencyAbbr.setPromptText("Enter currency abbreviation");
            newCurrencyName.setPromptText("Enter currency name");
            newCurrencyExchangeRate.setPromptText("Enter currency exchange rate");
        });

        addCurrency.setOnAction(event -> {
            System.out.println("Add currency");
            String abb = newCurrencyAbbr.getText();
            String name = newCurrencyName.getText();
            double exchangeRate = Double.parseDouble(newCurrencyExchangeRate.getText());
            // Check if either currency is null
            if (abb == null || name == null || exchangeRate < 0) {
                // Display an alert to the user
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Insertion Error");
                alert.setHeaderText("Inserted Empty Values");
                alert.setContentText("Please fill all the fields.");
                alert.showAndWait();
                return; // Stop execution if a selection is missing
            }
            abb = abb.toUpperCase();
            if (initialCurrencyChoiceBox.getItems().contains(abb)) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Duplicate Error");
                alert.setHeaderText("Currency already exists in the database");
                alert.setContentText("Please fill add a new currency.");
                alert.showAndWait();
                return;
            }

            try {
                Currency result = currencyController.createCurrency(abb, name, exchangeRate);
                currencyController.persistCurrency(result);
            } catch (NumberFormatException ex) {
                String error = currencyController.getErrorMessage();
                displayError(error);
            }
            String error = currencyController.getErrorMessage();
            displayError(error);
        });

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
            try {
                double amount = Double.parseDouble(initialAmount.getText());
                double result = currencyController.convertCurrency(initialCurrency, targetCurrency, amount);
                setResult(result);
            } catch (NumberFormatException ex) {
                String error = currencyController.getErrorMessage();
                displayError(error);
            }
            String error = currencyController.getErrorMessage();
            displayError(error);
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

    public void displayError(String error) {
        if (error != null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Database error");
            alert.setContentText(error);
            alert.showAndWait();
        } else {
            errorLabel.setText("");
        }
    }
}
