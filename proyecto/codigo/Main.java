
/**
 * Class Main.
 *
 * Gonzalo Garcia Hernandez
 * Sebastián Henao Zapata
 *///
import java.util.ArrayList;
import java.io.*;
public class Main
{
    //identifica si es un FICHERO o una CARPETA y la inserta en la ultima carpeta
    public static void insertar(String linea,Carpeta papa,int n){
        Carpeta padre = papa.ultimaC(); //es la ultima carpeta agregada a algÃºn lado         
        boolean unaCarpeta = false; //el archivo seleccionado es una carpeta??
        if(linea.indexOf('.') == -1){
            unaCarpeta = true;
        }
        
        if(n == 0 && unaCarpeta){ //esta en carp Principal y es una carpeta??
            Carpeta carp = new Carpeta(linea,papa.thisCarpeta(n)); //crea una subcarpeta en una carpeta principal
            papa.ultimaC().insertarC(carp); //agrega la nueva carpeta a la ULTIMA carpeta ACTUAL agregada a papa.
            System.out.println("$[MOD]$ Se agregÃ³ la carpeta ["+carp.nombre+"] a la carpeta ["+papa.ultimaC().nombre+"]");
        }else if(n == 0 && !unaCarpeta){ //esta en carp Principal y es un fichero??
            papa.ultimaC().insertarF(linea);
            System.out.println("$[MOD]$ Se agregÃ³ el fichero ["+linea+"] a la carpeta ["+papa.ultimaC().nombre+"]");
        }else{
            insertar(linea,padre,n-1); //Asigna a la ultima carpeta raiz(n==0)
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Carpeta papa = new Carpeta("Padre",null);
        int n = 0;
        String linea;
        int carpAct = -1;
        FileReader fil = new FileReader("Estructura.txt");
        BufferedReader buf = new BufferedReader(fil);
        while( (linea = buf.readLine()) != null ){
            //Esta condicion es para crear los PRINCIPALES ficheros y carpetas
            if(linea.charAt(0) == '+'){ 
                String[] cadena = linea.split("]  ");  
                String actual = "";
                if(cadena[1].indexOf('.') != -1){ //busca si hay un punto en el nombre
                    papa.insertarF(cadena[1]);
                    System.out.println("Se incertÃ³ el fichero:"+cadena[1]);
                }else{
                    Carpeta carp = new Carpeta(cadena[1],papa);
                    papa.insertarC(carp);
                    System.out.println("Se incertÃ³ la carpeta:"+cadena[1]);
                    carpAct++;
                    actual = papa.thisCarpeta(carpAct).nombre;
                }
                System.out.println("\tEstoy en la carpeta: "+actual);
            }else if(linea.charAt(0) == 'ï¿½'){//Esta condicion es para crear los demas ficheros y carpetas
                int i = 1; //indice para recorrer la linea
                int cont = 0; //cuenta espacios
                int numCarpeta = -1; //dice a que #de carpeta pertece el archivo
                while(linea.charAt(i) == ' '){
                    cont++;
                    if((cont % 3) == 0){
                        numCarpeta++; //numero de la subcarpeta a la que pertenece (0 es la principal y)
                    }
                    i++;
                }
                System.out.println("# de espacios: "+cont+"\tSe pondrÃ¡ en carpeta: "+numCarpeta);
                String[] cadena = linea.split("]  ");
                insertar(cadena[1],papa,numCarpeta); //agrega el fichero/carpeta dependiendo de los espacios
            }
        }
        buf.close();
    }
}
