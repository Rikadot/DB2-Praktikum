package ui.reportmanager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportForm {
    private JTextField textField_fahrzeug;
    private JTextField textField_vertrag;
    private JTextField textField_maengel;
    private JTextField textField_schaden;
    private JButton createNewReportButton;
    private JLabel Fahrzeug_ID;
    private JLabel Vertrag_ID;
    private JLabel Maengel;
    private JLabel Schaden;
    private JPanel panel;
    private JLabel kunden_id;
    private JTextField textField_kunden;

    public ReportForm() {

        createNewReportButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField_fahrzeug.getText().equals("") || textField_vertrag.getText().equals("") ||
                textField_schaden.getText().equals("")){
                    message("EINGABE NICHT VOLLSTÄNDIG!");
                    return;
                }
                if(!isDouble(textField_schaden.getText())){
                    message("Invalide Eingabe für Schaden! Bitte in der Form, xx.xx eingeben!");
                    return;
                }
                if(!isInt(textField_fahrzeug.getText())){
                    message("Eingabe für Fahrzeug ID ist keine ID!");
                    return;
                }
                if(!isInt(textField_vertrag.getText())){
                    message("Eingabe für Vertrags_ID is keine ID!");
                }
                //TODO checke, ob FahrzeugID in der Tabelle existiert!
                //TODO checke, ob VertragID in der Tabelle existiert!
                //TODO in die Gutachten Tabelle inserten!
                message("Eingabe erfolgreich");
            }
        });
    }

    private void message(String s){
        JOptionPane.showMessageDialog(null, s);
    }

    private boolean isDouble(String s){
        try{
            Double d = Double.parseDouble(s);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private boolean isInt(String s){
        try{
            int i = Integer.parseInt(s);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ReportForm");
        frame.setContentPane(new ReportForm().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
