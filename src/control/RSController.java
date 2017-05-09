package control;

import model.*;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class RSController {
    private  static RentServiceDAO dao = new RentServiceDAOImpl();

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getIndex(Model model) {
        return "index";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String getError(Model model) {
        return "error";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHome(Model model) {
        return "home";
    }

    @RequestMapping(value = "/films", method = RequestMethod.GET)
    public String getFilms(Model model) {
        try {
            List<Film> f = dao.getAllFilms();
            model.addAttribute("films", f);
        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "error";
        }
        return "films";
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String getCustomers(Model model) {
        try {
            List<Customer> c = dao.getAllCustomers();
            model.addAttribute("customers", c);
        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "error";
        }

        return "customers";
    }

    @RequestMapping(value = "/copys", method = RequestMethod.GET)
    public String getCopys(@RequestParam(value="id", required=true) Integer id, Model model) {
        try {
            List<Copy> c = dao.getCopyByFilm(id);
            model.addAttribute("copys", c);
            model.addAttribute("fId", id);
        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "error";
        }

        return "copys";
    }

    @RequestMapping(value = "/copy", method = RequestMethod.GET)
    public String getCopy(@RequestParam(value="id", required=true) Integer id, Model model) {
        try {
            Copy c = dao.loadCopy(id);
            model.addAttribute("copy", c);
            List<Customer> list = dao.getUnpayedCustomerByCopy(id);
            model.addAttribute("customers", list);
            model.addAttribute("len", list.size());
        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "error";
        }

        return "copy";
    }

    @RequestMapping(value = "/copy_history", method = RequestMethod.GET)
    public String getRents(@RequestParam(value="id", required=true) Integer id, Model model) {
        try {
            List<Rent> r= dao.getRentByCustomer(id);
            model.addAttribute("copys", r);
        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "error";
        }

        return "copys";
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String getHistory(Model model) {
        try {
            List<Rent> r = dao.getAllRents();
            model.addAttribute("rents", r);
        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "error";
        }
        return "history";
    }

    @RequestMapping(value = "/film", method = RequestMethod.GET)
    public String getFilm(@RequestParam(value="id", required=true) Integer id, Model model) {
        try {
            Film f = dao.loadFilm(id);
            model.addAttribute("film", f);
        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "error";
        }
        return "film";
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String getCustomer(@RequestParam(value="id", required=true) Integer id, Model model) {
        try {
            Customer c = dao.loadCustomer(id);
            model.addAttribute("customer", c);
            List<Rent> r= dao.getRentByCustomer(id);
            model.addAttribute("rents", r);
        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "error";
        }

        return "customer";
    }

    @RequestMapping(value = "/copy_add", method = RequestMethod.GET)
    public String getCopyAdd(@RequestParam(value="id", required=true) Integer id,
                            @RequestParam(value="type", required=true) Boolean type, Model model) {
        Copy c = new Copy();
        c.setFilm(dao.loadFilm(id));
        c.setIsCd(type);
        dao.addCopy(c);
        return "redirect:copys.form?id=" + id;
    }

    @RequestMapping(value = "/film_add", method = RequestMethod.GET)
    public String getFilmAdd(Model model) {
        model.addAttribute("film", new Film());
        return "film_add";
    }

    @RequestMapping(value = "/film_add", method = RequestMethod.POST)
    public String getFilmAdd(@ModelAttribute("film") Film f, Model model) {
        try {
            dao.addFilm(f);
        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "error";
        }
        return "redirect:films.form";
    }

    @RequestMapping(value = "/customer_add", method = RequestMethod.GET)
    public String getCustomerAdd(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer_add";
    }

    @RequestMapping(value = "/customer_add", method = RequestMethod.POST)
    public String getCustomerAdd(@ModelAttribute("customer") Customer c, Model model) {
        try {
            dao.addCustomer(c);
        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "error";
        }
        return "redirect:customers.form";
    }

    @RequestMapping(value = "/rent", method = RequestMethod.GET)
    public String rent(@RequestParam(value="id", required=true) Integer id, Model model) {
        try {
            Copy c = dao.loadCopy(id);
            Rent rent = new Rent();
            rent.setCopy(c);
            model.addAttribute("rent", rent);
            List<Customer> customers = dao.getAllCustomers();
            model.addAttribute("customers", customers);
        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "error";
        }

        return "rent";
    }

    @RequestMapping(value = "/rent", method = RequestMethod.POST)
    public String getCustomerAdd(@ModelAttribute("rent") Rent r, Model model) {
        try {
            Customer c = dao.loadCustomer(r.getCustomer().getId());
            r.setCustomer(c);
            dao.addRent(r);
        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "error";
        }
        return "redirect:films.form";
    }

    @RequestMapping(value = "/film_del", method = RequestMethod.GET)
    public String delFilm(@RequestParam(value="id", required=true) Integer id, Model model) {
        try {
            Film f = dao.loadFilm(id);
            dao.deleteFilm(f);
        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "error";
        }

        return "redirect:films.form";
    }

    @RequestMapping(value = "/customer_del", method = RequestMethod.GET)
    public String delCustomer(@RequestParam(value="id", required=true) Integer id, Model model) {
        try {
            Customer c = dao.loadCustomer(id);
            dao.deleteCustomer(c);
        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "error";
        }

        return "redirect:customers.form";
    }

    @RequestMapping(value = "/copy_del", method = RequestMethod.GET)
    public String delCopy(@RequestParam(value="id", required=true) Integer id, Model model) {
        try {
            Copy c = dao.loadCopy(id);
            dao.deleteCopy(c);
            return "redirect:copys.form?id=" + c.getFilm().getId();
        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "error";
        }


    }




    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
