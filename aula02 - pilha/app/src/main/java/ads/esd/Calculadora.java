package ads.esd;

import java.util.Stack;

public class Calculadora {
    private Stack<Double> stack;
    private int quantidadeElementos;
    private double x1;
    private double x2;

    Calculadora(){
        stack = new Stack<>();
        quantidadeElementos = 0;
    }

    public void adicionaNumero(Double num){
        stack.push(num);
    }

    public boolean completa() {
        return stack.size() == 1;
    }

    public Double calcula(String expressao) {
        String[] exp = expressao.split(" ");

        for (String s : exp) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                faz_operacao(s);
            } else {
                adicionaNumero(Double.parseDouble(s));
            }
        }
        return resultado();
    }

    public void faz_operacao(String operador) {
        x2 = stack.pop();
        x1 = stack.pop();

        switch (operador) {
            case "+" -> stack.push(x1 + x2);
            case "-" -> stack.push(x1 - x2);
            case "*" -> stack.push(x1 * x2);
            case "/" -> stack.push(x1 / x2);
        }
    }

    public double resultado() {
        return stack.pop();
    }

    public void limpar() {
        stack.clear();
    }
}
