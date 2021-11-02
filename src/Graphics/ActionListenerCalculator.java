package Graphics;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ActionListenerCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ActionListenerCalculator();
	}

	private String num1 = "";
	private String num2 = "";
	private boolean numPlace = true;
	private int operatorNum;
	private int int1;
	private int int2;

	JFrame window;
	JPanel panelC;
	JPanel panelS;
	JPanel panelE;
	JPanel panelN;

	JLabel answer = new JLabel("0");

	JButton[]operator = new JButton[5];
	JButton[]numBtn = new JButton[10];
	JButton clearBtn = new JButton("Clear");

	public ActionListenerCalculator() {
		window = new JFrame("Calculator");
		window.setSize(300,300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new BorderLayout());

		panelC = new JPanel();
		panelC.setLayout(new GridLayout(3,3,2,2));

		for(int i=1;i<10;i++) {
			numBtn[i] = new JButton(""+i);
			numBtn[i].addActionListener(new numCreator());
			panelC.add(numBtn[i]);
		}
		
		
		numBtn[0] = new JButton("0");
		numBtn[0].addActionListener(new numCreator());

		operator[0]= new JButton("=");
		operator[1]= new JButton("+");
		operator[2]= new JButton("-");
		operator[3]= new JButton("*");
		operator[4]= new JButton("/");

		panelE = new JPanel(new GridLayout(5,1));

		for(int i=4;i>=0;i--) {
			panelE.add(operator[i]);
		}


		for(int i=0;i<5;i++) {
			operator[i].addActionListener(new operationCreator());
		}

		panelS = new JPanel();
		panelS.add(numBtn[0]);
		panelS.add(clearBtn);


		panelN = new JPanel();
		panelN.setBorder( BorderFactory.createEmptyBorder(30,0,0,0) );
		//		panelN.setBorder(BorderFactory.createLineBorder(Color.black));
		answer.setFont(new Font("Arial", Font.PLAIN, 20));
		panelN.add(answer);

		window.add(panelN,BorderLayout.NORTH);
		window.add(panelC,BorderLayout.CENTER);
		window.add(panelE,BorderLayout.EAST);
		window.add(panelS,BorderLayout.SOUTH);

		window.setVisible(true);
	}

	class numCreator implements ActionListener{//sets number values (in strings)

		@Override
		public void actionPerformed(ActionEvent e) {
			if(numPlace==true) {
				for(int i=0;i<10;i++) {
					if(e.getSource()==numBtn[i]) {
						num1 = num1 + (i);
						answer.setText(num1);
					}
				}
			}else if(numPlace==false) {
				for(int i=0;i<10;i++) {
					if(e.getSource()==numBtn[i]) {
						if(operatorNum==1) {
							num2=num2+i;
							answer.setText(num1+" + "+num2);
						}
					}
				}
			}
		}

	}
	class operationCreator implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {//sets operator value


			if(numPlace==true) {
				if(e.getSource()==operator[1]) {
					
					operatorNum = 1;
					numPlace=false;
					answer.setText(num1 + " + ");

				}else if(e.getSource()==operator[2]) {
					operatorNum=2;
					numPlace=false;
				}else if(e.getSource()==operator[3]) {
					operatorNum=3;
					numPlace=false;
				}else if(e.getSource()==operator[4]) {
					
					operatorNum=4;
					numPlace=false;
				}
			}
			if(numPlace==false) {//parses string values and performs the operation
				
			}



			if(numPlace==true && e.getSource()==operator[0]) {
				answer.setText(num1);
			}else if(numPlace==false && e.getSource()==operator[0]) {
				if(operatorNum==1) {
					int1 = Integer.parseInt(num1);
					int2 = Integer.parseInt(num2);
					answer.setText(""+(int1 + int2));
				}
			}else if(numPlace==false && e.getSource()==operator[0]) {
				if(operatorNum==2) {
					int1 = Integer.parseInt(num1);
					int2 = Integer.parseInt(num2);
					answer.setText(""+(int1 - int2));
				}
			}

		}

	}
}
