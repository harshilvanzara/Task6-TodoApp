import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

 public class Todoapp {
    public static void main(String[] args) {
        
        JFrame  frame = new JFrame("To-Do App");
        frame.setSize(400, 500);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField taskField = new JTextField();
        JButton addButton = new JButton("Add Task");

        DefaultListModel<String> ListModel =  new DefaultListModel<>();
        JList<String> taskList = new JList<>(ListModel);

        JButton deleteButton = new JButton("Delete Task");

        // Layout
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(taskField, BorderLayout.CENTER);
        topPanel.add(addButton, BorderLayout.EAST);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(taskList),
        BorderLayout.CENTER);
        frame.add(deleteButton, BorderLayout.SOUTH);

        //Add Task
        addButton.addActionListener(e-> {
            String task = taskField.getText();
            if (!task.isEmpty()) {
                ListModel.addElement(task);
                taskField.setText("");
            }
        });

        //Delete Task
        deleteButton.addActionListener(e -> {
            int selected = taskList.getSelectedIndex();
            if (selected != -1) {
                ListModel.remove(selected);
            }
        });

        frame.setVisible(true);
    }
 }
