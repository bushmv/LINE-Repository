class Renderer {
 
  private int row;
  private int column;
  private int cellSize;
  private byte[][] table;
  private int wallSize;
  
  public Renderer(int row, int column, int cellSize, byte[][] table) {
    this.row = row;
    this.column = column;
    this.cellSize = cellSize;
    this.table = table;
    this.wallSize = cellSize / 10;
  }
  
  public void draw() {
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        int cell = table[i][j];
        if ((cell & 0b0001) == 0b0001) rect(j * cellSize, i * cellSize + cellSize - wallSize, cellSize, wallSize);
        if ((cell & 0b0010) == 0b0010)  rect(j * cellSize, i * cellSize, wallSize, cellSize); 
        if ((cell & 0b0100) == 0b0100)  rect(j * cellSize, i * cellSize, cellSize, wallSize); 
        if ((cell & 0b1000) == 0b1000)  rect(j * cellSize + cellSize - wallSize, i * cellSize, wallSize, cellSize); 
      }
    }
  }
  
}
