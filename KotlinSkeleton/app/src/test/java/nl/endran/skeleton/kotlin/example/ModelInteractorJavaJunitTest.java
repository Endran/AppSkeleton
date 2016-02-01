package nl.endran.skeleton.kotlin.example;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mockit.Mocked;
import mockit.Verifications;

import static org.assertj.core.api.Assertions.assertThat;

public class ModelInteractorJavaJunitTest {

    public static final String TEST_NAME = "TEST_NAME";
    public static final String TEST_MESSAGE = "TEST_MESSAGE";

    @Mocked
    private Function1<String, Unit> lambdaMock;

    private ModelInteractor interactor;

    @Before
    public void setUp() {
        interactor = new ModelInteractor(TEST_NAME);
    }

    @Test
    public void ShouldInformViaCallbackThatTheMessageIsEmpty_WhenEmptyMessageIsProvided() {
        interactor.executeSomeComplexOperation("", lambdaMock);

        new Verifications() {{
            List<String> actualList = new ArrayList<>();
            lambdaMock.invoke(withCapture(actualList));

            String expected = "ModelInteractor " + TEST_NAME + " received an empty message";
            assertThat(actualList).hasSize(1);
            assertThat(actualList.get(0)).isEqualTo(expected);
        }};
    }

    @Test
    public void ShouldInformViaCallbackAMessage_WhenNonEmptyMessageIsProvided() {

        interactor.executeSomeComplexOperation(TEST_MESSAGE, lambdaMock);

        new Verifications() {{
            List<String> actualList = new ArrayList<>();
            lambdaMock.invoke(withCapture(actualList));

            String expected = "ModelInteractor " + TEST_NAME + " received " + TEST_MESSAGE;
            assertThat(actualList).hasSize(1);
            assertThat(actualList.get(0)).isEqualTo(expected);
        }};
    }
}
