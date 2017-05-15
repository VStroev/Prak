package model;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class RentServiceDAOImpl implements RentServiceDAO {
    private static SessionFactory sessions = null;

    public RentServiceDAOImpl() {
        Configuration configuration = new Configuration();
        configuration.configure().addAnnotatedClass(Rent.class);
        configuration.configure().addAnnotatedClass(Copy.class);
        configuration.configure().addAnnotatedClass(Customer.class);
        configuration.configure().addAnnotatedClass(Film.class);
        sessions = configuration.buildSessionFactory(
                new StandardServiceRegistryBuilder().applySettings(
                        configuration.getProperties()).build());
    }

    public void end() {
        sessions.close();
    }

    @Override
    public List<Film> getAllFilms() throws HibernateException {
        Session session = sessions.openSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Film> list = session.createCriteria(Film.class).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    @Override
    public List<Customer> getAllCustomers() throws HibernateException {
        Session session = sessions.openSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Customer> list = session.createCriteria(Customer.class).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    @Override
    public List<Rent> getAllRents() throws HibernateException {
        Session session = sessions.openSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Rent> list = session.createCriteria(Rent.class).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    @Override
    public List<Copy> getAllCopys() throws HibernateException {
        Session session = sessions.openSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Copy> list = session.createCriteria(Copy.class).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public void addFilm(Film film) throws HibernateException {
        Session session = sessions.openSession();
        session.beginTransaction();
        session.save(film);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    public void addCustomer(Customer customer) throws HibernateException {
        Session session = sessions.openSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    public void addRent(Rent rent) throws HibernateException {
        Session session = sessions.openSession();
        session.beginTransaction();
        session.save(rent);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    public void addCopy(Copy copy) throws HibernateException {
        Session session = sessions.openSession();
        session.beginTransaction();
        session.save(copy);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteFilm(Film film) throws HibernateException {
        Session session = sessions.openSession();
        session.beginTransaction();
        session.delete(film);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    public void deleteCustomer(Customer customer) throws HibernateException {
        Session session = sessions.openSession();
        session.beginTransaction();
        session.delete(customer);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    public void deleteRent(Rent rent) throws HibernateException {
        Session session = sessions.openSession();
        session.beginTransaction();
        session.delete(rent);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    public void deleteCopy(Copy copy) throws HibernateException {
        Session session = sessions.openSession();
        session.beginTransaction();
        session.delete(copy);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateFilm(Film film) throws HibernateException {
        Session session = sessions.openSession();
        session.beginTransaction();
        session.update(film);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    public void updateCustomer(Customer customer) throws HibernateException {
        Session session = sessions.openSession();
        session.beginTransaction();
        session.update(customer);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    public void updateRent(Rent rent) throws HibernateException {
        Session session = sessions.openSession();
        session.beginTransaction();
        session.update(rent);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Film loadFilm(Integer filmId) throws HibernateException{
        Session session = sessions.openSession();
        session.beginTransaction();
        Query query = session.createQuery("select distinct film from Film film"
                + " where film.id ="
                + filmId.toString());
        session.getTransaction().commit();
        Film film = (Film) query.uniqueResult();
        session.close();
        return film;
    }

    @Override
    public Customer loadCustomer(Integer customerId) throws HibernateException{
        Session session = sessions.openSession();
        session.beginTransaction();
        Query query = session.createQuery("select distinct customer from Customer customer"
                + " where customer.id ="
                + customerId.toString());
        session.getTransaction().commit();
        Customer customer = (Customer) query.uniqueResult();
        session.close();
        return customer;
    }

    @Override
    public Rent loadRent(Integer rentId) throws HibernateException{
        Session session = sessions.openSession();
        session.beginTransaction();
        Query query = session.createQuery("select distinct rent from Rent rent"
                + " where rent.id ="
                + rentId.toString());
        session.getTransaction().commit();
        Rent rent = (Rent) query.uniqueResult();
        session.close();
        return rent;
    }

    @Override
    public Copy loadCopy(Integer copyId) throws HibernateException{
        Session session = sessions.openSession();
        session.beginTransaction();
        Query query = session.createQuery("select distinct copy from Copy copy"
                + " where copy.id ="
                + copyId.toString());
        session.getTransaction().commit();
        Copy copy = (Copy) query.uniqueResult();
        session.close();
        return copy;
    }

    @Override
    public List<Customer> getCustomerByRent(Integer rentId) throws HibernateException {
        Session session = sessions.openSession();
        session.beginTransaction();
        Query query = session.createQuery("select distinct customer from Customer customer,"
                + "Rent rent where customer.id ="
                + "rent.customer.id and rent.id = "
                + rentId.toString());
        session.getTransaction().commit();
        @SuppressWarnings("unchecked")
        List<Customer> list = query.list();
        session.close();
        return list;
    }
    @Override
    public List<Copy> getCopyByFilm(Integer filmId) throws HibernateException {
        Session session = sessions.openSession();
        session.beginTransaction();
        Query query = session.createQuery("select distinct copy from Copy copy,"
                + "Film film where film.id ="
                + "copy.film.id and film.id = "
                + filmId.toString());
        session.getTransaction().commit();
        @SuppressWarnings("unchecked")
        List<Copy> list = query.list();
        session.close();
        return list;
    }
    @Override
    public List<Rent> getRentByCustomer(Integer customerId) throws HibernateException {
        Session session = sessions.openSession();
        session.beginTransaction();
        Query query = session.createQuery("select distinct rent from Rent rent,"
                + "Customer customer where customer.id ="
                + "rent.customer.id and customer.id = "
                + customerId.toString());
        session.getTransaction().commit();
        @SuppressWarnings("unchecked")
        List<Rent> list = query.list();
        session.close();
        return list;
    }

    @Override
    public List<Customer> getCustomerByCopy(Integer copyId) throws HibernateException {
        Session session = sessions.openSession();
        session.beginTransaction();
        Query query = session.createQuery("select distinct customer from Customer customer,"
                + "Rent rent, Copy copy where customer.id = "
                + "rent.customer.id and rent.copy.id = copy.id "
                + "and copy.id = "
                + copyId.toString());
        session.getTransaction().commit();
        @SuppressWarnings("unchecked")
        List<Customer> list = query.list();
        session.close();
        return list;
    }

    @Override
    public List<Customer> getUnpayedCustomerByFilm(Integer filmId) throws HibernateException {
        Session session = sessions.openSession();
        session.beginTransaction();
        Query query = session.createQuery("select distinct customer from Customer customer,"
                + "Rent rent, Copy copy, Film film where customer.id ="
                + "rent.customer.id and rent.copy.id = copy.id "
                + "and rent.endDate = null "
                + "and copy.film.id = film.id "
                + "and film.id ="
                + filmId.toString());
        session.getTransaction().commit();
        @SuppressWarnings("unchecked")
        List<Customer> list = query.list();
        session.close();
        return list;
    }

    @Override
    public List<Customer> getUnpayedCustomerByCopy(Integer copyId) throws HibernateException {
        Session session = sessions.openSession();
        session.beginTransaction();
        Query query = session.createQuery("select distinct customer from Customer customer,"
                + "Rent rent, Copy copy where customer.id ="
                + "rent.customer.id and rent.copy.id = copy.id "
                + "and rent.endDate = null "
                + "and copy.id ="
                + copyId.toString());
        session.getTransaction().commit();
        @SuppressWarnings("unchecked")
        List<Customer> list = query.list();
        session.close();
        return list;
    }
}
