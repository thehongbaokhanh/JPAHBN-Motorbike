package com.example.jpahbnmotorbike.controller;

import com.example.jpahbnmotorbike.model.Motorbike;
import com.example.jpahbnmotorbike.service.IMotorbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/motorbikes")
public class MotorbikeController {
    @Autowired
    private IMotorbikeService motorbikeService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("motorbikes", motorbikeService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("motorbike", new Motorbike());
        model.addAttribute("action", "Add new");
        return "createAndUpdate";
    }

    @GetMapping("/edit/{id}")
    public String update(Model model, @PathVariable long id) {
        model.addAttribute("motorbike", motorbikeService.findById(id));
        model.addAttribute("action", "Update");
        return "createAndUpdate";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Motorbike motorbike) {
        motorbikeService.save(motorbike);
        return "redirect:/motorbikes";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id, Model model) {
        Motorbike motorbike = motorbikeService.findById(id);
        model.addAttribute("motorbike", motorbike);
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Motorbike motorbike) {
        motorbikeService.delete(motorbike.getId());
        return "redirect:/motorbikes";
    }

    @GetMapping("/information/{id}")
    public String information(@PathVariable long id, Model model) {
        model.addAttribute("motorbike", motorbikeService.findById(id));
        return "information";
    }

    @PostMapping("/searchByName")
    public String searchByName(@RequestParam String name, Model model) {
        if (name != null) {
            model.addAttribute("motorbikes", motorbikeService.findByName(name));
            return "index";
        } else {
            return "redirect:/motorbikes";
        }
    }

    @GetMapping("/bestSeller")
    public String bestSeller(Model model) {
        model.addAttribute("motorbikes", motorbikeService.findByBestSelling());
        return "index";
    }

}
