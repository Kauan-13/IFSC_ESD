package esd;

public class Pilha <T> {
    T[] mem; // a área de armazenamento
    int len = 0; // a quantidade de dados armazenados
    final int defcap = 8; // capacidade inicial

    @SuppressWarnings("unchecked")
    public Pilha() {
        mem = (T[])new Object[defcap];
    }

    public int comprimento() {
        return len;
    }

    public int capacidade() {
        return mem.length;
    }

    public void empilha(T algo) {
        if (len == capacidade()) {
            expandirPilha();
        }
        mem[len] = algo;
        len++;
    }

    @SuppressWarnings("unchecked")
    private void expandirPilha() {
        T[] novaPilha = (T[]) new Object[mem.length * 2];
        for (int i = 0; i < len; i++) {
            novaPilha[i] = mem[i];
        }
        mem = novaPilha;
    }

    public T desempilha() {
        T algo;
        if (estaVazia()) {
            throw new IndexOutOfBoundsException("Pilha vazia");
        }
        algo = mem[len - 1];
        mem[len - 1] = null;
        len--;
        return algo;
    }

    public T topo() {
        if (estaVazia()) {
            throw new IndexOutOfBoundsException("Pilha vazia");
        }
        return mem[len - 1];
    }

    public boolean estaVazia() {
        return len == 0;
    }

    @SuppressWarnings("unchecked")
    public void limpa() {
        mem = (T[])new Object[defcap];
        len = 0;
    }
}
