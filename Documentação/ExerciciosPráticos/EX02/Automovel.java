package EX02;

import java.io.*; 

public class Automovel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String placa;
    private String modelo;

    public Automovel(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return "Automovel [placa=" + placa + ", modelo=" + modelo + "]";
    }
}
