package grupp47_lab1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Stack;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching its controller in its state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of its components.
 **/

public class CarView extends JFrame implements Observer{
    private static final int X = 800;
    private static final int Y = 800;
    final DrawPanel drawPanel;
    final CarModel model;

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
    JButton addCarButton = new JButton("Add car");
    JButton removeCarButton = new JButton("Remove car");

    // Constructor
    public CarView(String frameName, CarModel model) {
        super(frameName);
        this.model = model;
        this.drawPanel = new DrawPanel(800, 460, model);
        model.addObserver(this); // Gör så att vyn uppdateras när modellen förändras
        initComponents(frameName);
    }


    public void update(){
        SwingUtilities.invokeLater(() -> drawPanel.repaint());
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

        controlPanel.setLayout(new GridLayout(0,6));

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
        controlPanel.add(addCarButton);
        controlPanel.add(removeCarButton);
        controlPanel.setPreferredSize(new Dimension(X, 150));
        this.add(controlPanel);
        controlPanel.setBackground(Color.cyan);

        //kopplar lyssnare till knappar och spinner
        /*.attachListeners(gasButton, brakeButton, startButton, stopButton,
                turboOnButton, turboOffButton, liftBedButton, lowerBedButton,
                turnRightButton, turnLeftButton, gasSpinner, addCarButton, removeCarButton);*/

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