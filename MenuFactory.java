import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class MenuFactory {

    public static JMenuBar createMenuBar(JTextArea textArea, Runnable onNewTab) {
        JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem newTab = new JMenuItem("New Tab");
        newTab.addActionListener(e -> onNewTab.run());
        fileMenu.add(newTab);

        fileMenu.add(new JMenuItem("New Window"));
        fileMenu.add(new JMenuItem("Open"));
        fileMenu.add(new JMenuItem("Save"));
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
}