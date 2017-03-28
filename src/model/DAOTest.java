package model;

import org.hibernate.HibernateException;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import java.util.List;

public class DAOTest {

    public void testFilm (Film f1, Film f2) {
        RentServiceDAOImpl rs = new RentServiceDAOImpl();
        Integer size = null;
        List<Film> list;
        try {
            list = rs.getAllFilms();
        }
        catch (HibernateException e) {
            assert false;
        }

    }

}
