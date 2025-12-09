
package controller;

import java.util.ArrayList;
import view.*;

/**
 *
 * @author Dell
 */
public class Observerable implements MainCaller{

    private ArrayList<Observer> observers = new ArrayList<>();
    private int sliderValue;
    
    public void addWindow(Observer observers){
        this.observers.add(observers);
    }
    
    public void removeWindow(Observer option){
        observers.remove(option);
    }
    
    public void notifyObservers(String status){ //send all systems the reeiving status from main
        for (Observer observer : observers) {
            observer.updateStatus(status);//call the updateStatus method and set status for all systems
        }
    }
    
    public void addInterface(Observer newInterface){
        observers.add(newInterface);
    }
    
    @Override
    public void setSliderValue(int value) { 
        if (this.sliderValue!=value) {
            this.sliderValue=value;
            setBtn(sliderValue);
        }
    }
    
    public void sendMessage(String message){ //this sends the message to all observers
        for (Observer observer : observers) {
            observer.setMessage(message);
        }
    }
    
    public ArrayList<Observer> getObserver(){ //method to return all observers in arraylist
        return observers;
    }

    private void setBtn(int sliderValue) {//activate the buttons based on slider values received
        //need to figure out
    }
    
}
