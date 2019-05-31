package gameObjects;

public class Rectangle {
    int xmin , ymin , xmax , ymax;
    public static Rectangle common_cache;
    public Rectangle(int a , int b , int c , int d){
        this.xmin = a;
        this.ymin = b;
        this.xmax = c;
        this.ymax = d;

    }
    Rectangle(){}
    public boolean hit(Rectangle b){
        Rectangle Common = new Rectangle();
        Common.xmin = Math.max(this.xmin,b.xmin);
        Common.xmax = Math.min(this.xmax,b.xmax);
        Common.ymin = Math.max(this.ymin,b.ymin);
        Common.ymax = Math.min(this.ymax,b.ymax);
        common_cache = Common;
        return  Common.xmin < Common.xmax && Common.ymin < Common.ymax;

    }
}
