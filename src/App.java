import models.DataService;
import models.MariaDb;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Adatbázis elérés");
        DataService dataService = new DataService(new MariaDb("shop", "shop", "shop"));
    }
}
