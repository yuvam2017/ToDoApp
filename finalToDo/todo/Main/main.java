package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Main.main;
import javax.swing.plaf.ColorUIResource;
import java.io.*;
import java.net.URL;
  
// class GridLayout extends JFrame
public class main extends JFrame {
  
    public main() {
        JPanel p1 = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel showTasksPanel = new JPanel();
        JPanel bottomSheet = new JPanel();

        FileHandler handler = new FileHandler("data.txt");
        
        JLabel tasksLabel = new JLabel("Tasks");
        JLabel detailsLabel = new JLabel("Details: ");
        JLabel labelDate = new JLabel();
        JLabel labelTitle = new JLabel();
        JLabel labelDetails = new JLabel();
        JLabel _labelDate = new JLabel("Date: ");
        JLabel _labelTitle = new JLabel("Title: ");
        JLabel _labelDetails = new JLabel("Details: ");

        JButton addTask = new JButton("Add Task");
        JButton showTask = new JButton("Show Task");
        JButton removeTask = new JButton("Remove Task");
        JButton contri = new JButton("Contributions");
        
        p1.setLayout(new GridLayout(3, 0));
        panel1.setLayout(new GridLayout(2,0));
        panel2.setLayout(new GridLayout(3, 2));
        
        _labelDate.setFont(new Font("TimesRoman",Font.ITALIC, 15)); 
        _labelTitle.setFont(new Font("TimesRoman",Font.ITALIC, 15));
        _labelDetails.setFont(new Font("TimesRoman",Font.ITALIC, 15));
        
        
        List l1 = new List(5);
        String tasks[] = handler.readLines();
        for(String str: tasks){
            l1.add(str.split("@")[1]);
        }

        panel1.setBackground(Color.white);

        bottomSheet.add(showTask);
        bottomSheet.add(addTask);
        bottomSheet.add(removeTask);
        bottomSheet.add(contri);

        panel2.add(_labelDate);
        panel2.add(labelDate);
        panel2.add(_labelTitle);
        panel2.add(labelTitle);
        panel2.add(_labelDetails);
        panel2.add(labelDetails);

        showTask.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int index = l1.getSelectedIndex();
                labelDate.setText(tasks[index].split("@")[0]);
                labelTitle.setText(tasks[index].split("@")[1]);
                labelDetails.setText(tasks[index].split("@")[2]);
            }
        });

        addTask.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new addTask();
                dispose();
            }
        });

        removeTask.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println(l1.getSelectedIndex());
                handler.deleteLine(l1.getSelectedIndex());
                dispose();
                new main();
            }
        });

        contri.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new contrib();
            }
        });

        panel1.add(tasksLabel);
        panel1.add(l1);

        p1.add(panel1);
        p1.add(panel2);

        add(p1, "North");
        add(bottomSheet, "South");
        setVisible(true);
        setSize(600, 600);
        setTitle("To do Manager");
    }

    public static void main(String args[]){
        new main();
    }
}


class addTask extends JFrame {

    addTask(){

        JPanel title = new JPanel();
        JPanel form = new JPanel();
        JPanel bottomSheet = new JPanel();

        JLabel titleLabel = new JLabel("ADD TASK");
        JLabel dLabel = new JLabel("Date");
        JLabel tLabel = new JLabel("Title");
        JLabel deLabel = new JLabel("Details");

        JButton done = new JButton("Done");
        JButton cancel = new JButton("Cancel");

        TextField inputDate = new TextField();
        TextField inputTitle = new TextField();
        TextField inputDetails = new TextField();

        titleLabel.setForeground(new Color(101,98,107));
        titleLabel.setFont(new Font("Sans",Font.BOLD,23));
        titleLabel.setBounds(100,20,200,150);
        form.setLayout(new GridLayout(3, 2));
        
        form.add(dLabel);
        form.add(inputDate);
        form.add(tLabel);
        form.add(inputTitle);
        form.add(deLabel);
        form.add(inputDetails);
        title.add(titleLabel);

        cancel.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            dispose();
            main m = new main();
            }
        });

        done.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            FileHandler handler = new FileHandler("data.txt");
            handler.write(inputDate.getText()+"@"+inputTitle.getText()+"@"+inputDetails.getText());
            dispose();
            main m = new main();
            }
        });

        bottomSheet.add(cancel);
        bottomSheet.add(done);
        
        add(title, "North");
        add(form);
        add(bottomSheet, "South");
        setVisible(true);
        setSize(400, 200);
    }

    public static void main(String[] args) {
        new addTask();
    }
}

class FileHandler {
    
    String fileName;
    FileReader reader = null;
    FileWriter writer = null;

    public FileHandler(String fileName){
        this.fileName = fileName;
    }

    public void open(){
        try{
            this.reader = new FileReader(this.fileName);
            this.writer = new FileWriter(this.fileName, true);
        }catch(Exception e){
            System.out.println("File not found");
        }
    }

