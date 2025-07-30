import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class Note {
    JFrame frame = new JFrame("Notepad");
    JMenuBar menuBar = new JMenuBar();

    public Note() {
        this.run();
    }

    public void run() {
        frame.setSize(1000, 1000);

        menuBar.setLayout(null);
        this.createMenuBar();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void createMenuBar() {
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);

        JMenu viewMenu = new JMenu("View");
        menuBar.add(viewMenu);

        frame.setJMenuBar(menuBar);
    }
}
