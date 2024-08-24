import java.util.ArrayList;

public class NearestPallindrome {

    public long findNearestPallindrome(long firstHalf, boolean isOdd){
        long res = firstHalf;
        if(isOdd){
            firstHalf/=10;
        }
        while(firstHalf>0){
            res = res * 10 + (firstHalf%10);
            firstHalf/=10;
        }
        return res;
    }    
    public String nearestPalindromic(String n) {
        ArrayList<Long> list = new ArrayList<Long>();
        int len = n.length();
        boolean isodd = (len%2!=0);
        int mid = (len%2 ==0)? (len/2):(len/2 +1);
        Long firstHalf = Long.parseLong (n.substring(0,mid));
        list.add(findNearestPallindrome(firstHalf, isodd));
        list.add(findNearestPallindrome(firstHalf+1, isodd));
        list.add(findNearestPallindrome(firstHalf-1, isodd));
        list.add((long)Math.pow(10, len-1)-1);
        list.add((long)Math.pow(10, len)+1);
        long num = Long.parseLong(n);
        Long minDiff = Long.MAX_VALUE;
        long res = Long.MAX_VALUE;
        for(Long element : list){
            if(element == num) continue;
            long currDiff = Math.abs(element-num);
            if(currDiff < minDiff){
                res = element;
                minDiff = currDiff;
            }else if(currDiff == minDiff){
                res = Math.min(res, element);
            }
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        NearestPallindrome np = new NearestPallindrome();
        System.out.println(np.nearestPalindromic("5")); 
        System.out.println(np.nearestPalindromic("100")); 
        System.out.println(np.nearestPalindromic("123")); 
        System.out.println(np.nearestPalindromic("1000")); 
    }
}