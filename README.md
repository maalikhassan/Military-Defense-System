# Military Defense System

> **A sophisticated demonstration of Object-Oriented Programming principles and Design Patterns in Java**

An enterprise-grade military command and control system showcasing advanced Java development skills, comprehensive OOP implementation, and production-ready software architecture. Built with Java Swing and implementing the Observer design pattern for real-time multi-unit coordination.

## 🎯 Key Highlights

- ✅ **Complete OOP Implementation** - All four pillars with practical examples
- ✅ **Observer Design Pattern** - Event-driven architecture for real-time coordination
- ✅ **SOLID Principles** - Professional software engineering practices
- ✅ **Modern Java Features** - Lambdas, generics, collections framework

## 📋 Overview

The system simulates a military defense command center managing three distinct military units (Helicopter, Tank, Submarine) through a centralized Main Controller. The architecture emphasizes **scalability**, **maintainability**, and **extensibility** through proven software engineering principles.

## ✨ Features

### Main Controller
- **Real-time Unit Monitoring**: Collect and display information from all military units
- **Threat Level Control**: Adjust threat levels via slider (0-100) that dynamically enables/disables weapons based on severity
- **Dual Messaging System**: 
  - Broadcast messages to all units
  - Send private messages to specific units
- **Area Status Management**: Toggle and broadcast area clearance status to all units
- **Information Dashboard**: View soldier count, fuel/ammunition levels, and position status of selected units

### Military Units (Helicopter, Tank, Submarine)

#### Helicopter
- **Weapons Systems**:
  - Standard guns (Threat Level ≥20)
  - Missiles (Threat Level ≥40)
  - Laser weapons (Threat Level ≥60)
- **Resources**: Soldier count, ammunition, fuel
- **Auto-depletion**: Fuel automatically decreases over time

#### Tank
- **Weapons Systems**:
  - Main cannon (Threat Level ≥20)
  - Rotating turret fire (Threat Level ≥40)
  - Radar system (Threat Level ≥60)
  - Guided missiles (Threat Level ≥80)
- **Resources**: Soldier count, ammunition, fuel
- **Auto-depletion**: Fuel automatically decreases over time

#### Submarine
- **Weapons Systems**:
  - Torpedoes (Threat Level ≥20)
  - Sonar activation (Threat Level ≥40)
  - Tomahawk cruise missiles (Threat Level ≥60)
  - Trident-3 ballistic missiles (Threat Level ≥80)
- **Dual Resources**: Fuel and oxygen levels
- **Auto-depletion**: Both fuel and oxygen decrease automatically over time

### Common Features (All Units)
- **Position Lock System**: Must enable position before weapons can be activated
- **Bidirectional Communication**: Send messages to Main Controller and receive broadcasts
- **Resource Management**: Track and adjust soldier count and ammunition via spinners
- **Status Updates**: Real-time display of area clearance status
- **Action Logging**: All weapon actions are logged in the unit's text area

## 🏗️ Software Architecture & Design Patterns

#### 1. **Encapsulation** 🔒
- **Private Data Members**: All unit attributes (`soldiers`, `ammo`, `fuel`, `position`) are encapsulated as private fields
- **Controlled Access**: Public getter methods and controlled setter logic protect data integrity
- **Information Hiding**: Internal state management hidden from external classes
- **Example**:
  ```java
  private int soldiers;  // Encapsulated state
  private Observerable observerable;  // Encapsulated dependency
  
  public int[] currentData() {  // Controlled public access
      return new int[]{soldiers, fuel, ammo, position};
  }
  ```

#### 2. **Abstraction** 🎭
- **Interface Contracts**: `Observer`, `getData`, `MainCaller` define abstract behaviors
- **Implementation Independence**: Concrete classes implement abstract methods based on their specific needs
- **Polymorphic Interfaces**: Multiple interfaces per class provide different abstraction views
- **Example**:
  ```java
  public interface Observer {
      void updateStatus(String status);
      void setButton(int value);
      void setMessage(String message);
  }
  // Units implement these contracts with their own logic
  ```

#### 3. **Inheritance** 🧬
- **Framework Extension**: All GUI classes extend `javax.swing.JFrame`
- **Interface Implementation**: Multiple interface inheritance for behavior contracts
- **Code Reuse**: Inherited Swing functionality reduces boilerplate
- **Example**:
  ```java
  public class Helicopter extends JFrame implements Observer, getData {
      // Inherits JFrame capabilities + implements two behavioral contracts
  }
  ```

#### 4. **Polymorphism** 🔄
- **Interface Polymorphism**: `Observer` references can point to any unit type
- **Dynamic Binding**: Runtime method resolution based on actual object type
- **Uniform Treatment**: Main Controller treats all units polymorphically through Observer interface
- **Example**:
  ```java
  ArrayList<Observer> observers = new ArrayList<>();
  observers.add(new Helicopter(this));  // Helicopter treated as Observer
  observers.add(new Tank(this));        // Tank treated as Observer
  observers.add(new Submarine(this));   // Submarine treated as Observer
  
  // Polymorphic iteration - each unit executes its own implementation
  for (Observer observer : observers) {
      observer.setButton(sliderValue);  // Dynamic binding at runtime
  }
  ```

