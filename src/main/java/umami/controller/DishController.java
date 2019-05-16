package umami.controller;

import org.springframework.validation.BindingResult;
import umami.model.Dish;
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

    @GetMapping("/dishes/delete/{id}")
    public String deletDish(@PathVariable("id") Long id, Model model) {
        umamiService.deleteByID(id);
        return "redirect:/dishes";
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

    @GetMapping("/dishes/update/{id}")
    public String updateDish(@PathVariable("id") Long id, Model model) {
        Dish dish = umamiService.getDishById(id);
        model.addAttribute("dish", dish);
        return "updateDish";
    }

    @PostMapping("/dishes/update")
    public String updateDish(@Valid Dish dish, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
            model.addAttribute("dish", umamiService.getDishById(dish.getId()));
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
