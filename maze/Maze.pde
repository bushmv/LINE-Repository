class Maze {
 
  private int row;
  private int column;
  private DSU dsu;
  private byte[][] table;
  private IntList wallList;
  
  public Maze(int row, int column) {
    this.row = row;
    this.column = column;
    this.dsu = new DSU(row * column);
    initTable();
    initWalls();
  }
  
  private void initTable() {
    this.table = new byte[row][column];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        table[i][j] = 15; 
      }
    }
  }
  
  private void initWalls() {
    this.wallList = new IntList();
    int wallListSize = (column - 1) * row + (row - 1) * column;
    for (int i = 0; i < wallListSize; i++) {
      wallList.append(i); 
    }
    wallList.shuffle();
  }
  
  public byte[][] generate() {
    int horizontalWallCount = (row - 1) * column;
    int unionCountLimit = row * column - 1;
    int i = 0;
    while (unionCountLimit > 0) {
       int wall = wallList.get(i++);
       if (wall < horizontalWallCount) { // horizontal wall
          if (isVerticalWallDestroyed(wall)) {
             unionCountLimit--;
          }
       } else { // vertical wall
          if (isHorizontalWallDestroyed(wall - horizontalWallCount)) {
            unionCountLimit--;
          }
       }
    }
     dump(); // for test
    return table;
  }
  
  private boolean isVerticalWallDestroyed(int wall) {
    int top = wall;
    int down = wall + column;
    if (!dsu.check(top, down)) {
       removeDownWallFor(top / column, top % column);
       removeTopWallFor(down / column, down % column); 
       dsu.union(top, down);
       return true;
    }
    return false;
  }
  
  private boolean isHorizontalWallDestroyed(int wall) {
    int rowForLeft = wall / (column - 1);
    int columnForLeft = wall % (column - 1);
    int left = rowForLeft * column + columnForLeft;
    int right = left + 1;
    if (!dsu.check(left, right)) {
       removeRightWallFor(left / column, left % column);
       removeLeftWallFor(right / column, right % column); 
       dsu.union(left, right);
       return true;
    }
    return false;
  }
  
  private void removeLeftWallFor(int x, int y) { table[x][y] -= 2; }
  private void removeRightWallFor(int x, int y) { table[x][y] -= 8; }
  private void removeTopWallFor(int x, int y) { table[x][y] -= 4; }
  private void removeDownWallFor(int x, int y) { table[x][y] -= 1; }
  
  public void dump() {
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        print(table[i][j] + "\t"); 
      }
      println();
    } 
  }
  
}
