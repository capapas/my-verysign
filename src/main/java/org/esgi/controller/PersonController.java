package org.esgi.controller;

import org.esgi.dao.PersonDao;
import org.esgi.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Transactional(propagation = Propagation.REQUIRED)
public class PersonController {

	@Autowired
	private PersonDao personDao;

	/**
	 * TODO remove this until method (one days ...)
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public String printUser(ModelMap model) {
        Person degree = personDao.findById(1);
        System.out.println(degree.getMail());
        return "contact";
	}
}
