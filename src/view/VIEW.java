package view;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.*;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.DefaultFormatter;
import jdbc.*;
import model.*;
import resources.CenterTabbedPane;

public class VIEW extends javax.swing.JFrame {

    GeneroJDBC generoDAO = new GeneroJDBC();
    LivroJDBC livroDAO = new LivroJDBC();
    MarcacaoJDBC marcacaoDAO = new MarcacaoJDBC();

    List<Genero> generos;

    Livro livro;
    List<Livro> livros;

    List<Marcacao> marcacoes;
    List<Marcacao> porLivro;

    boolean editarLivro = false, edidarMarcacao = false;

    public VIEW() {
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
        panelMarcacoes = new javax.swing.JPanel();
        scrollTable1 = new javax.swing.JScrollPane();
        tableMarcacoes = new javax.swing.JTable();
        cboLivros = new javax.swing.JComboBox();
        lblOrdenar = new javax.swing.JLabel();
        panelHeaderEditLivros3 = new javax.swing.JPanel();
        lblSuasMarcacoes = new javax.swing.JLabel();
        panelLivros = new javax.swing.JPanel();
        scrollTable = new javax.swing.JScrollPane();
        tableLivros = new javax.swing.JTable();
        panelHeaderLivros = new javax.swing.JPanel();
        lblLivros = new javax.swing.JLabel();
        panelEdicaoLivro = new javax.swing.JPanel();
        spinnerPaginaLivro = new javax.swing.JSpinner();
        cboGenero = new javax.swing.JComboBox();
        txtNomeLivro = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        lblPaginas = new javax.swing.JLabel();
        btnCadastraLivro = new javax.swing.JButton();
        checkLido = new javax.swing.JCheckBox();
        lblLeitura = new javax.swing.JLabel();
        btnLimparLivro = new javax.swing.JButton();
        panelHeaderEditLivros = new javax.swing.JPanel();
        lblAreaEdicao = new javax.swing.JLabel();
        panelEdicaoMarcacao = new javax.swing.JPanel();
        txtTítulo = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        lblLivro = new javax.swing.JLabel();
        lblPaginaMarcacao = new javax.swing.JLabel();
        spinnerPaginaMarcacao = new javax.swing.JSpinner();
        cboLivrosMarcacoes = new javax.swing.JComboBox();
        scrollMarcacoes = new javax.swing.JScrollPane();
        editorAnotacao = new javax.swing.JEditorPane();
        lblAnotacao = new javax.swing.JLabel();
        btnCadastraMarcacao = new javax.swing.JButton();
        btnLimparMarcacao = new javax.swing.JButton();
        panelHeaderMarcacao = new javax.swing.JPanel();
        lblMarcacao = new javax.swing.JLabel();

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

        panelHeaderEditLivros3.setBackground(new java.awt.Color(164, 234, 188));
        panelHeaderEditLivros3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(100,156,127)));

        lblSuasMarcacoes.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblSuasMarcacoes.setForeground(new java.awt.Color(100, 150, 127));
        lblSuasMarcacoes.setText("Anotações");

        javax.swing.GroupLayout panelHeaderEditLivros3Layout = new javax.swing.GroupLayout(panelHeaderEditLivros3);
        panelHeaderEditLivros3.setLayout(panelHeaderEditLivros3Layout);
        panelHeaderEditLivros3Layout.setHorizontalGroup(
            panelHeaderEditLivros3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderEditLivros3Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(lblSuasMarcacoes)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        panelHeaderEditLivros3Layout.setVerticalGroup(
            panelHeaderEditLivros3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderEditLivros3Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(lblSuasMarcacoes)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelMarcacoesLayout = new javax.swing.GroupLayout(panelMarcacoes);
        panelMarcacoes.setLayout(panelMarcacoesLayout);
        panelMarcacoesLayout.setHorizontalGroup(
            panelMarcacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMarcacoesLayout.createSequentialGroup()
                .addGroup(panelMarcacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMarcacoesLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelMarcacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelMarcacoesLayout.createSequentialGroup()
                                .addComponent(lblOrdenar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboLivros, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(scrollTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelMarcacoesLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(panelHeaderEditLivros3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMarcacoesLayout.setVerticalGroup(
            panelMarcacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMarcacoesLayout.createSequentialGroup()
                .addComponent(panelHeaderEditLivros3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(panelMarcacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboLivros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabbedPanelBiblioteca.addTab("", panelMarcacoes);

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

        panelHeaderLivros.setBackground(new java.awt.Color(164, 234, 188));
        panelHeaderLivros.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(100,156,127)));

        lblLivros.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblLivros.setForeground(new java.awt.Color(100, 150, 127));
        lblLivros.setText("Livros");

        javax.swing.GroupLayout panelHeaderLivrosLayout = new javax.swing.GroupLayout(panelHeaderLivros);
        panelHeaderLivros.setLayout(panelHeaderLivrosLayout);
        panelHeaderLivrosLayout.setHorizontalGroup(
            panelHeaderLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLivrosLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(lblLivros)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        panelHeaderLivrosLayout.setVerticalGroup(
            panelHeaderLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLivrosLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(lblLivros)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelLivrosLayout = new javax.swing.GroupLayout(panelLivros);
        panelLivros.setLayout(panelLivrosLayout);
        panelLivrosLayout.setHorizontalGroup(
            panelLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLivrosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelHeaderLivros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelLivrosLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelLivrosLayout.setVerticalGroup(
            panelLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLivrosLayout.createSequentialGroup()
                .addComponent(panelHeaderLivros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabbedPanelBiblioteca.addTab("", panelLivros);

        panelEdicaoLivro.setBackground(new java.awt.Color(164, 234, 188));
        panelEdicaoLivro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                panelEdicaoLivroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                panelEdicaoLivroFocusLost(evt);
            }
        });

        spinnerPaginaLivro.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 2));

        txtNomeLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeLivroActionPerformed(evt);
            }
        });

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

        btnLimparLivro.setText("LIMPAR");
        btnLimparLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparLivroActionPerformed(evt);
            }
        });

        panelHeaderEditLivros.setBackground(new java.awt.Color(164, 234, 188));
        panelHeaderEditLivros.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(100,156,127)));

        lblAreaEdicao.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblAreaEdicao.setForeground(new java.awt.Color(100, 150, 127));
        lblAreaEdicao.setText("Área de edição");

        javax.swing.GroupLayout panelHeaderEditLivrosLayout = new javax.swing.GroupLayout(panelHeaderEditLivros);
        panelHeaderEditLivros.setLayout(panelHeaderEditLivrosLayout);
        panelHeaderEditLivrosLayout.setHorizontalGroup(
            panelHeaderEditLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderEditLivrosLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(lblAreaEdicao)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        panelHeaderEditLivrosLayout.setVerticalGroup(
            panelHeaderEditLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderEditLivrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAreaEdicao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelEdicaoLivroLayout = new javax.swing.GroupLayout(panelEdicaoLivro);
        panelEdicaoLivro.setLayout(panelEdicaoLivroLayout);
        panelEdicaoLivroLayout.setHorizontalGroup(
            panelEdicaoLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEdicaoLivroLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(panelEdicaoLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEdicaoLivroLayout.createSequentialGroup()
                        .addGroup(panelEdicaoLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(txtNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGenero)
                            .addComponent(cboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPaginas)
                            .addComponent(spinnerPaginaLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelEdicaoLivroLayout.createSequentialGroup()
                                .addComponent(lblLeitura)
                                .addGap(9, 9, 9)
                                .addComponent(checkLido))
                            .addGroup(panelEdicaoLivroLayout.createSequentialGroup()
                                .addComponent(btnCadastraLivro)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimparLivro)))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEdicaoLivroLayout.createSequentialGroup()
                        .addComponent(panelHeaderEditLivros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );
        panelEdicaoLivroLayout.setVerticalGroup(
            panelEdicaoLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEdicaoLivroLayout.createSequentialGroup()
                .addComponent(panelHeaderEditLivros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(spinnerPaginaLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(panelEdicaoLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLeitura, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkLido, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelEdicaoLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastraLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimparLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabbedPanelBiblioteca.addTab("", panelEdicaoLivro);

        panelEdicaoMarcacao.setBackground(new java.awt.Color(164, 234, 188));

        txtTítulo.setText("Sem título");

        lblTitulo.setText("Título");

        lblLivro.setText("Livro");

        lblPaginaMarcacao.setText("Página da marcação");

        spinnerPaginaMarcacao.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 2));

        cboLivrosMarcacoes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        scrollMarcacoes.setViewportView(editorAnotacao);

        lblAnotacao.setText("Anotação");

        btnCadastraMarcacao.setText("Enviar");
        btnCadastraMarcacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraMarcacaoActionPerformed(evt);
            }
        });

        btnLimparMarcacao.setText("LIMPAR");
        btnLimparMarcacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparMarcacaoActionPerformed(evt);
            }
        });

        panelHeaderMarcacao.setBackground(new java.awt.Color(164, 234, 188));
        panelHeaderMarcacao.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(100,156,127)));

        lblMarcacao.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblMarcacao.setForeground(new java.awt.Color(100, 150, 127));
        lblMarcacao.setText("Marcação");

        javax.swing.GroupLayout panelHeaderMarcacaoLayout = new javax.swing.GroupLayout(panelHeaderMarcacao);
        panelHeaderMarcacao.setLayout(panelHeaderMarcacaoLayout);
        panelHeaderMarcacaoLayout.setHorizontalGroup(
            panelHeaderMarcacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderMarcacaoLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(lblMarcacao)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        panelHeaderMarcacaoLayout.setVerticalGroup(
            panelHeaderMarcacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderMarcacaoLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(lblMarcacao)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelEdicaoMarcacaoLayout = new javax.swing.GroupLayout(panelEdicaoMarcacao);
        panelEdicaoMarcacao.setLayout(panelEdicaoMarcacaoLayout);
        panelEdicaoMarcacaoLayout.setHorizontalGroup(
            panelEdicaoMarcacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEdicaoMarcacaoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelHeaderMarcacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelEdicaoMarcacaoLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblTitulo))
            .addGroup(panelEdicaoMarcacaoLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(txtTítulo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelEdicaoMarcacaoLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblAnotacao))
            .addGroup(panelEdicaoMarcacaoLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(scrollMarcacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelEdicaoMarcacaoLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblPaginaMarcacao))
            .addGroup(panelEdicaoMarcacaoLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(spinnerPaginaMarcacao, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelEdicaoMarcacaoLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblLivro))
            .addGroup(panelEdicaoMarcacaoLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(cboLivrosMarcacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelEdicaoMarcacaoLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btnCadastraMarcacao)
                .addGap(27, 27, 27)
                .addComponent(btnLimparMarcacao))
        );
        panelEdicaoMarcacaoLayout.setVerticalGroup(
            panelEdicaoMarcacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEdicaoMarcacaoLayout.createSequentialGroup()
                .addComponent(panelHeaderMarcacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lblTitulo)
                .addGap(6, 6, 6)
                .addComponent(txtTítulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblAnotacao)
                .addGap(1, 1, 1)
                .addComponent(scrollMarcacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblPaginaMarcacao)
                .addGap(6, 6, 6)
                .addComponent(spinnerPaginaMarcacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblLivro)
                .addGap(6, 6, 6)
                .addComponent(cboLivrosMarcacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(panelEdicaoMarcacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastraMarcacao)
                    .addComponent(btnLimparMarcacao)))
        );

        tabbedPanelBiblioteca.addTab("", panelEdicaoMarcacao);

        javax.swing.GroupLayout panelBackgroundLayout = new javax.swing.GroupLayout(panelBackground);
        panelBackground.setLayout(panelBackgroundLayout);
        panelBackgroundLayout.setHorizontalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPanelBiblioteca, javax.swing.GroupLayout.Alignment.TRAILING)
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
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost

    }//GEN-LAST:event_formFocusLost

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void tableMarcacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMarcacoesMouseClicked
        String opcao[] = {"Editar", "Excluir", "Info"};
        int linha = tableMarcacoes.getSelectedRow();
        List<Marcacao> auxiliar = cboLivros.getSelectedIndex() == 0 ? marcacoes : porLivro;

        int escolha = JOptionPane.showOptionDialog(this, auxiliar.get(linha).getTitulo() + " - " + auxiliar.get(linha).getAnotacao() + "\n" + auxiliar.get(linha).getLivro().getNomeLivro(),
                "Marcação",
                JOptionPane.CANCEL_OPTION,
                JOptionPane.DEFAULT_OPTION,
                null,
                opcao,
                opcao[0]
        );

        switch (escolha) {
            case 0:
                preencherCamposMarcacao(auxiliar.get(linha));
                tabbedPanelBiblioteca.setSelectedIndex(3);
                break;
            case 1:
                marcacaoDAO.delete(auxiliar.get(linha));
                coletarBancoDados();
                preencherTabelaMarcacoes();
                initComboBox();
                break;
            case 2:
                /*String mensagem = "Marcações:\n\n";
                for (Marcacao m : marcacaoDAO.read(livros.get(linha))) {
                    mensagem += m.getAnotacao() + "\n";
                }
                JOptionPane.showMessageDialog(this, mensagem + "\n");*/
                break;
            default:
        }
    }//GEN-LAST:event_tableMarcacoesMouseClicked

    private void panelEdicaoLivroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelEdicaoLivroFocusLost

    }//GEN-LAST:event_panelEdicaoLivroFocusLost

    private void panelEdicaoLivroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelEdicaoLivroFocusGained

    }//GEN-LAST:event_panelEdicaoLivroFocusGained

    private void btnLimparLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparLivroActionPerformed
        esvaziarComponentsLivro();
        mudarLivroCadastro();
    }//GEN-LAST:event_btnLimparLivroActionPerformed

    private void btnCadastraLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastraLivroActionPerformed
        if (txtNomeLivro.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nome vazio");
        } else if (cboGenero.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Gênero vazio");
        } else if (editarLivro) {
            atualizarLivro();
            esvaziarComponentsLivro();
        } else {
            livroDAO.create(cadastrarLivro());
            esvaziarComponentsLivro();
            coletarBancoDados();
            preencherTabelaLivros();
            initComboBox();
        }
    }//GEN-LAST:event_btnCadastraLivroActionPerformed

    private void cboLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLivrosActionPerformed

    }//GEN-LAST:event_cboLivrosActionPerformed

    private void cboLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboLivrosMouseClicked

    }//GEN-LAST:event_cboLivrosMouseClicked

    private void cboLivrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLivrosItemStateChanged
        if (cboLivros.getSelectedIndex() == 0) {
            preencherTabelaMarcacoes();
        } else if (cboLivros.getSelectedIndex() > 0) {
            coletarBancoDados();
            livro = (Livro) cboLivros.getSelectedItem();
            preencherTabelaMarcacoesPorLivro(livro.getIdLivro());
        }

    }//GEN-LAST:event_cboLivrosItemStateChanged

    private void btnCadastraMarcacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastraMarcacaoActionPerformed
        if (editorAnotacao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Insira a sua anotação");
        } else if (cboLivrosMarcacoes.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Escolha um livro");
        } else if (spinnerPaginaMarcacao.getValue().equals(0)) {
            JOptionPane.showMessageDialog(this, "Selecione uma página");
        } else {
            marcacaoDAO.create(coletarMarcacão());
            esvaziarCamposMarcacao();
            coletarBancoDados();
            initComboBox();
            initTables();
        }
    }//GEN-LAST:event_btnCadastraMarcacaoActionPerformed

    private void panelLivrosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelLivrosFocusGained

    }//GEN-LAST:event_panelLivrosFocusGained

    private void tableLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLivrosMouseClicked
        String opcao[] = {"Editar", "Excluir", "Mostrar marcações", "Adicionar marcação"};
        int linha = tableLivros.getSelectedRow();
        int escolha = JOptionPane.showOptionDialog(this,
                "Livro: " + livros.get(linha).getNomeLivro() + " - " + livros.get(linha).getGeneroLivro().getDescricaoGenero(),
                "Área de edição",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.DEFAULT_OPTION,
                null,
                opcao,
                opcao[1]
        );

        switch (escolha) {
            case 0:
                preencherCamposLivro(linha);
                tabbedPanelBiblioteca.setSelectedIndex(2);
                break;
            case 1:
                livroDAO.delete(livros.get(linha));
                coletarBancoDados();
                preencherTabelaLivros();
                initComboBox();
                break;
            case 2:
                String mensagem = "Marcações:\n";
                for (Marcacao m : marcacaoDAO.read(livros.get(linha))) {
                    mensagem += m.getAnotacao() + " - Pag. " + m.getPaginaAtual();
                }
                JOptionPane.showMessageDialog(this, mensagem);
                break;
            case 3:
                tabbedPanelBiblioteca.setSelectedIndex(3);
                cboLivrosMarcacoes.setSelectedItem(livros.get(linha));
                break;
            default:
        }
    }//GEN-LAST:event_tableLivrosMouseClicked

    private void btnLimparMarcacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparMarcacaoActionPerformed
        esvaziarCamposMarcacao();
    }//GEN-LAST:event_btnLimparMarcacaoActionPerformed

    private void txtNomeLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeLivroActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new VIEW().setVisible(true);
        });
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastraLivro;
    private javax.swing.JButton btnCadastraMarcacao;
    private javax.swing.JButton btnLimparLivro;
    private javax.swing.JButton btnLimparMarcacao;
    private javax.swing.JComboBox cboGenero;
    private javax.swing.JComboBox cboLivros;
    private javax.swing.JComboBox cboLivrosMarcacoes;
    private javax.swing.JCheckBox checkLido;
    private javax.swing.JEditorPane editorAnotacao;
    private javax.swing.JLabel lblAnotacao;
    private javax.swing.JLabel lblAreaEdicao;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblLeitura;
    private javax.swing.JLabel lblLivro;
    private javax.swing.JLabel lblLivros;
    private javax.swing.JLabel lblMarcacao;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblOrdenar;
    private javax.swing.JLabel lblPaginaMarcacao;
    private javax.swing.JLabel lblPaginas;
    private javax.swing.JLabel lblSuasMarcacoes;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelBackground;
    private javax.swing.JPanel panelEdicaoLivro;
    private javax.swing.JPanel panelEdicaoMarcacao;
    private javax.swing.JPanel panelHeaderEditLivros;
    private javax.swing.JPanel panelHeaderEditLivros3;
    private javax.swing.JPanel panelHeaderLivros;
    private javax.swing.JPanel panelHeaderMarcacao;
    private javax.swing.JPanel panelLivros;
    private javax.swing.JPanel panelMarcacoes;
    private javax.swing.JScrollPane scrollMarcacoes;
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

    private void definirIcone() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/icon.png")));
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
                " " + m.getTitulo() + " - " + m.getAnotacao(),
                m.getPaginaAtual()
            });
        }
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

    private void esvaziarComponentsLivro() {
        txtNomeLivro.setText("");
        cboGenero.setSelectedIndex(0);
        spinnerPaginaLivro.setValue(0);
        checkLido.setSelected(false);
        preencherTabelaLivros();
    }

    private void preencherCamposLivro(int linha) {
        livro = livros.get(linha);
        txtNomeLivro.setText(livro.getNomeLivro());
        spinnerPaginaLivro.setValue(livro.getPaginas());
        cboGenero.setSelectedIndex(buscarGeneroComboBox(livro.getGeneroLivro().getIdGenero()));
        checkLido.setSelected(livro.isLido());
        mudarLivroAtualizar();
    }

    private Livro cadastrarLivro() {
        livro = new Livro(
                txtNomeLivro.getText(),
                Integer.parseInt(spinnerPaginaLivro.getValue().toString()),
                new Date(),
                generos.get(cboGenero.getSelectedIndex() - 1),
                checkLido.isSelected()
        );
        return livro;
    }

    private int buscarGeneroComboBox(int idGenero) {
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
        mudarLivroCadastro();
    }

    private void mudarLivroCadastro() {
        btnCadastraLivro.setText("Cadastrar");
        editarLivro = false;
    }

    private void mudarLivroAtualizar() {
        btnCadastraLivro.setText("Atualizar");
        editarLivro = true;
    }

    private void inserirIconeJTabbed() {
        tabbedPanelBiblioteca.setIconAt(0, new ImageIcon(getClass().getResource("/image/home.png")));
        tabbedPanelBiblioteca.setIconAt(1, new ImageIcon(getClass().getResource("/image/edit.png")));
        tabbedPanelBiblioteca.setIconAt(2, new ImageIcon(getClass().getResource("/image/marcacao.png")));
        tabbedPanelBiblioteca.setIconAt(3, new ImageIcon(getClass().getResource("/image/marker.png")));
        tabbedPanelBiblioteca.setUI(new CenterTabbedPane());
    }

    private void preencherTabelaMarcacoesPorLivro(int idLivro) {
        porLivro = marcacoes.stream().filter(m -> m.getLivro().getIdLivro() == idLivro).map(mm -> mm).collect(Collectors.toList());

        DefaultTableModel dtmMarcacoes = (DefaultTableModel) tableMarcacoes.getModel();
        dtmMarcacoes.setNumRows(0);
        tableMarcacoes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        TableColumn colunaPagina = tableMarcacoes.getColumnModel().getColumn(1);
        colunaPagina.setMaxWidth(45);
        for (Marcacao m : porLivro) {
            dtmMarcacoes.addRow(new Object[]{
                " " + m.getTitulo() + " - " + m.getAnotacao(),
                m.getPaginaAtual()
            });
        }

    }

    private void preecherComboLivrosMarcacoes() {
        cboLivrosMarcacoes.removeAllItems();
        cboLivrosMarcacoes.addItem(" ");
        for (Livro l : livros) {
            cboLivrosMarcacoes.addItem(l);
        }
    }

    private Marcacao coletarMarcacão() {
        Marcacao m = new Marcacao(
                txtTítulo.getText(),
                editorAnotacao.getText(),
                (Livro) cboLivrosMarcacoes.getItemAt(cboLivrosMarcacoes.getSelectedIndex()),
                Integer.parseInt(spinnerPaginaMarcacao.getValue().toString())
        );
        return m;
    }

    private void esvaziarCamposMarcacao() {
        txtTítulo.setText("Sem título");
        editorAnotacao.setText("");
        spinnerPaginaMarcacao.setValue(0);
        cboLivrosMarcacoes.setSelectedIndex(0);
    }

    private void preencherCamposMarcacao(Marcacao marcacao) {
        txtTítulo.setText(marcacao.getTitulo());
        editorAnotacao.setText(marcacao.getAnotacao());
        spinnerPaginaMarcacao.setValue(marcacao.getPaginaAtual());
        cboLivrosMarcacoes.setSelectedIndex(buscarLivroComboBox(marcacao.getLivro().getIdLivro()));
        mudarMarcacaoAtualizar();
    }

    private int buscarLivroComboBox(int idLivro) {
        int index = 0;
        for (int i = 1; i < livros.size(); i++) {
            if (idLivro == livros.get(i).getIdLivro()) {
                index = i + 1;
            }
        }
        return index;
    }

    private void mudarMarcacaoAtualizar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
