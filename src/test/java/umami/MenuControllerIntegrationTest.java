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

import umami.model.DayMenu;
import umami.model.UmamiService;
import umami.model.WeekMenuRepository;

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
    private WeekMenuRepository repo;

    @Test
    public void givenTwoDaymenus_whenGetDaymenus_thenReturnJsonArray() throws Exception {
        ArrayList<DayMenu> weekmenu = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            DayMenu m = MenuBuilder.aMenu().build();
            weekmenu.add(m);
            repo.saveAndFlush(m);
        }

        ArrayList<DayMenu> c = (ArrayList<DayMenu>)weekmenu.clone();

        menuController.perform(get("/weekmenu")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(7)))
                .andExpect(jsonPath("$[" + 0 + "].date").value(weekmenu.get(0).getDate()))
                .andExpect(jsonPath("$[0].dagschotel.name").value(weekmenu.get(0).getDagschotel().getName()))
                .andExpect(jsonPath("$[0].soep.name").value(c.get(0).getSoep().getName()))
                .andExpect(jsonPath("$[0].veggie.name").value(weekmenu.get(0).getVeggie().getName()));

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
        DayMenu menu = MenuBuilder.aMenu().build();

        menuController.perform(post("/daymenu/add")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content("[{\"date\":\"Tue Apr 30 12:17:36 CEST 2019\",\"soep\":{\"id\":null,\"name\":\"Meat\",\"description\":\"heel erg lekker\",\"price\":0.0,\"type\":null},\"dagschotel\":{\"id\":null,\"name\":\"Meat\",\"description\":\"heel erg lekker\",\"price\":0.0,\"type\":null},\"veggie\":{\"id\":null,\"name\":\"Kak met bonen\",\"description\":\"heel erg vies\",\"price\":0.0,\"type\":null},\"day\":\"Tue\"},{\"date\":\"Tue Apr 30 12:17:36 CEST 2019\",\"soep\":{\"id\":null,\"name\":\"Meat\",\"description\":\"heel erg lekker\",\"price\":0.0,\"type\":null},\"dagschotel\":{\"id\":null,\"name\":\"Meat\",\"description\":\"heel erg lekker\",\"price\":0.0,\"type\":null},\"veggie\":{\"id\":null,\"name\":\"Kak met bonen\",\"description\":\"heel erg vies\",\"price\":0.0,\"type\":null},\"day\":\"Tue\"},{\"date\":\"Tue Apr 30 12:17:36 CEST 2019\",\"soep\":{\"id\":null,\"name\":\"Meat\",\"description\":\"heel erg lekker\",\"price\":0.0,\"type\":null},\"dagschotel\":{\"id\":null,\"name\":\"Meat\",\"description\":\"heel erg lekker\",\"price\":0.0,\"type\":null},\"veggie\":{\"id\":null,\"name\":\"Kak met bonen\",\"description\":\"heel erg vies\",\"price\":0.0,\"type\":null},\"day\":\"Tue\"},{\"date\":\"Tue Apr 30 12:17:36 CEST 2019\",\"soep\":{\"id\":null,\"name\":\"Meat\",\"description\":\"heel erg lekker\",\"price\":0.0,\"type\":null},\"dagschotel\":{\"id\":null,\"name\":\"Meat\",\"description\":\"heel erg lekker\",\"price\":0.0,\"type\":null},\"veggie\":{\"id\":null,\"name\":\"Kak met bonen\",\"description\":\"heel erg vies\",\"price\":0.0,\"type\":null},\"day\":\"Tue\"},{\"date\":\"Tue Apr 30 12:17:36 CEST 2019\",\"soep\":{\"id\":null,\"name\":\"Meat\",\"description\":\"heel erg lekker\",\"price\":0.0,\"type\":null},\"dagschotel\":{\"id\":null,\"name\":\"Meat\",\"description\":\"heel erg lekker\",\"price\":0.0,\"type\":null},\"veggie\":{\"id\":null,\"name\":\"Kak met bonen\",\"description\":\"heel erg vies\",\"price\":0.0,\"type\":null},\"day\":\"Tue\"},{\"date\":\"Tue Apr 30 12:17:36 CEST 2019\",\"soep\":{\"id\":null,\"name\":\"Meat\",\"description\":\"heel erg lekker\",\"price\":0.0,\"type\":null},\"dagschotel\":{\"id\":null,\"name\":\"Meat\",\"description\":\"heel erg lekker\",\"price\":0.0,\"type\":null},\"veggie\":{\"id\":null,\"name\":\"Kak met bonen\",\"description\":\"heel erg vies\",\"price\":0.0,\"type\":null},\"day\":\"Tue\"},{\"date\":\"Tue Apr 30 12:17:36 CEST 2019\",\"soep\":{\"id\":null,\"name\":\"Meat\",\"description\":\"heel erg lekker\",\"price\":0.0,\"type\":null},\"dagschotel\":{\"id\":null,\"name\":\"Meat\",\"description\":\"heel erg lekker\",\"price\":0.0,\"type\":null},\"veggie\":{\"id\":null,\"name\":\"Kak met bonen\",\"description\":\"heel erg vies\",\"price\":0.0,\"type\":null},\"day\":\"Tue\"}]"))
                // TODO
//                .content("{\"name\": \"Elke\", \"Daymenu\": \"OK well done!\"}"))
                .andDo(print()); // with this you print the request and response
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0]").value(menu));
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
