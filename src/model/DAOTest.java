package model;

import org.hibernate.HibernateException;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import java.util.List;

public class DAOTest {

    private boolean equals(Object a, Object b) {
        if (a == b) {
            return true;
        }
        if ((a == null) || (b == null)) {
            return false;
        }
        return a.equals(b);
    }

    @Test(dataProvider = "filmTestData")
    public void testFilm (String name, String company, String producer, Integer cost) {
        RentServiceDAOImpl rs = new RentServiceDAOImpl();
        Integer size = null;
        List<Film> list = null;
        try {
            list = rs.getAllFilms();
        }
        catch (HibernateException e) {
            assert(false);
        }
        size = list.size();
        assert(size != null);

        Film f = new Film();
        f.setName(name);
        f.setCompany(company);
        f.setProducer(producer);
        f.setCdCost(cost);
        f.setCasetteCost(cost);
        try {
            rs.addFilm(f);

        }
        catch (HibernateException e) {
            assert(false);
        }

        try {
            assert(rs.getAllFilms().size() == size + 1);
            Film tmp = rs.loadFilm(f.getId());
            assert(tmp != null);
            assert(equals(tmp.getId(), f.getId()));
            assert(equals(tmp.getName(), f.getName()));
            assert(equals(tmp.getCompany(), f.getCompany()));
            assert(equals(tmp.getProdusr(), f.getProdusr()));
            assert(equals(tmp.getCdCost(), f.getCdCost()));
            assert(equals(tmp.getCasetteCost(), f.getCasetteCost()));
            rs.deleteFilm(tmp);
            assert(rs.getAllFilms().size() == size);
        }
        catch (HibernateException e) {
            assert(false);
        }


    }
    @DataProvider
    public Object[][] filmTestData() {
        return new Object[][] {
                new Object[] { "TEST1", "TEST2", "TEST3", 20 },
                new Object[] { "TEST1", "TEST2", null, 40 },
                new Object[] { "TEST1", null, "TEST3", 50 },
                new Object[] { null, "TEST2", "TEST3", 100 },
                new Object[] { null, null, "TEST3", 0 },
                new Object[] { null, "TEST2", null, 1 },
                new Object[] { "TEST1", null, null, 2 },
                new Object[] { null, null, null, 3 },
        };
    }



}
