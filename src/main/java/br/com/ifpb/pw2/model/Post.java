package br.com.ifpb.pw2.model;

/**
 *
 * @author Rodrigo Bento
 */
public class Post {

    private String mensagem;
    private Usuario usuario;

    public Post() {
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Post{" + "mensagem=" + mensagem + ", usuario=" + usuario + '}';
    }
    
}
