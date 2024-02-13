import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.*;
import javax.swing.*;

class Server extends JFrame
{  
    ServerSocket server;
    Socket socket;
    BufferedReader br;
    PrintWriter out; 

  private JLabel heading = new JLabel("Server Area");
  private JTextArea messageArea = new JTextArea();
  private JTextField messageInput = new JTextField();
  private Font font = new Font("Roboto", Font.BOLD,20);


   //Constructor
   public Server()
   {
    try{
     server= new ServerSocket(7778);
     System.out.println("server is ready  to accept connection");
     System.out.println("waiting....");
      socket=  server.accept();
      br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      out = new PrintWriter(socket.getOutputStream());
      createGUI();
      HandleEvents();

      startReading();
      //startWriting();
    }
    catch(Exception e){
        e.printStackTrace();
    }
   }

   private void createGUI()
  {
    this.setTitle("Server Messanger");
    this.setSize(700,800);
    this.setLocationRelativeTo(null);  //  window centre   
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cross button .. programm close

    
    // // Load the original image
    ImageIcon originalIcon = new ImageIcon("chat.png");

    // // Resize the image icon
     int newWidth = 100; // Specify your desired width
     int newHeight = 100; // Specify your desired height
   
    ImageIcon resizedIcon = new ImageIcon(originalIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH));

    // // Set the resized ImageIcon to the heading
     heading.setIcon(resizedIcon);

// coding for component

    heading.setFont(font);
    messageArea.setFont(font);
    messageInput.setFont(font);
    //heading.setIcon(new ImageIcon("chat.png"));
    heading.setHorizontalTextPosition(SwingConstants.CENTER);
    heading.setHorizontalAlignment(SwingConstants.CENTER);
    heading.setVerticalTextPosition(SwingConstants.BOTTOM);
    


    heading.setHorizontalAlignment(SwingConstants.CENTER);
    heading.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    messageArea.setEditable(false);// not editable 





    // frame layout set 
    this.setLayout(new BorderLayout());
    
    // adding the component to frame
    this.add(heading,BorderLayout.NORTH); // heading will appear in north

    JScrollPane jScrollPane = new JScrollPane(messageArea);
    this.add(jScrollPane,BorderLayout.CENTER); // message area will be appear in centre
    this.add(messageInput,BorderLayout.SOUTH); //  text field will be appear in south/bottom

    


    this.setVisible(true); // window visible
    

  }

  private void HandleEvents() {
    
  messageInput.addKeyListener(new KeyListener() {

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==10) // 10 is enter botton code when we push enter that mean 10
        {
           String contentToString = messageInput.getText();
           messageArea.append("Server :"+ contentToString+"\n");
           out.println(contentToString);
           out.flush();
           messageInput.setText(" ");
           messageInput.requestFocus();
        }
    }
    
  });


}

  public void startReading()
   {
       // thread - for reading 

       Runnable r1 = ()->{
          System.out.println("reader started");
          try{
          while(true)
          {
            String msg;
            
                msg = br.readLine();
            
            if(msg.equals("exit"))
            {
                System.out.println("client terminated the chat");

                JOptionPane.showMessageDialog(this, "server Terminated the Chat");
                messageInput.setEnabled(false);

                socket.close();
                break;
            }

            //System.out.println("client :" + msg);
            messageArea.append("client :" + msg+"\n");
          } 
        }
          catch (IOException e)
           {
                
            //  e.printStackTrace();
            System.out.println("connection closed");
           }
       };
       new Thread(r1).start();

    }

   public void startWriting()
   {
     //thread - data user lega aur send karega client tak

     Runnable r2 =()->{
        System.out.println("writer started");
        try{

       while(!socket.isClosed())
       {
          BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
          String content = br1.readLine();
          out.println(content);
          out.flush();

          if(content.equals("exit"))
          {
            socket.close();
            break;
          }
        }
    }
        catch (Exception e)
        {
            // e.printStackTrace();
            System.out.println("connection closed");
        }
       
     };   
     new Thread(r2).start();

    }

    public static void main(String[] args) {
        System.out.println("this is serevr.. going on");
        new Server();
    }
}