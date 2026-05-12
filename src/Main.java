public class Main {

    public static void main(String[] args) {

        System.out.println(" Task 1");

        UserValidator validator = new UserValidator();

        validator.addRule(form -> form.email().contains("@"));
        validator.addRule(form -> form.password().length() >= 8);
        validator.addRule(form -> form.age() >= 18);

        UserForm form = new UserForm(
                "anna@example.com",
                "secure123",
                20
        );

        System.out.println("Is the form valid? " + validator.isValid(form));

        System.out.println("\n Task 2");

        ServiceOrder order = new ServiceOrder(
                "Alpha Company",
                10,
                120.0
        );

        PriceCalculator calculator = new PriceCalculator();

        PriceStrategy standard =orderData -> orderData.hours() * orderData.hourRate();

        PriceStrategy discount = orderData -> orderData.hours() * orderData.hourRate() * 0.90;

        PriceStrategy weekend = orderData -> orderData.hours() * orderData.hourRate() * 1.25;

        System.out.println("Standard price: " + calculator.calculate(order, standard)
        );

        System.out.println("Discount price: " + calculator.calculate(order, discount)
        );

        System.out.println("Weekend price: " + calculator.calculate(order, weekend)
        );

        System.out.println("\n Task 3");

        Order storeOrder = new Order("ORD-100", "Anna Kowalska");

        storeOrder.addItem(new Order.OrderItem("Keyboard", 249.99, 1));
        storeOrder.addItem(new Order.OrderItem("Mouse", 99.99, 2));

        OrderSummary summary = new OrderSummary(
                storeOrder.getOrderNumber(),
                storeOrder.getCustomerName(),
                storeOrder.total()
        );

        System.out.println(summary);
    }
}