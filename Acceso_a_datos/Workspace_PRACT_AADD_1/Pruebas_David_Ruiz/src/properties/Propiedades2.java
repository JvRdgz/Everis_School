package properties;

public class Propiedades2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String parametro = Config.getParametro("bd.nombre");
		System.out.println(parametro);
	}

}
