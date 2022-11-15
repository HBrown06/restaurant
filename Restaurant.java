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
            
            switch(ans){ // This is like using a bunch of if statements. Either way is good
                case 1:
                    System.out.println("Table Number: ");//TODO See code for option 3
                    int num = sc.nextInt();
                    TableOrder t = new TableOrder(num);
                    ArrayList<Food> tDishes = getDishes();
                    t.setDishes(tDishes);
                    orders.add(t);
                    break;
                case 2:
                    System.out.println("Customer Name: "); //TODO See code for option 3
                    String name = sc.nextLine();
                    TakeoutOrder tOrder = new TakeoutOrder(name);
                    ArrayList<Food> tODishes = getDishes();
                    tOrder.setDishes(tODishes);
                    orders.add(tOrder);
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
                        System.out.println("Sort by:  1.Order number 2.Type 3.Status ");
                        ans = sc.nextInt();
                        sc.nextLine();
                    }    
                    listOrders(ans);
                    break;
                case 5:
                    ans = -1;
                    while(ans != 0){
                        
                        System.out.println("1. Update Status");
                        System.out.println("2. Add Dish");
                        System.out.println("3. Remove Dish");
                        System.out.println("4. Cancel Order");
                        System.out.println("0. Exit");
                        System.out.println("Enter Choice: ");

                        int choice = sc.nextInt();

                        switch(choice){
                            case 1:
                                listOrders(1);
                            
                            case 2:
                                listOrders(1);
                                int order = sc.nextInt();
                                for(int i = 0;i<menu.size(); i++){
                                    System.out.println(i + menu.get(i).getName());
                                }
                                int food = sc.nextInt();
                                orders.get(order).addDish(menu.get(food));
                            case 3:
                                listOrders(1);
                                order = sc.nextInt();
                                for(int i = 0;i<menu.size(); i++){
                                    System.out.println(i + menu.get(i).getName());
                                }
                                food = sc.nextInt();
                                orders.get(order).removeDish(menu.get(food));
                            case 4:
                                listOrders(1);
                                System.out.println("Which order do you want to cancel?");
                                int ans2 = sc.nextInt();
                                orders.remove(ans2);
                            case 0:
                                break;

                        }
                    }
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
                dishes.add(menu.get(ans-1));
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
            for(Order o : orders){
                System.out.println(o);
            }
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
            HashSet<Integer> statuses = new HashSet<>();
            for(Order o : orders){
                statuses.add(o.getIndex());
            }

            for(int status : statuses){
                for(Order o : orders){
                    if(o.getIndex() == status){
                        System.out.println(o);
                    }
                }
            }
        }
    }
}
