import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Store {

 // list to hold the items in stock
 private List<Item> itemsInStock;

 public List<Item> getItemsInStock() {
  return itemsInStock;
 }

 public void setItemsInStock(List<Item> itemsInStock) {
  if (this.itemsInStock == null) {
   this.itemsInStock = itemsInStock;
  } else {
   this.itemsInStock.addAll(itemsInStock);
  }
 }

 public void setItemInStock(Item item) {
  if (this.itemsInStock == null) {
   this.itemsInStock = new ArrayList<Item>();
  }
  this.itemsInStock.add(item);
 }

 /**
  * Answers a List of Items from the items in stock between the low price and
  * the high price passed to it. The List returned is <b>backed by</b> the
  * actual items in stock so changes to one are reflected by the other.
  *
  *
  * @param lowPrice
  *            the lowest price of the items to fetch
  * @param highPrice
  *            the highest price of the items to fetch
  *
  * @return a List of Items in stock; null if there are no items between the
  *         lowest and the highest price.
  */
 public List<Item> getItemsInStock(BigDecimal lowPrice, BigDecimal highPrice) {

  // create dummy items for search
  Item startItem = new Item(null, lowPrice);
  Item endItem = new Item(null, highPrice);

  // clone the list so that the ordering of the items in the list is not affected
  List<Item> itemsClone = new ArrayList<Item>(this.itemsInStock);

  // sort the items for binary search
  Collections.sort(itemsClone);

  // Read binary search() documentation for more details.
  int fromIndex = Collections.binarySearch(itemsClone, startItem);
  int toIndex = Collections.binarySearch(itemsClone, endItem);

  // If the low price is not found, get insertion point
  if (fromIndex < 0) {
   // After this, fromIndex will be between ( 0...total items)
   fromIndex = -(fromIndex + 1);
  } else {
   // binary search doesn't necessarily return first matching item
   while (fromIndex > 0 && itemsClone.get(fromIndex).equals(itemsClone.get(fromIndex - 1))) {
    fromIndex--;
   }
  }

  // If the high price is not found, get (insertion point - 1 )
  if (toIndex < 0) {
   // After this, toIndex will be between ( -1...total items-1)
   toIndex = -(toIndex + 2);
  } else {
   // binary search doesn't necessarily return last matching item
   while (toIndex < (itemsClone.size() - 1) && itemsClone.get(toIndex).equals(itemsClone.get(toIndex + 1))) {
    toIndex++;
   }
  }

  /*
   * We have items between start and end ONLY IF fromIndex is <= toIndex
   * and fromIndex is != total items and toIndex is != -1
   */
  if (toIndex < fromIndex) {
   return null;
  }

  // Return a view of the list
  return itemsClone.subList(fromIndex, toIndex + 1);
 }
}

