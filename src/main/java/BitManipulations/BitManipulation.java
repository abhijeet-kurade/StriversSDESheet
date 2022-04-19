package BitManipulations;

public class BitManipulation {
    public static void main(String[] args) {
        //int[] unique = twoNonRepeatingNumbers(new int[]{12,4,6,4,8,6,412,9,9,8}) ;
        // System.out.println(unique[0] +" "+unique[1]);
        //System.out.println(singleUniqueNumber(new int[]{3,4,2,5,4,3,5,2,11115}));
        //System.out.println(oppositeSign(21, -98));
        //int num = 107;
        //int[] arr = {2,3,4,5,6,7,5,6,4,5,5,6,6,2,3};
        //getBinaryRepresentation(num);
        //getBinaryRepresentation(turnOffRightMostSetBit(num));
        //System.out.println(positionOfOnlySetBit(num));
        //System.out.println(countSetBits1(num));
        //getBinaryRepresentation(num);
        //getBinaryRepresentation(swapNibbles(num));

//        int[] arr = {9,1,14,13,15};
//        System.out.println(diffBits(arr));
        System.out.println(oppositeSign(100, -200));
    }
    public static boolean oppositeSign(int num1, int num2){

        //return ((num1^num2) & (1<<31)) != 0;

        int sign_bit = 1<<31;
        return ((num1&sign_bit)^(num2&sign_bit)) != 0;
    }

    // DSA1 - Flatten the Tree, Array - find sqr
    // DSA2 - add 1 in to string, OS qs mutex, semaphore, multithreading
    // DSA3 - colorSort

    public static int[] twoNonRepeatingNumbers(int[] arr){
        int xor = 0;
        for( int num : arr) xor ^= num;
        getBinaryRepresentation(xor);
        getBinaryRepresentation(-xor);
        xor &= (-xor);
        getBinaryRepresentation(xor);
        int num1=0, num2=0;
        for(int num : arr){
            if((num & xor) > 0) num1 ^= num;
            else num2 ^= num;
        }
        getBinaryRepresentation(num1);
        getBinaryRepresentation(num2);
        return new int[]{num1, num2};
    }
    public static int singleUniqueNumber(int[] arr){
        int number = 0;
        for(int num : arr) number ^= num;
        return number;
    }

    public static int addOne(int num){
        int andingNumber = -1;
        int bitCheck = 1;
        while((num&bitCheck)!= 0){
            andingNumber<<=1;
            bitCheck<<=1;
        }
        return (num&andingNumber)|bitCheck;
    }
    public static int addOne1(int num){
        return -(~num);
    }
    public static int turnOffRightMostSetBit(int num){
        int right_most = num & (-num);
        return num & (~right_most);
    }
    public static int turnOffRightMostSetBit1(int num){
        return num & (num-1);
    }

    public static boolean isPowerOfTwo(int num){
        //if(num == 1) return true;
        int set_bits = num & (num-1);
        return set_bits == 0;
    }
    public static boolean isPowerOfFour(int num){
        int count = 0;
        int set_bits = 0;
        for(int i=0; i<32; i++){
            set_bits += (num>>i)&1;
            if(((num>>i)&1) == 1 && count ==0) count = i;
        }
        if(set_bits > 1 || count == 0) return false;
        return count%2 == 0;
    }
    public static int getModuloByPowOf2Numbers(int num, int pow){
        return num & (pow - 1);
    }
    public static int leftRotate(int num, int shift){
        return (num<<shift) |(num>>(32-shift));
    }
    public static int getOddOccurrence(int[] arr){
        int number = 0;
        for(int num: arr) number ^= num;
        return number;
    }
    public static int countSetBits(int num){
        int count = 0;
        while (num != 0){
            num &= (num - 1);
            count += 1;
        }
        return count;
    }
    public static int countSetBits1(int num){
        int count = 0;
        for(int i=0; i<32; i++){
            count += (num>>i)&1;
        }
        return count;
    }
    public static String getBinaryRepresentation(int num){
        String brep = "";
        for(int i=0; i<32; i++){
            int bit = num & 1;
            num = num >> 1;
            brep = String.valueOf(bit) + brep;
        }
        System.out.println(brep);
        return brep;
    }
    public static int flippedCount(int num1, int num2){
        int xor = num1 ^ num2;
        int count = 0;
        while(xor != 0){
            xor &= (xor-1);
            count += 1;
        }
        return count;
    }
    public static int positionOfOnlySetBit(int num){
        int count = 0;
        while(num > 0){
            num >>= 1;
            count += 1;
        }
        return count;
    }

    public static int[] swapNumbersUsingMultiplication(int[] nums){
        int x = nums[0];
        int y = nums[1];
        x = x * y;
        y = x / y;
        x = x / y;
        return new int[]{x, y};
    }
    public static int[] swapNumbersUsingAddition(int[] nums){
        int x = nums[0];
        int y = nums[1];
        x = x + y;
        y = x - y;
        x = x - y;
        return new int[]{x, y};
    }
    public static int[] swapNumbersUsingXor(int[] nums){
        int x = nums[0];
        int y = nums[1];
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        return new int[]{x, y};
    }

    public static int swapNibbles(int num){
        return ((num & 0x0F) << 4) | ((num & 0xF0) >> 4);
        //return ((num << 4) | (num >> 4)) & (Integer.MAX_VALUE >> 23);
    }

    public static int diffBits(int[] arr){
        int sum = 0;
        for(int i=0; i<32; i++){
            int ones = 0;
            int zeros = 0;
            for(int j=0; j<arr.length; j++){
                int bit = (arr[j]>>i)&1;
                if(bit==1) ones += 1;
                else zeros += 1;
            }
            //System.out.println(i+" "+ ones +" "+zeros);
            sum += ones * zeros;
        }
        return sum;
    }
}
