import java.math.BigDecimal;
import java.util.List;

public class Test {

 public static void main(String args[]) {

  Store s = new Store();
  s.setItemInStock(new Item("Nexus S", new BigDecimal(300)));
  s.setItemInStock(new Item("Galaxy S 4G", new BigDecimal(400)));
  s.setItemInStock(new Item("Nexus S 4G", new BigDecimal(400)));
  s.setItemInStock(new Item("Galaxy S2", new BigDecimal(700)));
  s.setItemInStock(new Item("Xperia Arc", new BigDecimal(500)));
  s.setItemInStock(new Item("Sensation 4G", new BigDecimal(600)));
  s.setItemInStock(new Item("Galaxy Nexus", new BigDecimal(750)));
  s.setItemInStock(new Item("iPhone 5", new BigDecimal("799.99")));

  // Get items from Store between 299 and 799
  List<Item> itemsInRange = (List<Item>) s.getItemsInStock(new BigDecimal(299), new BigDecimal(799));

  if (itemsInRange != null) {
   for (Item i : itemsInRange) {
    System.out.println(i);
   }
  } else {
   System.out.println("Sorry, no items found in the price range!");
  }
 }
}

