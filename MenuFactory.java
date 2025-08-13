import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class MenuFactory {
    private static File file = new File("");

    public static JMenuBar createMenuBar(JTextArea textArea, Runnable onNewTab) {
        JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem newTab = new JMenuItem("New Tab");
        newTab.addActionListener(e -> onNewTab.run());
        fileMenu.add(newTab);

        fileMenu.add(new JMenuItem("New Window"));
        JMenuItem open = new JMenuItem("Open");
        open.addActionListener(e -> {
            onNewTab.run();
            openFile("java_note.txt", textArea);
        });
        fileMenu.add(open);

        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(e -> {
            String fileName = JOptionPane.showInputDialog("Enter file name:");

            saveFile(fileName, textArea.getText());
        });
        fileMenu.add(save);

        fileMenu.add(new JMenuItem("Save As"));
        fileMenu.add(new JMenuItem("Print"));
        fileMenu.add(new JMenuItem("Close Tab"));
        fileMenu.add(new JMenuItem("Close Window"));
        fileMenu.add(new JMenuItem("Exit"));
        menuBar.add(fileMenu);

        // Edit Menu
        JMenu editMenu = new JMenu("Edit");

        JMenuItem undo = new JMenuItem("Undo");
        editMenu.add(undo);

        JMenuItem cut = new JMenuItem("Cut");
        cut.addActionListener(e -> textArea.cut());
        editMenu.add(cut);

        JMenuItem copy = new JMenuItem("Copy");
        copy.addActionListener(e -> textArea.copy());
        editMenu.add(copy);

        JMenuItem paste = new JMenuItem("Paste");
        paste.addActionListener(e -> textArea.paste());
        editMenu.add(paste);

        editMenu.add(new JMenuItem("Delete"));
        menuBar.add(editMenu);

        // View Menu
        JMenu viewMenu = new JMenu("View");
        viewMenu.add(new JMenuItem("Zoom"));
        viewMenu.add(new JMenuItem("Status Bar"));
        viewMenu.add(new JMenuItem("Word Wrap"));
        viewMenu.add(new JMenuItem("Markdown"));
        menuBar.add(viewMenu);

        return menuBar;
    }

    private static void openFile(String filename, JTextArea textArea) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                textArea.setText(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            e.printStackTrace();
        }
    }

    private static void saveFile(String filename, String fileContent) {
        try {
            if (!file.exists()) {
                createNewFile(filename);
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            bw.write(fileContent);
            bw.close();
            JOptionPane.showMessageDialog(null, "Your note has been saved", "Success", 1);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            e.printStackTrace();
        }
    }

    private static void createNewFile(String filename) {
        try {
            file = new File(filename);

            if (file.exists()) {
                JOptionPane.showMessageDialog(null, "File already exists", "Error", 0);
                return;
            }

            if (file.createNewFile()) {
                JOptionPane.showMessageDialog(null, file.getName() + " has been created", "Success", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Error creating file", "Error", 0);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            e.printStackTrace();
        }
    }
}