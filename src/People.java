// Classe Pessoa para modelar uma pessoa real 
public class People {
  // Atributos de Pessoa
  private String name;
  private int age;
  private String phone;
  private String email;

  // Construtor de Pessoa com todos os atributos
  public People(String name, int age, String phone, String email) {
    this.name = name;
    this.age = age;
    this.phone = phone;
    this.email = email;
  }

  // Getter & Setter de "name"
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  
  // Getter & Setter de "age"
  public int getAge() { return age; }
  public void setAge(int age) { this.age = age; }
  
  // Getter & Setter de "email"
  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
  
  // Getter & Setter de "phone"
  public String getPhone() { return phone; }
  public void setPhone(String phone) { this.phone = phone; } 
  
  // Substituindo metodo toString() para gravar objeto em arquivo
  @Override
  public String toString() {
    return (
      this.getName() + "," + 
      this.getAge() + "," + 
      this.getPhone() + "," + 
      this.getEmail()
    );
  }
}
