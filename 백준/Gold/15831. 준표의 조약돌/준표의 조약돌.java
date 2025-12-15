import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int w = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();
        
        int[] bPrefix = new int[n+1];
        int[] wPrefix = new int[n+1];
        for(int i = 1; i <= n; i++){
            char c = input.charAt(i-1);
            if(c == 'W'){
                wPrefix[i] = wPrefix[i-1] + 1;
                bPrefix[i] = bPrefix[i-1];
            } else {
                wPrefix[i] = wPrefix[i-1];
                bPrefix[i] = bPrefix[i-1] + 1;
            }
        }
        
        int start = 1;
        int end = 1;
        int answer = 0;
        
        while(start <= n && end <= n){
            int result = check(bPrefix, wPrefix, b, w, start, end);
            // 성공
            if(result == 1){
                answer = Math.max(answer, end - start + 1);
                
                if(end < n){
                    end++;
                } else {
                    start++;
                }
            }
            
            // 검은돌 많은 경우
            else if(result == -2 && start < end){
                start++;
                
            } else if(start >= end){
                end++;
            }
            
            // 흰돌 부족한 경우
            else if(result == -1) {
                end++;
            }
            

                        
        }
        System.out.println(answer);
        //System.out.println(Arrays.toString(wPrefix));
        //System.out.println(Arrays.toString(bPrefix));
        
        // 실패
        // 하얀조약돌이 부족한 경우 -1
        // 검은조약돌이 많은 경우 -2
        // 
        // 
        // 성공
        // 하얀조약돌이 기준보다 많고, 검은 조약돌이 기준보다 작은 경우 1
    }
    
    public static int check(int[] bPrefix, int[] wPrefix, int b, int w, int start, int end){
        int bCount = bPrefix[end] - bPrefix[start-1];
        int wCount = wPrefix[end] - wPrefix[start-1];
        
        if(bCount > b) {
            return -2;
        } else if (wCount < w) {
            return -1;
        } else if(bCount <= b && wCount >= w){
            return 1;
        } else {
            return -3;
        }
    }
}