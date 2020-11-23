package com.company;

import java.awt.*;
import java.awt.event.*; // для отслеживания нажатий
import javax.swing.*;  // для создания GUI

import static java.lang.Math.*;
// comment for git

public class Formula extends JFrame{

     JButton Mplus = new JButton("M+");
     JButton MC = new JButton("MC");
     JLabel labelForResult = new JLabel("");
     JTextField input_x = new JTextField("",5);
     JTextField input_y = new JTextField("",5);
     JTextField input_z = new JTextField("",5);
     JLabel label_x = new JLabel("Введите x: ");
     JLabel label_y = new JLabel("Введите y: ");
     JLabel label_z = new JLabel("Введите z: ");
     JRadioButton F1 = new JRadioButton("Формула 1");
     JRadioButton F2 = new JRadioButton("Формула 2");

    double F_1(double x, double y, double z){
        return (sin(sin(y) + exp(cos(y)) + z*z)*pow((sin(PI*y*y)+log(x*x)),1/4));
    }

    double F_2(double x, double y, double z){
        return (atan(pow(z,1/x))/(y*y+z*sin(log(x))));
    }

    public Formula(){
        super("Формулы варианта №9");
        setBounds(600,300,400,250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(7,1));
        container.add(label_x);
        container.add(input_x);
        container.add(label_y);
        container.add(input_y);
        container.add(label_z);
        container.add(input_z);

        ButtonGroup group = new ButtonGroup();
        group.add(F1);
        group.add(F2);
        container.add(F1);
        F1.setSelected(true);
        container.add(F2);
        container.add(Mplus);
        container.add(MC);
        container.add(labelForResult);
        JButton calculate = new JButton("посчитать");
        container.add(calculate);
        calculate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                double x = Double.parseDouble(input_x.getText());
                double y = Double.parseDouble(input_y.getText());
                double z = Double.parseDouble(input_z.getText());
                double result = 0;
                if (F1.isSelected()) {
                    result = F_1(x, y, z);
                } else {
                    result = F_2(x, y, z);
                }
                labelForResult.setText(String.valueOf(result));
            }
        });
        JLabel tak = new JLabel("0");
        MC.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                tak.setText("0");
            }
        });
        Mplus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double sum = Double.parseDouble(tak.getText());
                sum += Double.parseDouble(labelForResult.getText());
                tak.setText(String.valueOf(sum));
            }
        });
        container.add(tak);
    }
}