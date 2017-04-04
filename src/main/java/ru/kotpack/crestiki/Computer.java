package ru.kotpack.crestiki;

import java.util.List;

/**
 * Created by kot on 31.03.17.
 */
public class Computer extends Igrok {

    private Pole pole = MainClass.igrovoePole;

    public void hod() {
        List<Cletka> freeCell = pole.getFreeCell();
        if(freeCell.isEmpty()){
            pole.setGameEnd(true);
        }

        int computerAnswer = getRandomFreeCell(freeCell);
        Cletka cletka = freeCell.get(computerAnswer);
        cletka.setZnachenie("o");
        freeCell.set(computerAnswer, cletka);
    }



    public static int getRandomFreeCell(List<Cletka> list){
        int res = (int) (Math.random()*list.size());
        return res;
    }
}
