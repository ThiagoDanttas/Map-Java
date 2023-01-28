
import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Exercise {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> votes = new LinkedHashMap<>();

        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();

            while(line != null) {

                String[] fields = line.split(";");
                String name = fields[0];
                int count = Integer.parseInt(fields[1]);

                if(votes.containsKey(name)) {
                    int voteSofar = votes.get(name);
                    votes.put(name, sum(count, voteSofar));
                } else {
                    votes.put(name, count);
                }

                line = br.readLine();

            }

            for (String key : votes.keySet()) {
                System.out.println(key + ": " + votes.get(key));
            }


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }

    // Método para somar os votos
    static int sum(int a, int b) {
        return a + b;
    }

}
