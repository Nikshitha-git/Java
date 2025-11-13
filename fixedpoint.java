public class fixedpoint {
    public static int fix(int arr[], int n) {
        int low = 0;
        int high = n - 1;
        int res = -1;
        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (arr[mid] == mid) {
                return mid;
            } else if (arr[mid] > mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[] = {-10, -5, 0, 3, 7};
        int res = fix(arr, arr.length);
        System.out.println("Fixed Point: " + res);
    }
}
