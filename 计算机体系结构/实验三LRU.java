import java.util.Arrays;

/**
 * zxt
 * Latinaxia
 */

class Cache {
    boolean state = false;
    int value = -1;
    int count = 0;
}

public class Main {
    static final int M = 4; // Cache块
    static Cache[] cache = new Cache[M];
    static final int N = 12;
    static int[] walk_sort = { 1, 1, 2, 4, 3, 5, 2, 1, 6, 7, 1, 3 }; // 测试数据

    public static void main(String[] args) {
        for (int i = 0; i < M; i++) {
            cache[i] = new Cache();
        }
        up_cache();
    }

    static void up_cache() {
        int i = 0;
        while (i < N) {
            int j = 0;
            while (j < M) {
                if (!cache[j].state && walk_sort[i] != cache[j].value) {
                    System.out.println("cache有空闲块，不考虑是否要置换...");
                    System.out.println(walk_sort[i] + " 被调入cache....");
                    cache[j].value = walk_sort[i++];
                    cache[j].state = true;
                    cache[j].count = 0;
                    int kk = 0;

                    for (int x = 0; x < M; x++) {
                        System.out.println("Cache 块 " + x + ": " + cache[x].value);
                    }
                    System.out.println();

                    // 更新其他缓存块未使用的时间
                    while (kk < M) {
                        if (kk != j && cache[kk].value != -1) {
                            cache[kk].count++;
                        }
                        kk++;
                    }
                    break;
                }
                if (cache[j].value == walk_sort[i]) {
                    System.out.println();
                    System.out.println(walk_sort[i] + " 命中!!!");
                    for (int x = 0; x < M; x++) {
                        System.out.println("Cache 块 " + x + ": " + cache[x].value);
                    }
                    System.out.println();
                    i++;
                    cache[j].count = 0;
                    // 更新其他缓存块未使用的时间
                    int kk = 0;
                    while (kk < M) {
                        if (kk != j && cache[kk].value != -1) {
                            cache[kk].count++;
                        }
                        kk++;
                    }
                }
                j++;
            }
            if (j == M) {
                System.out.println("cache已经满了，是否考虑置换...");
                System.out.println();
                int k = 0;
                while (k < M) {
                    if (cache[k].value == walk_sort[i]) {
                        System.out.println();
                        System.out.println(walk_sort[i] + " 命中!!!");
                        for (int x = 0; x < M; x++) {
                            System.out.println("Cache 块 " + x + ": " + cache[x].value);
                        }
                        i++;
                        cache[k].count = 0;
                        int kk = 0;
                        // 更新其他缓存块未使用的时间
                        while (kk < M) {
                            if (kk != k) {
                                cache[kk].count++;
                            }
                            kk++;
                        }
                        break;
                    }
                    k++;
                }
                // 是否更换该块。
                if (k == M) {
                    int ii = 0;
                    int t = 0; // 要替换的缓存块。
                    int max = cache[ii].count;
                    ii++;
                    while (ii < M) {
                        if (cache[ii].count > max) {
                            max = cache[ii].count;
                            t = ii;
                        }
                        ii++;
                    }
                    // Replace
                    System.out.println(cache[t].value + " 被 " + walk_sort[i] + " 在cache的" + t + "号块置换 " + "...");
                    cache[t].value = walk_sort[i++];
                    cache[t].count = 0;
                    for (int x = 0; x < M; x++) {
                        System.out.println("Cache 块 " + x + ": " + cache[x].value);
                    }
                    int kk = 0;
                    // 更新其他缓存块未使用的时间
                    while (kk < M) {
                        if (kk != t) {
                            cache[kk].count++;
                        }
                        kk++;
                    }
                }
            }
        }
    }
}
