package view;

import controller.DictionaryController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DictionaryView extends Application {
    private DictionaryController controller;
    private TextField word = new TextField();
    private TextField meaning = new TextField();
    private TextField query = new TextField();
    private Label result = new Label("The result should appear here");

    public void start(Stage stage) {
        Button submitButton = new Button("Add a word");
        Button searchButton = new Button("Search a word");
        word.setPromptText("Enter a word");
        meaning.setPromptText("Enter a meaning");
        query.setPromptText("Enter a query");

        FlowPane pane = new FlowPane();

        stage.setTitle("Dictionary");

        Insets insets = new Insets(10, 10, 10, 10);
        pane.setMargin(word, insets);
        pane.setMargin(meaning, insets);
        pane.setMargin(submitButton, insets);
        pane.setMargin(query, insets);
        pane.setMargin(searchButton, insets);
        pane.setMargin(result, insets);

        result.setMinWidth(30);
        result.setAlignment(Pos.CENTER);

        pane.getChildren().addAll(word, meaning, submitButton, query, searchButton, result);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String result = controller.addToDictionary(word.getText(), meaning.getText());
                setResult(result);
            }
        });

        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String result = controller.getMeaning(query.getText());
                setResult(result);
            }
        });

        stage.show();
    }

    public void init() {
        controller = new DictionaryController(this);
    }

    public String getWord() {
        return word.getText();
    }

    public String getMeaning() {
        return meaning.getText();
    }

    public void setResult(String result) {
        this.result.setText(result);
    }
}