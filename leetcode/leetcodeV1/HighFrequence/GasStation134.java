package HighFrequence;

public class GasStation134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, total = 0, tank = 0;

        //if car fails at 'start', record the next station
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1; //move starting position forward
                total += tank; //add the negative tank value to total
                tank = 0; //reset tank
            }
        }
        //negative total + positive tank should be 0 or more, if so we can do a round trip and return start
        return (total + tank < 0) ? -1 : start;
    }
}
