/******************************************************************************

Bob went to his favourite bakery to buy some pastries. 
After picking up his favourite pastries his total bill was P cents. 
Bob lives in Berland where all the money is in the form of coins with denominations {1, 2, 5, 10, 20, 50, 100, 500, 1000}.
Bob is not very good at maths and thinks fewer coins mean less money and he will be happy if he gives minimum number of coins to the shopkeeper. 
Help Bob to find the minimum number of coins that sums to P cents (assume that Bob has an infinite number of coins of all denominations).
*******************************************************************************/

public class Solution {

    public static int minimumCoins(int p){
        int coins[] = {1,2,5,10,20,50,100,500,1000};
    
        int count=0;
        for(int i=8;i>=0;i--){
            while(p>=coins[i]){
                p = p-coins[i];
                count++;
            }
            if(p==0)
                return count;
        }
        return count;
       
    }
}

