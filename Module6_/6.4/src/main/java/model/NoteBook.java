package model;

import java.util.ArrayList;

public class NoteBook {
    private ArrayList<Note> notes;

    public NoteBook() {
        notes = new ArrayList<>();
    }

    public void addNote(Note note) {
        if (!notes.contains(note)) {
            notes.add(note);
        }
    }

    public Note getNote(Note note) {
        Note foundNote = null;
        for (Note n : notes) {
            if (n.equals(note)) {
                foundNote = n;
            }
        }
        return foundNote;
    }

    public void removeNote(Note note) {
        notes.remove(note);
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }
}
