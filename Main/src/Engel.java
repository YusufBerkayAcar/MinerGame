
public class Engel {
    
    
    public class HareketsizEngel 
    {
        
        private int x;
        private int y;
        private int genislik;
        private int uzunluk;

        public HareketsizEngel()
        {
            
        }
        
        public HareketsizEngel(int x, int y, int genislik, int uzunluk) {
            this.x = x;
            this.y = y;
            this.genislik = genislik;
            this.uzunluk = uzunluk;
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

        public int getGenislik() {
            return genislik;
        }

        public void setGenislik(int genislik) {
            this.genislik = genislik;
        }

        public int getUzunluk() {
            return uzunluk;
        }

        public void setUzunluk(int uzunluk) {
            this.uzunluk = uzunluk;
        }
        
        
        public boolean engelKonumu(int karakterX, int karakterY , int engelX , int engelY , int genislik , int uzunluk) {
        // Karakterin konumu engelin konumunun içinde mi kontrol ediyoruz
        return (karakterX >= x && karakterX < x + genislik && karakterY >= y && karakterY < y + uzunluk);
        }
        
        
    }
    
    public class DinamikEngel
    {
        private int x;
        private int y;
        private int genislik;
        private int uzunluk;

        public DinamikEngel(int x, int y, int genislik, int uzunluk) {
            this.x = x;
            this.y = y;
            this.genislik = genislik;
            this.uzunluk = uzunluk;
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

        public int getGenislik() {
            return genislik;
        }

        public void setGenislik(int genislik) {
            this.genislik = genislik;
        }

        public int getUzunluk() {
            return uzunluk;
        }

        public void setUzunluk(int uzunluk) {
            this.uzunluk = uzunluk;
        }
        
         public boolean engelKonumu(int karakterX, int karakterY , int genislik , int uzunluk) {
        // Karakterin konumu engelin konumunun içinde mi kontrol ediyoruz
        return (karakterX >= x && karakterX < x + genislik && karakterY >= y && karakterY < y + uzunluk);
        }
        
    }
    
    
    
}
