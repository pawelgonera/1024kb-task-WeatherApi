package pl._1024kb.weatherapi.model;

public class Coord
{
    private Float lon;
    private Float lat;

    public Coord()
    {

    }

    public Coord(Float lon, Float lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }


}
