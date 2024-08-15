import java.io.Console;

/**
 * A classe Actions possui métodos para receber do usuário as entradas necessárias para as ações de criar, buscar, atualizar e deletar registros de pessoas.
 */
public class Actions {
  private Console console;
  private Storage storage; 

  /**
   * Construtor da classe Actions.
   *
   * @param c O console para fazer a entrada de dados.
   */
  Actions(Console c) {
    this.console = c;
    this.storage = new Storage("data.txt");
  }

  /**
   * Cria um novo registro de pessoa, solicitando os dados ao usuário.
   */
  public void create() {
    System.out.println("\n### Dados da Pessoa para criar");

    System.out.print("Digite o nome: ");
    String name = this.console.readLine();

    System.out.print("Digite o idade: ");
    int age = Integer.parseInt(this.console.readLine());

    System.out.print("Digite o telefone: ");
    String phone = this.console.readLine();

    System.out.print("Digite o email: ");
    String email = this.console.readLine();

    People people = new People(name, age, phone, email);

    // Chamando método para cadastrar nova pessoa
    this.storage.add(people);

    System.out.println("\n### Criado com sucesso!");
    this.console.readLine("\nAperte enter para continuar...\n");
  }

  /**
   * Busca um registro de pessoa com base no nome fornecido pelo usuário.
   */
  public void read() {
    System.out.println("\n### Dados da Pessoa para buscar");

    System.out.print("Digite o nome: ");
    String name = this.console.readLine();

    // Chamando método para buscar uma pessoa pelo nome
    People p = this.storage.search(name);

    // Verificando se foi encontrado
    if (p != null) {
      System.out.println("\nPessoa encontrada com sucesso!");
      System.out.println("Nome: " + p.getName());
      System.out.println("Idade: " + p.getAge());
      System.out.println("Telefone: " + p.getPhone());
      System.out.println("Email: " + p.getEmail());

    } else {
      System.out.println("\nNão foi encontrada pessoa com este nome!");
    }
    this.console.readLine("\nAperte enter para continuar...\n");
  }

  /**
   * Atualiza um registro de pessoa com base nos dados fornecidos pelo usuário.
   */
  public void update() {
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
    boolean success = this.storage.update(people);

    // Verificando se foi encontrado
    if (success) {
      System.out.println("\nAtualizado com sucesso!");
    } else {
      System.out.println("\nNão foi encontrada pessoa com este nome!");
    }
    this.console.readLine("\nAperte enter para continuar...\n");
  }

  /**
   * Deleta um registro de pessoa com base no nome fornecido pelo usuário.
   */
  public void delete() {
    System.out.println("\n### Dados da Pessoa para apagar");

    System.out.print("Digite o nome: ");
    String name = this.console.readLine();

    // Chamando método para apagar uma pessoa usando o nome
    boolean success = this.storage.remove(name);

    // Verificando se foi encontrado
    if (success) {
      System.out.println("\nApagado com sucesso!");
    } else {
      System.out.println("\nNão foi encontrada pessoa com este nome!");
    }
    this.console.readLine("\nAperte enter para continuar...\n");
  }
}
