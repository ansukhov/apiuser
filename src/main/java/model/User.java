package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private List<Results> results;

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Results {

        private String gender;
        private Name name;
        private Location location;
        private String email;
        private Dob dob;
        private String phone;
        private String cell;
        private String nat;

        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Name {
            private String title;
            private String first;
            private String last;
        }

        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Location {
            private String street;
            private String city;
            private String state;
            private String postcode;
        }

        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Dob {
            private String date;
            private int age;
        }

        @Override
        public String toString() {
            return String.format("User: name: %s, gender: %s, age: %s, city: %s, postcode: %s",
                    getName().getFirst(), getGender(), getDob().getAge(), getLocation().getCity(), getLocation().getPostcode());
        }
    }
}
