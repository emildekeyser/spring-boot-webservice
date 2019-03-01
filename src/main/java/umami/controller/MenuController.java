package umami.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import umami.model.DayMenu;
import umami.model.UmamiService;

import java.util.List;

@RestController
public class MenuController {
    @Autowired
    UmamiService umamiService;

    @GetMapping("weekmenu")
    public List<DayMenu> getWeekMenu() {
        return umamiService.getWeekMenu();
    }

//    @PostMapping("feedback")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Feedback createNewFeedback(@RequestBody @Valid Feedback feedback) {
//        int id = feedbackService.addFeedback(feedback);
//        return feedbackService.findFeedbackById(id);
//    }
//
//    @GetMapping("feedback/id/{foo}")
//    public Feedback getSpecificFeedbackById(@PathVariable("foo") int id) {
//        return feedbackService.findFeedbackById(id);
//    }
//
//    @GetMapping("feedback/name/{name}")
//    public List<Feedback> getSpecificFeedbackByName(@PathVariable() String name) {
//        return feedbackService.findFeedbackByName(name);
//    }
//
//    // When a client needs to replace an existing Resource entirely, they can use PUT.
//    // When they’re doing a partial update, they can use HTTP PATCH.
//    @PutMapping("feedback/{id}")
//    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
//    public Feedback editSpecificWholeFeedback(@PathVariable("id") int id, @RequestBody @Valid Feedback changedFeedback) {
//        return feedbackService.changeFeedback(id, changedFeedback);
//    }
//
//    // When a client needs to replace an existing Resource entirely, they can use PUT.
//    // When they’re doing a partial update, they can use HTTP PATCH.
//    /*
//    @PatchMapping("feedback/{id}")
//     /* Will be implemented later! Rather complicated :-)
//    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
//    public Feedback editSpecificPartialFeedback(@PathVariable("id") int id, @RequestBody @Valid Feedback changedFeedback) {
//        return feedbackService.changeFeedback(id, changedFeedback);
//    }
//    */
//
//    @DeleteMapping("feedback/{id}")
//    // HTTP 204 No Content: The server successfully processed the request,
//    // but is not returning any content
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteFeedback(@PathVariable("id") int id) {
//        feedbackService.deleteFeedback(id);
//    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Requested feedback not found!")
    @ExceptionHandler(value = IllegalArgumentException.class)
    public void badIdExceptionHandler() {
    }
}



