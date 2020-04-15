package com.livestream.rhastalive.api;

import com.livestream.rhastalive.dao.CustomerDao;
import com.livestream.rhastalive.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class CustomerAPi {

    private CustomerDao personDao;

    @Autowired
    public void setPersonDao(CustomerDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping
    public ModelAndView show() {
        return null;
    }

    @GetMapping("/list")
    public ModelAndView showAll() {
        return null;
    }

    @GetMapping("/add")
    public ModelAndView addPerson(Model model) {
        return new ModelAndView("views/add", "person", new Customer());
    }

    @PostMapping("/add")
    public ModelAndView addPerson (@NonNull @ModelAttribute("person") Customer person, Model model) {
        personDao.saveOrUpdate(person);
        return null;
    }

}

