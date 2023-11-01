public class Biblioteca extends Livro{
    
    //Cria atributo específico da classe
    private Livro[] livros;
    
    //Construtor
    public Biblioteca(int quantidadeDeLivros){
        livros = new Livro[quantidadeDeLivros];
    }
    
    //Getter & setter
    public Livro[] getLivros(){
        return this.livros;
    }
    public void setLivros(Livro[] livros){
        this.livros = livros;
    }
    
    //Método que insere os livros no array de livros do atributo 
    public boolean insereLivro(String titulo, String autor, double preco, int anoCriacao, int novoOuAntigo){
        
        for(int i = 0; i < livros.length; i++){
            if(livros[i] == null && titulo != null && autor != null && preco != 0.0 && anoCriacao != 0 && novoOuAntigo == 1){
                livros[i] = new Novo(titulo, autor, preco, anoCriacao, Teclado.leDouble("Digite o desconto do livro: "));
                return true;
            }else if(livros[i] == null && titulo != null && autor != null && preco != 0.0 && anoCriacao != 0 && novoOuAntigo == 2){
                livros[i] = new Antigo(titulo, autor, preco, anoCriacao, Teclado.leInt("Digite a edição do livro: "));
                return true;
            }
        }
        return false;
    }
    
    //Método que procura o livro por título
    public Livro procuraLivroPorTitulo(String titulo){
        int cont = 0;
        for(int i = 0; i < livros.length; i++){
            if(livros[i].getTitulo().equalsIgnoreCase(titulo)){
                cont++;
                return livros[i];
            }
        }
        return null;
    }
    
    //Método que verifica o desconto do livro a partir do título desejado
    public double verificaDesconto(String titulo){
        for(int i = 0; i < livros.length; i++){
            if(livros[i].getTitulo().equalsIgnoreCase(titulo) && livros[i] instanceof Novo){
                return ((Novo)livros[i]).getDesconto();
            }
        }
        return -1;
    }
    
    //Método que imprime as edições e livros antigos
    public void imprimeEdicoes(){
        for(int i = 0; i < livros.length; i++){
            if(i == 0){
                System.out.println("Edições dos livros da biblioteca");
            }
            if(livros[i] instanceof Antigo){
                System.out.println("\nTítulo" + (i + 1) + ": " + livros[i].getTitulo());
                System.out.println("Edição: " + ((Antigo)livros[i]).getEdicao());
            }
        }
    }
    
    //Método que imprime os livros por ordem decrescente de ano de criação
    public void imprimePorAno() {
        for (int i = 0; i < livros.length - 1; i++) {
            for (int j = 0; j < livros.length - i - 1; j++) {
                if (livros[j].getAnoCriacao() < livros[j + 1].getAnoCriacao()) {
                    Livro temp = livros[j];
                    livros[j] = livros[j + 1];
                    livros[j + 1] = temp;
                }
            }
        }

        System.out.println("Livros por ordem decrescente de publicação:");
        for (int i = 0; i < livros.length; i++) {
            System.out.println(livros[i].toString());
        }
    }
    
    //Método que calcula a média de preços de todos os livros da biblioteca
    public double calculaMediaPreco(){
        double somatorio = 0;
        for(int i = 0; i < livros.length; i++){
            somatorio += livros[i].getPreco();
        }
        double media = somatorio / livros.length;
        return media;
    }
    
    //Método que imprime o título do livro com o título mais longo e a sua quantidade de caracteres. Retorna a quantidade de caracteres.
    public int livroComMaiorTitulo(){
        String maiorTitulo = "";
        for(int i = 0; i < livros.length; i++){
            if (livros[i].getTitulo().length() > maiorTitulo.length()){
                maiorTitulo = this.livros[i].getTitulo();
            }
        }
        System.out.println("Título: " + maiorTitulo);
        System.out.println("Quantidade de caracteres: " + maiorTitulo.length());
        return maiorTitulo.length();
    }
        
    //Reescrita do toString
    @Override
    public String toString(){
        String retorno = "Livros da biblioteca: \n\n";
        for(int i = 0; i < livros.length; i++){
            if(livros[i] instanceof Novo){
                retorno += "\n" + ((Novo)livros[i]).toString();
            } else if(livros[i] instanceof Antigo){
                retorno += "\n" + ((Antigo)livros[i]).toString();
            }
        }
        return retorno;
    }
}