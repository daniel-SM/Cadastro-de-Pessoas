import java.io.Console;

public class Actions {
  private Console console;
  private Storage storage; 

  Actions(Console c) {
    this.console = c;
    this.storage = new Storage("data.txt");
  }

  void create() {
    System.out.println("\n### Dados da Pessoa para criar");

    System.out.print("Digite o nome: ");
    String name = this.console.readLine();

    System.out.print("Digite o telefone: ");
    String phone = this.console.readLine();

    System.out.print("Digite o email: ");
    String email = this.console.readLine();

    System.out.print("Digite o idade: ");
    int age = Integer.parseInt(this.console.readLine());

    People people = new People(name, age, phone, email);

    // Chamando método para cadastrar nova pessoa
    this.storage.add(people);

    System.out.println("\nCriado com sucesso!\n");
  }

  void read() {
    System.out.println("\n### Dados da Pessoa para buscar");

    System.out.print("Digite o nome: ");
    String name = this.console.readLine();

    // Chamando método para buscar uma pessoa pelo nome
    this.storage.search(name);

    System.out.println("\nEncontrado com sucesso!\n");
  }

  void update() {
    System.out.println("\n### Dados da Pessoa para atualizar");

    System.out.print("Digite o nome: ");
    String name = this.console.readLine();

    System.out.print("Digite o idade: ");
    int age = Integer.parseInt(this.console.readLine());

    System.out.print("Digite o telefone: ");
    String phone = this.console.readLine();

    System.out.print("Digite o email: ");
    String email = this.console.readLine();

    People people = new People(name, age, phone, email);

    // Chamando método para atualizar uma pessoa usando o nome
    this.storage.update(people);

    System.out.println("\nAtualizado com sucesso!\n");
  }

  void delete() {
    System.out.println("\n### Dados da Pessoa para apagar");

    System.out.print("Digite o nome: ");
    String name = this.console.readLine();

    // Chamando método para apagar uma pessoa usando o nome
    this.storage.remove(name);

    System.out.println("\nApagado com sucesso!\n");
  }
}
