import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;

/**
 * A classe Storage é responsável por gerenciar a escrita e leitura do arquivo em que é armazenado os registros das pessoas.
 */
public class Storage {
  private String path;

  /**
   * Construtor da classe Storage.
   *
   * @param path O caminho do arquivo onde os dados serão armazenados.
   */
  Storage(String path) {
    this.path = path;

    // Verificando se o arquivo existe
    File arquivo = new File(this.path);
    if (!arquivo.exists()) {
      try {
        // Criando um novo arquivo vazio caso nao exista
        arquivo.createNewFile(); 
      } catch (IOException e) { // Lidando com erro no arquivo
        System.out.println("Erro ao tentar criar novo arquivo!");
        System.exit(1);
      }
    }
  }

  /**
   * Grava uma lista de pessoas no arquivo.
   *
   * @param list A lista de pessoas a serem gravadas.
   */
  private void write(ArrayList<People> list) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.path))) {
      for (People people : list) {
        writer.write(people.toString());
        writer.newLine();
      }
    } catch (IOException e) {
      System.out.println("\nProblema ao gravar arquivo!");
      // TODO: handle exception
    }
  } // Fim da funcao write()

  /**
   * Lê o arquivo e retorna uma lista de pessoas.
   *
   * @return A lista de pessoas lidas do arquivo.
   */
  private ArrayList<People> read() {
    // Iniciando a lista vazia de pessoas
    ArrayList<People> list = new ArrayList<>();

    // Tentando ler arquivo
    try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
      // Percorrendo as linhas do arquivo
      String row;
      while ((row = reader.readLine()) != null) {
        // Separando a linha pela vírgula
        String[] info = row.split(",");

        // Gerando novo objeto para adicionar na lista
        People p = new People(
            info[0],                    // Nome
            Integer.parseInt(info[1]),  // Idade
            info[2],                    // Telefone
            info[3]                     // Email
        );

        // Adicionando a pessoa lida na lista
        list.add(p);
      }
    } catch (IOException e) { // Lidando com erro no arquivo
      System.out.println("\nProblema ao ler arquivo!");
    }

    // Retornando a lista completa das pessoas do arquivo
    return list;
  } // Fim da funcao read()

  /**
   * Adiciona uma nova pessoa ao arquivo.
   *
   * @param p A pessoa a ser adicionada.
   */
  public void add(People p) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.path, true))) {
      writer.write(p.toString());
      writer.newLine();
    } catch (IOException e) {
      System.out.println("\nProblema ao gravar arquivo!");
    }
  } // Fim da funcao add()

  /**
   * Busca uma pessoa no arquivo com base no nome.
   *
   * @param name O nome da pessoa a ser buscada.
   * @return A pessoa encontrada ou null se não for encontrada.
   */
  public People search(String name) {
    // Variavel para guardar a pessoa encontrada
    // ou nulo caso nao seja encontrada
    People people = null;

    // Tentando ler arquivo
    try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
      // Percorrendo as linhas do arquivo
      String row;
      while ((row = reader.readLine()) != null) {
        // Separando a linha pela vírgula
        String[] info = row.split(",");

        // Verificando se encontrou o nome informado
        if (name.equals(info[0])) {
          // Gerando novo objeto para adicionar na lista
          people = new People(
              info[0],                    // Nome
              Integer.parseInt(info[1]),  // Idade
              info[2],                    // Telefone
              info[3]                     // Email
          );
        } // Fim do if
      } // Fim do while
    } catch (IOException e) { // Lidando com erro no arquivo
      System.out.println("\nProblema ao ler arquivo!");
    }
    // Retornando a pessoa encontrada ou nulo caso nao seja encontrado
    return people;
  } // Fim da funcao search

  /**
   * Atualiza os dados de uma pessoa existente no arquivo com base no nome.
   *
   * @param people A pessoa com os novos dados.
   * @return true se a pessoa foi encontrada e atualizada, false caso contrário.
   */
  public boolean update(People people) {
    // Lendo o arquivo e obtendo as pessoas
    ArrayList<People> list = this.read();

    // Percorrendo todos as pessoas
    for (People p : list) {
      // Verificando se encontrou a pessoa
      if (people.getName().equals(p.getName())) {
        // Atualizando os dados 
        p.setAge(people.getAge());
        p.setPhone(people.getPhone());
        p.setEmail(people.getEmail());

        // Salvando no arquivo
        this.write(list);

        // Retornando que foi bem-sucedido
        return true;
      }
    }
    // Retornando que nao encontrou pessoa 
    return false;
  } // Fim da funcao update()

  /**
   * Remove uma pessoa do arquivo com base no nome.
   *
   * @param name O nome da pessoa a ser removida.
   * @return true se a pessoa foi encontrada e removida, false caso contrário.
   */
  public boolean remove(String name) {
    // Lendo o arquivo e obtendo as pessoas
    ArrayList<People> list = this.read();

    // Percorrendo todos as pessoas
    for (People p : list) {
      // Verificando se encontrou a pessoa
      if (name.equals(p.getName())) {
        // Removendo a pessoa 
        list.remove(p);

        // Salvando no arquivo
        this.write(list);

        // Retornando que foi bem-sucedido
        return true;
      }
    }
    // Retornando que nao encontrou pessoa
    return false;
  } // Fim da funcao remove()
}
