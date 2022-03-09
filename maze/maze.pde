
private int row = 30;
private int column = 40;
private int cellSize = 20;

void setup() {
 size(800, 600);
 background(255);
 fill(0);
 Maze m = new Maze(row, column);
 byte[][] table = m.generate();
 Renderer r = new Renderer(row, column, cellSize, table);
 r.draw();
 noLoop();
}

//void draw() {
  
//}
