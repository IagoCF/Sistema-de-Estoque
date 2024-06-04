package View;

import java.awt.EventQueue;
import java.awt.event.*;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import Controle.ClienteController;
import Controle.ProdutoController;
import DAO.*;

public class TelaInicialView extends JFrame implements ActionListener{

	public JButton cliente, produto, venda;
	
	public TelaInicialView() {
		super("Trabalho Etapa 2");
		
		//botões
		cliente = new JButton("Cliente");
		cliente.setBounds(10, 20, 100, 25);
		cliente.addActionListener(this);
        add(cliente);
        
        produto = new JButton("Produto");
        produto.setBounds(120, 20, 100, 25);
        produto.addActionListener(this);
        add(produto);
        
        venda = new JButton("Venda");
        venda.setBounds(230, 20, 100, 25);
        venda.addActionListener(this);
        add(venda);	
        
        //tela
        setLayout(null);
        setSize(375, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cliente) {
			ClienteView view = new ClienteView();
	        ClienteDAO dao = new ClienteDAO(ConexaoDAO.obterConexao());
	        ClienteController controller = new ClienteController(view, dao);
        } else if (e.getSource() == produto) {
        	ProdutoView view = new ProdutoView();
	        ProdutoDAO dao = new ProdutoDAO(ConexaoDAO.obterConexao());
	        ProdutoController controller = new ProdutoController(view, dao);
        } else if (e.getSource() == venda) {
            VendaView view = new VendaView();
        }
	}

	public static void main(String[] args) {
        TelaInicialView tela = new TelaInicialView();
    }
	
}
