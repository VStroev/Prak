import model.*;
import java.util.List;

public class Main {
    public static void main(String [] args) {
        RentServiceDAOImpl obj = new RentServiceDAOImpl();
        List<Rent> tmp = obj.getRentByCustomer(1);
        System.out.println("Look!");
        System.out.println(tmp.get(0).getId());
        obj.end();
    }
}
