package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import DAO.ProdutoDAO;
import DAO.ConexaoDAO;
import Modelo.Produto;
import Modelo.ProdutoAlimenticio;
import Modelo.ProdutoEletronico;
import Modelo.ProdutoLimpeza;
import View.ProdutoView;

public class ProdutoController implements ActionListener {
    private ProdutoView view;
    private ProdutoDAO dao;

    public ProdutoController(ProdutoView view, ProdutoDAO dao) {
        this.view = view;
        this.dao = dao;
        this.view.cadastrar.addActionListener(this);
        this.view.editar.addActionListener(this);
        this.view.remover.addActionListener(this);
        this.view.buscaCodigo.addActionListener(this);
        this.view.buscaNome.addActionListener(this);
        this.view.buscaCategoria.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.cadastrar) {
            cadastrarProduto();
        } else if (e.getSource() == view.editar) {
            editarProduto();
        } else if (e.getSource() == view.remover) {
            removerProduto();
        } else if (e.getSource() == view.buscaCodigo) {
        	buscarProdutoCodigo();
        } else if (e.getSource() == view.buscaNome) {
        	buscarProdutoNome();
        } else if (e.getSource() == view.buscaCategoria) {
        	buscarProdutoCategoria();
        }
    }

    private void cadastrarProduto() {
        try {
            String nome = view.campoNome.getText();
            String descricao = view.campoDescricao.getText();
            Double precoCusto = Double.parseDouble(view.campoCusto.getText());
            Double precoVenda = Double.parseDouble(view.campoVenda.getText());
            Integer quantidade = Integer.parseInt(view.campoQuantidade.getText());  
            String categoria = null;
            
            if (view.cat1.isSelected()) {
                categoria = "Alimentício";
            } else if (view.cat2.isSelected()) {
                categoria = "Eletrônico";
            } else if (view.cat3.isSelected()) {
                categoria = "Limpeza";
            } else {
                JOptionPane.showMessageDialog(view, "Selecione uma categoria.");
                return;
            }

            Produto produto;
            switch (categoria) {
                case "Alimentício":
                    produto = new ProdutoAlimenticio(quantidade, nome, descricao, categoria, precoCusto, precoVenda);
                    break;
                case "Eletrônico":
                    produto = new ProdutoEletronico(quantidade, nome, descricao, categoria, precoCusto, precoVenda);
                    break;
                case "Limpeza":
                    produto = new ProdutoLimpeza(quantidade, nome, descricao, categoria, precoCusto, precoVenda);
                    break;
                default:
                    JOptionPane.showMessageDialog(view, "Categoria inválida.");
                    return;
            }

            try {
                dao.adicionarProduto(produto);
                JOptionPane.showMessageDialog(view, "Produto cadastrado com sucesso!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(view, "Erro ao criar produto: " + ex.getMessage());
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Erro de formato. Certifique-se de que os campos numéricos são preenchidos corretamente.");
        }
    }

    private void editarProduto() {
    	int codigo = Integer.parseInt(view.campoCodigo.getText());
        String nome = view.campoNome.getText();
        String descricao = view.campoDescricao.getText();
        Double precoCusto = Double.parseDouble(view.campoCusto.getText());
        Double precoVenda = Double.parseDouble(view.campoVenda.getText());
        Integer quantidade = Integer.parseInt(view.campoQuantidade.getText());
        String categoria = null;
        
        if (view.cat1.isSelected()) {
            categoria = "Alimentício";
        } else if (view.cat2.isSelected()) {
            categoria = "Eletrônico";
        } else if (view.cat3.isSelected()) {
            categoria = "Limpeza";
        }

        Produto produto;
        switch (categoria) {
            case "Alimentício":
                produto = new ProdutoAlimenticio(quantidade, nome, descricao, categoria, precoCusto, precoVenda);
                break;
            case "Eletrônico":
                produto = new ProdutoEletronico(quantidade, nome, descricao, categoria, precoCusto, precoVenda);
                break;
            case "Limpeza":
                produto = new ProdutoLimpeza(quantidade, nome, descricao, categoria, precoCusto, precoVenda);
                break;
            default:
                JOptionPane.showMessageDialog(view, "Categoria inválida.");
                return;
        }

        try {
            dao.atualizarProduto(produto, codigo);
            JOptionPane.showMessageDialog(view, "Cliente atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Erro ao atualizar cliente: " + ex.getMessage());
        }
    }


    private void removerProduto() {
    	int codigo = Integer.parseInt(view.campoCodigo.getText());

    	try {
            dao.removerProduto(codigo);
            JOptionPane.showMessageDialog(view, "Produto removido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Erro ao deletar produto: " + ex.getMessage());
        }
    }
    
    private void buscarProdutoCodigo() {
    	int codigo = Integer.parseInt(view.campoCodigo.getText());
    	
    	try {
    		dao.consultarProdutoCodigo(codigo);
    	} catch (SQLException ex){
    		JOptionPane.showMessageDialog(view, "Erro ao buscar produto: " + ex.getMessage());
    	}
    }
    
    private void buscarProdutoNome() {
    	String nome = view.campoNome.getText();
    	
    	try {
    		dao.consultarProdutoNome(nome);
    	} catch (SQLException ex){
    		JOptionPane.showMessageDialog(view, "Erro ao buscar produto: " + ex.getMessage());
    	}
    }
    
    private void buscarProdutoCategoria() {
    	String categoria = null;
        
        if (view.cat1.isSelected()) {
            categoria = "Alimentício";
        } else if (view.cat2.isSelected()) {
            categoria = "Eletrônico";
        } else if (view.cat3.isSelected()) {
            categoria = "Limpeza";
        }
    	
    	try {
    		dao.consultarProdutoCategoria(categoria);
    	} catch (SQLException ex){
    		JOptionPane.showMessageDialog(view, "Erro ao buscar produto: " + ex.getMessage());
    	}
    }
}