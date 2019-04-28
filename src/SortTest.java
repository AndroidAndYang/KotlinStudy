import java.util.Arrays;

/**
 * author： YJZ
 * date:  2019/4/11
 * des:
 */
public class SortTest {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2, 6, 7, 9, 8, 1};
        bubbling(arr);
    }

    // 冒泡排序
    private static void bubbling(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) { // n
            for (int j = 0; j < arr.length - i - 1; j++) { // n * n
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j]; // 1
                    arr[j] = arr[j + 1]; // 1
                    arr[j + 1] = temp; // 1
                    // n*n + n + 3
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
