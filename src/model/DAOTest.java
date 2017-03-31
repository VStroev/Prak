package model;

import org.hibernate.HibernateException;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import java.sql.Date;
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
    @Test(dataProvider = "copyTestData")
    public void testCopy (Integer fId, boolean isCd) {
        RentServiceDAOImpl rs = new RentServiceDAOImpl();
        Integer size = null;
        List<Copy> list = null;
        try {
            list = rs.getAllCopys();
        } catch (HibernateException e) {
            assert (false);
        }
        size = list.size();
        assert (size != null);

        Copy c = new Copy();
        c.setFilm(rs.loadFilm(fId));
        c.setType(isCd);
        try {
            rs.addCopy(c);
            assert (rs.getAllCopys().size() == size + 1);
            Copy tmp = rs.loadCopy(c.getId());
            assert (tmp != null);
            assert (equals(tmp.getId(), c.getId()));
            assert (equals(tmp.getFilm().getId(), c.getFilm().getId()));
            rs.deleteCopy(tmp);
            assert (rs.getAllCopys().size() == size);
            list = rs.getCopyByFilm(fId);
            assert (!list.contains(tmp));
        } catch (HibernateException e) {
            assert (false);
        }
    }
    @DataProvider
    public Object[][] copyTestData() {
        return new Object[][] {
                new Object[] { 1, true },
                new Object[] { 2, false },
                new Object[] { 1, false },
                new Object[] { 3, true },
                new Object[] { 2, true },
                new Object[] { 4, true },
                new Object[] { 4, false },
        };
    }

    @Test(dataProvider = "customerTestData")
    public void testCustomer (String firstName, String surname, String addr, String phone) {
        RentServiceDAOImpl rs = new RentServiceDAOImpl();
        Integer size = null;
        List<Customer> list = null;
        try {
            list = rs.getAllCustomers();
        } catch (HibernateException e) {
            assert (false);
        }
        size = list.size();
        assert (size != null);

        Customer c = new Customer();
        c.setFirstName(firstName);
        c.setAddress(addr);
        c.setSurname(surname);
        c.setPatronymic(surname);
        c.setPhone(phone);
        try {
            rs.addCustomer(c);
            assert (rs.getAllCustomers().size() == size + 1);
            Customer tmp = rs.loadCustomer(c.getId());
            assert (tmp != null);
            assert (equals(tmp.getId(), c.getId()));
            assert (equals(tmp.getFirstName(), c.getFirstName()));
            assert (equals(tmp.getSurname(), c.getSurname()));
            assert (equals(tmp.getAddress(), c.getAddress()));
            assert (equals(tmp.getPhone(), c.getPhone()));
            rs.deleteCustomer(tmp);
            assert (rs.getAllCustomers().size() == size);
            assert (equals(rs.getUnpayedCustomerByFilm(0).size(), 0));
            assert (equals(rs.getUnpayedCustomerByFilm(1).size(), 1));
            assert (equals(rs.getCustomerByCopy(1).size(), 1));
            assert (equals(rs.getCustomerByCopy(3).size(), 2));
            assert (equals(rs.getCustomerByRent(1).get(0).getId(), 1));

        } catch (HibernateException e) {
            assert (false);
        }
    }
    @DataProvider
    public Object[][] customerTestData() {
        return new Object[][] {
                new Object[] { "TEST1", "TEST2", "TEST3", "TEST4" },
                new Object[] { "TEST1", "TEST2", null, "TEST4" },
                new Object[] { "TEST1", null, "TEST3", "TEST4" },
                new Object[] { null, "TEST2", "TEST3", null },
                new Object[] { null, null, "TEST3", "TEST4" },
                new Object[] { null, "TEST2", null, "TEST4" },
                new Object[] { "TEST1", null, null, "TEST4" },
                new Object[] { null, null, null, null },
        };
    }

    @Test(dataProvider = "rentTestData")
    public void testRent (Date startDate, Date endDate, Integer cId, Integer payed) {
        RentServiceDAOImpl rs = new RentServiceDAOImpl();
        Integer size = null;
        List<Rent> list = null;
        try {
            list = rs.getAllRents();
        }
        catch (HibernateException e) {
            assert(false);
        }
        size = list.size();
        assert(size != null);

        Rent r = new Rent();
        r.setStartDate(startDate);
        r.setEndDate(endDate);
        r.setCopy(rs.loadCopy(cId));
        r.setCustomer(rs.loadCustomer(cId));
        r.setPayed(payed);
        try {
            rs.addRent(r);

        }
        catch (HibernateException e) {
            assert(false);
        }

        try {
            assert(rs.getAllRents().size() == size + 1);
            Rent tmp = rs.loadRent(r.getId());
            assert(tmp != null);
            assert(equals(tmp.getId(), r.getId()));
            assert(equals(tmp.getCustomer().getId(), r.getCustomer().getId()));
            assert(equals(tmp.getCopy().getId(), r.getCopy().getId()));
            assert(equals(tmp.getStartDate(), r.getStartDate()));
            assert(equals(tmp.getEndDate(), r.getEndDate()));
            assert(equals(tmp.getPayed(), r.getPayed()));
            rs.deleteRent(tmp);
            assert(rs.getAllRents().size() == size);
            assert (equals(rs.getRentByCustomer(1).size(), 2));
            assert (equals(rs.getRentByCustomer(1).get(0).getId(), 1));
        }
        catch (HibernateException e) {
            assert(false);
        }


    }
    @DataProvider
    public Object[][] rentTestData() {
        return new Object[][] {
                new Object[] { new Date(1996, 1, 1), new Date(1996, 1, 2),
                                1, 1},
                new Object[] { new Date(1996, 1, 1), null,
                                1, 1},
                new Object[] { new Date(1996, 1, 1), new Date(1996, 1, 2),
                            3, 1000},
                new Object[] { new Date(1996, 1, 1), null,
                            2, 1},
                new Object[] { new Date(1996, 1, 1), new Date(1996, 1, 2),
                            4, 0},

        };
    }
}
