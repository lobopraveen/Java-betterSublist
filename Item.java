import java.math.BigDecimal;

public class Item implements Comparable<Item> {

 private String name;
 private BigDecimal price;

 @Override
 public int compareTo(Item item) {
  return this.price.compareTo(item.price);
 }

 @Override
 public boolean equals(Object o) {
  return this.price.equals(((Item)o).getPrice());
 }

 @Override
 public String toString() {
  return this.name + " - " + this.price;
 }

 Item(String name, BigDecimal price) {
  setName(name);
  setPrice(price);
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public BigDecimal getPrice() {
  return price;
 }

 public void setPrice(BigDecimal price) {
  this.price = price;
 }
}

