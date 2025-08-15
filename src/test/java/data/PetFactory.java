package data;

import dto.Pet;

public class PetFactory {
    public static Pet getPet() {
        return Pet.builder()
                .id(626)
                .name("StitchAuto")
                .api_key("special-key")
                .build();
    }


    public static Pet getSecondPet() {
        return Pet.builder()
                .id(627)
                .name("updStitchAuto")
                .api_key("special-key")
                .build();
    }


}
