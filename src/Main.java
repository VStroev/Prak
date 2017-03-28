import model.*;
import java.util.List;

public class Main {
    public static void main(String [] args) {
        RentServiceDAOImpl obj = new RentServiceDAOImpl();
        List<Customer> tmp = obj.getUnpayedCustomerByFilm(0);
        System.out.println("Look!");
        System.out.println(tmp.size());
        obj.end();
    }
}
