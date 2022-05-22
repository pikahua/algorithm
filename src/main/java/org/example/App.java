package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur = m + n - 1;
        while (n > 0) {
            if (m == 0) {
                while (n > 0) {
                    nums1[cur--] = nums2[n - 1];
                    n--;
                }
            } else {
                if (nums1[m - 1] <= nums2[n - 1]) {
                    nums1[cur--] = nums2[n - 1];
                    n--;
                } else {
                    nums1[cur--] = nums1[m - 1];
                    m--;
                }
            }
        }
    }
}
