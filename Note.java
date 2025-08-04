import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class Note {
    JFrame frame = new JFrame("Notepad");
    JMenuBar menuBar = new JMenuBar();
    JTextArea textArea = new JTextArea();

    public Note() {
        this.run();
    }

    public void run() {
        frame.setSize(1000, 800);

        menuBar.setLayout(null);
        this.createMenuBar();
        this.createTextField();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void createMenuBar() {
        JMenu fileMenu = new JMenu("File");
        JMenuItem newTab = new JMenuItem("New Tab");
        fileMenu.add(newTab);
        JMenuItem newWindow = new JMenuItem("New Window");
        fileMenu.add(newWindow);
        JMenuItem open = new JMenuItem("Open");
        fileMenu.add(open);
        JMenuItem save = new JMenuItem("Save");
        fileMenu.add(save);
        JMenuItem saveAs = new JMenuItem("Save As");
        fileMenu.add(saveAs);
        JMenuItem print = new JMenuItem("Print");
        fileMenu.add(print);
        JMenuItem closeTab = new JMenuItem("Close Tab");
        fileMenu.add(closeTab);
        JMenuItem closeWindow = new JMenuItem("Close Window");
        fileMenu.add(closeWindow);
        JMenuItem exit = new JMenuItem("Exit");
        fileMenu.add(exit);
        menuBar.add(fileMenu);

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
        JMenuItem delete = new JMenuItem("Delete");
        editMenu.add(delete);
        menuBar.add(editMenu);

        JMenu viewMenu = new JMenu("View");
        JMenuItem zoom = new JMenuItem("Zoom");
        viewMenu.add(zoom);
        JMenuItem statusBar = new JMenuItem("Status bar");
        viewMenu.add(statusBar);
        JMenuItem wordWrap = new JMenuItem("Word Wrap");
        viewMenu.add(wordWrap);
        JMenuItem markDown = new JMenuItem("Markdown");
        viewMenu.add(markDown);
        menuBar.add(viewMenu);

        frame.setJMenuBar(menuBar);
    }

    public void createTextField() {
        textArea.setFont(new Font("Roboto", Font.BOLD, 12));
        frame.add(textArea);
    }

}
