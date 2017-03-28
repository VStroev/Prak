package model;

import java.util.List;
import org.hibernate.HibernateException;

public interface RentServiceDAO {
    public List<Film> getAllFilms() throws HibernateException;
    public List<Customer> getAllCustomers() throws HibernateException;
    public List<Rent> getAllRents() throws HibernateException;
    public List<Copy> getAllCopys() throws HibernateException;

    public void addFilm(Film film) throws HibernateException;
    public void addCustomer(Customer customer) throws HibernateException;
    public void addRent(Rent rent) throws HibernateException;
    public void addCopy(Copy copy) throws HibernateException;

    public void deleteFilm(Film film) throws HibernateException;
    public void deleteCustomer(Customer customer) throws HibernateException;
    public void deleteRent(Rent rent) throws HibernateException;
    public void deleteCopy(Copy copy) throws HibernateException;

    public void updateFilm(Film film) throws HibernateException;
    public void updateCustomer(Customer customer) throws HibernateException;
    public void updateRent(Rent rent) throws HibernateException;

    public Film loadFilm(Integer filmId) throws HibernateException;
    public Customer loadCustomer(Integer customerId) throws HibernateException;
    public Rent loadRent(Integer rentId) throws HibernateException;
    public Copy loadCopy(Integer copyId) throws HibernateException;

    public List<Customer> getCustomerByRent(Integer rentId) throws HibernateException;
    public List<Copy> getCopyByFilm(Integer filmId) throws HibernateException;
    public List<Rent> getRentByCustomer(Integer customerId) throws HibernateException;
    public List<Customer> getCustomerByCopy(Integer copyId) throws HibernateException;
    public List<Customer> getUnpayedCustomerByFilm(Integer filmId) throws HibernateException;
}

