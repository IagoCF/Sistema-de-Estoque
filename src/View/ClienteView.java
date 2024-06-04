package View;

import java.awt.EventQueue;
import java.awt.event.*;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class ClienteView extends JFrame implements ActionListener{

	public JButton cadastrar, editar, remover;
	private JLabel cpf, nome, email, nascimento;
	public JTextField campoCpf, campoNome, campoEmail, campoNascimento;
	
	public ClienteView() {
		super("Setor de Clientes");
		
        //labels
        cpf = new JLabel("CPF:");
        cpf.setBounds(10, 10, 80, 25);
        add(cpf);

        nome = new JLabel("Nome:");
        nome.setBounds(10, 40, 80, 25);
        add(nome);

        email = new JLabel("Email:");
        email.setBounds(10, 70, 80, 25);
        add(email);
        
        nascimento = new JLabel("Nascimento:");
        nascimento.setBounds(10, 100, 80, 25);
        add(nascimento);
        
      //campos
        try {
            MaskFormatter formatter = new MaskFormatter("###########");
            formatter.setPlaceholderCharacter('0');
            campoCpf = new JFormattedTextField(formatter);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        campoCpf.setBounds(90, 10, 200, 25);
        add(campoCpf);

        campoNome = new JTextField();
        campoNome.setBounds(90, 40, 200, 25);
        add(campoNome);

        campoEmail = new JTextField();
        campoEmail.setBounds(90, 70, 200, 25);
        add(campoEmail);
        
        try {
            MaskFormatter formatterData = new MaskFormatter("##/##/####");
            formatterData.setPlaceholderCharacter('0');
            campoNascimento = new JFormattedTextField(formatterData);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        campoNascimento.setBounds(90, 100, 200, 25);
        add(campoNascimento);
		
		//botões
		cadastrar = new JButton("Cadastrar");
		cadastrar.setBounds(10, 140, 100, 25);
		cadastrar.addActionListener(this);
        add(cadastrar);
        
        editar = new JButton("Editar");
        editar.setBounds(120, 140, 100, 25);
        editar.addActionListener(this);
        add(editar);
        
        remover = new JButton("Remover");
        remover.setBounds(230, 140, 100, 25);
        remover.addActionListener(this);
        add(remover);	
        
        //tela
        setLayout(null);
        setSize(350, 220);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
