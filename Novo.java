public class Novo extends Livro{
    
    //Atributo específico da classe
    private double desconto;
    
    //Construtor vazio
    public Novo(){
    }
    
    //Construtor completo
    public Novo(String titulo, String autor, double preco, int anoCriacao, double desconto){
        super(titulo, autor, preco, anoCriacao);
        this.desconto = desconto;
    }
    
    //Getter & setter
    public double getDesconto(){
        return this.desconto;
    }
    public void setDesconto(double desconto){
        this.desconto = desconto;
    }
    
    //Reescrita do toString
    @Override
    public String toString(){
        String retorno = "";
        retorno += super.toString();
        retorno += "Desconto: R$" + this.getDesconto() + "\n";
        return retorno;
    }
}