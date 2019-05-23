package umami.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import umami.model.DayMenu;
import umami.model.UmamiService;
import umami.model.WeekMenu;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class WeekMenuController {
    @Autowired
    UmamiService umamiService;

    @GetMapping("/weekmenu")
    public List<WeekMenu> getWeekMenus() {
        return this.umamiService.getWeekMenus();
    }

    @GetMapping("/weekmenu/{id}")
    public WeekMenu getWeekMenu(@PathVariable int id) {
        return this.umamiService.getWeekMenuById(id).orElseThrow(IllegalArgumentException::new);
    }
}

