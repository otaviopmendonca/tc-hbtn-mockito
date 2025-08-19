package mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import mockito.Calculadora;
import mockito.ServicoMatematico;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

    @Test
    public void testSomar() {
        ServicoMatematico servicoMock = Mockito.mock(ServicoMatematico.class);
        Mockito.when(servicoMock.somar(2, 3)).thenReturn(5);
        Calculadora calculadora = new Calculadora(servicoMock);
        int resultado = calculadora.somar(2, 3);
        assertEquals(5, resultado);
        Mockito.verify(servicoMock).somar(2, 3);
    }
}