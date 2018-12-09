package saicinterview;

import java.util.ArrayList;

class Pizza {
    ArrayList toppings;

    public void addTopping(String topping) {
        toppings.add(topping);
    }

    public void removeTopping(String topping) {
        toppings.remove(topping);
    }
}


class PepperoniPizza extends Pizza {
    public void addTopping(String topping) {
        System.out.println("Cannot add Toppings");
    }

    public void removeTopping(String topping) {
        System.out.println("Cannot remove pepperoni");
    }
    
    public static void main(String[] args) {
    	Pizza pizza = new PepperoniPizza();
        pizza.addTopping("Mushrooms");
        pizza.removeTopping("Pepperoni");
	}
}

