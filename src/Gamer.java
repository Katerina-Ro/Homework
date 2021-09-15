import java.util.ArrayList;
import java.util.List;

public class Gamer {
    private final String nameGamer;
    private int numberPoints;

    public Gamer(String nameGamer, int numberPoints) {
        this.nameGamer = nameGamer;
        this.numberPoints = numberPoints;
    }

    public String getNameGamer() {
        return nameGamer;
    }

    public int getNumberPoints() {
        return numberPoints;
    }

    public void setNumberPoints(int numberPoints) {
        this.numberPoints = numberPoints;
    }

    @Override
    public String toString() {
        return " Игрок " +
                nameGamer + '\'' +
                ", количество очков = " + numberPoints;
    }

    public static void calculateTheWinner (String[] arr) {
        int maxPoints = 0;
        String nameWinner = null;

        List<Gamer> listGamer = new ArrayList<>();

        for (String s : arr) {
            int firstIndexSpace = s.indexOf(" ");
            String nameGamerArr = s.substring(0, firstIndexSpace);
            int numberPointsArr = Integer.parseInt(s.substring(firstIndexSpace + 1));

            if (!listGamer.isEmpty()) {
                for (int j = 0; j < listGamer.size(); j++) {
                    if (listGamer.get(j).getNameGamer().equalsIgnoreCase(nameGamerArr)) {
                        numberPointsArr = numberPointsArr + listGamer.get(j).getNumberPoints();
                        listGamer.get(j).setNumberPoints(numberPointsArr);
                        break;
                    } else if (!listGamer.get(j).getNameGamer().equalsIgnoreCase(nameGamerArr) && j == listGamer.size() - 1) {
                        Gamer gamer = new Gamer(nameGamerArr, numberPointsArr);
                        listGamer.add(gamer);
                        break;
                    }
                }
            } else {
                Gamer gamer = new Gamer(nameGamerArr, numberPointsArr);
                listGamer.add(gamer);
            }
        }
        for (Gamer g : listGamer) {
            maxPoints = g.getNumberPoints();

            for (Gamer gamer : listGamer) {
                if (gamer.getNumberPoints() > g.getNumberPoints()) {
                    maxPoints = gamer.getNumberPoints();
                    nameWinner = gamer.getNameGamer();
                    break;
                } else if (gamer.getNumberPoints() == g.getNumberPoints()) {
                    maxPoints = gamer.getNumberPoints();
                    nameWinner = gamer.getNameGamer();
                    break;
                }
            }
        }
        System.out.println("Имя победителя - " + nameWinner + "," + " количество очков = " + maxPoints);
    }
}
