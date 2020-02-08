package eecs2030.lab4;

import java.awt.Color;
import eecs2030.lab4.Point2;
import java.util.ArrayList;
import java.util.List;


public class JBlock
extends Block {
    private List<BlockGrid> grids = new ArrayList<BlockGrid>();
    private int gridIndex;

    public JBlock(Point2 pos, Color col) {
        super(3, pos, col);
        BlockGrid g = this.grid;
        g.set(0, 0);
        g.set(1, 0);
        g.set(1, 1);
        g.set(1, 2);
        this.grids.add(g);
        g = new BlockGrid(3);
        g.set(0, 1);
        g.set(0, 2);
        g.set(1, 1);
        g.set(2, 1);
        this.grids.add(g);
        g = new BlockGrid(3);
        g.set(1, 0);
        g.set(1, 1);
        g.set(1, 2);
        g.set(2, 2);
        this.grids.add(g);
        g = new BlockGrid(3);
        g.set(0, 1);
        g.set(1, 1);
        g.set(2, 0);
        g.set(2, 1);
        this.grids.add(g);
        this.gridIndex = 0;
    }

    public void spinLeft() {
       // this.erase();
        --this.gridIndex;
        if (this.gridIndex == -1) {
            this.gridIndex = 3;
        }
        this.grid = this.grids.get(this.gridIndex);
        this.draw();
    }

    public void spinRight() {
      //  this.erase();
        ++this.gridIndex;
        if (this.gridIndex == 4) {
            this.gridIndex = 0;
        }
        this.grid = this.grids.get(this.gridIndex);
        this.draw();
    }
}