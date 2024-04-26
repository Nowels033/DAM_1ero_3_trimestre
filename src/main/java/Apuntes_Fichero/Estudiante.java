package Apuntes_Fichero;

import java.io.*;
import java.util.Scanner;

public class Estudiante {
    private int id;
    private String nombre;
    private String apellidos;
    private double nota;

    public Estudiante(int id, String nombre, String apellidos, double nota) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Apellidos: " + apellidos + ", Nota: " + nota;
    }
}

