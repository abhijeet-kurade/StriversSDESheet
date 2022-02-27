package BinarySearch;

public class NthRoot {
    public static void main(String[] args) {

        System.out.println(nthRoot(27, 3));
    }
    public static double power(double num, int pow){
        double result = 1;
        for(int i=0; i<pow; i++){
            result *= num;
        }
        return result;
    }

    public static double nthRoot(int number, int root){
        double left = 0, right = number;
        double precision = 1e-6;
        double mid = 0;
        while ((right-left) > precision){
            mid = left + (right - left)/2;
            double power = power(mid, root);
            if(power > number) right = mid;
            else left = mid;
        }

        return mid;
    }
}
