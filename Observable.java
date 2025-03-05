package grupp47_lab1;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    void notifyObservers(){
        for (Observer observer : observers){
            observer.update();
        }
    }
}
