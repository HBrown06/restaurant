import java.util.ArrayList;

public class Order {
    private ArrayList<Food> dishes;
    private int orderNumber,index;
    private static int totalOrders = 0;
    private String status;
    private static String[] statuses = {"Placed", "Cooking", "Ready"};

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
    public void addDish(Food f){
        dishes.add(f);
    }
    public void removeDish(Food f){
        dishes.remove(f);
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

    public static String getStatuses(){
        return "0) " + statuses[0] + ", " + "1) " + statuses[1] + ", " + "2) " + statuses[2];
    }
    public static String getStatArrByIndex(int index){
        return statuses[index];
    }

    public void setStatus(String status){
        this.status = status;
    }

    public int getIndex(){
        return index;
    }

    public String toString(){
        return "Order No:"+orderNumber+" Status: "+status+" Number of Dishes:"+dishes.size()+" Total: "+getTotal()+" ";
    }
    
}
