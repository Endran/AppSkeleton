package nl.endran.skeleton.kotlin.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class ModelInteractorJavaJunitTest {

    public static final String TEST_NAME = "TEST_NAME";
    public static final String TEST_MESSAGE = "TEST_MESSAGE";

    @Mock
    private Function1<String, Unit> lambdaMock;

    @Captor
    private ArgumentCaptor<String> lambdaStringCaptor;

    private ModelInteractor interactor;

    @Before
    public void setUp() {
        initMocks(this);

        interactor = new ModelInteractor(TEST_NAME);
    }

    @Test
    public void ShouldInformViaCallbackThatTheMessageIsEmpty_WhenEmptyMessageIsProvided() {
        interactor.executeSomeComplexOperation("", lambdaMock);
        verify(lambdaMock).invoke(lambdaStringCaptor.capture());
        String actual = lambdaStringCaptor.getValue();

        String expected = "ModelInteractor " + TEST_NAME + " received an empty message";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void ShouldInformViaCallbackAMessage_WhenNonEmptyMessageIsProvided() {

        interactor.executeSomeComplexOperation(TEST_MESSAGE, lambdaMock);
        verify(lambdaMock).invoke(lambdaStringCaptor.capture());
        String actual = lambdaStringCaptor.getValue();

        String expected = "ModelInteractor " + TEST_NAME + " received " + TEST_MESSAGE;
        assertThat(actual).isEqualTo(expected);
    }
}
