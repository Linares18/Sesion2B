package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Empleado;
import pkg.Empleado.TipoEmpleado;

class EmpleadoTest {

	private float ventasMes1;
	private float ventasMes2;
	private float ventasMes3;
	private float ventasMes4;
	private float horasExtra1;
	private float horasExtra2;
	TipoEmpleado vendedor;
	TipoEmpleado encargado;
	TipoEmpleado otro;
	private float nominabruta0;
	private float nominabruta1;
	private float nominabruta2;
	private float nominabruta3;
		
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Before All");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("After All");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Before Each");
		ventasMes1 = -100;
		ventasMes2 = 900;
		ventasMes3 = 1300;
		ventasMes4 = 1700;
		horasExtra1 = -2;
		horasExtra2 = 2;
		vendedor = TipoEmpleado.Vendedor;
		encargado = TipoEmpleado.Encargado;
		nominabruta0 = -500;
		nominabruta1 = 1900;
		nominabruta2 = 2300;
		nominabruta3 = 2700;
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("After Each");
		
	}

	@Test
	void testCalculoNominaBrutaEncargado() {
		float expected = 2760;
		float actual = Empleado.calculoNominaBruta(encargado, 1500, 2);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaVendedor() {
		float expected = 2260;
		float actual = Empleado.calculoNominaBruta(vendedor, 1500, 2);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaOtro() {
		float expected = 260;
		float actual = Empleado.calculoNominaBruta(otro, 1500, 2);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaVentasMesNegativa() {
		float expected = 2560;
		float actual = Empleado.calculoNominaBruta(encargado, ventasMes1, 2);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaVentasMesMenor1000() {
		float expected = 2560;
		float actual = Empleado.calculoNominaBruta(encargado, ventasMes2, 2);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaVentasMesEntre1000y1500() {
		float expected = 2660;
		float actual = Empleado.calculoNominaBruta(encargado, ventasMes3, 2);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaVentasMesMayor1500() {
		float expected = 2760;
		float actual = Empleado.calculoNominaBruta(encargado, ventasMes4, 2);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaHorasExtraNegativa() {
		float expected = 2640;
		float actual = Empleado.calculoNominaBruta(encargado, 1500, horasExtra1);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaHorasExtraPositiva() {
		float expected = 2760;
		float actual = Empleado.calculoNominaBruta(encargado, 1500, horasExtra2);
		assertEquals(expected, actual);
	}

	@Test
	void testCalculoNominaNetaNegativa() {
		float expected = -500;
		float actual = Empleado.calculoNominaNeta(nominabruta0);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaNetaMenor2100() {
		float expected = 1900;
		float actual = Empleado.calculoNominaNeta(nominabruta1);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaNetaEntre2100y2500() {
		float expected = 1955;
		float actual = Empleado.calculoNominaNeta(nominabruta2);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaNetaMayor2500() {
		float expected = 2214;
		float actual = Empleado.calculoNominaNeta(nominabruta3);
		assertEquals(expected, actual);
	}

}