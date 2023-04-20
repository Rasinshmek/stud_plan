package com.example.ymo.load;

import java.io.FileReader;
import java.util.Scanner;

public class LoadFromFile {
    public float coefConsZaoch;
    public float coefConsDnev1;
    public float coefConsDnev2;
    public float coefConsDistan;
    public float coefEkzam;
    public float coefView;
    public float coefDifZach;
    public float coefZach;
    public float coefRGR;
    public float coefPracticeUchebHour;
    public float coefPracticeUchebDay;
    public float coefPracticeProizvDnev;
    public float coefPracticeProizvZaoch1;
    public float coefPracticeProizvZaoch2;
    public float coefCursRab;
    public float coefCursProject;
    public float coefContrRab;
    public float coefDiplomRecenz;
    public float coefDiplomProekt;
    public float coefDiplomRabota;
    public float coefGEKZashDipl;
    public float coefGEKSpec;

    public LoadFromFile() throws Exception {
        FileReader fr = new FileReader("Coef.txt");
        Scanner scan = new Scanner(fr);

        coefConsZaoch = Float.parseFloat(scan.nextLine().split(": ")[1]);
        coefConsDnev1 = Float.parseFloat(scan.nextLine().split(": ")[1]);
        coefConsDnev2 = Float.parseFloat(scan.nextLine().split(": ")[1]);
        coefConsDistan = Float.parseFloat(scan.nextLine().split(": ")[1]);
        coefEkzam = Float.parseFloat(scan.nextLine().split(": ")[1]);
        coefView = Float.parseFloat(scan.nextLine().split(": ")[1]);
        coefDifZach = Float.parseFloat(scan.nextLine().split(": ")[1]);
        coefZach = Float.parseFloat(scan.nextLine().split(": ")[1]);
        coefRGR = Float.parseFloat(scan.nextLine().split(": ")[1]);
        coefPracticeUchebHour = Float.parseFloat(scan.nextLine().split(": ")[1]);
        coefPracticeUchebDay = Float.parseFloat(scan.nextLine().split(": ")[1]);
        coefPracticeProizvDnev = Float.parseFloat(scan.nextLine().split(": ")[1]);
        coefPracticeProizvZaoch1 = Float.parseFloat(scan.nextLine().split(": ")[1]);
        coefPracticeProizvZaoch2 = Float.parseFloat(scan.nextLine().split(": ")[1]);
        coefCursRab = Float.parseFloat(scan.nextLine().split(": ")[1]);
        coefCursProject = Float.parseFloat(scan.nextLine().split(": ")[1]);
        coefContrRab = Float.parseFloat(scan.nextLine().split(": ")[1]);
        coefDiplomRecenz = Float.parseFloat(scan.nextLine().split(": ")[1]);
        coefDiplomProekt = Float.parseFloat(scan.nextLine().split(": ")[1]);
        coefDiplomRabota = Float.parseFloat(scan.nextLine().split(": ")[1]);
        coefGEKZashDipl = Float.parseFloat(scan.nextLine().split(": ")[1]);
        coefGEKSpec = Float.parseFloat(scan.nextLine().split(": ")[1]);
        fr.close();
    }

    @Override
    public String toString() {
        return "LoadFromFile{" +
                "coefConsZaoch=" + coefConsZaoch +
                ", coefConsDnev1=" + coefConsDnev1 +
                ", coefConsDnev2=" + coefConsDnev2 +
                ", coefConsDistan=" + coefConsDistan +
                ", coefEkzam=" + coefEkzam +
                ", coefView=" + coefView +
                ", coefDifZach=" + coefDifZach +
                ", coefZach=" + coefZach +
                ", coefRGR=" + coefRGR +
                ", coefPracticeUchebHour=" + coefPracticeUchebHour +
                ", coefPracticeUchebDay=" + coefPracticeUchebDay +
                ", coefPracticeProizvDnev=" + coefPracticeProizvDnev +
                ", coefPracticeProizvZaoch1=" + coefPracticeProizvZaoch1 +
                ", coefPracticeProizvZaoch2=" + coefPracticeProizvZaoch2 +
                ", coefCursRab=" + coefCursRab +
                ", coefCursProject=" + coefCursProject +
                ", coefContrRab=" + coefContrRab +
                ", coefDiplomRecenz=" + coefDiplomRecenz +
                ", coefDiplomProekt=" + coefDiplomProekt +
                ", coefDiplomRabota=" + coefDiplomRabota +
                ", coefGEKZashDipl=" + coefGEKZashDipl +
                ", coefGEKSpec=" + coefGEKSpec +
                '}';
    }
}
