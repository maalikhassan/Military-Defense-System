/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import controller.Observerable;
import java.util.Observable;
import view.Helicopter;
import view.MainController;
import view.Submarine;
import view.Tank;

/**
 *
 * @author Dell
 */
public class Demo {
    public static void main(String[] args) {
        FlatMacLightLaf.setup();
        Observerable observerable = new Observerable();
        observerable.addWindow(new Helicopter(observerable));
        //observerable.addWindow(new Tank(observerable));
       // observerable.addWindow(new Submarine(observerable));
        
       // MainController main = new MainController(observerable);
       // observerable.addWindow(main);
       // main.setVisible(true);
    }
}
