package mainTask;

public class Container {
    private int registrationNumber;

    public Container(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public String toString() {
        return "Container{" +
                + registrationNumber +
                '}';
    }
}
