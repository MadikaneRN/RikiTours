package za.co.whcb.tp2.rikitours.domain.tour;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class CountryDescription {
    private City city;
    private String countryCode;
    private String flagImage;

    public CountryDescription() {
    }

    public CountryDescription(Builder builder) {
        this.city = builder.city;
        this.countryCode = builder.countryCode;
        this.flagImage = builder.flagImage;
    }

    public City getCity() {
        return city;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getFlagImage() {
        return flagImage;
    }

    public static class Builder{
        private City city;
        private String countryCode;
        private String flagImage;

        public Builder city(City city){
            this.city = city;
            return this;
        }

        public Builder countryCode(String countryCode){
            this.countryCode = countryCode;
            return this;
        }

        public Builder flagImage(String flagImage){
            this.flagImage = flagImage;
            return this;
        }

        public Builder copy(CountryDescription countryDescription){
            this.countryCode = countryDescription.countryCode;
            this.city = countryDescription.city;
            this.flagImage = countryDescription.flagImage;

            return this;
        }

        public CountryDescription build() {
            return new CountryDescription(this);
        }
    }
}
