
import java.util.*;

//Read more: http://javarevisited.blogspot.com/2012/01/java-HashMap-example-tutorial-code.html#ixzz4uMshWOhm

/**
 *
 * Integrantes: -Gonzalo Garcia Hernandez
 * -Sebastián Henao Zapata
 */
public class Taller9{
    //pedrito 1
    public static void agregar(HashMap empresas,String key, String value){
        empresas.put(key,value);
    }

    //pedrito 2
    public static void buscar(HashMap empresas,String key){
        System.out.println(empresas.get(key));
    }
    //pedrito 3
    public static boolean contienekey(HashMap empresas,String value){
        return empresas.containsValue(value);
    } 

    public static void main(String[] args) {
        HashMap empresas = new HashMap();
        agregar(empresas,"Google","Estados Unidos");
        agregar(empresas,"La locura","Colombia");
        agregar(empresas,"Nokia","Finlandia");
        agregar(empresas,"Sony","Japón");
        
        buscar(empresas,"Google");
        buscar(empresas,"Motorola");
        
        System.out.println(contienekey(empresas,"India"));
    }    
}