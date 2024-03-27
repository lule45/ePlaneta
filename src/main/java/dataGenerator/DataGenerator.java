package dataGenerator;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataGenerator {
    public static String generateEmail() {
        Faker faker = new Faker(new Locale("srb-SRB"));
        String email = faker.name().firstName() + "+random@gmail.com";
        return email;
    }

    public static String generatePassword() {
        Faker faker = new Faker(new Locale("srb-SRB"));
        String password = faker.name().firstName() + faker.name().lastName() + "123!";
        return password;
    }
}
