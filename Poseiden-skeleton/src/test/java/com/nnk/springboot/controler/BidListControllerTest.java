package com.nnk.springboot.controler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nnk.springboot.controllers.BidListController;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.security.CustomUserDetailsService;
import com.nnk.springboot.security.SecurityConfig;
import com.nnk.springboot.service.BidListService;
import com.nnk.springboot.service.UserService;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 *
 * @author Acer
 */
@WithMockUser(username = "user1", password = "pwd", roles = "ADMIN")
@WebMvcTest(BidListController.class)
public class BidListControllerTest {


    @Autowired
    MockMvc mockMvc;

    @MockBean
    BidListService bidListService;


    @Test
    @Disabled
    void homeTest() throws Exception {
        //Given
        List<BidList> findAll = new ArrayList<>(Arrays.asList(new BidList("account", "type", 10.0), new BidList("account2", "type2", 20.0)));
        //WHEN
        Mockito.when(bidListService.findAll()).thenReturn(findAll);
        //THEN
        mockMvc.perform(get("/bidList/list"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("bidList"))
                .andExpect(MockMvcResultMatchers.model().attribute("bidList", findAll))
                .andExpect(view().name("bidList/list"));
    }

    @Test
    @Disabled
    void addBidFormTest() throws Exception {
        mockMvc.perform(get("/bidList/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("bidList/add"));
    }

    @Test
    @Disabled
    void showUpdateFormTest() throws Exception {
        BidList bidList = new BidList("account", "type", 10.0);
        Mockito.when(bidListService.findbyId(1).get()).thenReturn(bidList);

        mockMvc.perform(get("/bidList/update/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("bidlist"))
                .andExpect(MockMvcResultMatchers.model().attribute("bidlist", bidList))
                .andExpect(view().name("bidList/update"));
    }

}
