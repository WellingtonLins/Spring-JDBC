package br.com.ifpb.pw2.infra;

import br.com.ifpb.pw2.interfaces.UsuarioDAO;
import br.com.ifpb.pw2.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rodrigo Bento
 */
@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

    @Autowired
    private Connection con;

    public UsuarioDAOImpl() {
    }

    @Override
    public Usuario autentica(String nome, String senha) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setCaminhoImagem(rs.getString("caminhoImagem"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return usuario;
    }

    @Override
    public boolean adicionar(Usuario usuario) {
        boolean cond = false;
        String sql = "INSERT INTO usuario (nome, senha, caminhoImagem) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getCaminhoImagem());
            cond = stmt.executeUpdate() > 0;
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cond;
    }

    @Override
    public Usuario find(int id) {
        Usuario usuario = new Usuario();
        String sql = "SELECT usuario (nome, senha, caminhoImagem) where id= ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                usuario.setCaminhoImagem(result.getString("caminhoImagem"));
                usuario.setNome(result.getString("nome"));
                usuario.setSenha(result.getString("senha"));
            } else {
                return null;
              } 
        }catch (SQLException ex) {
            ex.printStackTrace();
        
        }
        return usuario;
    }

}
