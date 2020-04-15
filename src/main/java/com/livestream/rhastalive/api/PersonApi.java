package com.livestream.rhastalive.api;

import com.livestream.rhastalive.dao.PersonDao;
import com.livestream.rhastalive.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class PersonApi {

    private PersonDao personDao;

    @Autowired
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping
    public ModelAndView show() {
        return new ModelAndView("views/index", "person", personDao.get(1));
    }

    @GetMapping("/list")
    public ModelAndView showAll() {
        return new ModelAndView("views/list-person", "persons", personDao.getAll());
    }

    @GetMapping("/add")
    public ModelAndView addPerson(Model model) {
        return new ModelAndView("views/add", "person", new Person());
    }

    @PostMapping("/add")
    public ModelAndView addPerson (@NonNull @ModelAttribute("person") Person person, Model model) {
        personDao.saveOrUpdate(person);
        return new ModelAndView("redirect:/list", "persons", personDao.getAll());
    }

}

