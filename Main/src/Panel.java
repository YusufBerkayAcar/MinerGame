
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
    
    
    //Arkaplaný kapladýk.
    @Override
    protected void paintComponent(Graphics g) {
        
        int squareSize =  height / 100; // Karelerin kenar uzunluðu
       
        Lokasyon lok = new Lokasyon(width/2,height/2); //Yapýlandýrýcýsýný çaðýrarak lokasyondaki x ve y deðerlerini ayarladýk.
        
        Karakter kar = new Karakter(1, "Cüneyt", lok.getX(), lok.getY());
        
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

// Tüm koordinatlarý true yap
/*for (int x = 0; x < width; x++) {
    for (int y = 0; y < height; y++) {
        engelMatrisi[x][y] = true;
    }
}*/
        
        
    
    try {
            BufferedImage image1 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\cimen.jpg"));
            g.drawImage(image1, 0, 0, width, height, this); // Engellerin konumlarýný ve boyutunu buradan ayarlayabilirim!
        } catch (IOException e) {
            e.printStackTrace();
        }
    
     try {
            BufferedImage image1 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\kýþ.jpg"));
            g.drawImage(image1, 0, 0, width/2, height, this); // Engellerin konumlarýný ve boyutunu buradan ayarlayabilirim!
        } catch (IOException e) {
            e.printStackTrace();
        }
    
       
        
        
        //Bu kýsýmda engellerin rastgele yerleþtirilmesi gerçekleþtirilecek.
        
        //Madenciyi ortaladým.
        try {
            BufferedImage image1 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\madenci.png"));
            g.drawImage(image1, width/2, height/2, squareSize, squareSize, this); // Engellerin konumlarýný ve boyutunu buradan ayarlayabilirim!
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        //Aðaç ekleme iþlemi sol
        for(i=0;i<3;i++)
        {
            try {
            
            BufferedImage image1 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\kýþagac.png"));
            g.drawImage(image1, ge[i], uz[i], squareSize*4, squareSize*4, this); 
                falseYap(i,  squareSize*4, squareSize*4, ge, uz, engelMatrisi, width, height);
                
               
            
        } catch (IOException e) {
            e.printStackTrace();
        }
            
        }
        

        //sað
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
        
        //Kaya ekleme iþlemi
        for(i=5;i<8;i++)
        {
            try {
            
            BufferedImage image1 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\kýþkaya.png"));
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
        
        //Duvar ekleme iþlemi
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
            
            BufferedImage image1 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\kýþduvar.png"));
            g.drawImage(image1, ge[i], uz[i], squareSize*10, squareSize, this);
            falseYap(i,  squareSize*10, squareSize, ge, uz, engelMatrisi, width, height);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
            
        } 
        
        //Dag ekleme iþlemi
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
        
        //Arý ekleme iþlemi
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
        
        //Kuþ ekleme iþlemi
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
        
        //Altýn sandýk ekleme iþlemi
        for(i=24;i<29;i++)
        {
            try {
            
            
            BufferedImage image1 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\altin.png"));
            g.drawImage(image1, ge3[i], uz3[i], squareSize*3, squareSize*3, this); 
        } catch (IOException e) {
            e.printStackTrace();
        }
            
        }
        
        //Gümüþ sandýk ekleme iþlemi
        for(i=29;i<34;i++)
        {
            try {
            
            
            BufferedImage image1 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\gümüs.png"));
            g.drawImage(image1, ge3[i], uz3[i], squareSize*3, squareSize*3, this); 
        } catch (IOException e) {
            e.printStackTrace();
        }
            
        }
        
        //Bakýr sandýk ekleme iþlemi
        for(i=34;i<39;i++)
        {
            try {
            
           
            BufferedImage image1 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\bakir.png"));
            g.drawImage(image1, ge3[i], uz3[i], squareSize*3, squareSize*3, this); 
        } catch (IOException e) {
            e.printStackTrace();
        }
            
        }
        
        //Zümrüt sandýk ekleme iþlemi
        for(i=39;i<44;i++)
        {
            try {
            
            
            BufferedImage image1 = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\Resim\\zümrüt.png"));
            g.drawImage(image1, ge3[i], uz3[i], squareSize*3, squareSize*3, this); 
        } catch (IOException e) {
            e.printStackTrace();
        }
           
        }
        
         
     for(int ç=0;ç<24;ç++)
     {
         if (engelMatrisi[ge[ç]][uz[ç]]) {
    System.out.println("(" + ge[ç] + ", " + uz[ç] + ") noktasý engel tarafýndan kaplanmýþ.");
} else {
    System.out.println("(" + ge[ç] + ", " + uz[ç] + ") noktasý engel tarafýndan kaplanmamýþ.");
}
     } 
     
     
       
        
 
        
        
        
        
        // Kareleri çiz
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
            
            
            JButton createMapButton = new JButton("Harita Oluþtur");
            createMapButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    
                    panel.repaint(); // Harita oluþtur butonuna basýldýðýnda haritanýn baþtan oluþturulmasý için repaint çaðrýsý
                }
            });

            
            JButton startButton = new JButton("Baþlat");
            
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
