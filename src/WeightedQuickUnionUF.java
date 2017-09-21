import java.util.Scanner;

public class WeightedQuickUnionUF extends quickUnionUF {
    private int [] sizeOfTree ;
    //private int depthOfTree = 0;

    private WeightedQuickUnionUF(int N) {
        super(N);
        sizeOfTree = new int[N];
        for(int i = 0; i < N; i ++) {
            sizeOfTree[i] = 1;
        }
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        if (sizeOfTree[p] > sizeOfTree[q]) {
            id[qRoot] = pRoot;
            sizeOfTree[p] += sizeOfTree[q];
        }else {
            id[pRoot] = qRoot;
            sizeOfTree[q] += sizeOfTree[p];
        }
        count--;
        //StdOut.println("当前树的深度为" + depthOfTree);

    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("请输入要添加的触点的个数：");
        int N = reader.nextInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        uf.inPutAndOutput(reader, uf);
    }

}

