package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JTextField inputField1 = new JTextField();
        JTextField inputField2 = new JTextField();
        JTextField outputField = new JTextField();
        outputField.setEditable(false);

        inputField1.setFont((new Font("Arial", Font.PLAIN, 30)));
        inputField2.setFont((new Font("Arial", Font.PLAIN, 30)));
        outputField.setFont((new Font("Arial", Font.PLAIN, 30)));

        JLabel label1 = new JLabel("Número 1:");
        label1.setFont((new Font("Arial", Font.BOLD, 30)));
        JLabel label2 = new JLabel("Número 2:");
        label2.setFont((new Font("Arial", Font.BOLD, 30)));
        JLabel label3 = new JLabel("Resultado:");
        label3.setFont((new Font("Arial", Font.BOLD, 30)));

        panel.add(label1);
        panel.add(inputField1);
        panel.add(label2);
        panel.add(inputField2);
        panel.add(label3);
        panel.add(outputField);

        String[] buttonLabels =
                {
                        "Somar", "Subtrair", "Multiplicar", "Dividir"
                };

        for (String label : buttonLabels)
        {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            panel.add(button);

            button.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    double num1, num2, result = 0.0;

                    try
                    {
                        num1 = Double.parseDouble(inputField1.getText());
                        num2 = Double.parseDouble(inputField2.getText());

                        if (label.equals("Somar"))
                        {
                            result = num1 + num2;
                        }
                        else if (label.equals("Subtrair"))
                        {
                            result = num1 - num2;
                        }
                        else if (label.equals("Multiplicar"))
                        {
                            result = num1 * num2;
                        }
                        else if (label.equals("Dividir"))
                        {
                            if (num2 != 0)
                            {
                                result = num1 / num2;
                            }
                            else
                            {
                                outputField.setText("Erro: Divisão por zero");
                                return;
                            }
                        }
                        outputField.setText(Double.toString(result));
                    }
                    catch (NumberFormatException ex)
                    {
                        outputField.setText("Erro: Entrada inválida");
                    }
                }
            });
        }

        frame.add(panel);
        frame.setVisible(true);
    }
}