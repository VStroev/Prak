import model.*;
import java.util.List;

public class Main {
    public static void main(String [] args) {
        RentServiceDAOImpl obj = new RentServiceDAOImpl();
        Film tmp = obj.loadFilm(0);
        System.out.println("Look!");
        System.out.println(tmp.getId() + tmp.getName() + tmp.getCompany());
        obj.end();
    }
}
