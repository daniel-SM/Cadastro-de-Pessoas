import java.io.*;

public class Database {
  BufferedReader bf;
  PrintWriter pr;

  Database() {
    try {
      // FileReader f = new FileReader("data.txt");
      FileReader fr = new FileReader("data.txt");
      FileWriter fw = new FileWriter("data.txt");

      this.bf = new BufferedReader(fr);
      this.pr = new PrintWriter(fw);

    } catch (IOException e) {
      System.out.println("Não foi possível abrir arquivo!");
      bf = null;
      pr = null;
    }
  }

  void free() {
    // TODO: liberar os readers e writers de arquivos
  }

  void write(People people) {}
  void read(String name) {}
  void overwrite(String name) {}
  void remove(String name) {}
}
