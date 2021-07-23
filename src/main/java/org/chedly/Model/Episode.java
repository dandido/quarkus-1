package org.chedly.Model;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Episode extends PanacheEntity{
    
    //ce n'est pas une mauvaise pratique : Quarkus va trouver que c'est panache => il va convertir 
    //en private + gener get/set ;
    public String title;
    public String description;  

}
