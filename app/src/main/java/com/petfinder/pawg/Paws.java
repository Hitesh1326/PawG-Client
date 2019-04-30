package com.petfinder.pawg;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * This class is the model of the object which is used to get description and images of the pets.
 */

public class Paws {

    @SerializedName("AnimalDesc")
    @Expose
    private String AnimalDesc;

    @SerializedName("img")
    @Expose
    private String img;

    public Paws(String animalDesc, String img) {
        AnimalDesc = animalDesc;
        this.img = img;
    }


    public String getAnimalDesc() {
        return AnimalDesc;
    }

    public void setAnimalDesc(String AnimalDesc) {
        this.AnimalDesc = AnimalDesc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
