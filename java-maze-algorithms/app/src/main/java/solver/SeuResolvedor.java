package solver;

import java.util.*;

import esd.Pilha;
import main.MazeGridPanel;
import util.Cell;

public class SeuResolvedor extends BasicSolver {

    Pilha<Cell> cellPilha;

    public SeuResolvedor(List<Cell> grid, MazeGridPanel panel) {
        super(grid, panel);
        cellPilha = new Pilha<>();
        cellPilha.empilha(current);
    }

    protected void flood() {
        // aqui é a parte principal do seu algoritmo para buscar a saída do labirinto
        // aqui você deve atualizar a célula atual (atributo this.current, herdado de BasicSolver)
        // de acordo com a busca pela saída feita pelo seu algoritmo. A ideia é identificar a próxima
        // célula a ser visitada
        current = cellPilha.desempilha();

        // iso faz com que a célula apareça em vermelho ao desenhar o labirinto
        current.setDeadEnd(true);

        // obtém a lista de células vizinhas à célula referenciada por "current"
        List<Cell> adjacentCells = current.getValidMoveNeighbours(grid);


        // para cada célula vizinha, faça algo
        // neste código exemplo, faz com que current seja a primeira das células vizinhas que ainda não foi visitada
        // update_distance atualiz aa distância da célula até o início do labirinto, e retorna true se
        // conseguiu atualizar (a célula ainda não foi visitada)

        for (Cell c : adjacentCells) {
            if (update_distance(c)) {
                cellPilha.empilha(current);
                cellPilha.empilha(c);
            }
        }

    }

}