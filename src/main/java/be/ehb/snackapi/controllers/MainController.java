package be.ehb.snackapi.controllers;

import be.ehb.snackapi.model.Snack;
import be.ehb.snackapi.model.SnackDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@Controller
public class MainController {

    private SnackDataAccess snackDAO;

    @Autowired
    public MainController(SnackDataAccess snackDAO) {
        this.snackDAO = snackDAO;
    }

    @RequestMapping(value = "/welcome",
            method = RequestMethod.GET)
    @ResponseBody
    public String welcome(){
        return "hello world";
    }

    @RequestMapping(value = "/snacks",
            method = RequestMethod.GET)
    @ResponseBody
    public HashSet<Snack> getAllSnacks(){
        return snackDAO.getSnacks();
    }

    @RequestMapping(value = "/snacks",
                    method = RequestMethod.POST)
    @ResponseBody
    public HttpStatus addSnack(@RequestParam("id") int id,
                               @RequestParam("naam") String naam,
                               @RequestParam("prijs") double prijs){
        Snack nieuweSnackVanAPI = new Snack(id, naam, prijs);
        snackDAO.addSnack(nieuweSnackVanAPI);

        return HttpStatus.OK;
    }

    @RequestMapping(value="/snacks/{pathID}", method = RequestMethod.GET)
    //@GetMapping("/snacks/{pathID}")
    @ResponseBody
    public Snack snackByID(@PathVariable("pathID") int id){
        return snackDAO.searchById(id);
    }
}
