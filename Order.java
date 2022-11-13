import java.util.ArrayList;


public class Order {
    private ArrayList<Food> dishes;
    private int orderNumber;
    private static int totalOrders = 0;
    private String status;

    public Order(ArrayList<Food> dishes) {
        this.dishes = dishes;
        totalOrders++;
        this.orderNumber =totalOrders;
        status = "Placed";
    }
    public Order(){
        totalOrders++;
        this.orderNumber =totalOrders;
        dishes = new ArrayList<>();
        status = "Placed";
    }
    public ArrayList<Food> getDishes() {
        return dishes;
    }
    public void setDishes(ArrayList<Food> dishes) {
        this.dishes = dishes;
    }
    public int getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public boolean equals(Order o){
        return orderNumber == o.orderNumber;
    }

    public double getTotal(){
        return 0.0;
    }

    public String toString(){
        return "Ordder No:"+orderNumber+" Status: "+status+" Number of Dishes:"+dishes.size()+" Total: "+getTotal()+" ";
    }
    
}
