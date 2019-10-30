package pl._1024kb.weatherapi.model;

public class Sys
{
    private Integer type;
    private Long id;
    private Float message;
    private String country;
    private Long sunrise;
    private Long sunset;

    public Sys()
    {

    }

    public Sys(Long id, Integer type, Float message, String country, Long sunrise, Long sunset) {
        this.id = id;
        this.type = type;
        this.message = message;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Float getMessage() {
        return message;
    }

    public void setMessage(Float message) {
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    public Long getSunset() {
        return sunset;
    }

    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }


}
