package ru.kotpack.crestiki;

public class MainClass {

    public static Pole igrovoePole;

    public static void main(String[] args) {

        igrovoePole = new Pole();
        igrovoePole.setPole(new Cletka[3][3]);
        igrovoePole.ustanovkaPola();

        Computer computer = new Computer();
        computer.setName("computer");

        Chelovek chelovek = new Chelovek();
        ConsoleHelper.writeMessage("hello, how you doing, what's your name??");
        String name = ConsoleHelper.readString();
        chelovek.setName(name);


        while (true) {

            mainCourse(chelovek);
            if(igrovoePole.getWinner()!=null){break;}
            if (igrovoePole.isGameEnd()) break;

            mainCourse(computer);
            if(igrovoePole.getWinner()!=null){break;}
            if (igrovoePole.isGameEnd()) break;

            igrovoePole.pechatPola();
        }
    }

    public static void mainCourse(Igrok igrok){
        igrok.hod();
        igrovoePole.findHasWinner();
        igrovoePole.checkTheWinner(igrok);
        igrovoePole.checkTheGameEnd();
    }
}
