package telas;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TelaAjuda extends JFrame {

	private JPanel contentPane;

	
	public TelaAjuda(TelaPrincipal tp) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblO = new JLabel("<html>"
				+ "<p>Por meio da aplição é possivel converter uma expressão infixa em polonesa e polonesa reversa.</p>"
				+ "<p>Para converter basta escrever a expressão no campo e clicar em <b>OK</b>.</p>"
				+ "<p>Os resultados são mostrados nos campos abaixo.</p>"
				+ "<p />"
				+ "<p>-Operadores permitidos: <b>+</b>, <b>-</b>, <b>/</b> e <b>*</b>.</p>"
				+ "<p>-Operandos permitidos: <b>números</b> e <b>letras</b> positivos e nagativos.</p>"
				+ "<p>-A ordem das operações é definida <b>apenas por parênteses</b>.</p>"
				+ "<p>-Números negativos <b>não necessitam de parênteses</b>.</p>"
				+ "<p>-Números positivos <b>não necessitam do sinal +</b>.</p>"
				+ "<p>-Você pode ultizar quantos espaços <b>achar necessário</b>.</p>"
				+ "<p />"
				+ "<p>Exemplos:</p>"
				+ "<html>");
		panel.add(lblO);
		lblO.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblO.setVerticalAlignment(SwingConstants.TOP);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(5, 1, 0, 0));
		
		JButton btnA = new JButton("(1+1) * a");
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tp.campoExpressao.setText("(1+1) * a");
				tp.setVisible(true);
				dispose();
			}
		});
		panel_1.add(btnA);
		
		JButton btnaB = new JButton("(A - b) / (-4 + q)");
		btnaB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tp.campoExpressao.setText("(A - b) / (-4 + q)");
				tp.setVisible(true);
				dispose();
			}
		});
		panel_1.add(btnaB);
		
		JButton button = new JButton("((1 + -1) * 4 - 10) + 4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tp.campoExpressao.setText("((1 + -1) * 4 - 10) + 4");
				tp.setVisible(true);
				dispose();
			}
		});
		panel_1.add(button);
		
		JButton btnA_1 = new JButton("a / (5 - 2) + B");
		btnA_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tp.campoExpressao.setText("a / (5 - 2) + B");
				tp.setVisible(true);
				dispose();
			}
		});
		panel_1.add(btnA_1);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut);
		
		JButton btnOk = new JButton("< Voltar");
		contentPane.add(btnOk, BorderLayout.SOUTH);
	}

}
