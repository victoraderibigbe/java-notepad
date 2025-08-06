import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class NoteTabPanel extends JPanel {
    private JTextArea textArea;

    public NoteTabPanel() {
        this.setLayout(new BorderLayout());
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}
