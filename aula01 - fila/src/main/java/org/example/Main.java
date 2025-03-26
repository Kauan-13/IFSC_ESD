package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Queue<String> fila = new ArrayDeque<>();
        Scanner leitor = new Scanner(System.in);

        String opcao;

        do {
            System.out.print("> ");
            opcao = leitor.nextLine();
            opcao = opcao.strip();

            switch (opcao) {
                case "", "sair":
                    break;
                case "?":
                    if (!fila.isEmpty()) {
                        System.out.println(fila.remove());
                    } else {
                        System.out.println("Fila está vazia!");
                    }
                    break;
                default:
                    fila.add(opcao);
                    System.out.println(fila.size() - 1);
                    break;
            }
        }while (!opcao.equals("sair"));
        leitor.close();
    }
}