import java.util.Random;

public class TelevisionViewer {

    public static void main(String[] args) {
        Television television = new Television();
        boolean tired;
        int count = 0;
        Random random = new Random();


        for (int i = 1; i <= 10; i++) {
            tired = false;
            int boundary = random.nextInt(4) + 3;
            System.out.printf("Woke up, day %d %n", i);
            television.tvOnOff();
            while (!tired) {
                System.out.println("Watching channel " + television.getChannel());
                television.changeChannel();
                count++;
                if (count > boundary) {
                    tired = true;
                    television.tvOnOff();
                    count = 0;
                    System.out.println("Falling sleep");
                }
            }


        }
    }
}
