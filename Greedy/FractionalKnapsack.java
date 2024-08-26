//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0, k = 0; i < n; i++) {
                arr[i] = new Item(Integer.parseInt(inputLine[k++]),
                                  Integer.parseInt(inputLine[k++]));
            }
            System.out.println(
                String.format("%.6f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item arr[], int n) {
        Arrays.sort(arr, (a, b) -> {
            double ratioA = (double) a.value / a.weight;
            double ratioB = (double) b.value / b.weight;
            return Double.compare(ratioB, ratioA);
        });
        
        int i = 0;
        double ans = 0;
        
        while (w > 0 && i < n) {
            if (arr[i].weight <= w) {
                ans += arr[i].value;
                w -= arr[i].weight;
                
            } else {
                double perUnit = (double) arr[i].value/arr[i].weight;
                ans += perUnit * w;
                w = 0;
            }
            
            i++;
        }
        
        return ans;
    }
}