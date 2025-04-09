package ads.esd;

public class CalculadoraInversa {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        System.out.println(calculadora.calcula("10 3 2 / +"));

        Calculadora calculadora2 = new Calculadora();

        calculadora2.adicionaNumero(4.0);
        calculadora2.adicionaNumero(2.0);
        calculadora2.faz_operacao("/");
        calculadora2.adicionaNumero(3.0);
        calculadora2.faz_operacao("+");

        System.out.println(calculadora2.resultado());
    }
}
