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

    @GetMapping("/{id}/update")
    public String update(Model model,@PathVariable long id) {
        model.addAttribute("motorbike", motorbikeService.findById(id));
        model.addAttribute("action", "Update");
        return "createAndUpdate";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Motorbike motorbike) {
        motorbikeService.save(motorbike);
        return "redirect:/motorbikes";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable long id, Model model) {
        model.addAttribute("motorbike", motorbikeService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Motorbike motorbike) {
        motorbikeService.delete(motorbike.getId());
        return "redirect:/motorbikes";
    }
}
