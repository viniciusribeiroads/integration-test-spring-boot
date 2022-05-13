package br.com.senai.brabankapi;

import br.com.senai.brabankapi.domain.Usuario;
import br.com.senai.brabankapi.resources.UsuariosResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Before;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


public class UsuarioResourceTest extends BrabankapiApplicationTests{


    private MockMvc mockMvc;

    @Autowired
    private UsuariosResource usuariosResource;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(usuariosResource).build();
    }

    @org.junit.Test
    public void criarUsuarioComDadosCorretos_RetornarStatusCode201() throws Exception {
        Usuario usuario = new Usuario(null,"João","12345678910","teste@teste.com","M","123456");
        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(usuario);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.header()
                        .string("location", Matchers.containsString("http://localhost/usuarios")));
    }

    @org.junit.Test
    public void criarUsuarioComDadosErrados_RetornarStatusCode400() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("")
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }



}
