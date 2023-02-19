//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b)
    {
        String x = "";
        String y = "";
        for(int i=0; i<a.size(); i++)
            x += a.get(i);
        for(int i=0; i<b.size(); i++)
            y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> ans = obj.findSequences(startWord, targetWord, wordList);
            if(ans.size()==0)
                System.out.println(-1);
            else
            {
                Collections.sort(ans, new comp());
                for(int i=0; i<ans.size(); i++)
                {
                    for(int j=0; j<ans.get(i).size(); j++)
                    {
                        System.out.print(ans.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public ArrayList<ArrayList<String>> findSequences(String beginWord, String endWord, String[] wordList)
    {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(String i: wordList){
            set.add(i);
        }

        //bfs
        Queue<ArrayList<String>> q = new LinkedList<>();
        q.add(new ArrayList<>());
        q.peek().add(beginWord);
        // set.remove(beginWord);
        while(!q.isEmpty()){
            int size =q.size();
            ArrayList<String> toRemove = new ArrayList<String>();
            while(size-->0){
                ArrayList<String> ls = q.peek();
                q.poll();
                String s = ls.get(ls.size()-1);
                for(int i=0; i<s.length(); i++){
                    for(char ch ='a'; ch <= 'z' ; ch++){
                        char[] replacedW = s.toCharArray();
                        replacedW[i] = ch;
                        String replaced = new String(replacedW);
                        if(set.contains(replaced)){
                            ls.add(replaced);
                            toRemove.add(replaced);
                            q.add(new ArrayList<>(ls));
                            if(replaced.equals(endWord)){
                                ans.add(new ArrayList<>(ls));
                            }
                            ls.remove(ls.size()-1);
                        }
                    }
                } 
            }
            while(toRemove.size()!=0){
                set.remove(toRemove.get(0));
                toRemove.remove(0);
            }
        }
        return ans;

    }
}