package Losson1.Patricipant;

public class Robot implements Patricipant{

    private final String name;
    private final int jumpHeight;
    private final int runDistance;

    public Robot(String name, int jumpHeight, int runDistance) {
        this.name = name;
        this.jumpHeight = jumpHeight;
        this.runDistance = runDistance;
    }


    @Override
    public int jumpHeight() {
        System.out.printf("Robot %s способен прыгнуть %d%n", this.name,
                this.jumpHeight, this.runDistance);
        return this.jumpHeight;
    }

    @Override
    public int runDistance() {
        System.out.printf("Robot %s способен пробежать %d%n", this.name,
                this.jumpHeight, this.runDistance);
        return this.runDistance;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", jumpHeight=" + jumpHeight +
                ", runDistance=" + runDistance +
                '}';
    }
}
