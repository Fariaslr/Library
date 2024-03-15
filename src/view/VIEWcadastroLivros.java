package view;

import java.awt.Toolkit;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatter;
import jdbc.GeneroJDBC;
import jdbc.LivroJDBC;
import model.Genero;
import model.Livro;

public class VIEWcadastroLivros extends javax.swing.JFrame {

    GeneroJDBC generoDAO = new GeneroJDBC();
    LivroJDBC livroDAO = new LivroJDBC();
    Livro livro = new Livro();
    boolean editar = false;

    public VIEWcadastroLivros() {
        initComponents();
        initSpinner();
        initComboGenero();
        fillTable();
        iconAplication();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboGenero = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLivros = new javax.swing.JTable();
        txtNomeLivro = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        btnAtualizar = new javax.swing.JButton();
        lblPaginas = new javax.swing.JLabel();
        spinnerPagina = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Projeto final POO");
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });

        tableLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome do livro", "Genero do livro", "Páginas"
            }
        ));
        tableLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLivrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableLivros);

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        lblNome.setText("Nome do livro");

        lblGenero.setText("Genero");

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/430112_refresh_icon.png"))); // NOI18N
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        lblPaginas.setText("Páginas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCadastrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNome)
                                    .addComponent(txtNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPaginas)
                                    .addComponent(spinnerPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(212, 212, 212)))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblGenero)
                                .addComponent(cboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(lblGenero)
                    .addComponent(lblPaginas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerPagina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrar)
                    .addComponent(btnAtualizar))
                .addGap(13, 13, 13))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (txtNomeLivro.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nome vazio");
        } else if (cboGenero.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Genero vazio");
        } else if (editar) {
            atualizarLivro();
            emptyComponents();
        } else {
            cadastrarLivro();
            emptyComponents();
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost

    }//GEN-LAST:event_formFocusLost

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        fillTable();
    }//GEN-LAST:event_formFocusGained

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        cboGenero.removeAllItems();
        initComboGenero();
        fillTable();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void tableLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLivrosMouseClicked
        String opcao[] = {"Editar", "Excluir", "Adicionar marcação"};
        int linha = tableLivros.getSelectedRow();
        int escolha = JOptionPane.showOptionDialog(this, "Livro: " + livroDAO.read().get(linha).getNomeLivro().toString(), "Área de edição", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, opcao, opcao[0]);

        switch (escolha) {
            case 0:
                preencherCampos(linha);
                break;
            case 1:
                livroDAO.delete(livroDAO.read().get(linha));
                fillTable();
                break;
            case 2:
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
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JComboBox cboGenero;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPaginas;
    private javax.swing.JSpinner spinnerPagina;
    private javax.swing.JTable tableLivros;
    private javax.swing.JTextField txtNomeLivro;
    // End of variables declaration//GEN-END:variables

    private void initComboGenero() {
        cboGenero.addItem("");
        for (Genero g : generoDAO.read()) {
            cboGenero.addItem(g);
        }
    }

    private void emptyComponents() {
        txtNomeLivro.setText("");
        cboGenero.setSelectedIndex(0);
        spinnerPagina.setValue(0);
        fillTable();
    }

    private void fillTable() {
        DefaultTableModel dtmModel = (DefaultTableModel) tableLivros.getModel();
        dtmModel.setNumRows(0);
        for (Livro l : livroDAO.read()) {
            dtmModel.addRow(new Object[]{
                l.getNomeLivro(),
                l.getGeneroLivro().getDescricaoGenero(),
                l.getDataRegistro()
            });
        }
    }

    private void iconAplication() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/Icon.png")));
    }

    private void preencherCampos(int linha) {
        livro = livroDAO.read().get(linha);
        txtNomeLivro.setText(livro.getNomeLivro());
        spinnerPagina.setValue(livro.getPaginas());
        cboGenero.setSelectedIndex(buscarIndeComboBox(livro.getGeneroLivro().getIdGenero()));
        editar = true;
    }

    private void cadastrarLivro() {
        livro.setNomeLivro(txtNomeLivro.getText().trim());
        livro.setGeneroLivro(generoDAO.read().get(cboGenero.getSelectedIndex() - 1));
        livro.setPaginas(Integer.parseInt(spinnerPagina.getValue().toString()));
        livro.setDataRegistro(new Date());
        livroDAO.create(livro);
    }

    private int buscarIndeComboBox(int idGenero) {
        int index = 0;
        for (int i = 0; i < generoDAO.read().size(); i++) {
            if (idGenero == generoDAO.read().get(i).getIdGenero()) {
                index = i + 1;
            }
        }
        return index;
    }

    private void atualizarLivro() {
        livro.setNomeLivro(txtNomeLivro.getText().trim());
        livro.setGeneroLivro(generoDAO.read().get(cboGenero.getSelectedIndex() - 1));
        livro.setPaginas(Integer.parseInt(spinnerPagina.getValue().toString()));
        livro.setDataRegistro(new Date());
        livroDAO.update(livro);
        editar = false;
    }

    private void initSpinner() {
        JSpinner.DefaultEditor editor = (JSpinner.NumberEditor) spinnerPagina.getEditor();
        DefaultFormatter formatter = (DefaultFormatter) editor.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
    }
}
