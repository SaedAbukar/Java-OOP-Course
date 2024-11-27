package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Note;
import model.NoteBook;

import java.net.URL;
import java.util.ResourceBundle;

public class NoteController implements Initializable {
    NoteBook noteBook = new NoteBook();

    @FXML
    private TextField textField;

    @FXML
    private TextArea textArea;

    @FXML
    private Label resultLabel;

    @FXML
    private ListView<Note> notesList;

    @FXML
    private Label savedTitle;

    @FXML
    private Label savedNote;


    Note currentNote;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        notesList.getSelectionModel().selectedItemProperty().addListener(e -> {
            currentNote = notesList.getSelectionModel().getSelectedItem();
            if (currentNote != null) {
                textField.setText(currentNote.getTitle());
                textArea.setText(currentNote.getContent());
                savedTitle.setText(currentNote.getTitle());
                savedNote.setText(currentNote.getContent());
            }
        });
    }

    @FXML
    private void addNote() {
        System.out.println(textField.getText());
        System.out.println(textArea.getText());
        String title = textField.getText();
        String content = textArea.getText();
        if (!title.isEmpty() && !content.isEmpty()) {
            Note note = new Note(textField.getText(), textArea.getText());
            noteBook.addNote(note);
            notesList.getItems().add(note);
            System.out.println(noteBook.getNotes().size());
            savedTitle.setText(title);
            savedNote.setText(content);
            textField.clear();
            textArea.clear();
            textField.setPromptText("Add the title of you note");
            textArea.setPromptText("Write your note here...");
            resultLabel.setText("Note added successfully!");
        } else {
            textField.setPromptText("You cannot add an empty note");
            textArea.setPromptText("You cannot add an empty note");
            System.out.println("You cannot add an empty note");
        }
    }

    @FXML
    private void deleteNote() {
        currentNote = notesList.getSelectionModel().getSelectedItem();
        if (currentNote != null) {
            noteBook.removeNote(currentNote);
            notesList.getItems().remove(currentNote);
            textField.clear();
            textArea.clear();
            savedTitle.setText("");
            savedNote.setText("");
            resultLabel.setText("Note deleted successfully!");
        }
    }

    @FXML
    private void editNote() {
        currentNote = notesList.getSelectionModel().getSelectedItem();
        if (currentNote != null) {
            currentNote.setTitle(textField.getText());
            currentNote.setContent(textArea.getText());
            savedTitle.setText(currentNote.getTitle());
            savedNote.setText(currentNote.getContent());
            textField.clear();
            textArea.clear();
            resultLabel.setText("Note edited successfully!");
        }
    }
}
