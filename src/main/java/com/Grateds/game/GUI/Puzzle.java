package com.Grateds.game.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import com.Grateds.game.CONTROLLER.Controller;
import com.Grateds.game.MODEL.Board;
import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

/**
 * TODO Complete this doc
 * @author Grateds
 */
public class Puzzle extends javax.swing.JFrame implements Observer  {

	private static final long serialVersionUID = 1L;
    
    private Controller controller;
    private Board board;
    
    public Puzzle(Controller c) {
    	this.controller = c;
    	this.board = c.getBoard();
    	this.board.addObserver(this);
        this.initComponents();
        this.setLocationRelativeTo(getOwner());
        this.controller.initialization();
    }

    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        btnNuevoJuego = new javax.swing.JMenuItem();
        btnSalir = new javax.swing.JMenuItem();
        mnuAyuda = new javax.swing.JMenu();
        btnAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Puzzle");
        setLocationByPlatform(true);
        setMinimumSize(new Dimension(panelPrincipal.getWidth(), panelPrincipal.getHeight()));
        setResizable(false);

        
        panelPrincipal.setMaximumSize(new java.awt.Dimension(400, 400));
        panelPrincipal.setMinimumSize(new java.awt.Dimension(400, 400));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        mnuArchivo.setText("File");
        mnuArchivo.setFont(new Font("-", Font.BOLD, 12));

        btnNuevoJuego.setText("New Game");
        btnNuevoJuego.setFont(new Font("-", Font.BOLD, 12));
        btnNuevoJuego.setRequestFocusEnabled(false);
        btnNuevoJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoJuegoActionPerformed(evt);
            }
        });
        mnuArchivo.add(btnNuevoJuego);

        btnSalir.setText("Exit");
        btnSalir.setFont(new Font("-", Font.BOLD, 12));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        mnuArchivo.add(btnSalir);

        jMenuBar1.add(mnuArchivo);

        mnuAyuda.setText("About");
        mnuAyuda.setFont(new Font("-", Font.BOLD, 12));
        btnAcercaDe.setText("About...");
        btnAcercaDe.setFont(new Font("-", Font.BOLD, 12));
        btnAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcercaDeActionPerformed(evt);
            }
        });
        mnuAyuda.add(btnAcercaDe);

        jMenuBar1.add(mnuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnNuevoJuegoActionPerformed(java.awt.event.ActionEvent evt) {                                              
    	// TODO Implement this method
    }                                             

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	this.dispose();
    }                                        

    private void btnAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {                                            
    	About dialog = new About(this, false);
    	dialog.setVisible(true);
    }                                           

    public void setColor(JButton b) {
    	switch (b.getText()) {
    	case "2" :
    		b.setBackground(Color.MAGENTA);
    		b.setBorderPainted(false);
    		break;
    	case "4" :
    		b.setBackground(Color.BLUE);
    		break;
    	case "8" :
    		b.setBackground(Color.CYAN);
    		break;
    	case "16" :
    		b.setBackground(Color.GREEN);
    		break;
    	case "32" :
    		b.setBackground(Color.LIGHT_GRAY);
    		break;
    	case "64" :
    		b.setBackground(Color.ORANGE);
    		break;
    	case "128" :
    		b.setBackground(Color.PINK);
    		break;
    	case "256" :
    		b.setBackground(Color.RED);
    		break;
    	case "512" :
    		b.setBackground(Color.YELLOW);
    		break;
    	case "1024" :
    		b.setBackground(Color.GRAY);
    		break;
    	case "2048" :
    		b.setBackground(Color.WHITE);
    		break;
    	default:
    		b.setBackground(Color.BLACK);
            break;
    			
    	}
    }
    
    // Variables declaration - do not modify                     
    private javax.swing.JMenuItem btnAcercaDe;
    private javax.swing.JMenuItem btnNuevoJuego;
    private javax.swing.JMenuItem btnSalir;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenu mnuAyuda;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration                   

	@Override
	public void update(Observable arg0, Object arg1) {
		panelPrincipal.removeAll();
		Point p;
		JButton b;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				p = new Point(j * 100, i * 100);
				b = new JButton(""+this.board.get(i, j)+"");
				b.setFont(new java.awt.Font("Monaco", Font.BOLD, 23));
				b.setSize(100, 100);
				b.setLocation(p);
				setColor(b);
				b.setVisible(true);
//				if (this.board.get(i, j) != 0) b.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/"+this.board.get(i, j)+".png")));
				panelPrincipal.add(b);
			}
		}
	}
}
