import java.io.Console;

public class Actions {
  Console console;

  Actions() {
    this.console = System.console();
    // TODO: criar nova intância da classe importada para manipular arquivo
  }

  void create() {
    System.out.println("\n### Dados da Pessoa para criar");

    System.out.print("Digite o nome: ");
    String name = console.readLine();

    System.out.print("Digite o telefone: ");
    String phone = console.readLine();

    System.out.print("Digite o email: ");
    String email = console.readLine();

    System.out.print("Digite o idade: ");
    int age = Integer.parseInt(console.readLine());

    People people = new People(name, age, phone, email);

    // TODO: gravar pessoa em arquivo
    // OBS: chamar classe para armazenar nova pessoa no arquivo

    System.out.println("\nCriado com sucesso!\n");
  }

  void read() {
    System.out.println("\n### Dados da Pessoa para buscar");

    System.out.print("Digite o nome: ");
    String name = console.readLine();

    // TODO: localizar pessoa no arquivo
    // OBS: chamar classe para armazenar buscar pessoa no arquivo

    System.out.println("\nEncontrado com sucesso!\n");
  }

  void update() {
    System.out.println("\n### Dados da Pessoa para atualizar");

    System.out.print("Digite o nome: ");
    String name = console.readLine();

    System.out.print("Digite o idade: ");
    int age = Integer.parseInt(console.readLine());

    System.out.print("Digite o telefone: ");
    String phone = console.readLine();

    System.out.print("Digite o email: ");
    String email = console.readLine();

    People people = new People(name, age, phone, email);

    // TODO: localizar e atualizar pessoa no arquivo
    // OBS: chamar classe para atualizar pessoa no arquivo

    System.out.println("\nAtualizado com sucesso!\n");
  }

  void delete() {
    System.out.println("\n### Dados da Pessoa para apagar");

    System.out.print("Digite o nome: ");
    String name = console.readLine();

    // TODO: localizar e apagar pessoa no arquivo
    // OBS: chamar classe para remover pessoa no arquivo

    System.out.println("\nApagado com sucesso!\n");
  }
}
