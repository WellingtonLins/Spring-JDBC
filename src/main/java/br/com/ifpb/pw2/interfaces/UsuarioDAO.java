package br.com.ifpb.pw2.interfaces;

import br.com.ifpb.pw2.model.Usuario;

/**
 *
 * @author Rodrigo Bento
 */
public interface UsuarioDAO {
 
    Usuario autentica(String nome, String senha);
    boolean adicionar(Usuario usuario);
    Usuario find(int id);
    
}
