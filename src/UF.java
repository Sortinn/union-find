import java.io.BufferedReader;
import java.util.*;
import java.util.Arrays;

public class UF {
    private int[] id;
    private int count;
    private int arrCount;
    public UF(int N) {      //初始化分量id数组，index表示触点，value表示分量
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        arrCount++;
        return id[p];
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        } else {
            for (int i = 0; i < id.length; i++) {
                if (id[i] == pID) {
                    id[i] = qID;
                    arrCount++;
                }
            }
            count--;
        }
    }

    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        UF uf = new UF(N);
        //System.out.println(uf.count);
        while (reader.hasNextInt()) {
            int p = reader.nextInt();
            int q = reader.nextInt();
            if (uf.connected(p, q)) {
                StdOut.println(p + "和" + q + "已连通");
                StdOut.println("访问数组次数为：" + uf.arrCount);
                uf.arrCount = 0;
                continue;
            }
            uf.union(p, q);

            StdOut.println(p + "和" + q + "未连通");
            StdOut.println("还有" + uf.count() + "个连通分量" );
            StdOut.println("访问数组次数为：" + uf.arrCount);
            uf.arrCount = 0;
        }
        StdOut.println("还有" + uf.count + "个分量");
    }

}
