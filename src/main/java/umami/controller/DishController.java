package umami.controller;

import org.springframework.validation.BindingResult;
import umami.model.Dish;
import umami.model.DishType;
import umami.model.UmamiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class DishController implements WebMvcConfigurer {
    @Autowired
    private UmamiService umamiService;

    @RequestMapping(value = "/{locale:en|fr|nl}/home")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dishes")
    public String dishes(Model model) {
        model.addAttribute("dishes", umamiService.getAllDishes());
        return "dishes";
    }

    @GetMapping("/dishes/add")
    public String addDishForm(Model model) {
        return "addDish";
    }

    @PostMapping("/dishes/add")
    public String addDish(@Valid Dish dish, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
            return "addDish";
        } else {
            umamiService.addDish(dish);
            return "redirect:/dishes";
        }
    }

    @GetMapping("/dishes/delete/{name}")
    public String deleteDish(@PathVariable("name") String name) {
        Dish dish = umamiService.findDishByName(name);
        umamiService.deleteDish(dish);
        return "redirect:/dishes";
    }

    @GetMapping("/dishes/update/{name}")
    public String updateDish(@PathVariable("name") String name, Model model) {
        Dish dish = umamiService.findDishByName(name);
        model.addAttribute("dish", dish);
        model.addAttribute("dishTypes", DishType.values());
        return "updateDish";
    }

    @PostMapping("/dishes/update")
    public String updateDish(@Valid Dish dish, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
            model.addAttribute("dishTypes", DishType.values());
            return "updateDish";
        } else {
            umamiService.updateDish(dish);
            return "redirect:/dishes";
        }
    }

    // give the correct error back with this handler, 400 instead of 500
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Requested ID not found!")
    @ExceptionHandler(value = IllegalArgumentException.class)
    public void badIdExecptionHandler() {
        // really nothing to do here
    }
}
