package gameObjects;

public class shoot {
    public int x , y;

    public shoot(int x , int y){
        this.x = x;
        this.y  = y;
    }

    public void update() {
        this.y -= 3;
    }
}
