public class Antigo extends Livro{
    
    //Atributo específico da classe
    private int edicao;
    
    //Construtor vazio
    public Antigo(){
    }
    
    //Construtor completo
    public Antigo(String titulo, String autor, double preco, int anoCriacao, int edicao){
        super(titulo, autor, preco, anoCriacao);
        this.edicao = edicao;
    }
    
    //Getter & setter
    public int getEdicao(){
        return this.edicao;
    }
    public void setEdicao(int edicao){
        this.edicao = edicao;
    }
    
    //Reescrita do toString
    @Override
    public String toString(){
        String retorno = "";
        retorno += super.toString();
        retorno += "Edição: " + this.getEdicao() + "\n";
        return retorno;
    }
}