package specs;

import dto.Pet;

public class PetFactory {
    public static Pet.PetBuilder getPet() {
        return Pet.builder()
                .id(626)
                .name("StitchAuto")
                .api_key("special-key");
    }

    public static Pet.PetBuilder getSecondPet() {
        return Pet.builder()
                .id(627)
                .name("updStitchAuto")
                .api_key("special-key");
    }
}
