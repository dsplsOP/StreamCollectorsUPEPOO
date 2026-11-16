package questao1;

import modelo.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Produto p1 = new Produto(1L, "Caneta", "Papelaria", 3.0);
        Produto p2 = new Produto(2L, "Caderno", "Papelaria", 25.0);
        Produto p3 = new Produto(3L, "Banco Imobiliario", "Jogo", 80.0);
        Produto p4 = new Produto(4L, "Xadrez", "Jogo", 40.0);
        Produto p5 = new Produto(5L, "GTA VI", "Jogo", 500.0);
        Produto p6 = new Produto(6L, "Harry Potter", "Livro", 90.0);

        List<Produto> produtos = Arrays.asList(p1, p2, p3, p4, p5, p6);

        produtos.stream()
                .filter(p -> p.getCategoria().equals("Jogo"))
                .filter(p -> p.getPreco() < 100)
                .forEach(System.out::println);
    }
}
