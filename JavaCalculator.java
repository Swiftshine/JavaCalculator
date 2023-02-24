import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

// this is my first Java program :p

class JavaCalculator {
    static JFrame windowFrame;
    static JPanel windowPanel;

    static JLabel inputDescriptionLabel;
    static JLabel resultLabel;

    static JButton additionButton;
    static JButton subtractionButton;
    static JButton multiplicationButton;
    static JButton divisionButton;
    
    static JFormattedTextField numField1;
    static JFormattedTextField numField2;
    
    static int num1 = 1;
    static int num2 = 1;
    
    public static void main(String[] args) {
        // positioning.
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 20); // spacing.


        // setup window.
        windowFrame = new JFrame("Java Calculator by Swiftshine");
        windowFrame.setLayout(new GridBagLayout());
        windowFrame.setSize(1200, 720);
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the application when the window is closed.
        ImageIcon icon = new ImageIcon("swift_icon.png"); // app icon
        windowFrame.setIconImage(icon.getImage());
        
        // setup panel.
        windowPanel = new JPanel(new GridBagLayout());
        
        // setup buttons.
        additionButton = new JButton("Add");
        windowPanel.add(additionButton, gbc); // add buttons to panel (with specified constraints).

        gbc.gridx++;
        subtractionButton = new JButton("Subtract");
        windowPanel.add(subtractionButton, gbc);

        gbc.gridx++;
        multiplicationButton = new JButton("Multiply");
        windowPanel.add(multiplicationButton, gbc);

        gbc.gridx++;
        divisionButton = new JButton("Divide");
        windowPanel.add(divisionButton, gbc);
        
        // number formatter to only accept numbers (ints)
        NumberFormat format = NumberFormat.getIntegerInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setAllowsInvalid(false);

        
        // setup labels.
        gbc.gridx = 0;
        gbc.gridy = 1;
        
        inputDescriptionLabel = new JLabel("First number, second number");
        windowPanel.add(inputDescriptionLabel, gbc); // add the labels to the panel (with specified constraints).
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        resultLabel = new JLabel("Make some calculations!");
        windowPanel.add(resultLabel, gbc);
        
        // number fields
        numField1 = new JFormattedTextField(formatter);
        numField1.setColumns(5); // length of the apperance of the field
        numField2 = new JFormattedTextField(formatter);
        numField2.setColumns(5);

        gbc.gridx = 1;
        gbc.gridy = 0;
        // gbc.anchor = GridBagConstraints.CENTER;
        windowFrame.add(numField1, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        windowFrame.add(numField2, gbc);
    

        windowFrame.add(windowPanel);  // add the panel to the frame.
        windowFrame.setVisible(true);

        // button functions
        additionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num1 = (int) numField1.getValue();
                num2 = (int) numField2.getValue();
                resultLabel.setText("Answer: " + String.valueOf(num1 + num2));
            }
        });

        subtractionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num1 = (int) numField1.getValue();
                num2 = (int) numField2.getValue();
                resultLabel.setText("Answer: " + String.valueOf(num1 - num2));
            }
        });
        
        multiplicationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num1 = (int) numField1.getValue();
                num2 = (int) numField2.getValue();
                resultLabel.setText("Answer: " + String.valueOf(num1 * num2));
            }
        });

        divisionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num1 = (int) numField1.getValue();
                num2 = (int) numField2.getValue();
                if (num2 == 0) {
                    resultLabel.setText("You can't divide by zero.");
                    return;
                } else {
                    resultLabel.setText("Answer: " + String.valueOf((float) num1 / num2));
                }
            }
        });
    }
}
