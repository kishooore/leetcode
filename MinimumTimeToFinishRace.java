public class MinimumTimeToFinishRace {
    public static void main(String[] args) {
        int[][] tires = {{1,10}, {2,2}, {3,4}};
        MinimumTimeToFinishRace test = new MinimumTimeToFinishRace();
        int min = test.minimumFinishTime(tires, 6, 5);
        System.out.print(min);
    }

    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        int min = Integer.MAX_VALUE;
        for (int i=0; i<tires.length; i++) {
            min = Math.min(min, race(tires, i, changeTime, numLaps, 0, i, 0));
        }
        return min;
    }

    private int race(int[][] tires, int tire, int changeTime, int numLaps, int completedLaps, int sameTireLap, int depth) {
        String tab = "";
        for (int i=0; i<depth; i++) {
            tab = tab + "    ";
        }
//        System.out.println(tab + " tire: " + tire + " CL: " + completedLaps + " STL: " + sameTireLap);
        if (completedLaps == numLaps - 1) {
            int noChangeLast = tires[tire][0] * (int) Math.pow(tires[tire][1], sameTireLap);
            int changeLast = Integer.MAX_VALUE;
            String str = noChangeLast + ", ";
            for (int i=0; i<tires.length; i++) {
                int c = tires[i][0] + changeTime;
                str = str + c + ", ";
                changeLast = Math.min(c, changeLast);
            }
//            System.out.println(tab + " " + str);
//            System.out.println(tab + " tire: " + tire + " CL: " + completedLaps + " STL: " + sameTireLap + " -OP: " + Math.min(changeLast, noChangeLast));
            return Math.min(changeLast, noChangeLast);
        }
        int noChange = tires[tire][0] * (int) Math.pow(tires[tire][1], sameTireLap) + race(tires, tire, changeTime, numLaps, completedLaps+1, sameTireLap+1, depth+1);
        int change = Integer.MAX_VALUE;
        String str = noChange + ", ";
        for (int i=0; i<tires.length; i++) {
            int c = changeTime + race(tires, i, changeTime, numLaps, completedLaps+1, 0, depth+1);
            str = str + c + ", ";
            change = Math.min(change, c);
        }
//        System.out.println(tab + " " + str);
//        System.out.println(tab + " tire: " + tire + " CL: " + completedLaps + " STL: " + sameTireLap + " OP: " + Math.min(change, noChange));
        return Math.min(change, noChange);
    }
}
