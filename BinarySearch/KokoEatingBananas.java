package BinarySearch;

import java.util.Arrays;

// https://neetcode.io/problems/eating-bananas

public class KokoEatingBananas {
    /*
     * since there's a direct relationship between the eating speed and the total time needed to finish all bananas,
     * we can use binary search over the range of possible speeds, where Koko can eat from speed 1 banana/hr to 
     * max # bananas in piles per hour. The target here is h
     * The idea behind this is if Koko can eat all the bananas with the current speed, make the current time the result
     * and set the next area to search for possible answers as anything less than the current speed. Otherwise if Koko
     * can't finish, we need to increase the speed and discount any answers that are the current speed ofr less 
     */
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1; 
        int high = 0;
        for (int p : piles)
        {
            high = Math.max(high, p);
        }
        int result = high;

        while (low <= high)
        {
            int middle = low + (high - low) / 2; // this represents k in the problem description
            int totalTime = timeTaken(middle, piles);
            
            // if Koko can finish the bananas in upto h hours at the current speed, try decreasing it (aka lowering 
            // the high value) to see if Koko can finish in even less time
            if (totalTime <=  h)
            {
                result = middle;
                high = middle - 1;
            }
            // Koko can't finish, so we need to consider a higher speed
            else
            {
                low = middle + 1;
            }
        }

        return result;
    }

    /*
     * this is a helper function to determine how long it takes Koko to eat all the bananas with the given speed
     */
    private static int timeTaken(int speed, int[] piles)
    {
        int hours = 0;
        for (int i = 0; i < piles.length; i++)
        {
            /* 
             * note: neetcode doesn't recognize Math.cielDiv because it's not in the stanadard lib. 
             * subtracting 1 and then adding the speed makes sure any non-zero remainder causes the division to round
             * up since we can't have decimals in the Koko problem, and we need to round up.
            */
            hours += (piles[i] + speed - 1) / speed;
        }

        return hours;
    }

    public static void main(String[] args)
    {
        // int[] piles = {1,4,3,2};
        // int h = 9;
        // System.out.println(minEatingSpeed(piles, h)); // expect: 2

        
        int[] piles = {25,10,23,4};
        int h = 4;
        System.out.println(minEatingSpeed(piles, h)); // expect: 25
         
    }
}
