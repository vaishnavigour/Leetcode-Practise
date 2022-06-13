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
            int array_size = sc.nextInt();
            
            int arr[] = new int[array_size];
            for(int i = 0; i < array_size; i++)
             arr[i] = sc.nextInt();
             
            // int hash_table[] = new int[hash_size];
            // for(int i = 0; i < hash_size; i++)
            //     hash_table[i] = -1;
            Solution obj = new Solution();
            int hash_table[] = obj.linearProbing(hash_size, arr, array_size);
            
            for(int i = 0; i <hash_size; i++)
                System.out.print(hash_table[i] + " ");
             
            System.out.println();
             
        }
    }
    
}// } Driver Code Ends


class Solution{
    //Function to fill the array elements into a hash table 
    //using Linear Probing to handle collisions.
    int[] linearProbing(int hash_size, int arr[], int sizeOfArray)
    {
        int[] hash = new int[hash_size];
        for(int i=0 ; i<hash_size ; i++){
            hash[i] = -1;
        }
        for(int i=0; i<sizeOfArray ; i++){
            if(hash[arr[i]%hash_size] == -1)
            {
                hash[arr[i]%hash_size] = arr[i];
            }
            else
            {
                int counter =0 , flag =0;
                int key = arr[i]%hash_size ;
                while(counter < hash_size && hash[key] != -1){
                     if(hash[key]==arr[i])
                    {
                        flag=1;
                        break;
                    }
                    key=(key+1)%hash_size;
                    counter++;
                }
                if (flag ==1 )
                    continue;
                    
                if(counter < hash_size)
                    hash[key] = arr[i];
            }
        }
        return hash;
        
    }
}