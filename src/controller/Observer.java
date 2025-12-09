
package controller;

/**
 *
 * @author Dell
 */
public interface Observer { //ABSTRACT METHODS INSIDE, the observers will later define their unique behaviours
    
    public void updateStatus(String status); //updates whether area cleared or not
    
    public void setButton(int value);//activate the buttons based on slider values received
    
    public void setMessage(String message);//sets up message to send to main with the name of observer
    
    public void privateMessage();//if position ticked receives message from Main/obsevable  
}
