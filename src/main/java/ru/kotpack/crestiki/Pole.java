package ru.kotpack.crestiki;

import java.util.ArrayList;
import java.util.List;

public class Pole {

    private Cletka[][] pole;
    private boolean gameEnd;
    private boolean hasWinner;
    private Igrok winner;

    public Igrok getWinner() {
        return winner;
    }

    public boolean isHasWinner() {
        return hasWinner;
    }


    public boolean isGameEnd() {
        return gameEnd;
    }

    public void setGameEnd(boolean gameEnd) {
        this.gameEnd = gameEnd;
    }

    public Cletka[][] getPole() {
        return pole;
    }

    public void setPole(Cletka[][] pole) {
        this.pole = pole;
    }

    public void ustanovkaPola() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pole[i][j] = new Cletka();
            }
        }
    }

    public void pechatPola(){
        for(int i=0; i<3;i++){
            for(int j=0; j<3;j++){
                if(pole[i][j].getZnachenie()!=null)
                    System.out.print(pole[i][j].getZnachenie());

                else System.out.print("*");
            }
            System.out.println();
        }
    }

    public List<Cletka> getFreeCell(){
        List<Cletka> res = new ArrayList<Cletka>();
        for(int i = 0; i<3 ; i++){
            for(int j = 0; j<3; j++){
                if(pole[i][j].getZnachenie()==null){
                    res.add(pole[i][j]);
                }
            }
        }
        return res;
    }


    public void findHasWinner() {

        String winConditionO = "ooo";
        String winConditionX = "xxx";

        StringBuilder diag1 = new StringBuilder();
        StringBuilder diag2 = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            StringBuilder hor = new StringBuilder();
            StringBuilder vert = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                hor.append(pole[i][j].getZnachenie());
                vert.append(pole[j][i].getZnachenie());
                if (i == j) {
                    diag1.append(pole[i][j].getZnachenie());
                }

                if (i + j == 2 || Math.abs(i - j) == 2) {
                    diag2.append(pole[i][j].getZnachenie());
                }
            }

            List<String> listSb = new ArrayList<String>();
            listSb.add(hor.toString());
            listSb.add(vert.toString());
            listSb.add(diag1.toString());
            listSb.add(diag2.toString());

            if(listSb.contains(winConditionO) || listSb.contains(winConditionX)){
                hasWinner=true;
                break;
            }
        }
    }

    public void checkTheGameEnd(){
        List<Cletka> freeCell = getFreeCell();
        if(freeCell.isEmpty()){
            gameEnd = true;
        }
        else {
            gameEnd = false;
        }
    }

    public void checkTheWinner(Igrok igrok){
        if (isHasWinner()) {
            winner = igrok;
            pechatPola();
            ConsoleHelper.writeMessage("we have a winner!");
            ConsoleHelper.writeMessage("the winner is " + winner);
            gameEnd = true;
        }
    }
}
