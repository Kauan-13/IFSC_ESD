package esd;

public class Fila <T> {

    T[] area;
    int inicio = 0;
    int fim = 0;
    int len = 0;

    @SuppressWarnings("unchecked")
    public Fila() {
        area = (T[]) new Object[8];
    }

    public int comprimento() {
        return len;
    }

    public int capacidade() {
        return area.length;
    }

    public void adiciona(T algo) {
        if (len == capacidade()) {
            expandirFila();
        }
        area[fim] = algo;
        fim = (fim + 1) % capacidade();
        len++;
    }

    public T remove() {
        if (len == 0) {
            throw new IndexOutOfBoundsException("Erro ao remover elemento a fila está vazia");
        }
        T algo = area[inicio];
        area[inicio] = null;
        inicio = (inicio + 1) % capacidade();
        len--;
        return algo;
    }

    public T frente() {
        if (len == 0) {
            throw new IndexOutOfBoundsException("fila vazia");
        }

        return area[inicio];
    }

    public T tras() {
        if (len == 0) {
            throw new IndexOutOfBoundsException("fila vazia");
        }

        int pos = fim - 1;
        if (pos < 0) {
            pos = area.length - 1;
        }
        return area[pos];
    }

    public boolean estaVazia() {
        return len == 0;
    }

    @SuppressWarnings("unchecked")
    private void expandirFila() {
        T[] novaFila = (T[]) new Object[area.length * 2];
        for (int i = 0; i < area.length; i++) {
            int pos_orig = (i + inicio) % area.length;
            novaFila[i] = area[pos_orig];
        }
        area = novaFila;
        inicio = 0;
        fim = len;
    }

    @SuppressWarnings("unchecked")
    public void limpa() {
        area = (T[]) new Object[8];
    }
}
