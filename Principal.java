public class Principal{
    public static void main(String[] args){
        
        //Apresenta programa
        System.out.println("-------------------------------");
        System.out.println("Bem vindo à biblioteca virtual!");
        System.out.println("-------------------------------");
        
        //Recebe a quantidade de livros na biblioteca
        int qtdeLivros = Teclado.leInt("Digite a quantidade de livros que a sua biblioteca terá: ");
        Biblioteca b1 =new Biblioteca(qtdeLivros);
        System.out.println("---------------------------------------------------------");
        
        //Cria os livros da biblioteca
        for(int i = 1; i <= qtdeLivros; i++){
            if(i ==0){
                System.out.println("Agora vamos inserir os livros na sua biblioteca!\n");
            }
            
            int novoOuAntigo = Teclado.leInt("\nDigite [1] se o livro " + i + " é novo ou [2] se for antigo: ");
            while (novoOuAntigo != 1 && novoOuAntigo != 2){
                novoOuAntigo = Teclado.leInt("Erro. Digite 1 se o livro " + i + " é novo ou 2 se for antigo: ");
            }
            
            b1.insereLivro(Teclado.leString("Digite o nome do livro: "), Teclado.leString("Digite o autor: "), Teclado.leDouble("Digite o preco: R$"),
                       Teclado.leInt("Digite o ano de criação: "), novoOuAntigo);
        }
        
        //Apresenta o menu e solicita a opção desejada
        while(true){
            System.out.println("\n------------------------------------------------------");
            System.out.println("\n Digite o número da operação desejada:");
            System.out.println(" > 1 - Procurar um livro pelo título;\n");
            System.out.println(" > 2 - Verificar o desconto de um livro novo;\n");
            System.out.println(" > 3 - Imprimir todas as edições de livros antigos;\n");
            System.out.println(" > 4 - Exibir os livros conforme o ano de publicação;\n");
            System.out.println(" > 5 - Verificar a média de preços da biblioteca;\n");
            System.out.println(" > 6 - Encontrar o livro com o maior título;\n");
            System.out.println(" > 7 - Imprimir todas as informações de todos os livros da biblioteca;\n");
            System.out.println(" > 8 - Sair do programa.\n");
            
            //Recebe a opção desejada
            int opcao = Teclado.leInt();
            
            //Executa a opção desejada
            while(opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 5 && opcao != 6 && opcao != 7 && opcao != 8){
                opcao = Teclado.leInt("Erro. Digite novamente a opção desejada: ");
            }
            
            //Opção 1
            if (opcao == 1){
                String livroProcurado = Teclado.leString("Digite o título do livro que você deseja encontrar: ");
                if(b1.procuraLivroPorTitulo(livroProcurado) != null){
                    System.out.println(b1.procuraLivroPorTitulo(livroProcurado));
                }else{
                    System.out.println("O livro procurado não existe na biblioteca\n");
                }
            //Opção 2
            } else if (opcao == 2){
                String livroProcurado = Teclado.leString("Digite o título do livro que você deseja verificar o desconto: ");
                if(b1.verificaDesconto(livroProcurado) != -1){
                    System.out.println("Desconto: R$" + b1.verificaDesconto(livroProcurado));
                }else{
                    System.out.println("O livro procurado não existe na biblioteca ou não possui desconto\n");
                }
            //Opção 3
            } else if (opcao == 3){
                System.out.println();
                b1.imprimeEdicoes();
            //Opção 4
            } else if (opcao == 4){
                System.out.println();
                b1.imprimePorAno();
            //Opção 5
            } else if (opcao == 5){
                System.out.println();
                System.out.println("Média de preços da biblioteca: R$" + b1.calculaMediaPreco());
            //Opção 6
            } else if (opcao == 6){
                System.out.println();
                b1.livroComMaiorTitulo();
            //Opção 7
            } else if (opcao == 7){
                System.out.println();
                System.out.println(b1);
            //Opção 8
            } else {
                break;
            }
        }
    }
}