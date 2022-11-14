import java.util.ArrayList;

public class Order {
    private ArrayList<Food> dishes;
    private int orderNumber,index;
    private static int totalOrders = 0;
    private String status;
    private String[] statuses = {"Placed", "Cooking", "Ready"};

    public Order(ArrayList<Food> dishes) {
        index = 0;
        this.dishes = dishes;
        totalOrders++;
        this.orderNumber =totalOrders;
        status = statuses[index];
    }
    public Order(){
        index = 0;
        totalOrders++;
        this.orderNumber =totalOrders;
        dishes = new ArrayList<>();
        status = statuses[index];
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

    public void updateStatus(Order o){
        if(index < 3){
            index++;
        }
    }

    public boolean equals(Order o){
        return orderNumber == o.orderNumber;
    }

    public double getTotal(){
        double total = 0;
        for(Food dish : dishes){

            total += dish.getPrice();

        }
        return total;
    }

    public int getIndex(){
        return index;
    }

    public String toString(){
        return "Ordder No:"+orderNumber+" Status: "+status+" Number of Dishes:"+dishes.size()+" Total: "+getTotal()+" ";
    }
    
}
