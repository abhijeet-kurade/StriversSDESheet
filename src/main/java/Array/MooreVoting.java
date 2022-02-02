package Array;

public class MooreVoting {

    public static void main(String[] args) {
        int[] arr = findMajorityNumberNby3(new int[]{2,3,1,1,3});
        System.out.println(arr[0] +" "+arr[1]);
    }

    public static int findMajorityNumberNby2(int[] arr){
        if(arr.length == 0) return 0;
        int number = arr[0];
        int count = 1;
        for(int i=1; i<arr.length; i++){
            if(count == 0) number = arr[i];
            if(arr[i] == number) count += 1;
            else count += -1;
        }
        return number;
    }

    public static int[] findMajorityNumberNby3(int[] arr){
        int num1 = arr[0], num2=arr[1];
        int count1 = 0, count2 = 0;
        for(int i=2; i<arr.length; i++){
            if(count1 == 0) num1 = arr[i];
            else if(count2 == 0) num2 =arr[i];
            if(arr[i] == num1) count1 += 1;
            else if(arr[i] == num2) count2 += 1;
            else {
                count1 += -1;
                count2 += -1;
            }
        }
        return new int[]{num1, num2};
    }

}
