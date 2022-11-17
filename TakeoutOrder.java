import java.util.ArrayList;

public class TakeoutOrder extends Order{
    private String customer;

    public TakeoutOrder(String customer){
        super();
        this.customer = customer;
    }

    public TakeoutOrder(String customer, ArrayList<Food> dishes){
        super(dishes);
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String toString(){
        return "Takeout Order, Customer: " + customer + " " + super.toString();
    }

}