    public String read() {
        this.open();
        int ch;
        String result = "";
        try{
            while ((ch=this.reader.read())!=-1)
            result += (char)ch;
        }catch(Exception e){
            System.out.println(e);
        }
        this.close();
        return result;
    }

    public String[] readLines() {
        String result = this.read();
        return result.split("\n");
    }

    public void write(String line){
        this.open();
        try{
            this.writer.write("\n" + line);
        } catch (Exception e){
            System.out.println(e);
        }
        this.close();
    }

    public void writeLines(String[] lines){
        for(String line: lines){
            this.write(line + "\n");
        }
    }

    public void deleteLine(int index){
        String[] lines = this.readLines();
        try{
            FileWriter temp = new FileWriter(this.fileName);
            for(int i=0; i<lines.length; i++){
                if(i!=index){
                    temp.write(lines[i]);
                }
            }
            temp.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void close(){
        try{
            this.reader.close();
            this.writer.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

}

class contrib implements MouseListener , ActionListener{

    Frame frame;
    
    Label label;
    
    Label aman;
    Label amanwork;

    Label ayush;
    Label ayushwork;

    Label bharat;
    Label bharatwork;

    Label mohatsim;
    Label mohatsimwork;

    Label yuvam;
    Label yuvamwork;
    
    Label github;
    Label githublink;
    
    JButton close;

    
    public contrib() {
        
        frame = new Frame();
        
        label = new Label("Individual Contributions");
        label.setForeground(Color.black);
        label.setFont(new Font("Monospace",Font.BOLD,20));
        label.setBounds(210,30,300,50);

        aman  = new Label("Aman");
        aman.setFont(new Font("Monospace",Font.BOLD,16));
        aman.setBounds(80,100,100,30);
        
        amanwork  = new Label("Added the \"Add the Task Page\"");
        amanwork.setFont(new Font("Monospace",Font.BOLD,16));
        amanwork.setBounds(280,100,300,30);

        ayush = new Label("Ayush");
        ayush.setFont(new Font("Monospace",Font.BOLD,16));
        ayush.setBounds(80,150,100,30);
        
        ayushwork  = new Label("FileHandling Algorithm and Todo task manager");
        ayushwork.setFont(new Font("Monospace",Font.BOLD,16));
        ayushwork.setBounds(280,150,410,30);
        
        bharat = new Label("Bharat");
        bharat.setFont(new Font("Monospace",Font.BOLD,16));
        bharat.setBounds(80,200,100,30);
        
        bharatwork  = new Label("Todo task manager");
        bharatwork.setFont(new Font("Monospace",Font.BOLD,16));
        bharatwork.setBounds(280,200,300,30);

        mohatsim = new Label("Mohatsim");
        mohatsim.setFont(new Font("Monospace",Font.BOLD,16));
        mohatsim.setBounds(80,250,100,30);
        
        mohatsimwork  = new Label("Buttons Effect and Todo task manager");
        mohatsimwork.setFont(new Font("Monospace",Font.BOLD,16));
        mohatsimwork.setBounds(280,250,370,30);


        yuvam = new Label("Yuvam");
        yuvam.setFont(new Font("Monospace",Font.BOLD,16));
        yuvam.setBounds(80,300,100,30);
        
        yuvamwork  = new Label("LoginPage & functionality and Contribution page");
        yuvamwork.setFont(new Font("Monospace",Font.BOLD,16));
        yuvamwork.setBounds(280,300,410,30);
        
        github = new Label("Github");
        github.setFont(new Font("Monospace",Font.BOLD,16));
        github.setBounds(80,380,100,30);
        
        githublink  = new Label("https://github.com/yuvam2017/ToDoApp");
        githublink.setFont(new Font("Monospace",Font.BOLD,16));
        githublink.setBounds(280,380,410,30);
        githublink.setForeground(Color.blue);
        
        githublink.addMouseListener(this);
        
        close = new JButton("Close");
//      close.setText("Close");
        close.setBounds(280,480,100,50);
        
        close.addActionListener(this);
        
        frame.add(label);
        frame.add(aman);
        frame.add(amanwork);
        
        frame.add(ayush);
        frame.add(ayushwork);
        
        frame.add(bharat);
        frame.add(bharatwork);

        frame.add(mohatsim);
        frame.add(mohatsimwork);
        
        frame.add(yuvam);
        frame.add(yuvamwork);
        
        frame.add(github);
        frame.add(githublink);
        
        frame.add(close);
        

        
        frame.setSize(750,550);
        frame.setBackground(Color.white);
        frame.setLayout(null);
        frame.setVisible(true);
        
        frame.addWindowListener(new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }
    
    public static void main(String[] args) {
        contrib obj = new contrib();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            Desktop.getDesktop().browse(new URL(githublink.getText()).toURI());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        githublink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        githublink.setForeground(Color.gray);
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        githublink.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        githublink.setForeground(Color.blue);
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        frame.dispose();
        
    }

}