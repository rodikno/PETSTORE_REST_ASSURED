package io.swagger.petstore.testing;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.swagger.petstore.testing.data.IncorrectData;
import io.swagger.petstore.testing.models.pet.Pet;
import io.swagger.petstore.testing.steps.PetSteps;
import io.swagger.petstore.testing.utils.TestDataGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Pet store")
@Feature("Pet")
@Story("Put")
@DisplayName("Updating a pet")
public class UpdatePetTest extends BaseTest {

    private final PetSteps petSteps = new PetSteps();
    private final Pet fullDataPet = TestDataGenerator.generateFullDataPet();
    private final Pet modifiedPet = fullDataPet.toBuilder().name("SayMyName").build();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Updating data for a specific pet")
    public void updateFullDataPet() {
        petSteps.createPetSuccessfully(fullDataPet)
            .putPetSuccessfully(modifiedPet)
            .assertPetData(modifiedPet);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Creating a new pet with PUT")
    public void putNewPet() {
        petSteps.putPetSuccessfully(fullDataPet).assertPetData(fullDataPet);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Sending a bad PUT request with incorrect data")
    public void putIncorrectJson() {
        petSteps.putBadRequest(IncorrectData.INCORRECT_JSON);
    }
}
