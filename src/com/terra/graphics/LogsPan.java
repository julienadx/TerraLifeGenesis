package com.terra.graphics;

import javax.swing.*;
import java.awt.*;

public class LogsPan extends JPanel {

    private String logs;
    private JTextArea textArea;

    LogsPan(String logs) {
        super();

        this.setLayout(new BorderLayout());
        JLabel title = new JLabel("LOGS");
        this.add(title, BorderLayout.NORTH);

        this.logs = logs + "\n";
        this.textArea = new JTextArea(this.logs);
        JScrollPane scrollPane = new JScrollPane(this.textArea);
        this.textArea.setEditable(false);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    public void addLog(String log) {
        this.textArea.append(log + "\n");
        this.textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
