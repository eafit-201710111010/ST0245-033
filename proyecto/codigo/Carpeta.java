
/**
 * Class Carpeta.
 *
 * Gonzalo García Hernandez
 * Sebastián Henao Zapata
 */
import java.util.ArrayList;

public class Carpeta
{
    String nombre;
    ArrayList<Carpeta> carpetas = new ArrayList<>();
    ArrayList<String> ficheros = new ArrayList<>();
    Carpeta papa;
    String ruta = "";
    
    /**
     * Constructor de la clase carpeta, insertar null si esta no tiene carpeta padre.
     */
    public Carpeta(String nombre,Carpeta papa){
        this.nombre = nombre;
        this.papa = papa;
    }
    
    public void insertarC(Carpeta newCarpeta){
        carpetas.add(newCarpeta);
    }
    
    public void insertarF(String newFichero){
        ficheros.add(newFichero);
    }
    
    public Carpeta thisCarpeta(int n){ //seleccionar la carpeta en la posicion n
        return carpetas.get(n);
    }
    
    public Carpeta ultimaC(){ //devuelve la ultima carpeta agregada
        return carpetas.get(carpetas.size()-1); 
    }
    
    public boolean buscarCarpeta(Carpeta carpeta,String name){
        if(carpeta.nombre.equals(name)){
            //buscarPadres(carpeta);
            return true;
        }else if(carpeta.carpetas.size() == 0){
            return false;
        }else{
            for(Carpeta sc: carpeta.carpetas){
                if(buscarCarpeta(sc,name)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public String buscarPadres(Carpeta carpeta){
        if(carpeta.papa == null){
            return ruta;
        }
        ruta += carpeta.papa.nombre +"/";
        return buscarPadres(carpeta.papa);
    }
    
    public void buscarFichero(String name){
    
    }
    
    public static boolean main(String[] args){
        Carpeta papa = new Carpeta("Padre",null);
        Carpeta c1 = new Carpeta("DataSets",papa);
        Carpeta c2 = new Carpeta("Plantillas",papa);
        Carpeta c3 = new Carpeta("abc",c2);
        
        papa.insertarC(c1);
        papa.insertarC(c2);
        
        return papa.buscarCarpeta(papa,"abc");
    }
}
