package org.esgi.controller;

import org.esgi.dao.CertificatDao;
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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Controller
@Transactional(propagation = Propagation.REQUIRED)
public class PersonController {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private CertificatDao certificatDao;

    @RequestMapping(value = "/add-cert", method = RequestMethod.GET)
    public String addCert(ModelMap model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Person userConnected = personDao.findByName(authentication.getName());

        model.addAttribute("userConnected", userConnected);

        return "addCert";
    }


    @RequestMapping(value = "/add-cert", method = RequestMethod.POST)
    public String addCertPost(ModelMap model, HttpServletRequest request) {

        // Création du certificat et insertion dans la BDD
        Certificat certificat = new Certificat();
        certificat.setCertName(request.getParameter("certname") + "");
        certificat.setCountryName(request.getParameter("country") + "");
        certificat.setState(request.getParameter("state") + "");
        certificat.setSection(request.getParameter("city") + "");
        certificat.setCompagny(request.getParameter("compagny") + "");
        certificat.setCommonName(request.getParameter("commonName") + "");
        certificat.setEmail(request.getParameter("email") + "");

        Date startValidity = new Date();
        certificat.setStartValidity(startValidity.toString());
        Date endValidity = new Date();
        endValidity.setTime(startValidity.getTime() + (365 * 24 * 60 * 60));

        certificat.setEndValidity(endValidity.toString());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Person userConnected = personDao.findByName(authentication.getName());

        certificat.setContent("");

        certificat.setPerson(userConnected);

        System.out.println(certificat);

        //save certificate
        certificatDao.save(certificat);

        // rajouter redirect
        return "redirect:/list-cert.htm";
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

    @RequestMapping(value = "/list-cert", method = RequestMethod.GET)
    public String listCert(ModelMap model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Person userConnected = personDao.findByName(authentication.getName());

        model.addAttribute("userConnected", userConnected);

        return "listCert";
    }
}
