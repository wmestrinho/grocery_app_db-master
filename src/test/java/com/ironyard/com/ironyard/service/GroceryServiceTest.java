package com.ironyard.com.ironyard.service;

import com.ironyard.data.GroceryItem;
import com.ironyard.data.IronYardUser;
import com.ironyard.service.GroceryService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jasonskipper on 1/26/17.
 */
public class GroceryServiceTest {
    @Test
    public void getAll() throws Exception {

    }

    @Test
    public void save() throws Exception {
        IronYardUser aUser = new IronYardUser();
        aUser.setUsername("skipper.jason@gmail.com");
        GroceryItem item = new GroceryItem();
        item.setName("Carrot");
        item.setIsle(7);
        item.setPrice(3.99);
        item.setCat("");

        GroceryService gs = new GroceryService();
        gs.save(item);

        List<GroceryItem> allGs = gs.getAllGroceryFromDatabase();
        assertNotNull(allGs);
        assertEquals(1, allGs.size());
        GroceryItem foundItem = allGs.get(0);
        assertEquals(item.getName(), foundItem.getName());
        assertEquals(7, foundItem.getIsle());
        assertEquals(3.99, foundItem.getPrice(), .001);

    }

    @Test
    public void justShowItems(){
        IronYardUser aUser = new IronYardUser();
        aUser.setUsername("skipper.jason@gmail.com");

        GroceryService gs = new GroceryService();
        List<GroceryItem> allGs = gs.getAllGroceryFromDatabase();
        if(allGs!=null) {
            for (GroceryItem item : allGs) {
                System.out.print("found:" + item.getName());
            }
        }
    }

}