package hw1;

abstract class Figure {
    abstract void getFigureName();

    public void getFigureName(Figure figure) {
        figure.getFigureName();
    }

    public static void main(String[] args) {
        Figure circle = new Circle();
        Figure square = new Square();
        Figure triangle = new Triangle();

        circle.getFigureName();
        square.getFigureName();
        triangle.getFigureName();
    }
}
