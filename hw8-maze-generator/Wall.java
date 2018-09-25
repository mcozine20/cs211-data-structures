public class Wall {

    Cell first;
    Cell second;

    boolean visible;

    public Wall(Cell a, Cell b) {
	first = a;
	second = b;
	visible = true;
    }

}