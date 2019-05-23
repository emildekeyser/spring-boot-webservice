package umami;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import umami.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class MenuControllerIntegrationTest {

    @Autowired
    private MockMvc menuController;
    @Autowired
    private DishesRepository dishesRepo;
    @Autowired
    private DayMenuRepository dayMenuRepo;

    @Test
    public void givenTwoDaymenus_whenGetDaymenus_thenReturnJsonArray() throws Exception {
//        Dish soup = DishBuilder.aSoup().build();
//        dishesRepo.saveAndFlush(soup);
//        Dish mainCourse = DishBuilder.aMainCourse().build();
//        dishesRepo.saveAndFlush(mainCourse);
//        Dish veg = DishBuilder.aVegDish().build();
//        dishesRepo.saveAndFlush(veg);
//
//        ArrayList<DayMenu> weekmenu = new ArrayList<>();
//        for (int i = 0; i < 7; i++) {
//            DayMenu m = new MenuBuilder()
//                    .withDate(LocalDate.now())
//                    .withSoep(soup)
//                    .withDagschotel(mainCourse)
//                    .withVeggie(veg)
//                    .build();
//            weekmenu.add(m);
//            this.dayMenuRepo.saveAndFlush(m);
//        }
//
//        ArrayList<DayMenu> c = (ArrayList<DayMenu>)weekmenu.clone();

        menuController.perform(get("/daymenu")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(5*2)))
                .andExpect(jsonPath("$[" + 0 + "].date").value(LocalDate.of(2019, 4, 22).toString()))
//                .andExpect(jsonPath("$[" + 0 + "].date").value("2019-04-22"))
                .andExpect(jsonPath("$[0].soep.name").value("kak"));
//                .andExpect(jsonPath("$[0].dagschotel.name").value(weekmenu.get(0).getDagschotel().getName()))
//                .andExpect(jsonPath("$[0].veggie.name").value(weekmenu.get(0).getVeggie().getName()));

////        for (int i = 0; i < 7; i++) {
////            json.andExpect(jsonPath("$[" + i + "].day").value(weekmenu.get(i).getDay()))
////                    .andExpect(jsonPath("$[" + i + "].date").value(weekmenu.get(i).getDate().toString()))
////                    .andExpect(jsonPath("$[" + i + "].dagshotel").value(weekmenu.get(i).getDagschotel()))
////                    .andExpect(jsonPath("$[" + i + "].soep").value(weekmenu.get(i).getSoep()))
////                    .andExpect(jsonPath("$[" + i + "].veggie").value(weekmenu.get(i).getVeggie()));
////        }
    }

    @Test
    public void givenNoDaymenus_whenAddDaymenu_thenReturnJsonArray() throws Exception {
        String json = "  {";
        json += "    \"date\": \"2019-05-06\",";
        json += "    \"soep\": {";
        json += "      \"id\": 1,";
        json += "      \"name\": \"kak\",";
        json += "      \"description\": \"VIES\",";
        json += "      \"price\": 0.5,";
        json += "      \"type\": \"Soup\"";
        json += "    },";
        json += "    \"dagschotel\": {";
        json += "      \"id\": 2,";
        json += "      \"name\": \"kak2\",";
        json += "      \"description\": \"heeldjlvies\",";
        json += "      \"price\": 0.4,";
        json += "      \"type\": \"MainCourse\"";
        json += "    },";
        json += "    \"veggie\": {";
        json += "      \"id\": 3,";
        json += "      \"name\": \"kak3\",";
        json += "      \"description\": \"heel dsfjgvies\",";
        json += "      \"price\": 0.7,";
        json += "      \"type\": \"Veggie\"";
        json += "    },";
        json += "    \"dayOfWeek\": 5,";
        json += "    \"dayName\": \"Friday\",";
        json += "    \"yearAndWeekNumber\": 201918";
        json += "  }";

        menuController.perform(post("/daymenu/add")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(json))
                    .andDo(print()) //; // with this you print the request and response
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(11)))
                    .andExpect(jsonPath("$[10].date").value("2019-05-06"));
    }

    @Test
    public void givenNoDaymenus_whenAddDaymenuWithNoValidDaymenu_thenReturnJsonArray() throws Exception {
//        DaymenuController.perform(post("/Daymenus/add")
//                .contentType(MediaType.APPLICATION_JSON)
//                .characterEncoding("UTF-8")
//                .content("{\"name\": \"Yuki\", \"Daymenu\": \"OK\"}"))
//                //.andDo(print())
//                .andExpect(status().isNotFound())
//                .andExpect(content().string("size must be between 5 and 80"));
    }

}

