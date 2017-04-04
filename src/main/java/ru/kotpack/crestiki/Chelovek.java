package ru.kotpack.crestiki;

/**
 * Created by kot on 31.03.17.
 */
public class Chelovek extends Igrok{


    private Pole pole = MainClass.igrovoePole;

    public void hod() {
        ConsoleHelper.writeMessage("Vvedite koordinatj i j cherez probel");
        String coord = ConsoleHelper.readString();
        String[] massiv = coord.split(" ");

        if (massiv.length == 2) {


            try {
                int i = Integer.parseInt(massiv[0]);
                int j = Integer.parseInt(massiv[1]);

                if (i > 3 || j > 3 || i < 0 || j < 0) {
                    hod();
                }


                Cletka[][] cletki = pole.getPole();
                if (cletki[i][j].getZnachenie() == null) {
                    cletki[i][j].setZnachenie("x");
                } else {
                    hod();
                }


            } catch (NumberFormatException e) {
                hod();
            }

        } else {
            hod();
        }
    }

}
