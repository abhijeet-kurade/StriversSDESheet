package BinarySearch;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1};//{1,2,3,4,7};
        int[] arr2 = {1,2,2,2,3,4,5,6,7,8,9,9,10};//{6,10,12,15,20};
        System.out.println(medianOfTwoSortedArrays(arr1, arr2));

    }
    public static double medianOfTwoSortedArray(int[] arr1, int[] arr2){
        int n = arr1.length, m=arr2.length;
        int half = (m+n) / 2;
        System.out.println("half "+half);
        if(n>m) return medianOfTwoSortedArray(arr2, arr1);

        int left=0, right=n-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            int a1 = mid, a2 = mid+1;
            int b2 = half-a2, b1 = b2-1;
            System.out.println(mid+ " "+a1 +" "+a2 +" "+b1+" "+b2);
            int l1 = arr1[a1], r1 = a2>n-1?Integer.MAX_VALUE:arr1[a2];
            int l2=b1<0?Integer.MIN_VALUE:arr2[b1], r2=b2>n-1?Integer.MAX_VALUE: arr2[b2];
            if(arr1[a1]<=arr2[b2] && arr2[b1]<=arr1[a2]){
                if((n+m)%2 == 0){
                    return (Math.max(arr1[a1], arr2[b1]) + Math.min(arr1[a2], arr2[b2]) ) / 2.0;
                }
                else{
                    return Math.min(arr1[a2], arr2[b2]);
                }
            }
            else{
                if(arr1[a1]>arr2[b2])  right = mid-1;
                else left = mid+1;
            }
        }
        return -1;
    }

    public static double medianOfTwoSortedArrays(int[] arr1, int[] arr2){
        int m = arr1.length, n = arr2.length;;
        if(m>n) return medianOfTwoSortedArrays(arr2, arr1);
        int left=0, right=m, half=(m+n+1)/2;
        int MIN=Integer.MIN_VALUE, MAX=Integer.MAX_VALUE;
        while(left<=right){
            int mid1 = left + (right-left)/2;
            int mid2 = half - mid1;

            /*
            int l1 = (cut1 == 0)? Integer.MIN_VALUE:arr1[cut1-1];
            int l2 = (cut2 == 0)? Integer.MIN_VALUE:arr2[cut2-1];
            int r1 = (cut1 == m)? Integer.MAX_VALUE:arr1[cut1];
            int r2 = (cut2 == n)? Integer.MAX_VALUE:arr2[cut2];
            */

            int l1 = mid1<=0?MIN:arr1[mid1-1], r1 = mid1>=m?MAX:arr1[mid1];
            int l2 = mid2<=0?MIN:arr2[mid2-1], r2 = mid2>=n?MAX:arr2[mid2];
            if(l1<=r2 && l2<=r1){
                if((n+m)%2==0) return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                else return Math.min(l1,l2);
            }
            else if(l1>r1) right = mid1 - 1;
            else left = mid1 + 1;
        }
        return 0;
    }
}
