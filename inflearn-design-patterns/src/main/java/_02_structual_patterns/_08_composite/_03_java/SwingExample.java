package _02_structual_patterns._08_composite._03_java;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class SwingExample {

  public static void main(String[] args) {
    JFrame frame = new JFrame();

    JTextField textField = new JTextField();
    textField.setBounds(200, 200, 200, 40);
    frame.add(textField);

    JButton button = new JButton("click");
    button.setBounds(200, 100, 60, 40);
    button.addActionListener(e -> textField.setText("Hello Swing"));
    frame.add(button);

    frame.setSize(600, 400);
    frame.setLayout(null);
    frame.setVisible(true);
  }


}
