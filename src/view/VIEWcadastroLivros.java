package view;

import java.awt.Toolkit;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.DefaultFormatter;
import jdbc.*;
import model.*;
import resources.CenterTabbedPane;

public class VIEWcadastroLivros extends javax.swing.JFrame {

    GeneroJDBC generoDAO = new GeneroJDBC();
    LivroJDBC livroDAO = new LivroJDBC();
    MarcacaoJDBC marcacaoDAO = new MarcacaoJDBC();
    Livro livro;
    List<Genero> generos;
    List<Livro> livros;
    List<Marcacao> marcacoes;
    boolean editar = false;

    public VIEWcadastroLivros() {
        initComponents();
        coletarBancoDados();
        initSpinners();
        initComboBox();
        initTables();
        initIcons();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground = new javax.swing.JPanel();
        tabbedPanelBiblioteca = new javax.swing.JTabbedPane();
        panelLivros = new javax.swing.JPanel();
        scrollTable = new javax.swing.JScrollPane();
        tableLivros = new javax.swing.JTable();
        panelAreaCriacao = new javax.swing.JPanel();
        spinnerPaginaLivro = new javax.swing.JSpinner();
        cboGenero = new javax.swing.JComboBox();
        txtNomeLivro = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        lblPaginas = new javax.swing.JLabel();
        btnCadastraLivro = new javax.swing.JButton();
        checkLido = new javax.swing.JCheckBox();
        lblLeitura = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        panelMarcacoes = new javax.swing.JPanel();
        scrollTable1 = new javax.swing.JScrollPane();
        tableMarcacoes = new javax.swing.JTable();
        cboLivros = new javax.swing.JComboBox();
        lblOrdenar = new javax.swing.JLabel();
        panelAddMarcacao = new javax.swing.JPanel();
        txtTítulo = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        lblLivro = new javax.swing.JLabel();
        lblPaginaMarcacao = new javax.swing.JLabel();
        spinnerPaginaMarcacao = new javax.swing.JSpinner();
        cboLivrosMarcacoes = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        editorAnotacao = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();
        btnCadastraMarcacao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca");
        setAutoRequestFocus(false);
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });

        panelBackground.setBackground(new java.awt.Color(232, 244, 238));

        tabbedPanelBiblioteca.setBackground(new java.awt.Color(255, 255, 255));
        tabbedPanelBiblioteca.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPanelBiblioteca.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        tabbedPanelBiblioteca.setToolTipText("");
        tabbedPanelBiblioteca.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabbedPanelBiblioteca.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        tabbedPanelBiblioteca.setName(""); // NOI18N

        panelLivros.setBackground(new java.awt.Color(164, 234, 188));
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
        scrollTable.setViewportView(tableLivros);

        javax.swing.GroupLayout panelLivrosLayout = new javax.swing.GroupLayout(panelLivros);
        panelLivros.setLayout(panelLivrosLayout);
        panelLivrosLayout.setHorizontalGroup(
            panelLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLivrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLivrosLayout.setVerticalGroup(
            panelLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLivrosLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        tabbedPanelBiblioteca.addTab("", panelLivros);

        panelAreaCriacao.setBackground(new java.awt.Color(164, 234, 188));
        panelAreaCriacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                panelAreaCriacaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                panelAreaCriacaoFocusLost(evt);
            }
        });

        spinnerPaginaLivro.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 2));

        lblNome.setText("Nome do livro");

        lblGenero.setText("Genero");

        lblPaginas.setText("Quantidade de páginas");

        btnCadastraLivro.setText("Cadastrar");
        btnCadastraLivro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastraLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraLivroActionPerformed(evt);
            }
        });

        checkLido.setBackground(new java.awt.Color(164, 234, 188));
        checkLido.setBorder(null);

        lblLeitura.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblLeitura.setText("Finalizou a leitura?");

        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAreaCriacaoLayout = new javax.swing.GroupLayout(panelAreaCriacao);
        panelAreaCriacao.setLayout(panelAreaCriacaoLayout);
        panelAreaCriacaoLayout.setHorizontalGroup(
            panelAreaCriacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAreaCriacaoLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panelAreaCriacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAreaCriacaoLayout.createSequentialGroup()
                        .addGroup(panelAreaCriacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblGenero)
                            .addComponent(lblPaginas)
                            .addComponent(txtNomeLivro, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(cboGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spinnerPaginaLivro)
                            .addGroup(panelAreaCriacaoLayout.createSequentialGroup()
                                .addComponent(lblLeitura)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(checkLido)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelAreaCriacaoLayout.createSequentialGroup()
                        .addGroup(panelAreaCriacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelAreaCriacaoLayout.createSequentialGroup()
                                .addComponent(btnCadastraLivro)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpar))
                            .addComponent(lblNome))
                        .addContainerGap(43, Short.MAX_VALUE))))
        );
        panelAreaCriacaoLayout.setVerticalGroup(
            panelAreaCriacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAreaCriacaoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblGenero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAreaCriacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelAreaCriacaoLayout.createSequentialGroup()
                        .addComponent(cboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPaginas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerPaginaLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblLeitura))
                    .addComponent(checkLido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(panelAreaCriacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar)
                    .addComponent(btnCadastraLivro))
                .addGap(35, 35, 35))
        );

        tabbedPanelBiblioteca.addTab("", panelAreaCriacao);

        panelMarcacoes.setBackground(new java.awt.Color(164, 234, 188));

        tableMarcacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Marcação", "Página"
            }
        ));
        tableMarcacoes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableMarcacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMarcacoesMouseClicked(evt);
            }
        });
        scrollTable1.setViewportView(tableMarcacoes);

        cboLivros.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboLivros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLivrosItemStateChanged(evt);
            }
        });
        cboLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboLivrosMouseClicked(evt);
            }
        });
        cboLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLivrosActionPerformed(evt);
            }
        });

        lblOrdenar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblOrdenar.setText("Ordenar por");

        javax.swing.GroupLayout panelMarcacoesLayout = new javax.swing.GroupLayout(panelMarcacoes);
        panelMarcacoes.setLayout(panelMarcacoesLayout);
        panelMarcacoesLayout.setHorizontalGroup(
            panelMarcacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMarcacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMarcacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelMarcacoesLayout.createSequentialGroup()
                        .addComponent(lblOrdenar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboLivros, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMarcacoesLayout.setVerticalGroup(
            panelMarcacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMarcacoesLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(panelMarcacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboLivros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        tabbedPanelBiblioteca.addTab("", panelMarcacoes);

        panelAddMarcacao.setBackground(new java.awt.Color(164, 234, 188));

        txtTítulo.setText("Sem título");

        lblTitulo.setText("Título");

        lblLivro.setText("Livro");

        lblPaginaMarcacao.setText("Página da marcação");

        spinnerPaginaMarcacao.setModel(new javax.swing.SpinnerNumberModel(1, 0, null, 2));

        cboLivrosMarcacoes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jScrollPane1.setViewportView(editorAnotacao);

        jLabel1.setText("Anotação");

        btnCadastraMarcacao.setText("Enviar");
        btnCadastraMarcacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraMarcacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAddMarcacaoLayout = new javax.swing.GroupLayout(panelAddMarcacao);
        panelAddMarcacao.setLayout(panelAddMarcacaoLayout);
        panelAddMarcacaoLayout.setHorizontalGroup(
            panelAddMarcacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddMarcacaoLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panelAddMarcacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAddMarcacaoLayout.createSequentialGroup()
                        .addComponent(lblLivro)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelAddMarcacaoLayout.createSequentialGroup()
                        .addGroup(panelAddMarcacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPaginaMarcacao)
                            .addComponent(jLabel1)
                            .addComponent(lblTitulo))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddMarcacaoLayout.createSequentialGroup()
                        .addGroup(panelAddMarcacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cboLivrosMarcacoes, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spinnerPaginaMarcacao, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTítulo, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(42, 42, 42))))
            .addGroup(panelAddMarcacaoLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(btnCadastraMarcacao)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelAddMarcacaoLayout.setVerticalGroup(
            panelAddMarcacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddMarcacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTítulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPaginaMarcacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinnerPaginaMarcacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLivro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboLivrosMarcacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCadastraMarcacao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tabbedPanelBiblioteca.addTab("", panelAddMarcacao);

        javax.swing.GroupLayout panelBackgroundLayout = new javax.swing.GroupLayout(panelBackground);
        panelBackground.setLayout(panelBackgroundLayout);
        panelBackgroundLayout.setHorizontalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPanelBiblioteca)
        );
        panelBackgroundLayout.setVerticalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPanelBiblioteca)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost

    }//GEN-LAST:event_formFocusLost

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void tableMarcacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMarcacoesMouseClicked

    }//GEN-LAST:event_tableMarcacoesMouseClicked

    private void panelAreaCriacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelAreaCriacaoFocusLost

    }//GEN-LAST:event_panelAreaCriacaoFocusLost

    private void panelAreaCriacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelAreaCriacaoFocusGained

    }//GEN-LAST:event_panelAreaCriacaoFocusGained

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        esvaziarComponents();
        mudarEstadoCadastro();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnCadastraLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastraLivroActionPerformed
        if (txtNomeLivro.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nome vazio");
        } else if (cboGenero.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Gênero vazio");
        } else if (editar) {
            atualizarLivro();
            esvaziarComponents();
        } else {
            cadastrarLivro();
            esvaziarComponents();
            coletarBancoDados();
            preencherTabelaLivros();
            initComboBox();
        }
    }//GEN-LAST:event_btnCadastraLivroActionPerformed

    private void panelLivrosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelLivrosFocusGained

    }//GEN-LAST:event_panelLivrosFocusGained

    private void tableLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLivrosMouseClicked
        String opcao[] = {"Editar", "Excluir", "Mostrar marcações", "Adicionar marcação"};
        int linha = tableLivros.getSelectedRow();
        int escolha = JOptionPane.showOptionDialog(this, "Livro: " + livros.get(linha).getNomeLivro() + " - " + livros.get(linha).getGeneroLivro().getDescricaoGenero(), "Área de edição", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, opcao, opcao[0]);

        switch (escolha) {
            case 0:
                preencherCampos(linha);
                tabbedPanelBiblioteca.setSelectedIndex(1);
                break;
            case 1:
                livroDAO.delete(livros.get(linha));
                coletarBancoDados();
                preencherTabelaLivros();
                initComboBox();
                break;
            case 2:
                String mensagem = "Marcações:\n\n";
                for (Marcacao m : marcacaoDAO.read(livros.get(linha))) {
                    mensagem += m.getAnotacao() + "\n";
                }
                JOptionPane.showMessageDialog(this, mensagem + "\n");
                break;
            case 3:
                break;
            default:
        }
    }//GEN-LAST:event_tableLivrosMouseClicked

    private void cboLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLivrosActionPerformed

    }//GEN-LAST:event_cboLivrosActionPerformed

    private void cboLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboLivrosMouseClicked

    }//GEN-LAST:event_cboLivrosMouseClicked

    private void cboLivrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLivrosItemStateChanged
        if (cboLivros.getSelectedIndex() == 0) {
            preencherTabelaMarcacoes();
        } else if (cboLivros.getSelectedIndex() > 0) {
            livro = (Livro) cboLivros.getSelectedItem();
            preencherTabelaMarcacoesPorLivro();
        }

    }//GEN-LAST:event_cboLivrosItemStateChanged

    private void btnCadastraMarcacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastraMarcacaoActionPerformed
        if (editorAnotacao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Insira a sua anotação");
        } else if (cboLivrosMarcacoes.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Escolha um livro");
        }
    }//GEN-LAST:event_btnCadastraMarcacaoActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new VIEWcadastroLivros().setVisible(true);
        });
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VIEWcadastroLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastraLivro;
    private javax.swing.JButton btnCadastraMarcacao;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox cboGenero;
    private javax.swing.JComboBox cboLivros;
    private javax.swing.JComboBox cboLivrosMarcacoes;
    private javax.swing.JCheckBox checkLido;
    private javax.swing.JEditorPane editorAnotacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblLeitura;
    private javax.swing.JLabel lblLivro;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblOrdenar;
    private javax.swing.JLabel lblPaginaMarcacao;
    private javax.swing.JLabel lblPaginas;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelAddMarcacao;
    private javax.swing.JPanel panelAreaCriacao;
    private javax.swing.JPanel panelBackground;
    private javax.swing.JPanel panelLivros;
    private javax.swing.JPanel panelMarcacoes;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JScrollPane scrollTable1;
    private javax.swing.JSpinner spinnerPaginaLivro;
    private javax.swing.JSpinner spinnerPaginaMarcacao;
    private javax.swing.JTabbedPane tabbedPanelBiblioteca;
    private javax.swing.JTable tableLivros;
    private javax.swing.JTable tableMarcacoes;
    private javax.swing.JTextField txtNomeLivro;
    private javax.swing.JTextField txtTítulo;
    // End of variables declaration//GEN-END:variables

    private void iniciarSpinner(JSpinner spinner) {
        JSpinner.DefaultEditor editor = (JSpinner.NumberEditor) spinner.getEditor();
        DefaultFormatter formatter = (DefaultFormatter) editor.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
    }

    private void coletarBancoDados() {
        livros = livroDAO.read();
        generos = generoDAO.read();
        marcacoes = marcacaoDAO.list();
    }

    private void preencherComboGenero() {
        cboGenero.removeAllItems();
        cboGenero.addItem("");
        for (Genero g : generos) {
            cboGenero.addItem(g);
        }
    }

    private void preencherComboLivros() {
        cboLivros.removeAllItems();
        cboLivros.addItem(" ");
        for (Livro l : livros) {
            cboLivros.addItem(l);
        }
    }

    private void preencherTabelaLivros() {
        DefaultTableModel dtmModel = (DefaultTableModel) tableLivros.getModel();
        dtmModel.setNumRows(0);
        tableLivros.setRowHeight(30);

        for (Livro l : livros) {
            dtmModel.addRow(new Object[]{
                " " + l.getNomeLivro()
            });
        }
    }

    private void preencherTabelaMarcacoes() {
        DefaultTableModel dtmMarcacoes = (DefaultTableModel) tableMarcacoes.getModel();
        dtmMarcacoes.setNumRows(0);
        tableMarcacoes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        TableColumn colunaPagina = tableMarcacoes.getColumnModel().getColumn(1);
        colunaPagina.setMaxWidth(45);
        for (Marcacao m : marcacoes) {
            dtmMarcacoes.addRow(new Object[]{
                " " + m.getAnotacao(),
                m.getPaginaAtual()
            });
        }
    }

    private void definirIcone() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/icon.png")));
    }

    private void esvaziarComponents() {
        txtNomeLivro.setText("");
        cboGenero.setSelectedIndex(0);
        spinnerPaginaLivro.setValue(0);
        checkLido.setSelected(false);
        preencherTabelaLivros();
    }

    private void preencherCampos(int linha) {
        livro = livros.get(linha);
        txtNomeLivro.setText(livro.getNomeLivro());
        spinnerPaginaLivro.setValue(livro.getPaginas());
        cboGenero.setSelectedIndex(buscarIndeComboBox(livro.getGeneroLivro().getIdGenero()));
        checkLido.setSelected(livro.isLido());
        mudarEstadoAtualizar();
    }

    private void cadastrarLivro() {
        livro.setNomeLivro(txtNomeLivro.getText().trim());
        livro.setGeneroLivro(generos.get(cboGenero.getSelectedIndex() - 1));
        livro.setPaginas(Integer.parseInt(spinnerPaginaLivro.getValue().toString()));
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
        livro.setPaginas(Integer.parseInt(spinnerPaginaLivro.getValue().toString()));
        livro.setDataRegistro(new Date());
        livro.setLido(checkLido.isSelected());
        livroDAO.update(livro);
        mudarEstadoCadastro();
    }

    private void mudarEstadoCadastro() {
        btnCadastraLivro.setText("Cadastrar");
        editar = false;
    }

    private void mudarEstadoAtualizar() {
        btnCadastraLivro.setText("Atualizar");
        editar = true;
    }

    private void inserirIconeJTabbed() {
        tabbedPanelBiblioteca.setIconAt(0, new ImageIcon(getClass().getResource("/image/home.png")));
        tabbedPanelBiblioteca.setIconAt(1, new ImageIcon(getClass().getResource("/image/edit.png")));
        tabbedPanelBiblioteca.setIconAt(2, new ImageIcon(getClass().getResource("/image/marcacao.png")));
        tabbedPanelBiblioteca.setIconAt(3, new ImageIcon(getClass().getResource("/image/marker.png")));
        tabbedPanelBiblioteca.setUI(new CenterTabbedPane());
    }

    private void preencherTabelaMarcacoesPorLivro() {

    }

    private void preecherComboLivrosMarcacoes() {
        cboLivrosMarcacoes.removeAllItems();
        cboLivrosMarcacoes.addItem(" ");
        for (Livro l : livros) {
            cboLivrosMarcacoes.addItem(l);
        }
    }

    private void initComboBox() {
        preencherComboGenero();
        preencherComboLivros();
        preecherComboLivrosMarcacoes();
    }

    private void initSpinners() {
        iniciarSpinner(spinnerPaginaLivro);
        iniciarSpinner(spinnerPaginaMarcacao);
    }

    private void initTables() {
        preencherTabelaLivros();
        preencherTabelaMarcacoes();
    }

    private void initIcons() {
        definirIcone();
        inserirIconeJTabbed();
    }
}
