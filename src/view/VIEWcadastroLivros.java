package view;

import java.awt.Toolkit;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatter;
import jdbc.*;
import model.*;

public class VIEWcadastroLivros extends javax.swing.JFrame {

    GeneroJDBC generoDAO = new GeneroJDBC();
    LivroJDBC livroDAO = new LivroJDBC();
    MarcacaoJDBC marcacaoDAO = new MarcacaoJDBC();
    List<Genero> generos;
    List<Livro> livros;
    List<Marcacao> marcacoes;
    Livro livro = new Livro();
    boolean editar = false;

    public VIEWcadastroLivros(){
        initComponents();
        
        iniciarSpinner();
        coletarBancoDados();
        preecherComboGenero();        
        preencherTable();
        definirIcone();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPanelBiblioteca = new javax.swing.JTabbedPane();
        panelLivros = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLivros = new javax.swing.JTable();
        panelAreaCriacao = new javax.swing.JPanel();
        spinnerPagina = new javax.swing.JSpinner();
        cboGenero = new javax.swing.JComboBox();
        txtNomeLivro = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        lblPaginas = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        checkLido = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca");
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });

        tabbedPanelBiblioteca.setName(""); // NOI18N

        panelLivros.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                panelLivrosFocusGained(evt);
            }
        });

        tableLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Estante"
            }
        ));
        tableLivros.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLivrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableLivros);

        javax.swing.GroupLayout panelLivrosLayout = new javax.swing.GroupLayout(panelLivros);
        panelLivros.setLayout(panelLivrosLayout);
        panelLivrosLayout.setHorizontalGroup(
            panelLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLivrosLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        panelLivrosLayout.setVerticalGroup(
            panelLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLivrosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        tabbedPanelBiblioteca.addTab("Início", panelLivros);

        panelAreaCriacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                panelAreaCriacaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                panelAreaCriacaoFocusLost(evt);
            }
        });

        lblNome.setText("Nome do livro");

        lblGenero.setText("Genero");

        lblPaginas.setText("Páginas");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jLabel1.setText("Finalizou a leitura?");

        javax.swing.GroupLayout panelAreaCriacaoLayout = new javax.swing.GroupLayout(panelAreaCriacao);
        panelAreaCriacao.setLayout(panelAreaCriacaoLayout);
        panelAreaCriacaoLayout.setHorizontalGroup(
            panelAreaCriacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAreaCriacaoLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panelAreaCriacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAreaCriacaoLayout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addGap(254, 324, Short.MAX_VALUE))
                    .addGroup(panelAreaCriacaoLayout.createSequentialGroup()
                        .addGroup(panelAreaCriacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGenero)
                            .addComponent(cboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPaginas)
                            .addGroup(panelAreaCriacaoLayout.createSequentialGroup()
                                .addGroup(panelAreaCriacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnCadastrar)
                                    .addGroup(panelAreaCriacaoLayout.createSequentialGroup()
                                        .addComponent(txtNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addComponent(jLabel1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkLido)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelAreaCriacaoLayout.setVerticalGroup(
            panelAreaCriacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAreaCriacaoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAreaCriacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAreaCriacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(checkLido)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblGenero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPaginas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinnerPagina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnCadastrar)
                .addGap(89, 89, 89))
        );

        tabbedPanelBiblioteca.addTab("Área de criação", panelAreaCriacao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPanelBiblioteca)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPanelBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        
    }//GEN-LAST:event_formFocusLost

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        
    }//GEN-LAST:event_formFocusGained

    private void panelAreaCriacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelAreaCriacaoFocusLost

    }//GEN-LAST:event_panelAreaCriacaoFocusLost

    private void panelAreaCriacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelAreaCriacaoFocusGained

    }//GEN-LAST:event_panelAreaCriacaoFocusGained

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (txtNomeLivro.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nome vazio");
        } else if (cboGenero.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Genero vazio");
        } else if (editar) {
            atualizarLivro();
            esvaziarComponents();
        } else {
            cadastrarLivro();
            esvaziarComponents();
            coletarBancoDados();
            preencherTable();
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void panelLivrosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelLivrosFocusGained

    }//GEN-LAST:event_panelLivrosFocusGained

    private void tableLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLivrosMouseClicked
        String opcao[] = {"Editar", "Excluir", "Mostrar marcações", "Adicionar marcação"};
        int linha = tableLivros.getSelectedRow();
        int escolha = JOptionPane.showOptionDialog(this, "Livro: " + livros.get(linha).getNomeLivro().toString() + " - " + livros.get(linha).getGeneroLivro().getDescricaoGenero(), "Área de edição", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, opcao, opcao[0]);

        switch (escolha) {
            case 0:
                preencherCampos(linha);
                tabbedPanelBiblioteca.setSelectedIndex(1);
            break;
            case 1:
                livroDAO.delete(livros.get(linha));
                coletarBancoDados();
                preencherTable();
            break;
            case 2:
                String mensagem = "Marcações\n\n";
                for(Marcacao m : marcacaoDAO.read(livros.get(linha))){
                    mensagem += m.getAnotacao() + "\n";
                }
                JOptionPane.showMessageDialog(this, mensagem + "\n");
            break;
            default:
        }
    }//GEN-LAST:event_tableLivrosMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VIEWcadastroLivros().setVisible(true);
            }
        });
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                } 
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VIEWcadastroLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VIEWcadastroLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VIEWcadastroLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VIEWcadastroLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JComboBox cboGenero;
    private javax.swing.JCheckBox checkLido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPaginas;
    private javax.swing.JPanel panelAreaCriacao;
    private javax.swing.JPanel panelLivros;
    private javax.swing.JSpinner spinnerPagina;
    private javax.swing.JTabbedPane tabbedPanelBiblioteca;
    private javax.swing.JTable tableLivros;
    private javax.swing.JTextField txtNomeLivro;
    // End of variables declaration//GEN-END:variables

    private void preecherComboGenero() {
        cboGenero.addItem("");
        for (Genero g : generos) {
            cboGenero.addItem(g);
        }
    }

    private void esvaziarComponents() {
        txtNomeLivro.setText("");
        cboGenero.setSelectedIndex(0);
        spinnerPagina.setValue(0);
        checkLido.setSelected(false);
        preencherTable();
    }

    private void preencherTable() {
        DefaultTableModel dtmModel = (DefaultTableModel) tableLivros.getModel();
        dtmModel.setNumRows(0);
        tableLivros.setRowHeight(30);
        for (Livro l : livros) {
            dtmModel.addRow(new Object[]{
                l.getNomeLivro()
            });
        }
    }

    private void definirIcone() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/Icon.png")));
    }

    private void preencherCampos(int linha) {
        livro = livros.get(linha);
        txtNomeLivro.setText(livro.getNomeLivro());
        spinnerPagina.setValue(livro.getPaginas());
        cboGenero.setSelectedIndex(buscarIndeComboBox(livro.getGeneroLivro().getIdGenero()));
        checkLido.setSelected(livro.isLido());
        mudarEstadoAtualizar();
    }

    private void cadastrarLivro() {
        livro.setNomeLivro(txtNomeLivro.getText().trim());
        livro.setGeneroLivro(generos.get(cboGenero.getSelectedIndex() - 1));
        livro.setPaginas(Integer.parseInt(spinnerPagina.getValue().toString()));
        livro.setDataRegistro(new Date());
        livroDAO.create(livro);
    }

    private int buscarIndeComboBox(int idGenero) {
        int index = 0;
        for (int i = 0; i < generos.size(); i++) {
            if (idGenero == generos.get(i).getIdGenero()) {
                index = i + 1;
            }
        }
        return index;
    }

    private void atualizarLivro() {
        livro.setNomeLivro(txtNomeLivro.getText().trim());
        livro.setGeneroLivro(generos.get(cboGenero.getSelectedIndex() - 1));
        livro.setPaginas(Integer.parseInt(spinnerPagina.getValue().toString()));
        livro.setDataRegistro(new Date());
        livro.setLido(checkLido.isSelected());
        livroDAO.update(livro);
        mudarEstadoCadastro();
    }

    private void iniciarSpinner() {
        JSpinner.DefaultEditor editor = (JSpinner.NumberEditor) spinnerPagina.getEditor();
        DefaultFormatter formatter = (DefaultFormatter) editor.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
    }

    private void mudarEstadoCadastro() {
        btnCadastrar.setText("Cadastrar");
        editar = false;
    }

    private void mudarEstadoAtualizar() {
        btnCadastrar.setText("Atualizar");
        editar = true;
    }

    private void coletarBancoDados() {
        livros = livroDAO.read();
        generos = generoDAO.read();
        marcacoes = marcacaoDAO.read(livro);
    }
}
