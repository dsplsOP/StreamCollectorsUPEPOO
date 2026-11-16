package questao4;

import modelo.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Cliente c1 = new Cliente(1L, "Emanoel");
        Cliente c2 = new Cliente(2L, "Ana");
        Produto p1 = new Produto(1L, "Caneta", "Papelaria", 3.0);
        Produto p2 = new Produto(2L, "Caderno", "Papelaria", 25.0);
        Produto p3 = new Produto(3L, "Banco Imobiliario", "Jogo", 80.0);
        Produto p4 = new Produto(4L, "Xadrez", "Jogo", 40.0);
        Produto p5 = new Produto(5L, "GTA VI", "Jogo", 500.0);
        Produto p6 = new Produto(6L, "Harry Potter", "Livro", 90.0);

        List<Pedido> pedidos = Arrays.asList(
                new Pedido(1L, LocalDate.of(2026, 10, 10),
                        Arrays.asList(p1, p2), c1),

                new Pedido(2L, LocalDate.of(2026, 10, 20),
                        Arrays.asList(p2, p3, p6), c1),

                new Pedido(3L, LocalDate.of(2026, 10, 15),
                        Arrays.asList(p2, p4), c2),

                new Pedido(4L, LocalDate.of(2026, 10, 25),
                        Arrays.asList(p5, p6), c2)
        );

        List<Pedido> recentes = pedidos.stream()
                .collect(Collectors.groupingBy(
                        Pedido::getCliente,
                        Collectors.maxBy(
                                Comparator.comparing(Pedido::getDataPedido)
                        )
                ))
                .values()
                .stream()
                .map(Optional::get)
                .collect(Collectors.toList());

        recentes.forEach(p -> System.out.println(p + " -> " + p.getProdutos()));
    }
}