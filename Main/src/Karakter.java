
public class Karakter {
    
    private int ıd;
    private String ad;
    private int x ;
    private int y;
    
    public Karakter(){
        
    }

    public Karakter(int ıd, String ad, int x, int y) {
        this.ıd = ıd;
        this.ad = ad;
        this.x = x;
        this.y = y;
    }
    
    

    public int getId() {
        return ıd;
    }

    public void setId(int ıd) {
        this.ıd = ıd;
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
