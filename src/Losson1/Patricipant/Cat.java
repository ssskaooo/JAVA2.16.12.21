package Losson1.Patricipant;

public class Cat implements Patricipant{

    private final String name;
    private final int jumpHeight;
    private final int runLength;

    public Cat(String name, int jumpHeight, int runDistance) {
        this.name = name;
        this.jumpHeight = jumpHeight;
        this.runLength = runDistance;
    }

    @Override
    public int jumpHeight() {
        System.out.printf("Cat %s способен прыгнуть %d%n", this.name,
                this.jumpHeight, this.runLength);
        return this.jumpHeight;
    }

    @Override
    public int runDistance() {
        System.out.printf("Cat %s способен пробежать %d%n", this.name,
                this.jumpHeight, this.runLength);
        return this.runLength;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", jumpHeight=" + jumpHeight +
                ", runDistance=" + runLength +
                '}';
    }
}
