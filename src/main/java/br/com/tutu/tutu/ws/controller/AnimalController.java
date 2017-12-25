package br.com.tutu.tutu.ws.controller;

import br.com.tutu.tutu.ws.model.Animal;
import br.com.tutu.tutu.ws.model.DaoAnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;

@RestController
public class AnimalController {

    @Autowired
    private DaoAnimalRepository animalDao;


    @RequestMapping(method = RequestMethod.GET, value="/animal")
    @ResponseBody
    public Iterable<Animal> get() throws ParseException {

        Iterable<Animal> animal = new ArrayList<Animal>();
        try {
            animal = animalDao.findAll();
        }
        catch (Exception ex) {
            System.out.println("Error searching the Animal: " + ex.toString());
        }
        return animal;
    }

    @RequestMapping(method = RequestMethod.GET, value="/animal/name")
    @ResponseBody
    public Iterable<Animal> get(String name) throws ParseException {

        Iterable<Animal> animal = new ArrayList<Animal>();
        try {
            animal = animalDao.findByNameContains(name);
        }
        catch (Exception ex) {
            System.out.println("Error searching the Animal: " + ex.toString());
        }
        return animal;
    }


    @RequestMapping(method = RequestMethod.POST, value="/animal")
    @ResponseBody
    public String post(String name, Animal.AnimalKind kind, String subKind) throws ParseException {

        String animalId = "";
        try {
            Animal animal = new Animal(name, kind, subKind);
            animalDao.save(animal);
            animalId = String.valueOf(animal.getId());
        }
        catch (Exception ex) {
            return "Error creating the Animal: " + ex.toString();
        }
        return "Animal successfully created with id = " + animalId;
    }


}
