public class TableOrder extends Order {
    private int tableNumber;

    public TableOrder(int tableNumber){
        super();
        this.tableNumber  = tableNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    


}
