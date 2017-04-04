package ru.kotpack.crestiki;

/**
 * Created by kot on 31.03.17.
 */
public abstract class Igrok implements PovedenieIgroka{

    private String name;
    private Pole igrovoePole = MainClass.igrovoePole;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }


}
