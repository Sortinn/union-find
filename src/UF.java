public class UF {
    public int[] id;
    public int count;

    public UF(int N) {
        id = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            id[i] = i ;
        }
    }

    public UF() {

    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return 0;
    }

    public void union(int p, int q) {
//        int pRoot = find(p);
//        int qRoot = find(q);
//
//        if (pRoot == qRoot) {
//            return;
//        }
//
//        id[pRoot] = qRoot;
//        count--;
    }

}
