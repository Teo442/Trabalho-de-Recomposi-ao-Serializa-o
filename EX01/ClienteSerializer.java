package EX01;
import java.io.*;
import java.util.Scanner;

// Classe responsável pela serialização e desserialização dos objetos Cliente
public class ClienteSerializer {
    // Método para serializar um objeto Cliente
    public static void serializeCliente(Cliente cliente) {
        String filename = "Cliente-" + cliente.getCpf() + ".ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(cliente);
            System.out.println("Cliente salvo em " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para desserializar um objeto Cliente
    public static Cliente deserializeCliente(String cpf) {
        String filename = "Cliente-" + cpf + ".ser";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Cliente) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1 - Serializar Cliente");
            System.out.println("2 - Desserializar Cliente");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    Cliente cliente = Cliente.preencherDados();
                    serializeCliente(cliente);
                    break;
                case 2:
                    System.out.print("Digite o CPF do cliente para desserializar: ");
                    String cpf = scanner.nextLine();
                    Cliente desserializedCliente = deserializeCliente(cpf);
                    if (desserializedCliente != null) {
                        System.out.println("Cliente desserializado: " + desserializedCliente);
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }
}