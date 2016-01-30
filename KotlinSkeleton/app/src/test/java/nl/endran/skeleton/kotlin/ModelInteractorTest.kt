package nl.endran.skeleton.kotlin

import nl.endran.skeleton.kotlin.example.ModelInteractor
import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek

class ModelInteractorTest : Spek() {

    init {
        val testName = "testName"

        given("a ModelInteractor with name $testName") {
            val interactor = ModelInteractor(testName)

            on("calling executeSomeComplexOperation with an empty message") {
                var operationResult: String? = null
                interactor.executeSomeComplexOperation("") {
                    operationResult = it
                    return@executeSomeComplexOperation null
                }

                val expected = "ModelInteractor $testName received an empty message"
                it("should be equal to \"$expected\"") {
                    Assertions.assertThat(operationResult).isEqualTo(expected)
                }
            }

            val testMessage = "testMessage"
            on("calling executeSomeComplexOperation with $testMessage") {
                var operationResult: String? = null
                interactor.executeSomeComplexOperation(testMessage) {
                    operationResult = it
                    return@executeSomeComplexOperation null
                }

                val expected = "ModelInteractor $testName received $testMessage"
                it("should be equal to \"$expected\"") {
                    Assertions.assertThat(operationResult).isEqualTo(expected)
                }
            }
        }
    }
}
