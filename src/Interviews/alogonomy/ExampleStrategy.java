package Interviews.alogonomy;

interface  Vehicle{
    public void drive();
}

class Car implements Vehicle{
    public void drive(){
        System.out.println("Car driving");
    }
}

class Bus implements Vehicle {
    public void drive() {
        System.out.println("Bus driving");
    }
}

class Truck implements Vehicle {
    public void drive() {
        System.out.println("truck driving");
    }
}




public class ExampleStrategy {

    public Vehicle initiateStrategy(Vehicle v){
        if(v instanceof Car){
            return new Car();
        }
        if (v instanceof Bus) {
            return new Bus();
        }
        if (v instanceof Truck) {
            return new Truck();
        }
        return null;
    }
}
