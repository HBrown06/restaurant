import java.util.ArrayList;

public class Restaurant {

    private static ArrayList<Order>  orders = new ArrayList<>();
    public static void main(String[] args) {
        //THIS WILL BE PART OF YOUR ASSIGNMENT NEXT WEEK
    }

    public static String getType(Order o){
        if(o instanceof TakeoutOrder ){
            return "TakeoutOrder";
        }
        else if(o instanceof DeliveryOrder){
            return "DeliveryOrder";
        }else if(o instanceof TableOrder){
            return "TableOrder";
        }
        else{
            return "";
        }

    }
}
