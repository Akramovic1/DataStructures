import eg.edu.alexu.csd.datastructure.icehockey.cs18010056.IPlayersFinder;
import eg.edu.alexu.csd.datastructure.icehockey.cs18010056.IceHockey;
import java.awt.Point;
import org.junit.Assert;
import org.junit.Test;

public class IceHockeyTEST{
    private IceHockey playersFinder = new IceHockey();

    @Test
    public void SHOOTex1() {
        IPlayersFinder test = (IPlayersFinder) playersFinder;
        final String[] SHOOT = {"11111",
                "1AAA1",
                "1A1A1",
                "1AAA1",
                "11111"};
        final int team = 1;
        final int threshold = 3;
        Point[] returnedPoints;
        returnedPoints = test.findPlayers(SHOOT, team, threshold);
        final Point[] ans = {new Point(5, 5), new Point(5, 5)};
        Assert.assertArrayEquals(ans, returnedPoints);
    }

    @Test
    public void SHOOTex2() {
        IPlayersFinder test = (IPlayersFinder) playersFinder;
        final String[] SHOOT = {"8D88888J8L8E888",
                "88NKMG8N8E8JI88",
                "888NS8EU88HN8EO",
                "LUQ888A8TH8OIH8",
                "888QJ88R8SG88TY",
                "88ZQV88B88OUZ8O",
                "FQ88WF8Q8GG88B8",
                "8S888HGSB8FT8S8",
                "8MX88D88888T8K8",
                "8S8A88MGVDG8XK8",
                "M88S8B8I8M88J8N",
                "8W88X88ZT8KA8I8",
                "88SQGB8I8J88W88",
                "U88H8NI8CZB88B8",
                "8PK8H8T8888TQR8"};
        final int team = 8;
        final int threshold = 9;
        Point[] returnedPoints;
        returnedPoints = test.findPlayers(SHOOT, team, threshold);
        final Point[] ans = {new Point(1, 17), new Point(3,3) , new Point(3,10) , new Point(3,25) , new Point(5 , 21),new Point(8 , 17 ), new Point(9,2),new Point(10,9),new Point(12,23),new Point(17,16),new Point(18,3),new Point(18,11),new Point(18,28),new Point(22,20), new Point(23,26),new Point(24,15),new Point(27,2),new Point(28,26),new Point(29,16)};
        Assert.assertArrayEquals(ans, returnedPoints);
    }

    @Test
    public void SHOOTex3() {
        IPlayersFinder test = (IPlayersFinder) playersFinder;
        final String[] SHOOT = null;
        final int team = 5;
        final int threshold = 12;
        Point[] returnedPoints;
        returnedPoints = test.findPlayers(SHOOT, team,threshold);
        final Point[] ans = null;
        Assert.assertArrayEquals(ans, returnedPoints);
    }

    @Test
    public void SHOOTex4() {
        IPlayersFinder test = (IPlayersFinder) playersFinder;
        final String[] SHOOT = {"33JUBU33",
                "3U3O4433",
                "O33P44NB",
                "PO3NSDP3",
                "VNDSD333",
                "OINFD33X"};
        final int team = 3;
        final int threshold =16;
        Point[] returnedPoints;
        returnedPoints = test.findPlayers(SHOOT, team, threshold);
        final Point[] ans = {new Point(4, 5), new Point(13, 9),new Point(14,2)};
        Assert.assertArrayEquals(ans, returnedPoints);
    }
    @Test
    public void SHOOTex5() {
        IPlayersFinder test = (IPlayersFinder) playersFinder;
        final String[] SHOOT = {"A12YUOL",
                "OLKMTIO",
                "YOMKIL2",
                "PLRWTBO",
                "MBNROLW",
                "TKLAMFG",
                "L33MRTO",
                "OP3FRWL"};
        final int team = 3;
        final int threshold = 8;
        Point[] returnedPoints;
        returnedPoints = test.findPlayers(SHOOT, team,
                threshold);
        final Point[] ans = {
                new Point(4, 14)};
        Assert.assertArrayEquals(ans, returnedPoints);
    }

}