package Interviews.glance.coding;

//import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//@RunWith(Mockit.class)
public class TripletsTest {

    private Triplets triplets;

    @Before
    public void setup(){
        triplets = new Triplets();
    }


    @Test
    public void getTriplets() {
        Assert.assertEquals(1, triplets.getTriplets(new int[]{7, 4}, new int[]{5, 2, 8, 9}));
        Assert.assertEquals(9, triplets.getTriplets(new int[]{1,1}, new int[]{1,1,1}));
        Assert.assertEquals(2, triplets.getTriplets(new int[]{7, 7, 8, 3}, new int[]{1, 2, 9, 7}));
    }
}