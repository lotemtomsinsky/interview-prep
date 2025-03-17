package Stack;

import java.util.Arrays;
import java.util.Stack;

// https://neetcode.io/problems/car-fleet

public class CarFleet {
    public static int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> s = new Stack<>();
        
        // build an array of arrays where each internal array represents a given car's [position, speed] and is sorted in 
        // descending order based on positions 
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < cars.length; i++)
        {
            cars[i] = new int[]{position[i], speed[i]};
        }
        // use the (arg, comparator) overload of Arrays.sort where we use a lambda expression to build our own custom 
        // comparator that will sort the overall array by the first value of each inner array in descending order. 
        // Integer.compare does an ascending comparison by default, so if we want descending order we need to switch the 
        // position of the arguments
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        // go through the cars. if the stack is empty, add the first car's time to stack. for every other, if t of current <=
        // s.peek(), continue. else add t current to the stack
        for (int i = 0; i < cars.length; i++)
        {
            // if both args are ints, assigning answer to double isn't enough the / will still truncate the remainder and then
            // cast the int result to a double. to get it w/ remainder, at least one of the args must be a double
            double time = (double)(target - cars[i][0]) / (double) cars[i][1];
            
            // if it's the first car, then initialize the stack with its destination time 
            if ( i == 0)
            {
                s.push(time);
            }
            else
            {
                // cars form the same fleet if the car behind reaches the destination faster than or at the same time as the car 
                // in front. Therefore, it forms a different fleet if the car behind arrives slower than the car in front. Add the 
                // newest fleet's arrival time to the stack
                if (time > s.peek())
                {
                    s.push(time);
                }
            }
        }

        // since we push a new arrival time for each fleet, the size of the stack = # fleets
        return s.size();
    }

    public static void main(String[] args)
    {
        /* 
        // case: both arrive at target same time
        int target = 10;
        int[] position = {1,4};
        int[] speed = {3, 2};
        System.out.println(carFleet(target, position, speed)); // expected: 1
        */

        /* 
        // case: some arrive at target same time, some don't
        int target = 10;
        int[] position = {4,1,0,7};
        int[] speed = {2,2,1,1};
        System.out.println(carFleet(target, position, speed)); // expected: 3
        */

        /* 
        // case: car behind catches up to car in front, so they end up arriving @ same time
        int target = 10;
        int[] position = {2,5};
        int[] speed = {4, 2};
        System.out.println(carFleet(target, position, speed)); // expected: 1
        */

        int target = 10;
        int[] position = {6,8};
        int[] speed = {3, 2};
        System.out.println(carFleet(target, position, speed)); // expected: 2
    }
}
