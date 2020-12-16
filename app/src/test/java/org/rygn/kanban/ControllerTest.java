package org.rygn.kanban;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class ControllerTest {

	@Autowired
    protected MockMvc mvc;
	
	protected String accessToken;
	
	protected void obtainAccessToken() throws Exception {
		 
	    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
	    params.add("grant_type", "client_credentials");
	    params.add("scope", "any");
	 
	    ResultActions result = mvc.perform(post("/oauth/token")
							        .params(params)
							        .with(httpBasic("clientId","clientSecret"))
							        .accept("application/json;charset=UTF-8"))
							        .andExpect(status().isOk())
							        .andExpect(content().contentType("application/json;charset=UTF-8"));
	 
	    String resultString = result.andReturn().getResponse().getContentAsString();
	 
	    JacksonJsonParser jsonParser = new JacksonJsonParser();
	    
	    this.accessToken = jsonParser.parseMap(resultString).get("access_token").toString();
	}
	
	@Before
	public void setup() throws Exception {
		obtainAccessToken();
	}
}
