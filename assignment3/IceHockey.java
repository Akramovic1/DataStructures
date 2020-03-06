package eg.edu.alexu.csd.datastructure.icehockey.cs18010056;
import java.awt.Point;
import java.util.Arrays;
import java.util.Vector;

public class IceHockey implements IPlayersFinder {
    // Attributes
    int Area = 0;
    int MinimumOfI;
    int MinimumOfJ;
    int MaximumOfI;
    int MaximumOfJ;
    public static final int STEP = 4;
    public static final int ArraySize = 100;
    Vector<Point> SolutionVector = new Vector<>();
    boolean[][] CHECKER = new boolean[ArraySize][ArraySize];

    //Functions , I used Recursion
    public int Recursion(final String[] SHOOT, final int i, final int j, final char TheDesired) {
        char Required = SHOOT[i].charAt(j);
        if (Required != TheDesired || CHECKER[i][j]) {
            return Area; }
        else {
            if (i <= MinimumOfI) { MinimumOfI = i; }
            if (MaximumOfI <= i) { MaximumOfI = i; }
            if (j <= MinimumOfJ) { MinimumOfJ = j; }
            if (MaximumOfJ <= j) { MaximumOfJ = j; }
            CHECKER[i][j] = true;
            Area += STEP;
            if (i - 1 >= 0) { Recursion(SHOOT, i - 1, j, TheDesired); }
            if (i + 1 < SHOOT.length) { Recursion(SHOOT, i + 1, j, TheDesired); }
            if (j - 1 >= 0) { Recursion(SHOOT, i, j - 1, TheDesired); }
            if (j + 1 < SHOOT[0].length()) { Recursion(SHOOT, i, j + 1, TheDesired); }
            return Area;
        } }

    @Override
    public Point[] findPlayers(final String[] SHOOT, final int team, final int threshold) {
        if (SHOOT == null) {
            return null;
        } else {
            String NO = String.valueOf(team);
            char TheDesired = NO.charAt(0);
            int size = SHOOT.length;
            int i, j;
            int col = SHOOT[0].length();
            for (i = 0; i < size; i++)
                for (j = 0; j < col; j++) {
                    char Required = SHOOT[i].charAt(j);
                    if (Required == TheDesired) {
                        Area = 0;
                        MinimumOfI = i;
                        MinimumOfJ = j;
                        MaximumOfI = i;
                        MaximumOfJ = j;
                        int Q = Recursion(SHOOT, i, j, TheDesired);
                        if (Q >= threshold) {
                            int y = (2 * MinimumOfI + 2 * (MaximumOfI + 1)) / 2;
                            int x = (2 * MinimumOfJ + 2 * (MaximumOfJ + 1)) / 2;
                            Point center = new Point(x, y);
                            SolutionVector.add(center);
                        }
                    }
                }
            int s = SolutionVector.size();
            Point[] FP = new Point[s];
            for (int k = 0; k < s; k++) {
                FP[k] = SolutionVector.get(k); }
            Arrays.sort(FP, (a, b) -> {
                int COM = Integer.compare(a.x, b.x);
                if (COM == 0) {
                    return Integer.compare(a.y, b.y);
                } else {
                    return COM;
                }
            });
            for (int z = 0; z < ArraySize; z++) {
                for (int t = 0; t < ArraySize; t++) {
                    CHECKER[z][t] = false;
                } }
            SolutionVector.removeAllElements();
            return FP; }
    }}