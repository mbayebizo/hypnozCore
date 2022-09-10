package net.hypnozcore.hypnozcore.controller;

import net.hypnozcore.hypnozcore.dto.ApplicationConstantDto;
import net.hypnozcore.hypnozcore.service.ApplicationConstantService;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Transactional
public class ApplicationConstantControllerTest {
    private static final String ENDPOINT_URL = "/api/application-constant";
    @InjectMocks
    private ApplicationConstantController applicationconstantController;
    @Mock
    private ApplicationConstantService applicationconstantService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(applicationconstantController)
                //.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                //.addFilter(CustomFilter::doFilter)
                .build();
    }

    @Test
    public void findAllByPage() throws Exception {
        Page<ApplicationConstantDto> page = new PageImpl<>(Collections.singletonList(ApplicationConstantBuilder.getDto()));

        Mockito.when(applicationconstantService.findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(page);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.content", Matchers.hasSize(1)));

        Mockito.verify(applicationconstantService, Mockito.times(1)).findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any());
        Mockito.verifyNoMoreInteractions(applicationconstantService);

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(applicationconstantService.findById(ArgumentMatchers.anyString())).thenReturn(ApplicationConstantBuilder.getDto());

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(applicationconstantService, Mockito.times(1)).findById("1");
        Mockito.verifyNoMoreInteractions(applicationconstantService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(applicationconstantService.save(ArgumentMatchers.any(ApplicationConstantDto.class))).thenReturn(ApplicationConstantBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(ApplicationConstantBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(applicationconstantService, Mockito.times(1)).save(ArgumentMatchers.any(ApplicationConstantDto.class));
        Mockito.verifyNoMoreInteractions(applicationconstantService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(applicationconstantService.update(ArgumentMatchers.any(), ArgumentMatchers.anyString())).thenReturn(ApplicationConstantBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(ApplicationConstantBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(applicationconstantService, Mockito.times(1)).update(ArgumentMatchers.any(ApplicationConstantDto.class), ArgumentMatchers.anyString());
        Mockito.verifyNoMoreInteractions(applicationconstantService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(applicationconstantService).deleteById(ArgumentMatchers.anyString());
        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(CustomUtils.asJsonString(ApplicationConstantBuilder.getIds()))).andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(applicationconstantService, Mockito.times(1)).deleteById(Mockito.anyString());
        Mockito.verifyNoMoreInteractions(applicationconstantService);
    }
}