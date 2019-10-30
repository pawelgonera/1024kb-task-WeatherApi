package pl._1024kb.weatherapi.model;

public class Wind
{
    private Float speed;
    private Integer deg;

    public Wind()
    {

    }

    public Wind(Float speed, Integer deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }


}
