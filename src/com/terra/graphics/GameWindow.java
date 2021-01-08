package com.terra.graphics;

import com.terra.data.MachinesData;
import com.terra.data.MiscData;
import com.terra.exceptions.NoMoneyException;
import com.terra.livings.Species;
import com.terra.tools.Environment;
import com.terra.tools.Player;
import com.terra.tools.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Calendar;

public class GameWindow extends JFrame implements ActionListener, WindowListener {

    GamePLayScreen gamePlayScreen;

    private Player player;
    private StatusBarPan statusBar;
    private String worldname;

    public GameWindow(String worldname){
        this.setTitle("Terra Life Genesis v1.0");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);

        this.addWindowListener(this);

        this.player = new Player(new World(new Environment(), worldname), 500);

        this.gamePlayScreen = new GamePLayScreen();


        this.statusBar = new StatusBarPan(this.player.getWorld().getName(), this.player.getWorld().getWorldBiomass(), this.player.getDollars());


        statusBar.getPauseButton().addActionListener(this);

        statusBar.getRestartButton().addActionListener(this);

        for (int i=0; i<this.gamePlayScreen.getMachinePan().getValuesKind().length; i++) {
            this.gamePlayScreen.getMachinePan().getUpgradeButton()[i].addActionListener(this);
            this.gamePlayScreen.getMachinePan().getSellButton()[i].addActionListener(this);
        }

        for (int i=0; i<this.gamePlayScreen.getDisorderPan().getValuesKind().length; i++) {
            this.gamePlayScreen.getDisorderPan().getUpgradeButton()[i].addActionListener(this);
            this.gamePlayScreen.getDisorderPan().getSellButton()[i].addActionListener(this);
        }

