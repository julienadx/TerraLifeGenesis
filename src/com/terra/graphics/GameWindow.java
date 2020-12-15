package com.terra.graphics;

import com.terra.tools.Environment;
import com.terra.tools.Player;
import com.terra.tools.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame implements ActionListener {

    CardLayout cl = new CardLayout();
    JPanel content = new JPanel();

    //Liste des noms de nos conteneurs pour la pile de cartes
    String[] listContent = {"gamePlay", "stats"};

    GamePLayScreen gamePlayScreen;

    private Player player;
    private StatusBarPan statusBar;

    public GameWindow(){
        this.setTitle("Terra Life Genesis v0.4");
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.player = new Player(new World(new Environment()), 100);

        //On crée deux conteneurs de couleur différente
        this.gamePlayScreen = new GamePLayScreen();

        JPanel statScreen = new JPanel();
        statScreen.setLayout(new BorderLayout());
        statScreen.add(new JLabel("stats screen"), BorderLayout.CENTER);


        this.statusBar = new StatusBarPan("World", 100, 100);


        //Définition de l'action du bouton
        statusBar.getStatButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                //Via cette instruction, on passe au prochain conteneur de la pile
                cl.next(content);
            }
        });

        for (int i=0; i<this.gamePlayScreen.getMachinePan().getValuesKind().length; i++) {
            this.gamePlayScreen.getMachinePan().getUpgradeButton()[i].addActionListener(this);
        }

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
        /*
        for (int i=0; i<100; i++) {
            this.gamePlayScreen.getEnvironmentPan().modifyValue(i, i % 6);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                //pass
            }
        }
         */

        player.getWorld().getSpecies()[0].setPopulation(20);

        //game loop
        for (this.player.getWorld().getDate(); this.player.getWorld().getDate()<12000; this.player.getWorld().setDate(this.player.getWorld().getDate() + 1)) {
            if (player.getWorld().getWorldBiomass() == 0) {
                System.out.println("you looooooooose!");
                break;
            } else if (player.getWorld().getWorldBiomass() >= 20000000) {
                System.out.println("you win! Congrats your planet is suitable for human beings!");
                break;
            }
            if (this.player.getWorld().getDate() % 10 == 0) {
                player.yearCompleted();
            }
            System.out.println("day " + this.player.getWorld().getDate());
            player.getWorld().grow();
            System.out.println(player);
            this.update();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                //pass
            }
        }
    }

    private void update() {
        //statuBar
        this.statusBar.modifyData(0, this.player.getDollars());
        this.statusBar.modifyData(1, this.player.getWorld().getDate());
        this.statusBar.modifyData(2, this.player.getWorld().getWorldBiomass());
        //environment
        this.gamePlayScreen.getEnvironmentPan().modifyValue(0, this.player.getWorld().getEnvironment().getOxygen());
        this.gamePlayScreen.getEnvironmentPan().modifyValue(1, this.player.getWorld().getEnvironment().getDayNight());
        this.gamePlayScreen.getEnvironmentPan().modifyValue(2, this.player.getWorld().getEnvironment().getMinerals());
        this.gamePlayScreen.getEnvironmentPan().modifyValue(3, this.player.getWorld().getEnvironment().getGravity());
        this.gamePlayScreen.getEnvironmentPan().modifyValue(4, this.player.getWorld().getEnvironment().getTemperature());
        this.gamePlayScreen.getEnvironmentPan().modifyValue(5, this.player.getWorld().getEnvironment().getWater());
        //population
        for (int i=0; i<5; i++) {
            this.gamePlayScreen.getPopulationPan().modifyValue(i, this.player.getWorld().getSpecies()[i].getPopulation());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}