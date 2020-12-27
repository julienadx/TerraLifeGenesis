package com.terra.graphics;

import com.terra.data.MachinesData;
import com.terra.exceptions.NoMoneyException;
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
        this.setTitle("Terra Life Genesis v0.5");
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

        statusBar.getPauseButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.getWorld().isPause()) {
                    player.getWorld().setPause(false);
                } else {
                    player.getWorld().setPause(true);
                }
            }
        });

        statusBar.getRestartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.setWorld(new World());
            }
        });

        for (int i=0; i<this.gamePlayScreen.getMachinePan().getValuesKind().length; i++) {
            this.gamePlayScreen.getMachinePan().getUpgradeButton()[i].addActionListener(this);
        }

        for (int i=0; i<this.gamePlayScreen.getDisorderPan().getValuesKind().length; i++) {
            this.gamePlayScreen.getDisorderPan().getUpgradeButton()[i].addActionListener(this);
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

        player.getWorld().getSpecies()[0].setPopulation(20);

        //game loop
        while(true) {
            if (!player.getWorld().isPause()) {
                this.player.getWorld().setDate(this.player.getWorld().getDate() + 1);
                if (player.getWorld().getWorldBiomass() == 0) {
                    System.out.println("you looooooooose!");
                    break;
                } else if (player.getWorld().getWorldBiomass() >= 20000000 && player.getWorld().getSpecies()[4].getPopulation() > 5000) {
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
            } else {
                System.out.println("paused");
            }
        }
    }

    private void updateLogs(String logs) {
        this.gamePlayScreen.getLogsPan().addLog(logs);
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
        UpgradeButton button = (UpgradeButton) e.getSource();
        int price = 0;
        String error = "";
        try {
            switch (button.getContext()) {
                case "MACHINES":
                    error = "[-] not enough money to buy machine " + this.gamePlayScreen.getMachinePan().getValuesKind()[button.getIndex()];
                    price = this.player.getWorld().getMachines()[button.getIndex()].getPrice();
                    this.player.addDollars(- price);
                    this.player.getWorld().getMachines()[button.getIndex()].levelUp();
                    this.gamePlayScreen.getMachinePan().modifyValue(button.getIndex(), this.gamePlayScreen.getMachinePan().getValues()[button.getIndex()] + 1);
                    updateLogs("[+] machine " + this.gamePlayScreen.getMachinePan().getValuesKind()[button.getIndex()] + " just bought for $" + price);
                    if (this.player.getWorld().getMachines()[button.getIndex()].getLevel() == MachinesData.MAX_LEVEL.getValue()) {
                        this.gamePlayScreen.getMachinePan().getUpgradeButton()[button.getIndex()].setText("full");
                        this.gamePlayScreen.getMachinePan().getUpgradeButton()[button.getIndex()].setEnabled(false);
                    } else {
                        this.gamePlayScreen.getMachinePan().getUpgradeButton()[button.getIndex()].setText(Integer.toString(this.player.getWorld().getMachines()[button.getIndex()].getPrice()));
                    }
                    break;
                case "NATURAL DISORDERS":
                    error = "[-] not enough money to buy machine " + this.gamePlayScreen.getDisorderPan().getValuesKind()[button.getIndex()];
                    price = this.player.getWorld().getDisasters()[button.getIndex()].getPrice();
                    this.player.addDollars(- price);
                    this.player.getWorld().getDisasters()[button.getIndex()].levelUp();
                    this.gamePlayScreen.getDisorderPan().modifyValue(button.getIndex(), this.gamePlayScreen.getDisorderPan().getValues()[button.getIndex()] + 1);
                    updateLogs("[+] reducing " + this.gamePlayScreen.getDisorderPan().getValuesKind()[button.getIndex()] + " machine just bought for $" + price);
                    if (this.player.getWorld().getDisasters()[button.getIndex()].getLevel() == MachinesData.MAX_LEVEL.getValue()) {
                        this.gamePlayScreen.getDisorderPan().getUpgradeButton()[button.getIndex()].setText("full");
                        this.gamePlayScreen.getDisorderPan().getUpgradeButton()[button.getIndex()].setEnabled(false);
                    } else {
                        this.gamePlayScreen.getDisorderPan().getUpgradeButton()[button.getIndex()].setText(Integer.toString(this.player.getWorld().getDisasters()[button.getIndex()].getPrice()));
                    }
                    break;
                default:
                    //pass
                    break;
            }
        } catch (NoMoneyException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "no money error!", JOptionPane.ERROR_MESSAGE);
            updateLogs(error);
        }

        this.update();
    }
}