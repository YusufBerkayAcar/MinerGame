
public class Karakter {
    
    private int �d;
    private String ad;
    private int x ;
    private int y;
    
    public Karakter(){
        
    }

    public Karakter(int �d, String ad, int x, int y) {
        this.�d = �d;
        this.ad = ad;
        this.x = x;
        this.y = y;
    }
    
    

    public int getId() {
        return �d;
    }

    public void setId(int �d) {
        this.�d = �d;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}
