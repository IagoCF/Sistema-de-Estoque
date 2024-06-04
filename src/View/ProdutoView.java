package View;

import java.awt.event.*;
import javax.swing.*;

public class ProdutoView extends JFrame implements ActionListener{

	public JButton cadastrar, editar, remover, buscaCodigo, buscaNome, buscaCategoria;
	private JLabel codigo, nome, descricao, precoCusto, precoVenda, quantidade, categoria;
	public JTextField campoCodigo, campoNome, campoDescricao, campoQuantidade, campoCusto, campoVenda;
	public JRadioButton cat1, cat2, cat3;
	
	public ProdutoView() {
		super("Setor de Produtos");
		
        //labels
		codigo = new JLabel("Codigo:");
		codigo.setBounds(10, 10, 80, 25);
		add(codigo);
		
		nome = new JLabel("Nome:");
		nome.setBounds(10, 40, 80, 25);
		add(nome);
		
		descricao = new JLabel("Descrição:");
		descricao.setBounds(10, 70, 80, 25);
        add(descricao);

        precoCusto = new JLabel("Preço Custo:");
        precoCusto.setBounds(10, 100, 80, 25);
        add(precoCusto);
        
        precoVenda = new JLabel("Preço Venda:");
        precoVenda.setBounds(10, 130, 80, 25);
        add(precoVenda);
        
        quantidade = new JLabel("Quantidade:");
        quantidade.setBounds(10, 160, 80, 25);
        add(quantidade);
        
        categoria = new JLabel("Categoria:");
        categoria.setBounds(10, 190, 80, 25);
        add(categoria);
        
      //campos
        campoCodigo = new JTextField();
        campoCodigo.setBounds(90, 10, 280, 25);
        add(campoCodigo);
        
        campoNome = new JTextField();
        campoNome.setBounds(90, 40, 280, 25);
        add(campoNome);

        campoDescricao = new JTextField();
        campoDescricao.setBounds(90, 70, 280, 25);
        add(campoDescricao);
        
        campoCusto = new JTextField();
        campoCusto.setBounds(90, 100, 280, 25);
        add(campoCusto);
        
        campoVenda = new JTextField();
        campoVenda.setBounds(90, 130, 280, 25);
        add(campoVenda);
        
        campoQuantidade = new JTextField();
        campoQuantidade.setBounds(90, 160, 280, 25);
        add(campoQuantidade);
        
      //radio buttons        
        cat1 = new JRadioButton("Alimentício");
        cat2 = new JRadioButton("Eletrônico");
        cat3 = new JRadioButton("Limpeza");
        ButtonGroup grupoTipo = new ButtonGroup();
        grupoTipo.add(cat1);
        grupoTipo.add(cat2);
        grupoTipo.add(cat3);
        
        cat1.setBounds(90, 190, 100, 25);
        cat2.setBounds(190, 190, 100, 25);
        cat3.setBounds(290, 190, 100, 25);
        add(cat1);
        add(cat2);
        add(cat3);
        
        //botões de busca
        buscaCodigo = new JButton("Buscar");
        buscaCodigo.setBounds(390, 10, 100, 25);
        buscaCodigo.addActionListener(this);
        add(buscaCodigo);
        
        buscaNome = new JButton("Buscar");
        buscaNome.setBounds(390, 40, 100, 25);
        buscaNome.addActionListener(this);
        add(buscaNome);
        
        buscaCategoria = new JButton("Buscar");
        buscaCategoria.setBounds(390, 190, 100, 25);
        buscaCategoria.addActionListener(this);
        add(buscaCategoria);
		
		//botões
		cadastrar = new JButton("Cadastrar");
		cadastrar.setBounds(70, 240, 100, 25);
		cadastrar.addActionListener(this);
        add(cadastrar);
        
        editar = new JButton("Editar");
        editar.setBounds(180, 240, 100, 25);
        editar.addActionListener(this);
        add(editar);
        
        remover = new JButton("Remover");
        remover.setBounds(290, 240, 100, 25);
        remover.addActionListener(this);
        add(remover);	
        
        //tela
        setLayout(null);
        setSize(520, 320);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
