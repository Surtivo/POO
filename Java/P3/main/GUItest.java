package main;

import view.MenuView;

public class GUItest {

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	MenuView.createAndShowGUI();
            }
        });
    }
}