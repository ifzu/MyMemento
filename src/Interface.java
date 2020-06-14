
import sun.java2d.pipe.SpanShapeRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Interface extends JFrame {
    private JPanel mainPane;
    private JPanel westPane;
    private JPanel eastPane;
    private JPanel southPane;
    private JLabel obiectivLabel;
    private JLabel dataLabel;
    private JLabel descriptionLabel;
    private JTextField nameText;
    private JTextField dateText;
    private JTextField descriptieText;
    private JButton insertButton;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JCheckBox checkBox5;
    private JCheckBox checkBox6;
    private JCheckBox checkBox7;
    private JCheckBox checkBox8;
    private JCheckBox checkBox9;
    private JCheckBox checkBox10;
    private JPanel secondmainPane;
    private JCheckBox testBox;
    private JButton updateButton;


    private JCheckBox array[];
    int nrUNDONE; //NUMARUL DE OBIECTIVE UNDONE
    private DataBaseManager dataBaseManager;  //dataBase ref


    //Mai putem adauga evenimente care sunt de mult timp sa le scriem cu rosu

    public Interface() {

            dataBaseManager = new DataBaseManager();

            manageCheckBoxes();

            manageButtons();


            initFrame();

    }





    //management Checkboxes
    private void manageCheckBoxes(){

        ArrayList<Obiectiv> undoneObj=dataBaseManager.getAllObjectifs(2); //obiectivele UNDONE
        nrUNDONE = undoneObj.size();

        array=new JCheckBox[10];

        array[0]= checkBox1;
        array[1]= checkBox2;
        array[2]= checkBox3;
        array[3]= checkBox4;
        array[4]= checkBox5;
        array[5]= checkBox6;
        array[6]= checkBox7;
        array[7]= checkBox8;
        array[8]= checkBox9;
        array[9]= checkBox10;

        //Afisam obictivele undone
        for(int i=0;i<nrUNDONE;i++){
            String numeObiectiv = undoneObj.get(i).getNumeObiectiv();
            array[i].setText(numeObiectiv);
        }

        //dezactivam restu de checkboxuri
        for(int i=nrUNDONE;i<10;i++)
            array[i].setVisible(false);




        array[0].addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("Desigur");

            }
        });

        array[1].addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("Desigur");

            }
        });

        array[2].addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("Desigur");

            }
        });

        array[3].addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("Desigur");

            }
        });

        array[4].addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("Desigur");

            }
        });

    }


    //Management butoane **** Mai trebuie introdus functionalitate update -> care face obiectivele undone selectate in obiective done
    private void manageButtons(){

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Obiectiv obiectiv = null;
                String ob = nameText.getText();
                String data = dateText.getText();
                String des = descriptieText.getText();

                //daca sunt introduse date in cele 3 fielduri => inseram nou Obiectiv in baza de date
                if (ob.length() != 0 && data.length() != 0 && des.length() != 0) {
                    obiectiv = new Obiectiv(ob, false, des, data);
                    dataBaseManager.insertObiectif(obiectiv);
                    nameText.setText("");
                    dateText.setText("");
                    descriptieText.setText("");

                    /*  Facem vizibil un nou checkbox */


                    array[nrUNDONE].setText(ob);
                    array[nrUNDONE].setVisible(true);
                    nrUNDONE++;
                } else {

                    //Daca nu sau introdus suficiente date
                    JOptionPane.showMessageDialog(null, "Nu s-au introdus suficiente informatii", "Warning", 2);

                }

            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nr=0;
                for(int i=0;i <= nrUNDONE;i++){
                    if(array[i].isSelected()){

                        String numeOb=array[i].getText();
                        dataBaseManager.updateStatus(numeOb);
                        array[i].setVisible(false);
                        nr++;
                    }

                    nrUNDONE-=nr;

                    if(nrUNDONE==-1)
                        nrUNDONE=0;

                }
            }
        });

    }



    private void initFrame(){

        setTitle("MyMemento");
        setContentPane(mainPane);
        setBounds(500, 200, 400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }


    //returneaza nr zile
    private int difDate(String dataAd){
        SimpleDateFormat form=new SimpleDateFormat("dd.MM.yyyy");
        LocalDate now=LocalDate.now();

        return 0;
    }


}
