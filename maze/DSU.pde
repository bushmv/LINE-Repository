class DSU {
 
  public int[] p;
  
  public DSU(int size) {
   p = new int[size];
   for (int i = 0; i < size; i++) {
    makeSet(i); 
   }
  }
  
  public void makeSet(int x) {
    p[x] = x; 
  }
  
  public int find(int x) {
    if (p[x] == x) {
      return x; 
    }
    p[x] = find(p[x]);
    return p[x];
  }
  
  public void union(int a, int b) {
   int aSet = find(a);
   int bSet = find(b);
   if (aSet == bSet) return;
   if (random(1) < 0.5) {
      p[aSet] = bSet;
   } else {
      p[bSet] = aSet;
   }
  }
  
  public boolean check(int a, int b) {
   return find(a) == find(b); 
  }
  
}
