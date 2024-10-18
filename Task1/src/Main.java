public class Main {
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Укажите два аргумента: n и m.");
            return;
        }


        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        int position = 0;
        StringBuilder result = new StringBuilder();

        do {
            result.append(position + 1);
            position = (position + m - 1) % n;
        } while (position != 0);

        System.out.println(result.toString());
    }
}

