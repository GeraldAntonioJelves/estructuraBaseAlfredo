package test.java.carritocompras;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import main.java.pageEvents.CarritoComprasEvents;
import main.java.utils.OpenCSV;
import main.java.utils.Utils;
import test.java.BaseTest;

public class CarritoComprasTest extends BaseTest {

	@Test(enabled = true, dataProvider = "carritoComprasData")
	public void QAS12(String args[]) throws InterruptedException {

		Utils.infoTestCase("Carrito de compras",
				"Validar la generación de una compra al agregar un producto al carrito de compras");

		CarritoComprasEvents.iniciarSesion(args[0], args[1]);
		CarritoComprasEvents.seleccionarProducto(args[2]);
		CarritoComprasEvents.validarPaginaPrincipal();
		CarritoComprasEvents.verCarritoCompras(args[0]);
	}
	
	@DataProvider(name = "carritoComprasData")
	public Object[][] dataBrokerAPAlternative() throws CsvValidationException, InterruptedException, IOException {

		Object[][] data = OpenCSV.getCSVParameters("CSVParametersCarritoCompras.csv", 1, 3);
		return data;
	}
}
