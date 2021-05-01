package com.example.brushalgorithmproblem.swordtooffer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/12 11:44 下午
 */
//数组中的逆序对
public class JZ35 {

    //    暴力方法 用于验证其他算法结果的准确性和性能比较
    public static int InversePairs(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    sum++;
                }
            }
        }
        return sum % 1000000007;
    }


    private static int[] arr = new int[200005];
    private static int count = 0;

    //    改进递归排序
    public static int InversePairs1(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
//        初始化
        count = 0;
        MergeSort(0, array.length - 1, array);
        return count;
    }

    public static void Merge(int left, int mid, int right, int[] array) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                arr[k++] = array[i++];
            } else {
//                这里进行合并的两段数[left,mid],[mid+1,right]都是有序的
//                所以[left,mid]中的某个数a(下标为i)大于[mid+1,right]中的某个数b时,
//                在[left,mid]中，[i,mid]这些数都大于b
                count = (count + mid - i + 1) % 1000000007;
                arr[k++] = array[j++];
            }
        }
        while (i <= mid) {
            arr[k++] = array[i++];
        }
        while (j <= right) {
            arr[k++] = array[j++];
        }
//        找逆序对不需要实际排序
        System.arraycopy(arr, left, array, left, right - left + 1);
    }

    public static void MergeSort(int left, int right, int[] array) {
        if (left < right) {
            int mid = (left + right) >> 1;
            MergeSort(left, mid, array);
            MergeSort(mid + 1, right, array);
            Merge(left, mid, right, array);
        }
    }

    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 0};

//        测试归并排序
//        MergeSort(0, array.length - 1, array);
//        Arrays.stream(array).forEach(a -> {
//            System.out.print(a + " ");
//        });
//        System.out.println();

//        7
        Long start = System.currentTimeMillis();
        System.out.println(InversePairs(array));
        System.out.println("Spending time: " + (System.currentTimeMillis() - start));
        System.out.println();

        start = System.currentTimeMillis();
        System.out.println(InversePairs1(array));
        System.out.println("Spending time: " + (System.currentTimeMillis() - start));
        System.out.println();
    }
}
