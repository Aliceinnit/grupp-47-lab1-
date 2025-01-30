import grupp47_lab1.Car;
import grupp47_lab1.Saab95;
import grupp47_lab1.Volvo240;

void main() {
    grupp47_lab1.Car volvo = new Volvo240();
    System.out.println(volvo.getModelName());
    Car saab = new Saab95();
    System.out.println(saab);
}