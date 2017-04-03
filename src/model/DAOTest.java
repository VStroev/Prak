package model;

import org.hibernate.HibernateException;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.Assert;

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

        list = rs.getAllFilms();

        size = list.size();
        Assert.assertNotNull(size);

        Film f = new Film();
        f.setName(name);
        f.setCompany(company);
        f.setProducer(producer);
        f.setCdCost(cost);
        f.setCasetteCost(cost);

        rs.addFilm(f);


        Assert.assertEquals(rs.getAllFilms().size(), size + 1);
        Film tmp = rs.loadFilm(f.getId());
        Assert.assertNotNull(tmp);
        Assert.assertTrue(equals(tmp.getId(), f.getId()));
        Assert.assertTrue(equals(tmp.getName(), f.getName()));
        Assert.assertTrue(equals(tmp.getCompany(), f.getCompany()));
        Assert.assertTrue(equals(tmp.getProdusr(), f.getProdusr()));
        Assert.assertTrue(equals(tmp.getCdCost(), f.getCdCost()));
        Assert.assertTrue(equals(tmp.getCasetteCost(), f.getCasetteCost()));

        f.setName("UPDATED");
        rs.updateFilm(f);
        tmp = rs.loadFilm(f.getId());
        Assert.assertTrue(equals(f.getName(), tmp.getName()));
        rs.deleteFilm(tmp);
        Assert.assertEquals(rs.getAllFilms().size(), size.intValue());



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

        list = rs.getAllCopys();

        size = list.size();
        Assert.assertNotNull (size);

        Copy c = new Copy();
        c.setFilm(rs.loadFilm(fId));
        c.setType(isCd);

        rs.addCopy(c);
        Assert.assertEquals (rs.getAllCopys().size(), size + 1);
        Copy tmp = rs.loadCopy(c.getId());
        Assert.assertNotNull (tmp);
        Assert.assertTrue (equals(tmp.getId(), c.getId()));
        Assert.assertTrue (equals(tmp.getFilm().getId(), c.getFilm().getId()));


        rs.deleteCopy(tmp);
        Assert.assertEquals (rs.getAllCopys().size(), size.intValue());
        list = rs.getCopyByFilm(fId);
        Assert.assertFalse (list.contains(tmp));

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

        list = rs.getAllCustomers();

        size = list.size();
        Assert.assertNotNull (size);

        Customer c = new Customer();
        c.setFirstName(firstName);
        c.setAddress(addr);
        c.setSurname(surname);
        c.setPatronymic(surname);
        c.setPhone(phone);

        rs.addCustomer(c);
        Assert.assertEquals (rs.getAllCustomers().size(), size + 1);
        Customer tmp = rs.loadCustomer(c.getId());
        Assert.assertNotNull (tmp);
        Assert.assertTrue (equals(tmp.getId(), c.getId()));
        Assert.assertTrue (equals(tmp.getFirstName(), c.getFirstName()));
        Assert.assertTrue (equals(tmp.getSurname(), c.getSurname()));
        Assert.assertTrue (equals(tmp.getAddress(), c.getAddress()));
        Assert.assertTrue (equals(tmp.getPhone(), c.getPhone()));

        boolean exec = false;
        try {
            c.setPhone("88888888888");
            rs.updateCustomer(c);
        }
        catch (Exception e) {
            exec = true;
        }
        Assert.assertTrue(exec);

        c.setPhone("8888888888");
        rs.updateCustomer(c);
        tmp = rs.loadCustomer(c.getId());
        Assert.assertTrue(equals(c.getPhone(), tmp.getPhone()));

        rs.deleteCustomer(tmp);
        Assert.assertEquals (rs.getAllCustomers().size(), size.intValue());
        Assert.assertTrue (equals(rs.getUnpayedCustomerByFilm(0).size(), 0));
        Assert.assertTrue (equals(rs.getUnpayedCustomerByFilm(1).size(), 1));
        Assert.assertTrue (equals(rs.getCustomerByCopy(1).size(), 1));
        Assert.assertTrue (equals(rs.getCustomerByCopy(3).size(), 2));
        Assert.assertTrue (equals(rs.getCustomerByRent(1).get(0).getId(), 1));

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

        list = rs.getAllRents();

        size = list.size();
        Assert.assertNotNull(size);

        Rent r = new Rent();
        r.setStartDate(startDate);
        r.setEndDate(endDate);
        r.setCopy(rs.loadCopy(cId));
        r.setCustomer(rs.loadCustomer(cId));
        r.setPayed(payed);

        rs.addRent(r);



        Assert.assertEquals(rs.getAllRents().size(), size + 1);
        Rent tmp = rs.loadRent(r.getId());
        Assert.assertNotNull(tmp);
        Assert.assertTrue(equals(tmp.getId(), r.getId()));
        Assert.assertTrue(equals(tmp.getCustomer().getId(), r.getCustomer().getId()));
        Assert.assertTrue(equals(tmp.getCopy().getId(), r.getCopy().getId()));
        Assert.assertTrue(equals(tmp.getStartDate(), r.getStartDate()));
        Assert.assertTrue(equals(tmp.getEndDate(), r.getEndDate()));
        Assert.assertTrue(equals(tmp.getPayed(), r.getPayed()));

        r.setPayed(0);
        rs.updateRent(r);
        tmp = rs.loadRent(r.getId());
        Assert.assertTrue(equals(r.getPayed(), r.getPayed()));

        rs.deleteRent(tmp);
        Assert.assertEquals(rs.getAllRents().size(), size.intValue());
        Assert.assertTrue (equals(rs.getRentByCustomer(1).size(), 2));
        Assert.assertTrue (equals(rs.getRentByCustomer(1).get(0).getId(), 1));



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
