package com.terra.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameScreen extends JFrame{

    CardLayout cl = new CardLayout();
    JPanel content = new JPanel();

    //Liste des noms de nos conteneurs pour la pile de cartes
    String[] listContent = {"CARD_1", "CARD_2"};

    public GameScreen(){
        this.setTitle("CardLayout");
        this.setSize(300, 120);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //On crée trois conteneurs de couleur différente
        JPanel card1 = new JPanel();
        card1.setBackground(Color.blue);
        JPanel card2 = new JPanel();
        card2.setBackground(Color.red);

        JPanel boutonPane = new JPanel();
        JButton bouton = new JButton("Contenu suivant");
        //Définition de l'action du bouton
        bouton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                //Via cette instruction, on passe au prochain conteneur de la pile
                cl.next(content);
            }
        });


        boutonPane.add(bouton);

        //On définit le layout
        content.setLayout(cl);
        //On ajoute les cartes à la pile avec un nom pour les retrouver
        content.add(card1, listContent[0]);
        content.add(card2, listContent[1]);

        this.getContentPane().add(boutonPane, BorderLayout.NORTH);
        this.getContentPane().add(content, BorderLayout.CENTER);
        this.setVisible(true);
    }
}