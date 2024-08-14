import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;

public class Storage {
  private String path;

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

  public void add(People p) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.path, true))) {
      writer.write(p.toString());
      writer.newLine();
    } catch (IOException e) {
      System.out.println("\nProblema ao gravar arquivo!");
    }
  } // Fim da funcao add()

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
