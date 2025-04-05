package ads.esd;

import java.util.Stack;

public class Calculadora {
    Stack<Double> stack;
    int quantidadeElementos;

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
                stack.push(Double.parseDouble(s));
            }
        }
        return stack.pop();
    }

    public void faz_operacao(String operador) {
        switch (operador) {
            case "+" -> stack.push(stack.pop() + stack.pop());
            case "-" -> stack.push(stack.pop() - stack.pop());
            case "*" -> stack.push(stack.pop() * stack.pop());
            case "/" -> stack.push(stack.pop() / stack.pop());
        }
    }

    public double resultado() {
        return stack.pop();
    }

    public void limpar() {
        stack.clear();
    }
}
