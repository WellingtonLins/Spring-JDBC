package br.com.ifpb.pw2.infra;

import br.com.ifpb.pw2.interfaces.UsuarioDAO;
import br.com.ifpb.pw2.interfaces.UsuarioService;
import br.com.ifpb.pw2.model.Usuario;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Rodrigo Bento
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDAO dao;

    @Override
    public Usuario autenticar(Usuario usuario) {
        return dao.autentica(usuario.getNome(), usuario.getSenha());
    }

    @Override
    public boolean adicionar(Usuario usuario, MultipartFile arquivo) {
        if (autenticar(usuario) != null) {
            return false;
        } else {
            salvarImagem(usuario, arquivo);
            dao.adicionar(usuario);
            return true;
        }
    }

    public void salvarImagem(Usuario usuario, MultipartFile arquivo) {
        String caminho = "src/main/webapp/imagens/" + usuario.getNome();
        try {
            File folderUser = new File(caminho);
            if (!folderUser.exists()) {
                folderUser.mkdir();
            }
            
            File arq = new File(caminho + "/" + arquivo.getOriginalFilename());
            
            FileOutputStream out = new FileOutputStream(arq);
            out.write(arquivo.getBytes());
            out.close();
            
            usuario.setCaminhoImagem("/imagens/" + usuario.getNome() + "/" + arquivo.getOriginalFilename());            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Usuario find(int id) {
       return  dao.find(id);
    }

}
