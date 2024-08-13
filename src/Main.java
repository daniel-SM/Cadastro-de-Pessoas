import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    // Criando objetos de ações do menu
    Actions actions = new Actions();

    // Iniciando Scane para leitura do teclado
    Scanner sc = new Scanner(System.in);

    // Iniciando variável de controle do loop do menu
    boolean loop = true;

    // Loop do menu para escolher as opções
    while (loop) {
      // Imprimindo as opções do menu
      System.out.println("### Menu");
      System.out.println("1. Criar Pessoa");
      System.out.println("2. Buscar Pessoa");
      System.out.println("3. Atualizar Pessoa");
      System.out.println("4. Apagar Pessoa");
      System.out.println("5. Sair");

      // Recebendo a opção escolhida
      System.out.print("\nDigite sua opção: ");
      String option = sc.nextLine();

      // Verificando cada caso das opções
      switch (option) {
        case "1":
          System.out.println("Opção escolhida: " + option + "\n");
          // Realizando ação para criar nova pessoa
          actions.create();
          break;
          
          case "2":
          System.out.println("Opção escolhida: " + option + "\n");
          // Realizando ação para buscar pessoa
          actions.read();
          break;
          
          case "3":
          System.out.println("Opção escolhida: " + option + "\n");
          // Realizando ação para atualizar pessoa
          actions.update();
          break;
          
          case "4":
          System.out.println("Opção escolhida: " + option + "\n");
          // Realizando ação para apagar pessoa
          actions.delete();
          break;

        case "5":
          System.out.println("Saindo...");
          loop = false;
          sc.close();
          break;

        default:
          System.out.println("\nOpção inválida! Tente novamente.\n");
          break;
      } // Fim de switch (option)
    } // Fim de while (loop)
  } // Fim de public static void main()
} // Fim de class Main