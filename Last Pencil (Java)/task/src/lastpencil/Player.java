package lastpencil;

public abstract class Player {

    protected final String name;

    public Player(String name) {
        this.name = name;
    }

    public abstract int takePencils(int currentPencils);

    public String getName() {
        return name;
    }
}
