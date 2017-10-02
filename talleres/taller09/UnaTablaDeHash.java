/** 
 * Integrantes: -Gonzalo Garcia Hernandez
 * -Sebastián Henao Zapata
 */

//Una tabla de hash donde la llave es un String y el valor un int.
public class UnaTablaDeHash
{
    // Ojo, esta tabla definida así no permite manejar las colisiones
    private int[] tabla;

    public UnaTablaDeHash(){
        tabla = new int[10];
    }

    // Ojo, esta función hash es muy ingenua
    private int funcionHash(String k){
        return ((int) k.charAt(0)*k.length()) % 10;
    }

    // Ojo con las colisiones
    public int get(String k){
        return tabla[funcionHash(k)];
    }

    // Ojo con las colisiones
    public void put(String k, int v){
        int pos = funcionHash(k);
        if(tabla[pos] == 0){
            tabla[pos] = v;
        }else{
            for(int i = 0; i < tabla.length;i++){
                if(tabla[i] == 0){
                    tabla[i] = v;
                    break;
                }
            }
        }
    }

    public static void main(String[] args){
        UnaTablaDeHash hashT = new  UnaTablaDeHash();
        
        hashT.put("abeja",30);
        System.out.println(hashT.get("abeja"));
        hashT.put("arro",45);
        System.out.println(hashT.get("arro"));
    }
}