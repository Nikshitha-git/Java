import java.util.Scanner;

public class SegmentTreeSum {
    static int[] arr;   // Original array
    static int[] tree;  // Segment tree

    // Build the tree
    static void build(int i, int low, int high) {
        if (low == high) {
            tree[i] = arr[low];
        } else {
            int mid = (low + high) / 2;
            build(2 * i + 1, low, mid);
            build(2 * i + 2, mid + 1, high);
            tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
        }
    }

    // Query the sum in range [l, r]
    static int query(int index, int start, int end, int l, int r) {
        if (r < start || end < l) return 0; // No overlap
        if (l <= start && end <= r) return tree[index]; // Total overlap

        int mid = (start + end) / 2;
        int left = query(2 * index + 1, start, mid, l, r);
        int right = query(2 * index + 2, mid + 1, end, l, r);
        return left + right;
    }

    // Update index i to new value val
    static void update(int index, int start, int end, int i, int val) {
        if (start == end) {
            arr[i] = val;
            tree[index] = val;
        } else {
            int mid = (start + end) / 2;
            if (i <= mid)
                update(2 * index + 1, start, mid, i, val);
            else
                update(2 * index + 2, mid + 1, end, i, val);

            tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n];      
        for (int i = 0; i < n; i++) 
            arr[i] = sc.nextInt();
        
        tree = new int[4 * n];
        build(0, 0, n - 1);

        int l = sc.nextInt();
        int r = sc.nextInt();
        query(0, 0, n - 1, l, r);

        int i = sc.nextInt();
        int val = sc.nextInt();
        update(0, 0, n - 1, i, val);

        l = sc.nextInt();
        r = sc.nextInt();
        query(0, 0, n - 1, l,r);
    }
}