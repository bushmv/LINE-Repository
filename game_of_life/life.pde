Grid grid;

void setup() {
 size(600, 600); 
 grid = new Grid(60, 60, 10);
 frameRate(30);
 grid.init();
}

void draw() {
  background(255);
  grid.redraw();
}
