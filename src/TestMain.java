public class TestMain {
    public static void main(String[] args) {
        Travel travelCar = new Travel(new Car());
        travelCar.run();

        Travel travelTrain = new Travel(new Train());
        travelTrain.run();
    }
}
