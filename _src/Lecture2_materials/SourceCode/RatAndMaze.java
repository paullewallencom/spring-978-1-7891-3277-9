package com.loonycorn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jananiravi on 11/19/15.
 */
public class RatAndMaze {


    public static void main(String[] args) {
        Cell a = new Cell("A");
        Cell b = new Cell("B");
        Cell c = new Cell("C");
        Cell d = new Cell("D");
        Cell e = new Cell("E");
        Cell f = new Cell("F");
        Cell g = new Cell("G");
        Cell h = new Cell("H");
        Cell i = new Cell("I");

        a.addNeighbor(b);
        b.addNeighbor(a, e, c);
        c.addNeighbor(b);
        d.addNeighbor(a);
        e.addNeighbor(b, f, g);
        f.addNeighbor(e, h);
        g.addNeighbor(e, h);
        h.addNeighbor(g, f, i);
        i.addNeighbor(h);
        i.setIsEnd(true);

        List<Cell> path = new ArrayList<>();
        findPath(d, path);
        print(path);
    }

    public static void print(List<Cell> path) {
        for (Cell cell : path) {
            System.out.print(cell.getId() + "->");
        }
        System.out.println("END");
    }

    public static boolean findPath(Cell current, List<Cell> currentPath) {
        currentPath.add(current);
        if (current.isEnd()) {
            return true;
        }

        for (Cell neighbor : current.getNeighborList()) {
            if (!currentPath.contains(neighbor)) {
                List<Cell> neighborPath = new ArrayList<>();
                neighborPath.addAll(currentPath);

                if (findPath(neighbor, neighborPath)) {
                    currentPath.clear();
                    currentPath.addAll(neighborPath);
                    return true;
                }
            }
        }

        return false;
    }

    public static class Cell {
        private String id;
        private boolean isEnd = false;

        private List<Cell> neighborList = new ArrayList<>();

        public Cell(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public List<Cell> getNeighborList() {
            return neighborList;
        }

        public void addNeighbor(Cell... neighbors) {
            for (Cell neighbor : neighbors) {
                neighborList.add(neighbor);
            }
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setIsEnd(boolean isEnd) {
            this.isEnd = isEnd;
        }

        public String toString() {
            return id;
        }
    }
}
