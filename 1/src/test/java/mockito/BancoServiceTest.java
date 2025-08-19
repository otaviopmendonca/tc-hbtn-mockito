package mockito;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BancoServiceTest {

    @Test
    public void testConsultarSaldo() {
        ContaRepository contaRepositoryMock = mock(ContaRepository.class);
        Conta contaMock = new Conta("123", 100.0);
        when(contaRepositoryMock.buscarConta("123")).thenReturn(contaMock);

        BancoService bancoService = new BancoService(contaRepositoryMock);
        double saldo = bancoService.consultarSaldo("123");

        assertEquals(100.0, saldo);
        verify(contaRepositoryMock).buscarConta("123");
    }

    @Test
    public void testDepositar() {
        ContaRepository contaRepositoryMock = mock(ContaRepository.class);
        Conta contaMock = new Conta("123", 100.0);
        when(contaRepositoryMock.buscarConta("123")).thenReturn(contaMock);

        BancoService bancoService = new BancoService(contaRepositoryMock);
        bancoService.depositar("123", 50.0);

        assertEquals(150.0, contaMock.getSaldo());
        verify(contaRepositoryMock).buscarConta("123");
        verify(contaRepositoryMock).salvar(contaMock);
    }
}
