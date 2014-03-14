package org.esgi.controller;

import org.esgi.dao.PersonDao;
import org.esgi.model.Ca;
import org.esgi.model.Certificat;
import org.esgi.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
@Transactional(propagation = Propagation.REQUIRED)
public class PersonController {

	@Autowired
	private PersonDao personDao;

    @RequestMapping(value = "/add-cert", method = RequestMethod.GET)
    public String addCert(ModelMap model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Person userConnected = personDao.findByName(authentication.getName());

        model.addAttribute("userConnected", userConnected);

        return "addCert";
    }


    @RequestMapping(value = "/add-cert", method = RequestMethod.POST)
    public String addCertPost(ModelMap model, HttpServletRequest request) {

        //param =>
        //certname
        //country
        //state
        //city
        //compagny
        //section
        //commonName
        //email
        // récupérer un paramètre => request.getAttribute("certname")


        System.out.println(request.getAttribute("certname"));

        // rajouter redirect
        return "listCert";
    }

    @RequestMapping(value = "/test-cert", method = RequestMethod.GET)
    public String testAddCert(ModelMap model) {

        Certificat certificat = new Certificat();
        certificat.setCertName("toto12");
        certificat.setCommonName("toto12");
        certificat.setCompagny("toto12");
        certificat.setCountryName("FR");
        certificat.setEmail("maxime.horcholl12e@gmail.com");
        certificat.setSection("IT");
        certificat.setState("Paris");

        Ca ca = new Ca();
        certificat = ca.generateCert(certificat);

        return "index";
    }

}