        this.getContentPane().add(statusBar, BorderLayout.NORTH);
        this.getContentPane().add(gamePlayScreen, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void growWorld(World world) {
        int rand;
        for (int i=0; i<this.player.getWorld().getSpecies().length; i++) {
            //TODO make this cool and working
            rand = (int) (Math.random() * 100 + 1);
            if (this.player.getWorld().getSpecies()[i].getPopulation() > 0 && rand <= this.player.getWorld().getSpecies()[i].getProbAction()) {
                if (this.player.getWorld().getEnvironment().isEnough(this.player.getWorld().getSpecies()[i])) {
                    this.player.setWorld(Species.speciesAction(this.player.getWorld(), i));
                } else {
                    if (this.player.getWorld().getSpecies()[i].getPopulation() < 10) {
                        int deads = this.player.getWorld().getSpecies()[i].die(-1);
                    } else {
                        int deads = this.player.getWorld().getSpecies()[i].die();
                    }
                }
            }
        }
    }

    public boolean startGame() {

        int rand;
        int prob;

        //game loop
        while(true) {
            //System.out.println("loop");
            if (!player.getWorld().isPause()) {
                this.player.getWorld().incrementDate();
                //System.out.println(this.player.getWorld().getSpecies()[0].getPopulation());
                if (player.getWorld().getWorldBiomass() == 0) {
                    System.out.println("you looooooooose!");
                    updateLogs("[-] you looooose! Nobody's left on your planet! Restart a new game :)");
                    return false;
                } else if (player.getWorld().getSpecies()[4].getPopulation() > 300) {
                    System.out.println("you win! Congrats your planet is suitable for human beings!");
                    updateLogs("[+] you win! Congrats your planet is suitable for human beings!");
                    return true;
                }
                if (this.player.getWorld().getDate().get(Calendar.DATE) == 1) {
                    updateLogs("[+] Month completed, you earned " + Integer.toString(player.monthCompleted()) + "!");
                }
                if (this.player.getWorld().getDate().get(Calendar.DATE) % 7 == 0) {
                    for (int a=0; a<this.player.getWorld().getMachines().length; a++) {
                        this.player.getWorld().setEnvironment(this.player.getWorld().getMachines()[a].action(this.player.getWorld().getEnvironment()));
                    }
                }
                //WORLD
                this.growWorld(this.player.getWorld());
                //System.out.println(this.player.getWorld().getDate().getTime());
                //System.out.println(player);

                if (this.player.getWorld().getDate().get(Calendar.DATE) % 4 == 0) {
                    for (int i=0; i<this.player.getWorld().getDisasters().length; i++) {
                        rand = (int) (Math.random() * 100 + 1);
                        if (rand <= this.player.getWorld().getDisasters()[i].getProbability()) {
                            this.player.setWorld(this.player.getWorld().getDisasters()[i].action(this.player.getWorld()));
                            updateLogs(this.player.getWorld().getDisasters()[i].getMessage());
                        }
                    }
                }

                this.update();
                try {
                    Thread.sleep(MiscData.TIME_DAY.getValue());
                } catch (Exception e) {
                    //pass
                }
            } else {
                System.out.print(""); //prevent pause from not working
            }
        }
    }

    private void updateLogs(String logs) {
        this.gamePlayScreen.getLogsPan().addLog(logs);
    }

    private void updateLogs(String logs, int mode) {
        updateLogs(logs);
        JOptionPane.showMessageDialog(this, logs, "logs", mode);
    }

    private void update() {
        //statuBar
        this.statusBar.modifyData(0, this.player.getDollars());
        this.statusBar.getData()[1].setText(this.player.getWorld().getFormattedDate());
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
        //machines
        for (int i=0; i<this.player.getWorld().getMachines().length; i++) {
            this.gamePlayScreen.getMachinePan().modifyValue(i, this.player.getWorld().getMachines()[i].getLevel());
            if (this.player.getWorld().getMachines()[i].getLevel() == MachinesData.MAX_LEVEL.getValue()) {
                this.gamePlayScreen.getMachinePan().getUpgradeButton()[i].setText("full");
                this.gamePlayScreen.getMachinePan().getUpgradeButton()[i].setEnabled(false);
            } else if (this.player.getWorld().getMachines()[i].getLevel() == 0) {
                this.gamePlayScreen.getMachinePan().getSellButton()[i].setText("0");
                this.gamePlayScreen.getMachinePan().getSellButton()[i].setEnabled(false);
                this.gamePlayScreen.getMachinePan().getUpgradeButton()[i].setText(Integer.toString(MachinesData.PRICE.getValue()));
            } else {
                this.gamePlayScreen.getMachinePan().getSellButton()[i].setEnabled(true);
                this.gamePlayScreen.getMachinePan().getUpgradeButton()[i].setText(Integer.toString(this.player.getWorld().getMachines()[i].getPrice()));
                this.gamePlayScreen.getMachinePan().getSellButton()[i].setText(Integer.toString(this.player.getWorld().getMachines()[i].getPrice() / 4));
            }
        }
        //anti-machine
        for (int i=0; i<this.player.getWorld().getDisasters().length; i++) {
            this.gamePlayScreen.getDisorderPan().modifyValue(i, this.player.getWorld().getDisasters()[i].getLevel());
            if (this.player.getWorld().getDisasters()[i].getLevel() == MachinesData.MAX_LEVEL.getValue()) {
                this.gamePlayScreen.getDisorderPan().getUpgradeButton()[i].setText("full");
                this.gamePlayScreen.getDisorderPan().getUpgradeButton()[i].setEnabled(false);
            } else if (this.player.getWorld().getDisasters()[i].getLevel() == 0) {
                this.gamePlayScreen.getDisorderPan().getSellButton()[i].setText("0");
                this.gamePlayScreen.getDisorderPan().getSellButton()[i].setEnabled(false);
                this.gamePlayScreen.getDisorderPan().getUpgradeButton()[i].setText(Integer.toString(MachinesData.PRICE.getValue()));
            } else {
                this.gamePlayScreen.getDisorderPan().getSellButton()[i].setEnabled(true);
                this.gamePlayScreen.getDisorderPan().getUpgradeButton()[i].setText(Integer.toString(this.player.getWorld().getDisasters()[i].getPrice()));
                this.gamePlayScreen.getDisorderPan().getSellButton()[i].setText(Integer.toString(this.player.getWorld().getDisasters()[i].getPrice() / 4));
            }
        }
        //pause button
        if (this.player.getWorld().isPause()) {
            this.statusBar.getPauseButton().setText("play");
        } else {
            this.statusBar.getPauseButton().setText("pause");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameButton button = (GameButton) e.getSource();
        int price = 0;
        String error = "";
        try {
            switch (button.getContext()) {
                case "MACHINES":
                    UpgradeButton button1 = (UpgradeButton) button;
                    error = "[-] not enough money to buy machine " + this.gamePlayScreen.getMachinePan().getValuesKind()[button.getIndex()];
                    price = this.player.getWorld().getMachines()[button.getIndex()].getPrice();
                    switch (button1.getFormatText()) {
                        case "buy: $ ":
                            this.player.addDollars(- price);
                            this.player.getWorld().getMachines()[button1.getIndex()].levelUp();
                            updateLogs("[+] machine " + this.gamePlayScreen.getMachinePan().getValuesKind()[button1.getIndex()] + " just bought for $" + price);
                            break;
                        case "sell: $ ":
                            price /= 4;
                            this.player.addDollars(price);
                            this.player.getWorld().getMachines()[button1.getIndex()].levelDown();
                            updateLogs("[+] machine " + this.gamePlayScreen.getMachinePan().getValuesKind()[button1.getIndex()] + " just sold for $" + price);
                            break;
                        default:
                            //defaul
                            break;
                    }
                    break;
                case "NATURAL DISORDERS":
                    error = "[-] not enough money to buy machine " + this.gamePlayScreen.getDisorderPan().getValuesKind()[button.getIndex()];
                    price = this.player.getWorld().getDisasters()[button.getIndex()].getPrice();
                    UpgradeButton button2 = (UpgradeButton) button;
                    switch (button2.getFormatText()) {
                        case "buy: $ ":
                            this.player.addDollars(- price);
                            this.player.getWorld().getDisasters()[button2.getIndex()].levelUp();
                            updateLogs("[+] reducing " + this.gamePlayScreen.getDisorderPan().getValuesKind()[button2.getIndex()] + " machine just bought for $" + price);
                            break;
                        case "sell: $ ":
                            price /= 4;
                            this.player.addDollars(price);
                            this.player.getWorld().getDisasters()[button2.getIndex()].levelDown();
                            updateLogs("[+] machine " + this.gamePlayScreen.getDisorderPan().getValuesKind()[button2.getIndex()] + " just sold for $" + price);
                            break;
                        default:
                            //default
                            break;
                    }
                    break;
                case "RESTART":
                    int result = JOptionPane.showConfirmDialog(this,"Are you sur you want to restart the game?\nUnsaved data will be lost.", "restart game?",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION){
                        this.player.reset();
                        updateLogs("[*] The game has been restarted");
                    }
                    break;
                case "PAUSE":
                    if (player.getWorld().isPause()) {
                        player.getWorld().setPause(false);
                        updateLogs("[*] The game has been resumed");

                    } else {
                        player.getWorld().setPause(true);
                        updateLogs("[*] The game has been paused");
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

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        int result = JOptionPane.showConfirmDialog(this,"Sure? You want to exit?", "Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION){
            System.exit(0);
        } else {
            //new GameWindow().setVisible(true);
            this.setVisible(true);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}