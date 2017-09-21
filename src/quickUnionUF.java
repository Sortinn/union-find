import java.util.Scanner;

public class quickUnionUF extends UF {
    private int arrCount;


    public quickUnionUF(int N) {
        super(N);
    }

//    public boolean connected(int p, int q) {
//        return find(p) == find(q);
//    }

    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        id[pRoot] = qRoot;
        count--;

    }


    public void inPutAndOutput(Scanner reader, quickUnionUF uf) {
        while (reader.hasNextInt()) {
            int p = reader.nextInt();
            int q = reader.nextInt();
            if (uf.connected(p, q)) {
                StdOut.println(p + "和" + q + "已连通");
                StdOut.println("还有" + uf.count() + "个连通分量");
                //StdOut.println("访问数组次数为：" + uf.arrCount);
                uf.arrCount = 0;
                continue;
            } else {
                uf.union(p, q);

                StdOut.println(p + "和" + q + "未连通");
                StdOut.println("还有" + uf.count() + "个连通分量");
                //StdOut.println("访问数组次数为：" + uf.arrCount);
                uf.arrCount = 0;
            }
        }
        StdOut.println("还有" + uf.count + "个量");
    }

    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        quickUnionUF uf = new quickUnionUF(N);
        //System.out.println(uf.count);
        uf.inPutAndOutput(reader, uf);
    }
}