### Design Patterns Implementation

#### Observer Pattern (Event-Driven Architecture)
**Problem Solved**: Maintaining consistency across distributed components without tight coupling

**Implementation**:
- **Subject (Observable)**: `Observerable` class maintains observer registry and notification logic
- **Observers**: All units (`MainController`, `Helicopter`, `Tank`, `Submarine`) implement `Observer` interface
- **Notification Mechanism**: State changes trigger automatic notifications to all registered observers
- **Decoupling**: Subject doesn't know concrete types of observers, only their interface

**Benefits Demonstrated**:
- ✅ **One-to-Many Dependency**: Single state change propagates to multiple observers
- ✅ **Loose Coupling**: Subject and observers are independently extensible
- ✅ **Open/Closed Principle**: New observers can be added without modifying existing code
- ✅ **Real-Time Synchronization**: All units stay synchronized automatically

```java
// Observable manages observers and broadcasts changes
public class Observerable {
    private ArrayList<Observer> observers = new ArrayList<>();
    
    public void notifyObservers(String status) {
        for (Observer observer : observers) {
            observer.updateStatus(status);  // Polymorphic call
        }
    }
}
```

### Architecture Layers (MVC Pattern)

- **Controller**: Interfaces for communication (`Observer`, `getData`, `MainCaller`), observable subject for notifications
- **View**: Java Swing GUIs with event handlers for all military units
- **Model**: Application bootstrap and initialization logic

### Project Structure

```
Military Defense System/
├── src/
│   ├── controller/
│   │   ├── Observer.java           # Observer interface
│   │   ├── Observerable.java       # Observable/Subject class
│   │   ├── getData.java            # Data interface
│   │   └── MainCaller.java         # Caller interface
│   ├── model/
│   │   └── Demo.java               # Application entry point
│   ├── view/
│   │   ├── MainController.java     # Command center GUI
│   │   ├── Helicopter.java         # Helicopter unit GUI
│   │   ├── Tank.java               # Tank unit GUI
│   │   └── Submarine.java          # Submarine unit GUI
│   └── assets/                     # (Reserved for sound effects)
├── build.xml                       # Ant build configuration
└── README.md                       # Project documentation
```

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- NetBeans IDE (recommended) or any Java IDE
- FlatLaf library (for modern UI theme)

### Installation

1. **Clone or download the project**
   ```bash
   git clone https://github.com/maalikhassan/Military-Defense-System.git
   cd Military-Defense-System
   ```

2. **Open in NetBeans**
   - File → Open Project → Navigate to folder

3. **Build and Run**
   - Right-click project → Clean and Build → Run

**Alternative (Command Line)**:
```bash
javac -d build/classes src/**/*.java
java -cp build/classes model.Demo
```

### Advanced Java Concepts Demonstrated

### Core Java Proficiency

#### Collections Framework Mastery
```java
ArrayList<Observer> observers = new ArrayList<>();  // Generic type safety
observers.add(helicopter);
observers.get(index).setMessage(message);  // Type-safe access
```
- Generic collections for type safety
- Dynamic array management
- Iterator pattern usage

#### Event-Driven Programming
```java
shootBtn.addActionListener(evt -> shootBtnActionPerformed(evt));  // Lambda expression
```
- Lambda expressions (Java 8+)
- ActionListener implementation
- Callback mechanisms
- Asynchronous event handling

#### Timer & Concurrency
```java
Timer timer = new Timer(4000, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        sliderFuel.setValue(sliderFuel.getValue() - 1);
    }
});
timer.start();
```
- javax.swing.Timer for scheduled tasks
- Thread-safe GUI updates
- Resource auto-depletion simulation

#### Exception Handling
```java
private void playSound(String soundFile) {
    try {
        // Sound loading logic
    } catch (Exception e) {
        System.err.println("Error playing sound: " + e.getMessage());
    }
}
```
- Try-catch blocks for robust error handling
- Defensive programming practices
- Resource management

### SOLID Principles Applied

- **SRP**: Each class has single responsibility (e.g., `Observerable` manages observers only)
- **OCP**: Extensible for new unit types without modifying existing code
- **LSP**: Any `Observer` implementation is substitutable
- **ISP**: Focused interfaces (`Observer`, `getData`, `MainCaller`)
- **DIP**: High-level modules depend on abstractions, not concrete classes

## 🛠️ Technology Stack

- **Language**: Java SE 8+ (lambdas, generics, collections)
- **GUI**: Java Swing with FlatLaf theme
- **Build**: Apache Ant
- **IDE**: Apache NetBeans
- **APIs**: javax.swing.*, java.util.*, javax.sound.sampled.*

## 💼 Key Competencies Demonstrated

**Object-Oriented Design**: All 4 OOP pillars, Observer pattern, interface-driven architecture

