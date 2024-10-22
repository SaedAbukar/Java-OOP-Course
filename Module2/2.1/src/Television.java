public class Television {
    int channel = 1;
    boolean tvState = false;

    public void tvOnOff() {
        tvState = !tvState;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        if (channel < 1 || channel > 10) {
            System.out.println("Invalid channel");
        } else {
            this.channel = channel;
        }
    }

    public int changeChannel() {
        this.channel++;
        if (this.getChannel() > 10) {
            this.setChannel(1);
        }
        return channel;
    }
}
