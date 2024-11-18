package model;

import java.util.HashMap;

public class Dictionary {
    private HashMap<String,String> dictionary;

    public Dictionary() {
        dictionary = new HashMap<>();
    }

    public String addToDictionary(String word, String meaning) {
        word = word.toLowerCase();
        if (word.isEmpty()) {
            System.out.println("Enter a word");
            return "Enter a word";
        } else if (meaning.isEmpty()) {
            System.out.println("Enter a meaning");
            return "Enter a meaning";
        } else if (dictionary.containsKey(word)) {
            dictionary.put(word, meaning);
            System.out.println("The word " + word + " has been added to the dictionary. Meaning updated");
            return "The word " + word + " was already in the dictionary. Meaning updated.";
        } else {
            dictionary.put(word, meaning);
            System.out.println("The word " + word + " has been added to the dictionary");
            return "The word " + word + " added to the dictionary.";
        }
    }

    public String getMeaning(String word) {
        word = word.toLowerCase();
        if (word == null) {
            return "Enter a word";
        }
        if (dictionary.containsKey(word)) {
            return word + ": " + dictionary.get(word);
        }
        return "The word is not in the dictionary";
    }
}
