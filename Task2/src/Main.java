

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Жестко заданные файлы
        String circle = "test1.txt";
        String pointse = "test2.txt";


        BufferedReader br1 = new BufferedReader(new FileReader(circle));
        String[] circleData = br1.readLine().split(" ");
        double centerX = Double.parseDouble(circleData[0]);
        double centerY = Double.parseDouble(circleData[1]);
        double radiusSquared = Math.pow(Double.parseDouble(br1.readLine()), 2);
        br1.close();


        BufferedReader br2 = new BufferedReader(new FileReader(pointse));
        String line;
        while ((line = br2.readLine()) != null) {
            String[] point = line.split(" ");
            double distanceSquared = Math.pow(Double.parseDouble(point[0]) - centerX, 2) + Math.pow(Double.parseDouble(point[1]) - centerY, 2);
            System.out.println(distanceSquared < radiusSquared ? 1 : distanceSquared == radiusSquared ? 0 : 2);
        }
        br2.close();
    }
}
