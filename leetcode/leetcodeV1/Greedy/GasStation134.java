package Greedy;

    //If car starts at A and can not reach B. Any station between A and B can not reach B.(B is the first station that A can not reach.)
    /*Proof to the first point: say there is a point C between A and B -- that is A can reach C but cannot reach B.
    Since A cannot reach B, the gas collected between A and B is short of the cost.
    Starting from A, at the time when the car reaches C, it brings in gas >= 0, and the car still cannot reach B.
    Thus if the car just starts from C, it definitely cannot reach B.*/
public class GasStation134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        int start = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        if (sumGas < sumCost) {
            return -1;
        } else {
            return start;
        }
    }
}
