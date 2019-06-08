package resources;

public class Vector {
    double x , y;
    public Vector(double x , double y){
        this.x = x;
        this.y = y;
    }
    public double getSize(){
        return Math.sqrt(x * x + y * y);
    }

    public Vector get_yekke(){
        Vector ret = new Vector(x,y);
        ret.x /= this.getSize();
        ret.y /= this.getSize();
        return ret;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

}
