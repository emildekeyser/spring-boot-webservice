package umami.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import umami.model.DayMenu;
import umami.model.UmamiService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class DayMenuController {
    @Autowired
    UmamiService umamiService;

    @GetMapping("/daymenu")
    public List<DayMenu> getDayMenus(){
        return this.umamiService.getDayMenus();
    }

    @PostMapping("/daymenu/add")
    public List<DayMenu> addDayMenu(@RequestBody @Valid DayMenu dayMenu) {
        umamiService.addDayMenu(dayMenu);
        return umamiService.getDayMenus();
    }

    @PatchMapping("/daymenu/change")
    public List<DayMenu> changeDayMenu(@RequestBody @Valid DayMenu dayMenu) {
        umamiService.changeDayMenu(dayMenu);
        return umamiService.getDayMenus();
    }

    @DeleteMapping("/daymenu/delete/{date}")
    public void deleteDayMenu(@PathVariable String date) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("[yyyy-MM-dd][yyyy/MM/dd][dd-MM-yyyy][dd/MM/yyyy]");
        LocalDate parsedDate = LocalDate.parse(date, fmt);
        umamiService.deleteDayMenu(parsedDate);
    }

//    @ResponseStatus(HttpStatus.CREATED)

//    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "wrong")
//    @ExceptionHandler(value = IllegalArgumentException.class)
//    public void badIdExceptionHandler() {
//    }
}
