import java.util.Arrays;

public class Main {
        private static final int MAX_MEM = 4;
        private static final int MAX_DEVICE = 4;
        private static final int[] a = {0, 1, 2, 0, 1, 3, 0};
        private static final int[] workLength = {15, 9, 9, 9, 9, 9, 9};
        private static final int[] timeLength = {5, 10, 80, 85, 90, 100, 105};
        private static int idx = 0;
        private static final int[] d = new int[MAX_DEVICE];
        private static final int[] deviceTime = {10, 20, 25, 40};

        public static void main(String[] args) {
            initMem();
            initDevice();
            System.out.println("工作状态模拟");
            work();
        }

        private static void initMem() {
            for (int i = 0; i < MAX_MEM; i++) {
                System.out.println("Mem" + i + " :         使用内存" + (i + 1));
            }
        }

        private static void initDevice() {
            for (int i = 0; i < MAX_DEVICE; i++) {
                System.out.println("设备" + i + "     请求时间" + deviceTime[i] + "      内容：设备" + i + "完成初始化");
            }
        }

        private static void initD() {
            Arrays.fill(d, -1);
        }

        private static void showDeviceState() {
            for (int i = 0; i < MAX_DEVICE; i++) {
                if (d[i] == -1) {
                    System.out.println("d[" + i + "]--------当前状态" + 1);
                } else {
                    System.out.println("d[" + i + "]--------当前状态" + 0);
                }
            }
            System.out.println();
        }

        private static void showDevice() {
            for (int i = 0; i < MAX_DEVICE; i++) {
                System.out.print("设备" + i + "     请求时间" + deviceTime[i]);
                if (d[i] == -1) {
                    System.out.println("      内容：设备" + i + "完成初始化");
                } else {
                    System.out.println("      内容：使用内存" + (i + 1));
                }
            }
        }

        private static void successWork() {
            do {
                System.out.println("设备的工作内容长度：" + workLength[idx]);
                showDeviceState();
                if (idx > 0) {
                    d[a[idx - 1]] = -1;
                }
                System.out.println("序号为： " + a[idx]);
                d[a[idx]] = a[idx] + 1;
                showDevice();
                System.out.println("时间长度为：" + timeLength[idx++]);
            } while (idx != 7);
            System.out.println("完成状态");
            System.out.println("CPU中断");
            System.out.println("这是一条I/O初始化指令，通道管理器正在初始化设备...");
        }

        private static void work() {
            System.out.println("工作状态");
            System.out.println("CPU正在工作...");
            System.out.println("CPU正在工作...");
            System.out.println("初始化状态");
            initD();
            System.out.println("CPU中断");
            System.out.println("这是一条I/O初始化指令，通道管理器正在初始化设备...");
            successWork();
        }
    }
