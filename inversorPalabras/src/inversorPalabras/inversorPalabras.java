package inversorPalabras;
//Importar libreria para scanner
import java.util.Scanner;

public class inversorPalabras {

	public static void main(String[] args) {
		//Definir variables para la palabra y la invertida
		String palabra = "", palabraInvertida = "";
		int  longitudPalabra = 0;
		//Crear un objeto scanner y darle un valor
		Scanner entrada = new Scanner(System.in);
		//Pedir la entrada y cerrar el scanner
		System.out.print("Pon una palabra o una frase: ");
		palabra = entrada.nextLine();
		entrada.close();
		
		longitudPalabra = palabra.length();
		
		//Agrega todo de longitud de palabra -1 al final y se va moviendo en 1
		while(longitudPalabra != 0){
			palabraInvertida += palabra.substring(longitudPalabra -1, longitudPalabra);
			longitudPalabra --;
		}
		System.out.println(palabraInvertida);

	}

}
