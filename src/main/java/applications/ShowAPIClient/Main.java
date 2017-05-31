package applications.ShowAPIClient;

/**
 * Created by Maiko on 12-5-2017.
 */
public class Main {
    public static void main(String[] args) {
        if(args[0] != null && !args[0].isEmpty()) {
            new ShowAPIClientManager(args[0]);
            System.out.println(args[0] + " Started");
        }
    }
}
