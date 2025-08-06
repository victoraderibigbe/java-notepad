import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class NoteApp extends JFrame {
    private JTabbedPane tabbedPane;

    public NoteApp() {
        setTitle("Notepad");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();

        add(tabbedPane, BorderLayout.CENTER);

        JPanel plusTabPanel = new JPanel();
        tabbedPane.addTab("+", plusTabPanel);

        addNewTab();

        JMenuBar menuBar = MenuFactory.createMenuBar(getActiveTextArea(), this::addNewTab);

        setJMenuBar(menuBar);
    }

    private void addNewTab() {
        NoteTabPanel notePanel = new NoteTabPanel();
        int plusTabIndex = tabbedPane.getTabCount() - 1;
        tabbedPane.insertTab("Note " + (plusTabIndex + 1), null, notePanel, null, plusTabIndex);
        tabbedPane.setSelectedComponent(notePanel);
    }

    private JTextArea getActiveTextArea() {
        Component selected = tabbedPane.getSelectedComponent();

        if (selected instanceof NoteTabPanel panel) {
            return panel.getTextArea();
        }

        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NoteApp app = new NoteApp();
            app.setVisible(true);
        });
    }
}