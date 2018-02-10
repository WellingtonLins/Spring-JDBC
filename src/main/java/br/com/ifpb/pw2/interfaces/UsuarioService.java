package br.com.ifpb.pw2.interfaces;

import br.com.ifpb.pw2.model.Usuario;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Rodrigo Bento
 */
public interface UsuarioService {

    Usuario autenticar(Usuario usuario);
    boolean adicionar(Usuario usuario, MultipartFile arquivo);
    Usuario find(int id);    
}
