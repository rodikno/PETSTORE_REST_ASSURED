package io.swagger.petstore.testing;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.swagger.petstore.testing.models.pet.Pet;
import io.swagger.petstore.testing.steps.PetSteps;
import io.swagger.petstore.testing.utils.TestDataGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Pet store")
@Feature("Pet")
@Story("Get")
@DisplayName("Getting a Pet")
public class GetPetTest extends BaseTest {

    private final PetSteps petSteps = new PetSteps();
    private final Pet fullDataPet = TestDataGenerator.generateFullDataPet();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("GET a Pet")
    public void getPetTest() {
        petSteps.createPetSuccessfully(fullDataPet).assertPetData(fullDataPet);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Getting a pet by non-existing Id")
    public void getNotFoundPetTest() {
        String notFoundId = "-1";
        petSteps.getNotFoundPetById(notFoundId);
    }
}
