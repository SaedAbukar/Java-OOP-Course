public class Pen {
    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");
        private final String color;

        Color(String color) {
            this.color = color;
        }

        ;

        @Override
        public String toString() {
            return color;
        }
    }

    private Color color;
    private boolean capOn = true;

    public Pen(Color color) {
        this.color = color;
    }

    public Pen() {
        color = Color.RED;
    }

    // your code here
    public String draw() {
        if (!capOn) {
            return "Drawing " + color.toString();
        } else {
            return "";
        }
    }

    public void capOn() {
        capOn = true;
    }

    public void capOff() {
        capOn = false;
    }

    public void changeColor(Color color) {
        this.color = color;
    }
}