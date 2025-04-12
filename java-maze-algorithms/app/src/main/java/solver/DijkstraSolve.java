package solver;

import java.util.*;
import main.MazeGridPanel;
import util.Cell;

public class DijkstraSolve extends BasicSolver {
	
	private final Queue<Cell> queue;

	public DijkstraSolve(List<Cell> grid, MazeGridPanel panel) {
		super(grid, panel);
		queue = new PriorityQueue<Cell>(new CellDistanceFromGoalComparator());
		queue.offer(current);
	}

	protected void flood() {
		current.setDeadEnd(true);
		current = queue.poll();
		List<Cell> adjacentCells = current.getValidMoveNeighbours(grid);
		for (Cell c : adjacentCells) {
			if (update_distance(c)) {
				queue.offer(c);
			}
		}
	}

	private class CellDistanceFromGoalComparator implements Comparator<Cell> {
		Cell goal = grid.get(grid.size() - 1);

		@Override
		public int compare(Cell arg0, Cell arg1) {
			if (getDistanceFromGoal(arg0) > getDistanceFromGoal(arg1)) {
				return 1;
			} else {
				return getDistanceFromGoal(arg0) < getDistanceFromGoal(arg1) ? -1 : 0;
			}
		}

		private double getDistanceFromGoal(Cell c) {
			return Math.hypot(c.getX() - goal.getX(), c.getY() - goal.getY());
		}
	}
	
}