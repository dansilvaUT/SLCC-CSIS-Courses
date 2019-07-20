package percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int n;
    private int top;
    private int size;
    private int bottom;
    private boolean[][] grid;
    int numberOpen = 0;
    WeightedQuickUnionUF wqf;
    WeightedQuickUnionUF wqf2;

    public Percolation(int N) {


        if (n < 0) {
            throw new IllegalArgumentException("No negative numbers allowed");
        }

        this.n = N;
        size = n * n;

        grid = new boolean[N][N];

        wqf = new WeightedQuickUnionUF((size + 2));
        wqf2 = new WeightedQuickUnionUF((size + 1));
        top = size;
        bottom = size + 1;

        for (int i = 0; i < n; i++) {
            wqf.union(i, top);
            wqf2.union(i, top);
            wqf.union(size - i - 1, bottom);
        }


    }

    public void open(int i, int j) {

        if (i > n - 1 || i < 0 || j > n - 1 || j < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        grid[i][j] = true;
        if (i - 1 >= 0 && grid[i - 1][j]) {
            wqf.union(location(i - 1, j), location(i, j));
            wqf2.union(location(i - 1, j), location(i, j));
        }
        if (i + 1 < n && grid[i + 1][j]) {
            wqf.union(location(i + 1, j), location(i, j));
            wqf2.union(location(i + 1, j), location(i, j));
        }
        if (j - 1 >= 0 && grid[i][j - 1]) {
            wqf.union(location(i, j - 1), location(i, j));
            wqf2.union(location(i, j - 1), location(i, j));
        }
        if (j + 1 < n && grid[i][j + 1]) {
            wqf.union(location(i, j + 1), location(i, j));
            wqf2.union(location(i, j + 1), location(i, j));
        }
        numberOpen++;
    }


    public boolean isOpen(int i, int j) {

        if (i > n - 1 || i < 0 || j > n - 1 || j < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        return grid[i][j];

    }

    public boolean isFull(int i, int j) {

        if (i > n - 1 || i < 0 || j > n - 1 || j < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        if (!isOpen(i, j)) {
            return false;
        }
        return wqf2.connected(top, location(i, j));

    }

    public boolean percolates() {

        return wqf.connected(top, bottom);

    }

    private int location(int i, int j) {

        return (n * i) + j;
    }

    public String numberOfOpenSites() {
        return "" + numberOpen;
    }


}

