import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Укажите файл с числами в качестве аргумента.");
            return;
        }

        String fileName = args[0];

        int[] nums = readNumbersFromFile(fileName);
        int minMoves = calculateMinMoves(nums);
        System.out.println(minMoves);
    }

    private static int[] readNumbersFromFile(String fileName) {
        int[] nums = new int[100];
        int count = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = br.readLine()) != null) {
                nums[count] = Integer.parseInt(line);
                count++;
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        int[] result = new int[count];
        System.arraycopy(nums, 0, result, 0, count);
        return result;
    }

    private static int calculateMinMoves(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int average = sum / nums.length;
        int moves = 0;

        for (int num : nums) {
            moves += Math.abs(num - average);
        }

        return moves;
    }
}
