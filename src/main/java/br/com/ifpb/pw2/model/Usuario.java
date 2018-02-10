package br.com.ifpb.pw2.model;

/**
 *
 * @author Rodrigo Bento
 */
public class Usuario {
    
    private int id;
    private String nome;
    private String senha;
//    private String nomeImagem;
    private String caminhoImagem;

    public Usuario() {
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", senha=" + senha + ", caminhoImagem=" + caminhoImagem + '}';
    } 
    
}
