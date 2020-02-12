/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.util.Objects;

/**
 *
 * @author Mamey
 */
public class Pelicula {
    
    private Integer id;
    private String title;
    private String director;
    private Integer duration;
    private String gender;
    private Integer year;
    private Boolean availability;
    private Integer copies;
    private Integer reservedCopies;

    public Pelicula(Integer id, String title, String director, Integer duration, String gender, Integer year, Boolean availability, Integer copies, Integer reservedCopies) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.duration = duration;
        this.gender = gender;
        this.year = year;
        this.availability = availability;
        this.copies = copies;
        this.reservedCopies = reservedCopies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Boolean getAvailability() {
        return !Objects.equals(this.getCopies(), this.getReservedCopies());
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public Integer getReservedCopies() {
        return reservedCopies;
    }

    public void setReservedCopies(Integer reservedCopies) {
        this.reservedCopies = reservedCopies;
    }

    
}
