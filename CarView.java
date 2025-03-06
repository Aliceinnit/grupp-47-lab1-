package grupp47_lab1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Stack;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class CarView extends JFrame{
    private static final int X = 800;
    private static final int Y = 800;
    private final EventHandler eventHandler; // Hanterar knapptryck istället för att CarView gör det
    public CarPositionHandler CarPositionHandler;
    final DrawPanel drawPanel;

    //DrawPanel drawPanel = new DrawPanel(X, Y-340, CarPositionHandler.cars);

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();

    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");
    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Turbo on");
    JButton turboOffButton = new JButton("Turbo off");
    JButton liftBedButton = new JButton("Lift Bed");
    JButton lowerBedButton = new JButton("Lower Bed");
    JButton turnRightButton = new JButton("Turn right");
    JButton turnLeftButton = new JButton("Turn left");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    // Constructor
    public CarView(String frameName, Controllable cc, Stack<Car> cars, CarPositionHandler positionHandler){
        this.eventHandler = new EventHandler(cc); //skapar ny EventHandler
        this.drawPanel = new DrawPanel(800, 460, cars, positionHandler);
        initComponents(frameName);
    }

    //Uppdaterar UIt genom att anropa repaint på drawpanel
    public void updateUI(){
        drawPanel.repaint();
    }

    public void updateCarPosition(int x, int y, Car car) {
        drawPanel.updateCarPosition(x, y, car);
    }
    // Sets everything in place and fits everything
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(0,5));

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.black);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);

        controlPanel.add(gasButton);
        controlPanel.add(brakeButton);
        controlPanel.add(turboOnButton);
        controlPanel.add(turboOffButton);
        controlPanel.add(liftBedButton);
        controlPanel.add(lowerBedButton);
        controlPanel.add(turnRightButton);
        controlPanel.add(turnLeftButton);
        controlPanel.add(startButton);
        controlPanel.add(stopButton);
        controlPanel.setPreferredSize(new Dimension(X, 150));
        this.add(controlPanel);
        controlPanel.setBackground(Color.cyan);

        //kopplar lyssnare till knappar och spinner
        eventHandler.attachListeners(gasButton, brakeButton, startButton, stopButton,
                turboOnButton, turboOffButton, liftBedButton, lowerBedButton,
                turnRightButton, turnLeftButton, gasSpinner);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}