package controller;

import model.Dictionary;
import view.DictionaryView;

import java.util.Scanner;

public class DictionaryController {
    private Dictionary dictionary = new Dictionary();
    private DictionaryView view;
    public DictionaryController(DictionaryView view) {
        this.view = view;
    }

    public String getMeaning(String word) {
        return dictionary.getMeaning(word);
    }

    public String addToDictionary(String word, String meaning) {
        return dictionary.addToDictionary(word, meaning);
    }
}