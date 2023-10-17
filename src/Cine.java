import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

public class Cine {
    //En el diseño del Formulario existe un label actualice a su Nombre y Apellido
    //No borre ninguna sección del codigo proporcionado,
    // Si borra tendrá la nota minima 1.0
    //Se necesita completar las clases Cine y Formulario
    //Con los algoritmos y métodos necesarios de la estructura FIFO
    //Enunciado: Cada sala de cine tiene una capacidad de 25 espacios, solo se
    //pueden comprar como máximo 4 entradas por cliente a una pelicula.
    //Desplegar cada una de las compras en el textArea.
    //Se necesita consultar cuántos espacios quedan disponibles por cada una
    //de las peliculas.
    //Rubrica de calificación:
    //Completar la clase Cine 4 Puntos.
    //Agregar elemento a la Cola y mostrar en el textArea 2 Puntos.
    //Programar los botones para conocer la cantidad de espacios disponibles 4 Puntos.
    //Suba su programa a la plataforma hasta que finalice la hora.

    //Declare la referencia Cola para almacenar asistentes
    Queue<Asistente> colaAsistentes;
    public Cine(){
    //inicialice el objeto
        colaAsistentes=new LinkedList<>();
    }

    public boolean esVacia(){
     // cambie el método para que funcione correctamente
        return colaAsistentes.isEmpty();
    }

    public int tamanio(){
        //actualice la sentencia para que devuelva el tamaño de elementos en la cola
        return colaAsistentes.size();
    }

    public void encolar(Asistente asistente) throws Exception{
      //complete el método
        if (colaAsistentes.size() < 25) {
            colaAsistentes.add(asistente); // Agrega un asistente a la cola si hay espacio disponible.
        } else {
            throw new Exception("No hay entradas Disponibles");
        }
    }

    public Object desencolar() throws Exception{
       //actualice el método para eliminar el elemento del inicio.
        if (colaAsistentes.isEmpty()){
            throw new Exception("No existen elementos en la cola");
        }else{
            return colaAsistentes.remove();
        }
    }

    //cree un método para listar los elementos en una textArea.
    public void listarAsistentes(JTextArea textArea) {
        textArea.setText("");
        for (Asistente asistente : colaAsistentes) {
            textArea.append(asistente.toString() + "\n");
        }
    }

    //cree un método para conocer la cantidad de entradas disponibles
    public int entradasDisponibles(int cantidad) {
        return 25 - cantidad;
        // Calcula las entradas disponibles en la sala.
    }


}
