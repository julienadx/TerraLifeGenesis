package com.terra.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame{

    CardLayout cl = new CardLayout();
    JPanel content = new JPanel();

    //Liste des noms de nos conteneurs pour la pile de cartes
    String[] listContent = {"gamePlay", "stats"};

    GamePLayScreen gamePlayScreen;

    public GameWindow(){
        this.setTitle("Terra Life Genesis v0.4");
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //On crée deux conteneurs de couleur différente
        this.gamePlayScreen = new GamePLayScreen();

        JPanel statScreen = new JPanel();
        statScreen.setLayout(new BorderLayout());
        statScreen.add(new JLabel("stats screen"), BorderLayout.CENTER);


        StatusBarPan statusBar = new StatusBarPan("World", 100, 100);
        //Définition de l'action du bouton
        statusBar.getStatButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                //Via cette instruction, on passe au prochain conteneur de la pile
                cl.next(content);
            }
        });

        //On définit le layout
        content.setLayout(cl);
        //On ajoute les cartes à la pile avec un nom pour les retrouver
        content.add(gamePlayScreen, listContent[0]);
        content.add(statScreen, listContent[1]);

        this.getContentPane().add(statusBar, BorderLayout.NORTH);
        this.getContentPane().add(content, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void startGame() {
        for (int i=0; i<100; i++) {
            this.gamePlayScreen.getEnvironmentPan().modifyValue(i, i % 6);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                //pass
            }
        }
    }
}