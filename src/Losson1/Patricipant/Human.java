package Losson1.Patricipant;

public class Human implements Patricipant{
    private final String name;
    private final int jumpHeight;
    private final int runDistance;

    public Human(String name, int jumpHeight, int runDistance) {
        this.name = name;
        this.jumpHeight = jumpHeight;
        this.runDistance = runDistance;
    }


    @Override
    public int jumpHeight() {
        System.out.printf("Human %s способен прыгнуть %d%n", this.name,
                this.jumpHeight, this.runDistance);
        return this.jumpHeight;
    }

    @Override
    public int runDistance() {
        System.out.printf("Human %s способен пробежать %d%n", this.name,
                this.jumpHeight, this.runDistance);
        return this.runDistance;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", jumpHeight=" + jumpHeight +
                ", runDistance=" + runDistance +
                '}';
    }
}
