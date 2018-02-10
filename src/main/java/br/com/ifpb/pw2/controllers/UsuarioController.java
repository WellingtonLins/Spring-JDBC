
package br.com.ifpb.pw2.controllers;

import br.com.ifpb.pw2.interfaces.UsuarioService;
import br.com.ifpb.pw2.model.Usuario;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Rodrigo Bento
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;
    
    @PostMapping(value = "/adicionar")
    public ModelAndView addUsuario(Usuario usuario, @RequestParam("foto") MultipartFile file) 
            throws FileNotFoundException, IOException{
        ModelAndView mv = new ModelAndView("redirect:/");
        service.adicionar(usuario, file);
        return mv;
    }
    
        @GetMapping(value = "/load/{id}")     
        public String load(@PathVariable("id") int id){
    
        Usuario usuario = service.find(id);
        return  usuario.getCaminhoImagem();
    }
    
    @PostMapping(value = "/autenticar")
    public ModelAndView attUsuario(Usuario usuario){
        ModelAndView mv = new ModelAndView("/home.jsp");
        Usuario aux = service.autenticar(usuario);
        mv.addObject("usuario", aux);
        return mv;
    }
    
}
