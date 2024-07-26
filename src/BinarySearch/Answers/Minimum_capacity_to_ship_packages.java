package BinarySearch.Answers;

public class Minimum_capacity_to_ship_packages {
    /**
     * A conveyor belt has packages that must be shipped from one port to another within `days` days.
     * The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
     * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.
     * */

    public int findDays(int[] weights, int capacity){
        int days = 1, load = 0;
        int n = weights.length;
        for (int i = 0; i < n; i++) {
            if(load + weights[i] > capacity){
                // Load this to next day
                load = weights[i];
                days += 1;
            }
            else{
                load += weights[i];
            }
        }

        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        // WE know that the capacity of the ship lies between max(weights) and sum(weights)

        // Bruteforce: We check for all the possible capacities of the arrays.
        // Here we apply linear search, and then we calculate how many days does it need to ship those itens.
        // If days are less than deadline, that is our result.

        int sum = 0, maxi = Integer.MIN_VALUE;
        for(int weight: weights){
            sum += weight;
            maxi = Math.max(maxi, weight);
        }

        int low = maxi, high = sum;
        while(low <= high){
            int mid = (low + high) / 2;
            int daysTaken = findDays(weights, mid);

            if(daysTaken <= days){
                // Capacity is high
                high = mid - 1;
            }
            else{
                // Capacity is low
                low = mid + 1;
            }
        }

        return low;
    }
}