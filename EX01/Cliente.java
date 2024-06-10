package EX01;
import java.io.Serializable;
import java.util.Scanner;

// A classe Cliente deve implementar Serializable
public class Cliente implements Serializable {
    // Atributos
    private String nome;
    private char sexo;
    private String cpf;
    private static final long serialVersionUID = 1L;

    // Construtor
    public Cliente(String nome, char sexo, String cpf) {
        this.nome = nome;
        this.sexo = sexo;
        this.cpf = cpf;
    }

    // Métodos
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return this.nome + " / " + "Sexo: " + this.sexo + "\n" + "CPF: " + this.cpf;
    }

    // Método para preencher os dados do cliente
    public static Cliente preencherDados() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o sexo do cliente (M/F): ");
        char sexo = scanner.next().charAt(0);

        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.next();

        return new Cliente(nome, sexo, cpf);
    }

    public static void main(String[] args) {
        Cliente cliente = Cliente.preencherDados();
        System.out.println("Cliente preenchido: " + cliente);
    }

   
}
