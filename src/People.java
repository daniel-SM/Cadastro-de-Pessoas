/**
 * A classe People modela uma pessoa real com atributos como nome, idade, telefone e email.
 */
public class People {
  // Atributos de Pessoa
  private String name;
  private int age;
  private String phone;
  private String email;

  /**
   * Construtor da classe People.
   *
   * @param name  O nome da pessoa.
   * @param age   A idade da pessoa.
   * @param phone O telefone da pessoa.
   * @param email O email da pessoa.
   */
  public People(String name, int age, String phone, String email) {
    this.name = name;
    this.age = age;
    this.phone = phone;
    this.email = email;
  }

  /**
   * Retorna o nome da pessoa.
   *
   * @return O nome da pessoa.
   */
  public String getName() { return name; }
  /**
   * Define o nome da pessoa.
   *
   * @param name O nome da pessoa.
   */
  public void setName(String name) { this.name = name; }
  
  /**
   * Retorna a idade da pessoa.
   *
   * @return A idade da pessoa.
   */
  public int getAge() { return age; }
  /**
   * Define a idade da pessoa.
   *
   * @param age A idade da pessoa.
   */
  public void setAge(int age) { this.age = age; }
  
  /**
   * Retorna o email da pessoa.
   *
   * @return O email da pessoa.
   */
  public String getEmail() { return email; }
  /**
   * Define o email da pessoa.
   *
   * @param email O email da pessoa.
   */
  public void setEmail(String email) { this.email = email; }
  
  /**
   * Retorna o telefone da pessoa.
   *
   * @return O telefone da pessoa.
   */
  public String getPhone() { return phone; }
  /**
   * Define o telefone da pessoa.
   *
   * @param phone O telefone da pessoa.
   */
  public void setPhone(String phone) { this.phone = phone; } 
  
  /**
   * Retorna uma representação em String do objeto para ser gravado em arquivo.
   *
   * @return A representação em String da pessoa.
   */
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
