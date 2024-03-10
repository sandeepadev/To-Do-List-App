

package todolist;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;


public class AppFrame extends JFrame {
    
    TitleBar title= new TitleBar();
    BtnPanel btnpanel= new BtnPanel();
    List list =new List();
    private JButton addtask;
    private JButton clear;
    
    
    public AppFrame(){
        this.setSize(400,700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(this.title,BorderLayout.NORTH);  
        this.add(this.btnpanel,BorderLayout.SOUTH);
        this.add(this.list,BorderLayout.CENTER);
        
        addtask = btnpanel.getaddtaskbtn();
        clear=btnpanel.getclearbtn();
        
        addlistener();
    }
    public void addlistener(){
      addtask.addMouseListener(new MouseAdapter(){
      
          @Override
          public void mousePressed(MouseEvent e){
              Task task= new Task();
              list.add(task);
              list.indexnum();
              revalidate();
              
              JButton done = task.getdonej();
              done.addMouseListener(new MouseAdapter(){
                  
                  @Override
                  public void mousePressed(MouseEvent e){
                   task.donestatus();
                   revalidate();
                   
                  } 
           });
              JButton remove = task.getremovej();
              remove.addMouseListener(new MouseAdapter(){
                  
                  @Override
                  public void mousePressed(MouseEvent e){
                  list.remove(task);
                   list.indexnum();
                   revalidate();
                   repaint();
                   
                  } 
                  
                 });
              }
    
    });
      clear.addMouseListener(new MouseAdapter() {
         
          @Override
           public void mousePressed(MouseEvent e){
           Component[] tasklist= list.getComponents();
              for (int i=0; i<tasklist.length; i++){
                  if(tasklist[i] instanceof Task){
                  list .remove((Task)tasklist[i]);
                  }
              }
              revalidate();
              repaint();
          } 
      });
      
    
   }

}
