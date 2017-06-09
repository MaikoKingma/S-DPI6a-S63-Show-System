package applications.ShowAPIClient;

/**
 * Created by Maiko on 12-5-2017.
 */
public class Main {
    public static void main(String[] args) {
        if(args[0] != null && !args[0].isEmpty()) {
            readers reader = readers.values()[Integer.parseInt(args[0])];
            new ShowAPIClientManager(reader);
            System.out.println(reader + " Started");
        }
    }
}
