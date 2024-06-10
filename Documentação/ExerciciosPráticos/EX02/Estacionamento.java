package EX02;

import java.io.*;
import java.util.*;

public class Estacionamento implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private List<Automovel> automoveis;

    public Estacionamento() {
        this.automoveis = new ArrayList<>();
    }

    public void adicionarAutomovel(Automovel automovel) {
        automoveis.add(automovel);
    }

    public List<Automovel> getAutomoveis() {
        return automoveis;
    }

    @Override
    public String toString() {
        return "Estacionamento [automoveis=" + automoveis + "]";
    }
}
