/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Mamey
 */
public class Practica4 {
    private int totalCopies = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Practica4 videoClub = new Practica4();
        ArrayList <Pelicula> movies = new ArrayList <> ();
        Scanner lector = new Scanner(System.in);
        
        boolean out = false;
        while (!out) {
            System.out.println("1)añadir película");
            System.out.println("2)reservar película");
            System.out.println("3)buscar películas");
            System.out.println("4)salir");
            Integer option = lector.nextInt();
            switch (option) {
                case 1:
                    videoClub.addMovies(movies, lector);
                    break;
                case 2:
                    videoClub.bookMovie(movies, videoClub, lector);
                    break;
                case 3:
                    videoClub.searchMovies(movies, videoClub, lector);
                    break;
                case 4:
                    out = true;
                    break;
            }
        }
    }
    
    public void addMovies(ArrayList<Pelicula> movies, Scanner lector) {
        
        System.out.println("dame la cantidad de copias que quieres introducir: ");
        Integer copiesQuantity = lector.nextInt();
        lector.nextLine();
        if (this.totalCopies + copiesQuantity > 3000) {
            System.out.println("el videoclub no puede almacenar más copias");
        } else {
            System.out.println("dame el título de la peli: ");
            String title = lector.nextLine();
            System.out.println("dame el director de la peli: ");
            String director = lector.nextLine();
            System.out.println("dame el género de la peli: ");
            String gender = lector.nextLine();
            System.out.println("dame el año de la peli: ");
            Integer year = lector.nextInt();
            System.out.println("dame la duración en minutos: ");
            Integer duration = lector.nextInt();
            Integer reservedCopies = 0;

            movies.add(new Pelicula(movies.size()+1, title, director, duration, gender, year, true, copiesQuantity,reservedCopies));
            this.totalCopies += copiesQuantity;
        }
    }
    
    public void listMovies(ArrayList<Pelicula> movies, Practica4 videoClub){
        movies.forEach((Pelicula movie) -> {
            videoClub.listMovie(movie);
        });
    }
    
    public void listMovie(Pelicula movie){
        System.out.print("id:" + movie.getId());
        System.out.print(" Título:" + movie.getTitle());
        System.out.print(" Director:" + movie.getDirector());
        System.out.print(" Género:" + movie.getGender());
        System.out.print(" Año:" + movie.getYear());
        System.out.print(" Duración:" + movie.getDuration());
        System.out.print(" Estado:" + (movie.getAvailability() ? "Disponible" : "No disponible"));
        System.out.println("\n");  
    }
    
    public void bookMovie(ArrayList<Pelicula> movies, Practica4 videoClub, Scanner lector){
        videoClub.listMovies(movies, videoClub);
        System.out.print("Dame el id de la película que quieres reservar: ");
        Integer movieId = lector.nextInt();
        int i = 0;
        boolean idExist = false;
        do {
            if (Objects.equals(movies.get(i).getId(), movieId)){
                if (movies.get(i).getAvailability()) {
                    movies.get(i).setReservedCopies(movies.get(i).getReservedCopies()+1);
                    System.out.print("La película ha sido reservada"); 
                } else {
                    System.out.print("No está disponible la película");
                }
                idExist = true;
            }
            i++;
        }
        while (i<movies.size() && !idExist);
        if (!idExist) {
            System.out.print("El id de la película no existe en este videoclub");
        }
        System.out.println("\n");
    }
    
    public void searchMovies(ArrayList<Pelicula> movies, Practica4 videoClub, Scanner lector) {
        System.out.println("¿Qué tipo de búsqueda deseas realizar?");
        System.out.println("1) por título");
        System.out.println("2) por director");
        System.out.println("3) por género");
        System.out.println("4) por año");
        System.out.println("5) por duración");
        Integer option = lector.nextInt();
        lector.nextLine();
        String searchString;
        Integer searchInteger;
        switch (option) {
                case 1:
                    System.out.println("Introduce el título:");
                    searchString = lector.nextLine();
                    movies.forEach((Pelicula movie) -> {
                        if (movie.getTitle().contains(searchString)) {
                            videoClub.listMovie(movie);
                        }
                    });
                    break;
                case 2:
                    System.out.println("Introduce el director:");
                    searchString = lector.nextLine();
                    movies.forEach((Pelicula movie) -> {
                        if (movie.getDirector().contains(searchString)) {
                            videoClub.listMovie(movie);
                        }
                    });
                    break;
                case 3:
                    System.out.println("Introduce el género:");
                    searchString = lector.nextLine();
                    movies.forEach((Pelicula movie) -> {
                        if (movie.getGender().contains(searchString)) {
                            videoClub.listMovie(movie);
                        }
                    });
                    break;
                case 4:
                    System.out.println("Introduce el año:");
                    searchInteger = lector.nextInt();
                    movies.forEach((Pelicula movie) -> {
                        if (Objects.equals(movie.getYear(), searchInteger)) {
                            videoClub.listMovie(movie);
                        }
                    });
                    break;
                case 5:
                    System.out.println("Introduce la duración:");
                    searchInteger = lector.nextInt();
                    movies.forEach((Pelicula movie) -> {
                        if (Objects.equals(movie.getDuration(), searchInteger)) {
                            videoClub.listMovie(movie);
                        }
                    });
                    break;
            }
    }

    
}
