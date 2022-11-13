import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Restaurant {

    private static ArrayList<Order>  orders = new ArrayList<>();
    private static ArrayList<Food> menu = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        makeMenu();
        int ans = -1;
        while(ans != 0){
            System.out.println("1. Eat in");
            System.out.println("2. Place Takeout Order");
            System.out.println("3. Place Delivery Order");
            System.out.println("4. List orders");
            System.out.println("5. Update Order");
            System.out.println("0. Exit");
            System.out.println("Enter Choice:");
            ans = sc.nextInt();
            sc.nextLine();
            
            switch(ans){ // This is like using a bunch of if statements
                case 1:
                System.out.println("TableOrder code goes here");//TODO 
                break;
                case 2:
                System.out.println("TakeoutOrder goes here"); //TODO 
                break;
                case 3:
                System.out.print("Customer Name: ");
                String customer = sc.nextLine();
                System.out.print("Address: ");
                String addr =sc.nextLine();
                System.out.print("Phone: ");
                String phone = sc.nextLine();
                ArrayList<Food> dishes = getDishes();//This function is inside  of Restaurant
                DeliveryOrder  o = new DeliveryOrder(customer, addr, phone);
                o.setDishes(dishes);
                orders.add(o);

                break;
                case 4:
                ans= 0;
                while(ans <1 || ans > 3){
                    System.out.println("Sort by:  1.Order number 2)Type 3)Status ");
                    ans = sc.nextInt();
                    sc.nextLine(); 
                }    
                listOrders(ans);
                break;
            }
        }
        
    }

    public static void makeMenu(){
        menu.add(new Food("Cheeseburder", 10));
        menu.add(new Food("Lasagna", 12));
        menu.add(new Food("Chopped Saled", 9.99));
        menu.add(new Food("Drink", 2.99));
    }

    public static ArrayList<Food> getDishes(){
        ArrayList<Food>  dishes =new ArrayList<>();
        int ans = 1;
        while(ans !=0){
            for(int i = 0; i < menu.size();i++){
                System.out.println(i+1+" "+menu.get(i));
            }
            System.out.println("Enter Choice (-1 to exit): ");
            ans = sc.nextInt();
            sc.nextLine();
            if(ans > 0 && ans <=menu.size()){
                dishes.add(menu.get(ans));
            }
            else if(ans== -1){
                break;
            }else{
                System.out.println("Invalid choice");
            }
        }
        return dishes;
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

    public static void listOrders(int n){
        if(n == 1){//print orders by order number

        }else if(n == 2){//Print Orders by orderType
            HashSet<String> orderTypes = new HashSet<>();
            for(Order o: orders)//Find all the order types
                orderTypes.add(getType(o));
        
            for(String orderType:  orderTypes){//Loop through the order types
                for(Order o: orders){//For each order type print the oders that belong to that type
                    if(getType(o).equals(orderType)){
                        System.out.println(o);
                    }
                }
            }
            

        }else if(n == 3){//Print orders by status

        }
    }
}
