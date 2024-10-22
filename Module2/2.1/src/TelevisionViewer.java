public class TelevisionViewer {

    public static void main(String[] args) {
        Television television = new Television();
        boolean tired;
        int count = 0;

        for (int i = 1; i <= 10; i++) {
            tired = false;
            System.out.printf("Woke up, day %d %n", i);
            television.tvOnOff();
            while (!tired) {
                System.out.println("Watching channel " + television.getChannel());
                television.changeChannel();
                count++;
                if (count > 3) {
                    tired = true;
                    television.tvOnOff();
                    count = 0;
                    System.out.println("Falling sleep");
                }
            }


        }
    }
}