**Java Proficiency**: Modern features (lambdas, generics), Collections Framework, event-driven programming, exception handling

**Software Engineering**: MVC pattern, SOLID principles, separation of concerns, defensive programming

**Project Complexity**: 1500+ LOC, intermediate to advanced level, production-quality architecture

## � Technical Notes

**Scalability**: Easy to extend with new unit types (implement Observer interface), supports broadcast and targeted messaging, modular architecture

**Code Quality**: Consistent naming conventions, comprehensive documentation, modular design, error handling, input validation

## 🎮 Usage Guide

### Starting the Application
When you run the application, four windows will open in different corners of your screen:
- **Top-Left**: Main Controller (Command Center)
- **Top-Right**: Helicopter
- **Bottom-Left**: Tank  
- **Bottom-Right**: Submarine

### Operating the Main Controller

1. **Adjust Threat Level**
   - Use the slider to set threat level (0-100)
   - This automatically enables/disables weapons across all units

2. **Send Messages**
   - Type message in text field
   - Click "Send" for broadcast (all units receive)
   - Check "send private" and select unit from dropdown for private message

3. **Collect Unit Information**
   - Select unit from dropdown
   - Click "Collect Information"
   - View soldier count, fuel, ammunition, and position status

4. **Toggle Area Status**
   - Check/uncheck "Area Clear" checkbox
   - Status broadcasts to all units automatically

### Operating Military Units

1. **Enable Position Lock**
   - Check the "Position" checkbox
   - This is required before any weapons can be used

2. **Adjust Resources**
   - Use spinners to set soldier count (0-100)
   - Use spinners to set ammunition (0-1000)
   - Fuel/Oxygen sliders show auto-depleting resources

3. **Use Weapons**
   - Weapons become enabled based on threat level from Main Controller
   - Click weapon buttons to execute actions
   - Actions are logged and broadcast to all units

4. **Send Messages**
   - Type in the text field at bottom
   - Click "Send" to broadcast to Main Controller and all other units

## 🔧 Configuration

### Customizing Initial Values
Edit the constructor in each unit class to change starting values:

```java
// In Helicopter.java
spinnerSoldier.setModel(new javax.swing.SpinnerNumberModel(8, 0, 100, 1));   // 8 soldiers
spinnerAmmo.setModel(new javax.swing.SpinnerNumberModel(200, 0, 1000, 1));   // 200 ammo

// In Tank.java
soldierCountSpinner.setModel(new javax.swing.SpinnerNumberModel(30, 0, 100, 1));  // 30 soldiers
ammoCountSpinner.setModel(new javax.swing.SpinnerNumberModel(300, 0, 1000, 1));   // 300 ammo

// In Submarine.java
soldierCountSpinner.setModel(new javax.swing.SpinnerNumberModel(80, 0, 100, 1));  // 80 soldiers
ammoCountSpinner.setModel(new javax.swing.SpinnerNumberModel(500, 0, 1000, 1));   // 500 ammo
```

### Adding Sound Effects
1. Create `src/assets/` folder
2. Add `.wav` sound files (e.g., `shoot.wav`, `missile.wav`, `sonar.wav`)
3. Uncomment the sound code in the `playSound()` method in each unit class

### Adjusting Window Positions
Modify the `setLocation()` calls in each GUI class:

```java
// In each unit's initComponents() method
setLocation(x, y);  // x, y are pixel coordinates from top-left of screen
```

## 🛠️ Technologies Used

- **Language**: Java 8+
- **GUI Framework**: Java Swing
- **UI Theme**: FlatLaf (Flat Look and Feel)
- **IDE**: Apache NetBeans
- **Build Tool**: Apache Ant
- **Design Pattern**: Observer Pattern

## 📚 Key Concepts Demonstrated

- **Observer Design Pattern**: Real-time event-driven communication
- **Interface-based Programming**: Loose coupling between components
- **Event-Driven Architecture**: GUI event handling and listeners
- **Timer-based Updates**: Auto-depletion of resources
- **State Management**: Position locking and weapon enabling logic
- **MVC Architecture**: Separation of concerns (Model-View-Controller)

## 🐛 Known Issues & Solutions

### Issue: Weapon buttons stop working after editing forms
**Solution**: Action listeners are now added in constructors (not in `initComponents()`), preventing NetBeans from removing them.

### Issue: Spinners show 0 on initial load
**Solution**: Set spinner models before reading values in constructor.

### Issue: Buttons don't disable when unchecking position
**Solution**: The `setButton()` method now handles both checked and unchecked states.

## 🤝 Contributing

Contributions welcome! Potential enhancements: sound effects, persistent storage, health/damage system, mission scenarios, map-based movement, network multiplayer.

## 👨‍💻 Author & Acknowledgments

**Maalik Hassan** - [@maalikhassan](https://github.com/maalikhassan)

Inspired by Gang of Four design patterns | FlatLaf UI library | NetBeans IDE community

---

**Note**: Educational project demonstrating software engineering principles. Simulates a command and control system for learning purposes only.
