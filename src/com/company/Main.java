package com.company;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {

        conExpresionesRegulares();
        sinExpresionesRegulares();

    }

    public static void conExpresionesRegulares() throws FileNotFoundException {

        File archivo = new File("src/Santako.txt");
        Scanner scanner = new Scanner(archivo);

        //Utilizo '\\' para poder poder poner '*'
        Pattern papaNoel = Pattern.compile("\\*<]:-DOo");
        //Utilizo '\\' para poder poder poner ')'
        Pattern reno = Pattern.compile(">:o\\)");
        //Para que nos funcione bien el programa, debemos utilizar '[^\\*]' para decirle al programa que los follet no tienen un '*'
        Pattern follet = Pattern.compile("[^\\*]<]:-D");

        //val linea
        String linea;

        // val cont's
        int contPapaNoel = 0;
        int contReno = 0;
        int contFollet = 0;


        System.out.println("------------------------------------");
        System.out.println("     CON EXPRESIONES REGULARES");
        System.out.println();

        //el bucle
        //Read and find
        while (scanner.hasNextLine()){
            linea = scanner.nextLine();

            Matcher matcherPapa = papaNoel.matcher(linea);
            Matcher matcherReno = reno.matcher(linea);
            Matcher matcherFollet = follet.matcher(linea);

            while (matcherPapa.find()){
                contPapaNoel++;
            }
            while (matcherReno.find()){
                contReno++;
            }
            while  (matcherFollet.find()){
                contFollet++;
            }

            if(contPapaNoel>0) System.out.print("Pare Noel (" + contPapaNoel + ") ");
            if(contReno>0) System.out.print("Ren (" + contReno + ") ");
            if(contFollet>0) System.out.print("Follet (" + contFollet + ") ");
            System.out.println();

            if(contPapaNoel==0 && contReno==0 && contFollet==0)
                System.out.print("");

            contPapaNoel=0;
            contReno=0;
            contFollet=0;
        }
    }

    public static void sinExpresionesRegulares() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/santako.txt"));
        try {
            System.out.println("------------------------------------");
            System.out.println("     SIN EXPRESIONES REGULARES");
            System.out.println();
            String linea;

            // val cont's
            int contadorSanta = 0;
            int contadorReno = 0;
            int contadorFollet = 0;

            boolean santa;
            boolean reno;
            boolean follet;

            //lineas-----
            while ((linea = br.readLine()) != null) {

                santa = linea.contains("*<]:-DOo");
                reno = linea.contains(">:o)");
                follet = linea.contains("<]:-D");

                if (santa) {
                    contadorSanta++;
                } else contadorSanta = 0;

                if (reno) {
                    contadorReno++;
                } else contadorReno = 0;

                //harcodeado, pero funciona
                if (follet && linea.endsWith("D")) {
                    contadorFollet++;
                } else contadorFollet = 0;

                //
                if (contadorSanta > 0) System.out.print("Pare Noel (" + contadorSanta + ") ");
                if (contadorReno > 0) System.out.print("Reno (" + contadorReno + ") ");
                if (contadorFollet > 0) System.out.print("Follet (" + contadorFollet + ") ");

                System.out.println("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
    }
}
