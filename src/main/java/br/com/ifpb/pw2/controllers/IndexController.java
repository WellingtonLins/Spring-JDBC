package br.com.ifpb.pw2.controllers;

import br.com.ifpb.pw2.interfaces.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Rodrigo Bento
 */
@RequestMapping("/")
public class IndexController {
    
    @Autowired
    private UsuarioDAO dao;
    
    @RequestMapping(method = RequestMethod.GET)
    public String getIndex(){
        return "/index.jsp";
    }
    
}
