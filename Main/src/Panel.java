
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.util.Random;
import javax.imageio.ImageIO;




public class Panel extends JPanel {
    private int width;
    private int height;
    public static int[] uz = new int[45];
    public static int[] ge = new int[45];
    public static int[] ge2 = new int[45];
    public static int[] uz3 = new int[45];
    public static int[] ge3 = new int[45];
    Random r=new Random();
    
    
    
 
    
   public static void falseYap(int basla , int sizeX , int sizeY , int dizi1[] , int dizi2[] , boolean engeldizi[][] , int width , int height)
{

    
    int x = dizi1[basla] ;
    int y = dizi2[basla] ;
    int sizex = sizeX;
    int sizey = sizeY;
    
    for(int j = x; j <= x + sizex; j++)
    {
        
        for(int l = y; l <= y+sizey; l++)
        {
            
            if(j >= 0 && j < width && l >= 0 && l < height) {
                engeldizi[j][l] = true;
            }
        }
    } 
   
    

    
}


    public Panel(int width, int height) {
        this.width = width;
        this.height = height;
        

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setSize(width, height);
            }
            
        });
        
    }
    
    
    //Arkaplan� kaplad�k.
    @Override
    protected void paintComponent(Graphics g) {
        
        int squareSize =  height / 100; // Karelerin kenar uzunlu�u
       
        Lokasyon lok = new Lokasyon(width/2,height/2); //Yap�land�r�c�s�n� �a��rarak lokasyondaki x ve y de�erlerini ayarlad�k.
        
        Karakter kar = new Karakter(1, "C�neyt", lok.getX(), lok.getY());
        
        int i;
        
        ge[0] = 100;
        uz[0] = 100;
        for(i=1;i<44;i++) 
        {
            Random r=new Random();
             
             int a=r.nextInt(50)*squareSize;
             int b=r.nextInt(100)*squareSize;
             
             ge[i] = a;
             uz[i] = b;
             
             if(ge[i] == width/2 && uz[i] == height/2)
             {
                 ge[i] += squareSize*3;
                 uz[i] += squareSize*3;
             }
               
        }
        
        
        for(i=1;i<44;i++)
        {
            /*Random r=new Random();
            int a=r.nextInt(width/2);
            int b = width/2 + a-squareSize*10;
            
                ge2[i] = b;*/
            int number;
            do {
                int a=r.nextInt(width/2);
                int b = width/2 + a-squareSize*10;
                number = b; 
            } while (number % squareSize != 0); 
            ge2[i] = number; 
        }
        
        
        ge3[24] = 110;
        uz3[24] = 110;
        for(i=25;i<44;i++) 
        {
            Random r=new Random();
             
             int a=r.nextInt(width);
             int b=r.nextInt(height);
             
             ge3[i] = a;
             uz3[i] = b;
             
             if(ge3[i] == width/2 && uz3[i] == height/2)
             {
                 ge3[i] += squareSize*3;
                 uz3[i] += squareSize*3;
             }
                   
        }
        
       
        boolean[][] engelMatrisi = new boolean[width][height];

// T�m koordinatlar� true yap
/*for (int x = 0; x < width; x++) {
    for (int y = 0; y < height; y++) {
        engelMatrisi[x][y] = true;
    }
}*/
        
        
    
    try {
            BufferedImage image1 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\cimen.jpg"));
            g.drawImage(image1, 0, 0, width, height, this); // Engellerin konumlar�n� ve boyutunu buradan ayarlayabilirim!
        } catch (IOException e) {
            e.printStackTrace();
        }
    
     try {
            BufferedImage image1 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\k��.jpg"));
            g.drawImage(image1, 0, 0, width/2, height, this); // Engellerin konumlar�n� ve boyutunu buradan ayarlayabilirim!
        } catch (IOException e) {
            e.printStackTrace();
        }
    
       
        
        
        //Bu k�s�mda engellerin rastgele yerle�tirilmesi ger�ekle�tirilecek.
        
        //Madenciyi ortalad�m.
        try {
            BufferedImage image1 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\madenci.png"));
            g.drawImage(image1, width/2, height/2, squareSize, squareSize, this); // Engellerin konumlar�n� ve boyutunu buradan ayarlayabilirim!
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        //A�a� ekleme i�lemi sol
        for(i=0;i<3;i++)
        {
            try {
            
            BufferedImage image1 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\k��agac.png"));
            g.drawImage(image1, ge[i], uz[i], squareSize*4, squareSize*4, this); 
                falseYap(i,  squareSize*4, squareSize*4, ge, uz, engelMatrisi, width, height);
                
               
            
        } catch (IOException e) {
            e.printStackTrace();
        }
            
        }
        

        //sa�
        for(i=3;i<5;i++)
        {
            try {
            
            BufferedImage image1 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\agac.png"));
            g.drawImage(image1, ge2[i], uz[i], squareSize*4, squareSize*4, this); 
            falseYap(i,  squareSize*4, squareSize*4, ge2, uz, engelMatrisi, width, height);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
            
        }
        
        //Kaya ekleme i�lemi
        for(i=5;i<8;i++)
        {
            try {
            
            BufferedImage image1 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\k��kaya.png"));
            g.drawImage(image1, ge[i], uz[i], squareSize*2, squareSize*2, this);
            falseYap(i,  squareSize*2, squareSize*2, ge, uz, engelMatrisi, width, height);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
            
        } 
        //sol
        for(i=8;i<13;i++)
        {
            try {
            
            BufferedImage image1 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\kaya.png"));
            g.drawImage(image1, ge2[i], uz[i], squareSize*2, squareSize*2, this); 
            falseYap(i,  squareSize*2, squareSize*2, ge2, uz, engelMatrisi, width, height);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
            
        }
        
        //Duvar ekleme i�lemi
        for(i=13;i<15;i++)
        {
            try {
            
            BufferedImage image1 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\duvar.png"));
            g.drawImage(image1, ge2[i], uz[i], squareSize*10, squareSize, this); 
            falseYap(i,  squareSize*10, squareSize, ge2, uz, engelMatrisi, width, height);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
            
        } 
        //sol
        for(i=15;i<18;i++)
        {
            try {
            
            BufferedImage image1 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\k��duvar.png"));
            g.drawImage(image1, ge[i], uz[i], squareSize*10, squareSize, this);
            falseYap(i,  squareSize*10, squareSize, ge, uz, engelMatrisi, width, height);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
            
        } 
        
        //Dag ekleme i�lemi
        for(i=18;i<20;i++)
        {
            try {
            
            ge[17]=ge[18]+squareSize;
            ge[18]=ge[19]+squareSize;
            BufferedImage image1 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\dag.png"));
            g.drawImage(image1, ge2[i], uz[i], squareSize*15, squareSize*15, this); 
            falseYap(i,  squareSize*15, squareSize*15, ge2, uz, engelMatrisi, width, height);
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
            
        }
        
        //Ar� ekleme i�lemi
        for(i=20;i<22;i++)
        {
            try {
            
            BufferedImage image1 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\ari.png"));
            g.drawImage(image1, ge2[i], uz[i], squareSize*2, squareSize*2, this); 
            falseYap(i,  squareSize*4, squareSize*4, ge, uz, engelMatrisi, width, height);
            
            
            
            for(int j=1;j<=3;j++)
            {
             BufferedImage image2 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\ari.png"));
            g.drawImage(image2, ge2[i]+squareSize*j, uz[i], squareSize*2, squareSize*2, this);   
            
            
            }
            for(int j=1;j<=3;j++)
            {
             BufferedImage image2 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\ari.png"));
            g.drawImage(image2, ge2[i]-squareSize*j, uz[i], squareSize*2, squareSize*2, this);  
            
            }
        } 
            
            catch (IOException e) {
            e.printStackTrace();
        }
            
        }
        
        //Ku� ekleme i�lemi
        for(i=22;i<24;i++)
        {
            try {
            
            BufferedImage image1 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\kus.png"));
            g.drawImage(image1, ge[i], uz[i], squareSize*2, squareSize*2, this); 
            falseYap(i,  squareSize*2, squareSize*2, ge, uz, engelMatrisi, width, height);
            
            for(int j=1;j<=5;j++)
            {
             BufferedImage image2 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\kus.png"));
            g.drawImage(image2, ge[i], uz[i]+squareSize*j, squareSize*2, squareSize*2, this);   
            }
            for(int j=1;j<=5;j++)
            {
             BufferedImage image2 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\kus.png"));
            g.drawImage(image2, ge[i], uz[i]-squareSize*j, squareSize*2, squareSize*2, this);   
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
            
        }
        
        //Alt�n sand�k ekleme i�lemi
        for(i=24;i<29;i++)
        {
            try {
            
            
            BufferedImage image1 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\altin.png"));
            g.drawImage(image1, ge3[i], uz3[i], squareSize*3, squareSize*3, this); 
        } catch (IOException e) {
            e.printStackTrace();
        }
            
        }
        
        //G�m�� sand�k ekleme i�lemi
        for(i=29;i<34;i++)
        {
            try {
            
            
            BufferedImage image1 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\g�m�s.png"));
            g.drawImage(image1, ge3[i], uz3[i], squareSize*3, squareSize*3, this); 
        } catch (IOException e) {
            e.printStackTrace();
        }
            
        }
        
        //Bak�r sand�k ekleme i�lemi
        for(i=34;i<39;i++)
        {
            try {
            
           
            BufferedImage image1 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\bakir.png"));
            g.drawImage(image1, ge3[i], uz3[i], squareSize*3, squareSize*3, this); 
        } catch (IOException e) {
            e.printStackTrace();
        }
            
        }
        
        //Z�mr�t sand�k ekleme i�lemi
        for(i=39;i<44;i++)
        {
            try {
            
            
            BufferedImage image1 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\z�mr�t.png"));
            g.drawImage(image1, ge3[i], uz3[i], squareSize*3, squareSize*3, this); 
        } catch (IOException e) {
            e.printStackTrace();
        }
           
        }
        
         
     for(int �=0;�<24;�++)
     {
         if (engelMatrisi[ge[�]][uz[�]]) {
    System.out.println("(" + ge[�] + ", " + uz[�] + ") noktas� engel taraf�ndan kaplanm��.");
} else {
    System.out.println("(" + ge[�] + ", " + uz[�] + ") noktas� engel taraf�ndan kaplanmam��.");
}
     } 
     
     
       
        
 
        
        
        
        
        // Kareleri �iz
g.setColor(Color.BLACK);

for (int x = 0; x < 2000; x++) {
    for (int y = 0; y < 2000; y++) {
        g.drawRect(x * squareSize, y * squareSize, squareSize, squareSize);
    }
        
}
      

        
       
        
        
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
        
    } 

   
    

    public static void main(String[] args) {
        
            int width = Integer.parseInt(JOptionPane.showInputDialog("Enter width:"));
            int height = Integer.parseInt(JOptionPane.showInputDialog("Enter height:"));
            
            Panel panel = new Panel(width, height);

         
        SwingUtilities.invokeLater(() -> {
            

            JFrame frame = new JFrame("Oyun");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            frame.add(panel);
            
            
            JButton createMapButton = new JButton("Harita Olu�tur");
            createMapButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    
                    panel.repaint(); // Harita olu�tur butonuna bas�ld���nda haritan�n ba�tan olu�turulmas� i�in repaint �a�r�s�
                }
            });

            
            JButton startButton = new JButton("Ba�lat");
            
            startButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    
                    if(panel.isVisible())
                    {
                        panel.setVisible(false);   
                    }
                    else
                    {
                        panel.setVisible(true);
                    }
                    
                }
            });
                    
            
            
            
            JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
            buttonPanel.add(createMapButton);
            buttonPanel.add(startButton);
            frame.add(buttonPanel, BorderLayout.SOUTH);

            frame.pack();
            frame.setVisible(true);
            
        });
        
         
        
        
    }
}
