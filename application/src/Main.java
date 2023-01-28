import java.util.TreeMap;
import java.util.Map;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> cookies = new TreeMap<>();
        cookies.put("username", "Maria");
        cookies.put("email", "Maria@gmail.com");
        cookies.put("phone", "912345678");

        cookies.remove("phone"); // removendo o phone
        cookies.put("phone", "912345786");
        System.out.println("Contains 'phone' key: " + cookies.containsKey("phone"));
        System.out.print("Enter a phone number : ");
        int numberPhone =  sc.nextInt();
        System.out.println("Contains 'phone' Value: " + cookies.containsValue(String.valueOf(numberPhone)));


        for(String key: cookies.keySet()) {
            System.out.println(key + ": " + cookies.get(key));
        }

    }

}