// TCSD 14 JAVA Course HW_2
// Yiftach navot 304956279
// Rannan tivoni 302500228

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class Calculator extends JFrame implements ActionListener
{
// create all elements of calculator
JTextField field = new JTextField(10);
JButton button_CALC = new JButton("=");
JButton button_CLEAR = new JButton("C");
JButton button_0 = new JButton("0");
JButton button_1 = new JButton("1");
JButton button_2 = new JButton("2");
JButton button_3 = new JButton("3");
JButton button_4 = new JButton("4");
JButton button_5 = new JButton("5");
JButton button_6 = new JButton("6");
JButton button_7 = new JButton("7");
JButton button_8 = new JButton("8");
JButton button_9 = new JButton("9");
JButton button_Plus = new JButton("+");
JButton button_Minus = new JButton("-");
JButton button_Mul = new JButton("*");
JButton button_Div = new JButton("/");
JButton button_Perc = new JButton("%");

String element0, element1, element2; // elements for storage of values

// element0 element1(+-*/%) element2 = result

boolean minus = false; // element for minus sign

// C'Tor 
public Calculator() 
{	
	super("Calculator"); // headline of window
	element0 = element1 = element2 = "";
	JPanel num_Pan = new JPanel(new GridLayout(4,4)); // Creating the first panel
	num_Pan.add(button_CALC);
	num_Pan.add(button_0);
	num_Pan.add(button_1);
	num_Pan.add(button_Plus);
	num_Pan.add(button_2);
	num_Pan.add(button_3);
	num_Pan.add(button_4);
	num_Pan.add(button_Minus);
	num_Pan.add(button_5);
	num_Pan.add(button_6);
	num_Pan.add(button_7);
	num_Pan.add(button_Mul);
	num_Pan.add(button_8);
	num_Pan.add(button_9);
	num_Pan.add(button_Perc);
	num_Pan.add(button_Div);
	
	
	JPanel result_Pan = new JPanel(new FlowLayout()); // Creating the second panel
	field.setEditable(false);
	result_Pan.add(field);
	result_Pan.add(button_CLEAR);
	
	setLayout(new BorderLayout()); // insert panels to the main layout
	add(num_Pan, BorderLayout.SOUTH);
	add(result_Pan, BorderLayout.NORTH);
	this.pack();
	
	// adding the action function to the buttons
	button_0.addActionListener(this);
	button_1.addActionListener(this);
	button_2.addActionListener(this);
	button_3.addActionListener(this);
	button_4.addActionListener(this);
	button_5.addActionListener(this);
	button_6.addActionListener(this);
	button_7.addActionListener(this);
	button_8.addActionListener(this);
	button_9.addActionListener(this);
	button_CALC.addActionListener(this);
	button_CLEAR.addActionListener(this);
	button_Div.addActionListener(this);
	button_Minus.addActionListener(this);
	button_Plus.addActionListener(this);
	button_Mul.addActionListener(this);
	button_Perc.addActionListener(this);
	
}
@Override
public void actionPerformed(ActionEvent action) {
	
	String arg = action.getActionCommand();
	
	// if the value entered is a number
	if ((arg.charAt(0) >= '0' && arg.charAt(0) <= '9') || minus == false && arg.charAt(0) != 'C')
	{
		minus = true;
		
		// if operand is present then add to second number
		if (!element1.equals("") && !element1.equals('-'))
		{
			element2 = element2 + arg;
		}
		else
		{
			element0 = element0 + arg;
		}
		
		// set the text
		field.setText(element0 + element1 + element2);
	}
	
	else if (arg.charAt(0) == 'C')
	{
		
		// clear all elements
		element0 = element1 = element2 = "";
		
		// set the text
		field.setText(element0 + element1 + element2);
		
		minus = false;
	}
	
	else if (arg.charAt(0) == '=')
	{
		int result = 0;

		// calculate the result
		if (element1.equals("+"))
		{
			result = (Integer.parseInt(element0) + Integer.parseInt(element2));
		}
		
		else if (element1.equals("-"))
		{
			result = (Integer.parseInt(element0) - Integer.parseInt(element2));
		}

		else if (element1.equals("/"))
		{
			result = (Integer.parseInt(element0) / Integer.parseInt(element2));
		}
		
		else if (element1.equals("*"))
		{
			result = (Integer.parseInt(element0) * Integer.parseInt(element2));
		}
		
		else if (element1.equals("%"))
		{
			result = (Integer.parseInt(element0) % Integer.parseInt(element2));
		}
		
		else if (element1.equals("") && element2.equals(""))
		{
			field.setText(element0 + "=" + element0);
			return;
		}
		
		// set the text
		field.setText(element0 + element1 + element2 + "=" + result);
		
		element0 = Integer.toString(result);
		
		element1 = element2 = "";
	}
	
	else
	{
		
		
		// if there is no operand
		if (!element0.equals('-') || element1.equals("") || element2.equals(""))
		{
			minus = false;		
			element1 = arg;
		}
		
		else
		{
			minus = false;
			int result = 0;
			
			// calculate the result
			if (element1.equals("+"))
			{
				result = (Integer.parseInt(element0) + Integer.parseInt(element2));
			}
			
			else if (element1.equals("-"))
			{
				result = (Integer.parseInt(element0) - Integer.parseInt(element2));
			}

			else if (element1.equals("/"))
			{
				result = (Integer.parseInt(element0) / Integer.parseInt(element2));
			}
			
			else if (element1.equals("*"))
			{
				result = (Integer.parseInt(element0) * Integer.parseInt(element2));
			}
			
			else if (element1.equals("%"))
			{
				result = (Integer.parseInt(element0) % Integer.parseInt(element2));
			}
			
			element0 = Integer.toString(result);
			
			// put operator in place
			element1 = arg;
			 
			element2 = "";
		}
		
		field.setText(element0 + element1 + element2);
	}

}
public static void main(String[] args) {
Calculator f = new Calculator();
f.show();
}


}