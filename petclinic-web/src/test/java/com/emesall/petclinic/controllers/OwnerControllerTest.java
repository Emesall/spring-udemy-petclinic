package com.emesall.petclinic.controllers;

import static org.hamcrest.CoreMatchers.equalToObject;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.emesall.petclinic.model.Owner;
import com.emesall.petclinic.service.OwnerService;

class OwnerControllerTest {

	private static final String LASTNAME = "test";

	private static final long ID = 1L;

	@InjectMocks
	OwnerController ownerController;

	MockMvc mockMvc;

	@Mock
	OwnerService ownerService;

	@Mock
	Model model;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();

	}
	/*
	 * that way you can test multiple sources
	 * 
	 * @ParameterizedTest
	 * 
	 * @ValueSource(strings = {"/owners", "/owners/index",
	 * "/owners/index.html","/owners/find"})
	 */
/*
	@Test
	@WithMockUser("owner1")  
	void showAccount() throws Exception {
		// given
		Owner owner = Owner.builder()
				.id(1l)
				.username("user")
				.password("pass")
				.firstName("first")
				.lastName("last")
				.build();
		when(ownerService.findById(anyLong())).thenReturn(owner);
		// then
		mockMvc.perform(get("/owners"))
				.andExpect(status().isOk())
				.andExpect(view().name("owners/showOwner"))
				.andExpect(model().attributeExists("owner"));
				//.andExpect(model().attribute("owner", equalToObject(owner)));
	}

	
	@Test
	void initEditOwnerForm() throws Exception {
		// given
		Owner owner = Owner.builder().id(ID).lastName(LASTNAME).build();
		when(ownerService.findById(anyLong())).thenReturn(owner);

		// then
		mockMvc.perform(get("/owners/1/edit"))
				.andExpect(status().isOk())
				.andExpect(view().name("owners/createOrUpdateOwnerForm"))
				.andExpect(model().attributeExists("owner"))
				.andExpect(model().attribute("owner", equalToObject(owner)));

		verify(ownerService).findById(anyLong());

	}

	@Test
	void processEditOwnerForm() throws Exception {
		// given
		Owner owner = Owner.builder().id(ID).lastName(LASTNAME).build();
		when(ownerService.save(any(Owner.class))).thenReturn(owner);
		// then
		mockMvc.perform(post("/owners/1/edit").contentType(MediaType.APPLICATION_FORM_URLENCODED))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/owners/" + ID))
				.andExpect(model().attributeExists("owner"));

		verify(ownerService).save(any(Owner.class));

	}
*/
}
