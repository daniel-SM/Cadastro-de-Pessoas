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
      System.out.println("Problema ao gravar arquivo!");
      // TODO: handle exception
    }
  } // Fim da funcao write()

  private ArrayList<People> read() {
    // Iniciando a lista vazia de pessoas
    ArrayList<People> list = new ArrayList<>();

    // Tentando ler arquivo
    try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
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
      System.out.println("Problema ao ler arquivo!");
      // TODO: handle exception

    } catch (NumberFormatException e) { // Lidando com erro da conversao para inteiro
      System.out.println("Formato de idade inválido!");
      // TODO: handle exception
    }

    // Retornando a lista completa das pessoas do arquivo
    return list;
  } // Fim da funcao read()

  public void add(People p) {
    ArrayList<People> list = new ArrayList<>();

    list.add(p);

    write(list);
  }

  public void search(String name) {
  }

  public void update(People people) {
  }

  public void remove(String name) {
  }
}
