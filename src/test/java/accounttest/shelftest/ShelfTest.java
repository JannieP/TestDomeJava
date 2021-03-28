package accounttest.shelftest;

import org.junit.Assert;
import org.junit.Test;
import shelftest.Shelf;

public class ShelfTest {

    @Test
    public void shelfCanAcceptAndReturnItem() {
        Shelf shelf = new Shelf();
        shelf.put("Orange");
        Assert.assertTrue(shelf.take("Orange"));
    }

    @Test
    public void shelfDoNothingWhenPassedNull() {
        Shelf shelf = new Shelf();
        shelf.put(null);
        shelf.put("");
        Assert.assertFalse(shelf.take(null));
        Assert.assertFalse(shelf.take(""));
    }

    @Test
    public void eachItemOnlyTakenOnce() {
        Shelf shelf = new Shelf();
        shelf.put("Orange");
        Assert.assertTrue(shelf.take("Orange"));
        Assert.assertFalse(shelf.take("Orange"));
    }

    @Test
    public void duplicatesMayExist() {
        Shelf shelf = new Shelf();
        shelf.put("Orange");
        shelf.put("Orange");
        Assert.assertTrue(shelf.take("Orange"));
        Assert.assertTrue(shelf.take("Orange"));
        Assert.assertFalse(shelf.take("Orange"));
    }

}
