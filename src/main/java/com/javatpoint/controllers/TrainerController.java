package com.javatpoint.controllers;

import java.util.List;

import com.javatpoint.beans.Trainer;
import com.javatpoint.dao.TrainerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TrainerController {
    @Autowired
    TrainerDao dao;//will inject dao from xml file

    /*It displays a form to input data, here "command" is a reserved request attribute
     *which is used to display object data into form
     */
    @RequestMapping("/trainerForm")
    public String showForm(Model model){
        model.addAttribute("command", new Trainer());
        return "trainerForm";
    }
    /*It saves object into database. The @ModelAttribute puts request data
     *  into model object. You need to mention RequestMethod.POST method
     *  because default request is GET*/
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("trainer") Trainer trainer){
        dao.save(trainer);
        return "redirect:/viewTrainer";//will redirect to viewTrainer request mapping
    }
    /* It provides list of trainers in model object */
    @RequestMapping("/viewTrainer")
    public String viewTrainer(Model model){
        List<Trainer> list=dao.getTrainers();
        model.addAttribute("list",list);
        return "viewTrainer";
    }
    /* It displays object data into form for the given id.
     * The @PathVariable puts URL data into variable.*/
    @RequestMapping(value= "/editTrainer/{id}")
    public String edit(@PathVariable int id, Model model){
        Trainer trainer=dao.getTrainerById(id);
        model.addAttribute("command",trainer);
        return "trainerEditForm";
    }
    /* It updates model object. */
    @RequestMapping(value= "/editSave",method = RequestMethod.POST)
    public String editSave(@ModelAttribute("trainer") Trainer trainer){
        dao.update(trainer);
        return "redirect:/viewTrainer";
    }
    /* It deletes record for the given id in URL and redirects to /viewTrainer */
    @RequestMapping(value= "/deleteTrainer/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        dao.delete(id);
        return "redirect:/viewTrainer";
    }
}