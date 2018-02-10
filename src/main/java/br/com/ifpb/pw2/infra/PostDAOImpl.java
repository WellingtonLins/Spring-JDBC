package br.com.ifpb.pw2.infra;

import br.com.ifpb.pw2.interfaces.PostDAO;
import br.com.ifpb.pw2.model.Post;
import br.com.ifpb.pw2.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rodrigo Bento
 */
@Repository
public class PostDAOImpl implements PostDAO{

    @Autowired
    private Connection con;
    
    @Override
    public boolean cadastrar(Post post) {
        boolean cond = false;
        String sql = "INSERT INTO post (mensagem, usuario_id) VALUES (?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, post.getMensagem());
            stmt.setInt(2, post.getUsuario().getId());
            cond = stmt.executeUpdate() > 0;
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cond;
    }

    @Override
    public List<String> todosPosts(Usuario usuario) {
        String sql = "SELECT * FROM post WHERE usuario_id = ?";
        List<String> posts = new ArrayList<>();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, usuario.getId());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                posts.add(rs.getString("mensagem"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return posts;
    }
    
}
