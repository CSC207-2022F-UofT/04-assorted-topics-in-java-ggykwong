/* TODO: Create a subclass of Trader named DrivableTrader
 * This class should be identical to Trader, except that it takes
 * only Drivable objects in its inventory, wishlist, etc.
 *
 * The sellingPrice returned should also be overridden. The selling price
 * should be equal to the:
 *     Object's price + Object's max speed
 * If the object is Tradable (and Tradable.MISSING_PRICE otherwise.)
 *
 * Look at DomesticatableTrader.java for an example.
 */

import java.util.ArrayList;
import java.util.List;

public class DrivableTrader<Drivable> extends Trader<Object> {
    private final List<Drivable> inventory;
    private final List<Drivable> wishlist;
    private int money;

    public DrivableTrader(List<Drivable> inventory, List<Drivable> wishlist, int money) {
        super((List<Object>) inventory, (List<Object>) wishlist, money);
        this.inventory = inventory;
        this.wishlist = wishlist;
        this.money = money;
    }

    public DrivableTrader(int money) {
        super(money);
        this.inventory = new ArrayList<Drivable>();
        this.wishlist = new ArrayList<Drivable>();
    }

    public void addToWishlist(Object item) {
        this.wishlist.add((Drivable) item);
    }

    public int getSellingPrice(Object item) {
        if (item instanceof Tradable) {
            return ((Tradable) item).getPrice() + item.getMaxSpeed();
        }
        return Tradable.MISSING_PRICE;
    }

    public boolean exchangeMoney(Trader<Object> other, Object item) {
        return super.exchangeMoney(other, item);
    }

    public boolean sellTo(Trader<Object> other) {
        return super.sellTo(other);
    }

    public boolean buyFrom(Trader<Object> other) {
        return super.buyFrom(other);
    }

    public String toString() {
        return super.toString();
    }

    public List<Object> getWishlist(){
        return super.getWishlist();
    }

    public List<Object> getInventory() {
        return super.getInventory();
    }
}