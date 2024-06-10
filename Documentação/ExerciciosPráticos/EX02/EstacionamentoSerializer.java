package EX02;

import java.io.*;

public class EstacionamentoSerializer {

    public static void salvarEstacionamento(Estacionamento estacionamento, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(estacionamento);
        }
    }

    public static Estacionamento carregarEstacionamento(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Estacionamento) ois.readObject();
        }
    }

    public static void main(String[] args) {
        // Exemplo de uso
        Estacionamento estacionamento = new Estacionamento();
        estacionamento.adicionarAutomovel(new Automovel("ABC1234", "Ford Ka"));
        estacionamento.adicionarAutomovel(new Automovel("XYZ5678", "Chevrolet Onix"));

        try {
            // Salvando o estacionamento no disco
            salvarEstacionamento(estacionamento, "estacionamento.ser");

            // Carregando o estacionamento do disco
            Estacionamento estacionamentoCarregado = carregarEstacionamento("estacionamento.ser");
            System.out.println("Estacionamento Carregado:");
            for (Automovel automovel : estacionamentoCarregado.getAutomoveis()) {
                System.out.println(automovel);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
