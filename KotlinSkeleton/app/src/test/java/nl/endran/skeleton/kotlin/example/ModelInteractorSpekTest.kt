package nl.endran.skeleton.kotlin.example

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek

class ModelInteractorSpekTest : Spek() {

    init {
        val testName = "TEST_NAME"

        given("a ModelInteractor with name $testName") {
            val interactor = ModelInteractor(testName)

            on("calling executeSomeComplexOperation with an empty message") {
                var actual = ""
                interactor.executeSomeComplexOperation("") {
                    actual = it
                }

                val expected = "ModelInteractor $testName received an empty message"
                it("should be equal to \"$expected\"") {
                    Assertions.assertThat(actual).isEqualTo(expected)
                }
            }

            val testMessage = "testMessage"
            on("calling executeSomeComplexOperation with $testMessage") {
                var actual = ""
                interactor.executeSomeComplexOperation(testMessage) {
                    actual = it
                }

                val expected = "ModelInteractor $testName received $testMessage"
                it("should be equal to \"$expected\"") {
                    Assertions.assertThat(actual).isEqualTo(expected)
                }
            }
        }
    }
}
