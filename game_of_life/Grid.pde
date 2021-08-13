class Grid {
 
  private int rows;
  private int columns;
  private int len;
  private boolean[][] population;
  private boolean[][] temp;
  
  private boolean[][] t1;
  private boolean[][] t2;
  private boolean toggle;
  
  public Grid(int rows, int columns, int len) { 
   this.rows = rows;
   this.columns = columns;
   this.len = len; 
   t1 = new boolean[rows][columns];
   t2 = new boolean[rows][columns];
   population = t1;
   temp = t2;
   toggle = true;
  }
  
  void init() {
    for(int i = 0; i < rows; i++) {
      for(int j = 0; j < columns; j++) {
        if(i == j || i == rows - j) population[i][j] = true;
      }
    }
  }

  void redraw() {
    draw();
    update();
  }
  
  private void draw() {
    for(int i = 0; i < rows; i++) {
      for(int j = 0; j < columns; j++) {
        if (population[i][j]) { fill(0); } 
        else { fill(255); }
        rect(j * len, i * len, len, len);
      }
    }
  }
  
  private void update() {
    for(int i = 0; i < rows; i++) {
        for(int j = 0; j < columns; j++) {
          int neighbors = neighborsFor(i, j);

          if (neighbors < 2 || neighbors > 3) temp[i][j] = false;
          else if (!population[i][j] && neighbors == 3) temp[i][j] = true;
          else temp[i][j] = population[i][j];
        }
    }
    if (toggle) { population = t2; temp = t1; } 
    else { population = t1; temp = t2; }
    toggle = !toggle;
  }
  
  private int neighborsFor(int i, int j) {
    int neighbors = 0;
    for (int li = -1; li < 2; li++) {
      for (int lj = -1; lj < 2; lj++) {
         if (population[(i + li + rows) % rows][(j + lj + columns) % columns]) { neighbors++; }
      }
    } 
    if (population[i][j]) neighbors--;
    return neighbors;
  }
  
}
