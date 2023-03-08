package helpers;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String phoneNumber;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    public Address createFakeAddress() {
        Faker faker = new Faker(Locale.US);
        this.phoneNumber = faker.phoneNumber().cellPhone();
        this.streetAddress = faker.address().streetAddress();
        this.city = faker.address().city();
        this.state = faker.address().state();
        this.zipCode = faker.address().zipCode();
        this.country = faker.address().countryCode();
        return this;
    }
}