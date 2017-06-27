
import java.text.DecimalFormat;
import java.util.LinkedList;

/**
 *
 * @author Jorge Silva Borda
 */
public class Calculador {
    private float puntosMax;
    private float porc4;
    
    //Constructores-------------------------------------------------------------
    public Calculador(){
        
    }

    public Calculador(float puntosMax, float porc4) {
        this.puntosMax = puntosMax;
        this.porc4 = porc4;
    }
    
    public String puntosPal4(){
        float puntos4 = puntosMax * (porc4/100);
        DecimalFormat df = new DecimalFormat("###");
        return (String)(df.format(puntos4));
    }

    //Métodos-------------------------------------------------------------------
    public LinkedList<Nota> calcular(){
        LinkedList<Nota> notas = new LinkedList();
        float puntos4 = puntosMax * (porc4/100);
        System.out.println("Puntos máximos: " + puntosMax);
        System.out.println("Porcentaje para el 4.0: " + porc4 + "%");
        System.out.println("Puntos para el 4.0: " + puntos4);
        DecimalFormat df = new DecimalFormat("###.##");
        DecimalFormat red = new DecimalFormat("###.#");
        int fin = 0;
        float nota;
        for(int i = 0; i <= puntos4; i++){
            nota = (float)(i * (4/puntos4));
            System.out.println("Puntos: " + i + " Nota: " + df.format(nota) + " Redondeado: " + red.format(nota));
            notas.add(new Nota(i, red.format(nota).replace(".", ",")));
            fin = i;
        }
        
        for(int x = (fin + 1); x <= puntosMax; x++ ){
            nota = (float)(x * (7/puntosMax));
            System.out.println("Puntos: " + x + " Nota: " + df.format(nota) + " Redondeado: " + red.format(nota));
            notas.add(new Nota(x, red.format(nota).replace(".", ",")));
        }
        return notas;
    }
    
    
    //Getter - Setter ----------------------------------------------------------
    public float getPuntosMax() {
        return puntosMax;
    }

    public void setPuntosMax(float puntosMax) {
        this.puntosMax = puntosMax;
    }

    public float getPorc4() {
        return porc4;
    }

    public void setPorc4(float porc4) {
        this.porc4 = porc4;
    }
    
}
