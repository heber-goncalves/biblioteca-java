public class Livro{
    
    //Atributos da classe
    private String titulo;
    private String autor;
    private double preco;
    private int anoCriacao;
    
    //Construtor vazio
    public Livro(){
    }
    
    //Construtor completo
    public Livro(String titulo, String autor, double preco, int anoCriacao){
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        this.anoCriacao = anoCriacao;
    }
    
    //Getters & setters
    public String getTitulo(){
        return this.titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public String getAutor(){
        return this.autor;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    
    public double getPreco(){
        return this.preco;
    }
    public void setPreco(double preco){
        this.preco = preco;
    }
    
    public int getAnoCriacao(){
        return this.anoCriacao;
    }
    public void setAnoCriacao(int anoCriacao){
        this.anoCriacao = anoCriacao;
    }
    
    //Sobrescrita do toString
    @Override
    public String toString(){
        String retorno = "";
        retorno += "Título do livro: " + this.getTitulo() + "\n";
        retorno += "Autor: " + this.getAutor() + "\n";
        retorno += "Preço: R$" + this.getPreco() + "\n";
        retorno += "Ano de criação: " + this.getAnoCriacao() + "\n";
        
        return retorno; 
    }
}