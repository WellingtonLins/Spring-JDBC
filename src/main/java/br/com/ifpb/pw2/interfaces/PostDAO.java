package br.com.ifpb.pw2.interfaces;

import br.com.ifpb.pw2.model.Post;
import br.com.ifpb.pw2.model.Usuario;
import java.util.List;

/**
 *
 * @author Rodrigo Bento
 */
public interface PostDAO {
    
    boolean cadastrar(Post post);
    List<String> todosPosts(Usuario usuario);
    
}
