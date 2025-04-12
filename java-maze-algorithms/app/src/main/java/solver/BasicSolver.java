package solver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.Timer;

import main.MazeGridPanel;
import main.Maze;
import util.Cell;

public abstract class BasicSolver {

    protected Cell current;
    protected final List<Cell> grid;

    public BasicSolver(List<Cell> grid, MazeGridPanel panel) {
        this.grid = grid;
        current = grid.get(0);
        current.setDistance(0);

        final Timer timer = new Timer(Maze.speed, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!current.equals(grid.get(grid.size() - 1))) {
                    flood();
                } else {
                    drawPath();
                    Maze.solved = true;
                    timer.stop();
                }
                panel.setCurrent(current);
                panel.repaint();
                timer.setDelay(Maze.speed);
            }
        });
        timer.start();
    }

    protected abstract void flood();

    protected boolean update_distance(Cell c) {
        if (c.getDistance() == -1) {
            c.setDistance(current.getDistance() + 1);
            c.setParent(current);
            return true;
        }
        return false;
    }

    private void drawPath() {
        while (current != grid.get(0)) {
            current.setPath(true);
            current = current.getParent();
        }
    }
}