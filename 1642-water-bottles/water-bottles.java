class Solution {
    public int solve(int nb,int ne,int rem){
        if (nb == 0) return 0;

        // total bottles you can drink now
        int drank = nb;

        // how many new bottles can we get from exchanges
        int newBottles = (nb + rem) / ne;
        int newRem = (nb + rem) % ne;

        return drank + solve(newBottles, ne, newRem);
    }
    public int numWaterBottles(int numBottles, int numExchange) {
        return solve(numBottles,numExchange,0);
    }
}