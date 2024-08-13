import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    boolean loop = true;

    while (loop) {
      System.out.println("### Menu");
      System.out.println("1. Criar Pessoa");
      System.out.println("2. Buscar Pessoa");
      System.out.println("3. Atualizar Pessoa");
      System.out.println("4. Apagar Pessoa");
      System.out.println("5. Sair");

      System.out.print("\nDigite sua opção: ");
      int option = sc.nextInt();
      // TODO: trycatch para validar erro ao digitar letra

      switch (option) {
        case 1:
          System.out.println("Opção escolhida: " + option + "\n");
          break;
      
        case 2:
          System.out.println("Opção escolhida: " + option + "\n");
          break;
      
        case 3:
          System.out.println("Opção escolhida: " + option + "\n");
          break;
      
        case 4:
          System.out.println("Opção escolhida: " + option + "\n");
          break;
      
        case 5:
          System.out.println("Saindo...");
          loop = false;
          sc.close();
          break;
      
        default:
          System.out.println("Opção inválida! Tente novamente\n");
          break;
      } // Fim de switch (option)
    } // Fim de while (loop)
  } // Fim de public static void main()
} // Fim de class Main