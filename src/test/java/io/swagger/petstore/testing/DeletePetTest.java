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
@Story("Delete")
@DisplayName("Deleting a pet")
public class DeletePetTest extends BaseTest {

    private final PetSteps petSteps = new PetSteps();
    private final Pet fullDataPet = TestDataGenerator.generateFullDataPet();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Deleting an existing pet")
    public void deletePet() {
        petSteps.createPetSuccessfully(fullDataPet)
            .deletePetById(fullDataPet.getId().toString())
            .getNotFoundPetById(fullDataPet.getId().toString());
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Trying to delete a pet by non-existing ID")
    public void deleteNotFoundPetTest() {
        String notFoundId = "-1";
        petSteps.deleteNotFoundPetById(notFoundId);
    }
}
