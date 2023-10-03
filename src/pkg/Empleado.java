package pkg;

public class Empleado {
	
	public enum TipoEmpleado{Vendedor, Encargado};
	
	public static float calculoNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtra) {
		
		float salarioBase = 0, primas = 0, extras = 0;
		
		if(tipo == TipoEmpleado.Encargado) {
			salarioBase = 2500;
		}
		else if (tipo == TipoEmpleado.Vendedor) {
			salarioBase = 2000;
		}
		
		if(ventasMes >= 1500) {
			primas = 200;
		}
		else if(ventasMes >= 1000) {
			primas = 100;
		}
		
		extras = horasExtra * 30;
		
		return salarioBase + primas + extras;
	}
	
	public static float calculoNominaNeta(float nominaBruta) {
		float retencion = 0;
		
		if (nominaBruta < 2100 ) {
			retencion = 0;
		}
		else if (nominaBruta >= 2100 && nominaBruta < 2500) {
			retencion = 0.15f;
		}
		else {
			retencion = 0.18f;
		}
		return nominaBruta * (1 - retencion);
	}

}
