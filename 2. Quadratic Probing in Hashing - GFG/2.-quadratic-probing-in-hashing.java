// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- >0)
        {
            int hash_size = sc.nextInt();
            int N= sc.nextInt();
            
            int arr[] = new int[N];
            
            for(int i = 0; i < N ; i++)
             arr[i] = sc.nextInt();
             
            int hash_table[] = new int[hash_size];
            Solution obj = new Solution();
            obj.quadraticProbing(hash_table, hash_size, arr, N);
            
            for(int i = 0; i <hash_size; i++)
             System.out.print(hash_table[i] + " ");
             
             System.out.println();
             
        }
    }
    
}
// } Driver Code Ends


class Solution{
    //Function to fill the array elements into a hash table 
    //using Quadratic Probing to handle collisions.
    static void quadraticProbing(int[] hash, int hash_size, int arr[], int N)
    {
        Arrays.fill(hash , -1);
        for(int i =0; i<N ; i++)
        {
            int h = arr[i]%hash_size;
            if(arr[i] == hash[h]) 
                continue;
            if(hash[h] == -1)
                hash[h] = arr[i];
            else{
                int power=1;
                while(hash[(h+power*power)%hash_size]!=-1)
                {
                     power++;
                }
                hash[(h+power*power)%hash_size] = arr[i];
                // for (int j = 1; j < hash_size; j++){
                //     int index= (hash_key + j*j) % hash_size;
                //     if(hash[index] == arr[i]) break;
                //     if(hash[index] == -1) {
                //         hash[index] = arr[i]; break;
                //     }
                // }
                
            }
        }
    }
}
