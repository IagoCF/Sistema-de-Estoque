package View;

import java.awt.EventQueue;
import java.awt.event.*;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class VendaView extends JFrame implements ActionListener{

	public JButton cadastrar, adicionar;
	private JLabel cliente, pagamento, produto, quantidade;
	public JTextField campoCliente, campoProduto, campoQuantidade;
	public JRadioButton cat1, cat2, cat3;
	
	public VendaView() {
		super("Setor de Vendas");
		
        //labels
        cliente = new JLabel("Cliente:");
        cliente.setBounds(10, 10, 80, 25);
        add(cliente);

        pagamento = new JLabel("Forma Pagamento:");
        pagamento.setBounds(10, 40, 120, 25);
        add(pagamento);

        produto = new JLabel("Produto:");
        produto.setBounds(10, 70, 80, 25);
        add(produto);
        
        quantidade = new JLabel("Quantidade:");
        quantidade.setBounds(10, 100, 80, 25);
        add(quantidade);
        
        //campos
        campoCliente = new JTextField();
        campoCliente.setBounds(90, 10, 238, 25);
        add(campoCliente);
        
        //radiobuttons
        cat1 = new JRadioButton("Dinheiro");
        cat2 = new JRadioButton("Cartão");
        cat3 = new JRadioButton("Cheque");
        ButtonGroup grupoTipo = new ButtonGroup();
        grupoTipo.add(cat1);
        grupoTipo.add(cat2);
        grupoTipo.add(cat3);
        
        cat1.setBounds(120, 40, 75, 25);
        cat2.setBounds(195, 40, 65, 25);
        cat3.setBounds(260, 40, 100, 25);
        add(cat1);
        add(cat2);
        add(cat3);
        
        campoProduto = new JTextField();
        campoProduto.setBounds(90, 70, 238, 25);
        add(campoProduto);

        campoQuantidade = new JTextField();
        campoQuantidade.setBounds(90, 100, 238, 25);
        add(campoQuantidade);
		
		//botões
        adicionar = new JButton("Adicionar");
        adicionar.setBounds(150, 130, 100, 25);
        adicionar.addActionListener(this);
        add(adicionar);
        
		cadastrar = new JButton("Cadastrar Produto");
		cadastrar.setBounds(110, 180, 170, 25);
		cadastrar.addActionListener(this);
        add(cadastrar);
        
        //tela
        setLayout(null);
        setSize(360, 250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
