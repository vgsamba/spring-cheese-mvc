package org.launchcode.cheesemvc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


/**
 * Created by Vamsee Vennu on 3/14/2019.
 */
@Controller
@RequestMapping("cheese")
public class CheeseController {
    static ArrayList<String> cheeses=new ArrayList<>();

    //Request path : /cheese
    @RequestMapping(value= "")
    //@ResponseBody  // (To pass controller to view) it(rb) allows controller to return text directly from controller(the handler function)
    public String index(Model model)
    {
        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");//Title comes from controller rather than view
        return "cheese/index";//tell spring which template we want to render by giving its name.
        //return "index";

    }

    @RequestMapping(value = "add", method=RequestMethod.GET)
    public String displayAddCheeseForm(Model model)
    {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add"; //sending control to this template
    }

    @RequestMapping(value = "add", method= RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName )
    {
        cheeses.add(cheeseName);
        return "redirect:";

    }

}
