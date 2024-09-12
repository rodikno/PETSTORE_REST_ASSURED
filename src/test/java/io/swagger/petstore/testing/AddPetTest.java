package io.swagger.petstore.testing;

import io.qameta.allure.*;
import io.swagger.petstore.testing.data.IncorrectData;
import io.swagger.petstore.testing.models.pet.Pet;
import io.swagger.petstore.testing.steps.PetSteps;
import io.swagger.petstore.testing.utils.TestDataGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Pet store")
@Feature("Pet")
@Story("Post")
@DisplayName("Adding a pet")
public class AddPetTest extends BaseTest {

    private final PetSteps petSteps = new PetSteps();
    private final Pet minDataPet = TestDataGenerator.generateMinDataPet();
    private final Pet fullDataPet = TestDataGenerator.generateFullDataPet();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Adding pet with minimum amount of required fields")
    public void createMinDataPet() {
        petSteps.createPetSuccessfully(minDataPet);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Adding a pet with all possible fields set")
    public void createFullDataPet() {
        petSteps.createPetSuccessfully(fullDataPet);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Incorrect POST request body processing")
    public void postIncorrectJson() {
        petSteps.postBadRequest(IncorrectData.INCORRECT_JSON);
    }
}
