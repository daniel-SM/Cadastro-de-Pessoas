import java.io.Console;

/**
 * A classe Main contém o ponto de entrada do programa (o método main) e gerencia o menu principal para as operações de criar, buscar, atualizar e deletar registros de pessoas.
 */
class Main {
  public static void main(String[] args) {
    // Iniciando Scane para leitura do teclado
    Console c = System.console();

    // Verificando se há console disponível
    if (c == null) {
      System.out.println("Console não disponível!");
      System.exit(1);
    }
    // Criando objetos de ações do menu
    Actions actions = new Actions(c);

    // Iniciando variável de controle do loop do menu
    boolean loop = true;

    // Loop do menu para escolher as opções
    while (loop) {
      // Imprimindo as opções do menu
      System.out.println("\n### Menu");
      System.out.println("1. Criar Pessoa");
      System.out.println("2. Buscar Pessoa");
      System.out.println("3. Atualizar Pessoa");
      System.out.println("4. Apagar Pessoa");
      System.out.println("5. Sair");

      // Recebendo a opção escolhida
      System.out.print("\nDigite sua opção: ");
      String option = c.readLine();

      // Quebrando linha no terminal
      System.out.println();

      // Verificando cada caso das opções
      switch (option) {
        case "1":
          // Realizando ação para criar nova pessoa
          actions.create();
          break;
          
          case "2":
          // Realizando ação para buscar pessoa
          actions.read();
          break;
          
          case "3":
          // Realizando ação para atualizar pessoa
          actions.update();
          break;
          
          case "4":
          // Realizando ação para apagar pessoa
          actions.delete();
          break;

        case "5":
          System.out.println("Saindo...");
          loop = false;
          break;

        default:
          System.out.println("Opção inválida! Tente novamente.");
          break;
      } // Fim de switch (option)
    } // Fim de while (loop)
  } // Fim de public static void main()
} // Fim de class Main