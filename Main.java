import java.util.ArrayList;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        RandomNumbers();
    }

    public static void RandomNumbers() {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();

        for (int x = 0; x < 100; x++) {                        // burada 0 ile 100 arasında random sayıları üretip listeye yazdırıyoruz.
            int randomNumber = random.nextInt(101);
            randomNumbers.add(randomNumber);
            System.out.println(randomNumber);
        }

        int desiredNumber = random.nextInt(101);         // rastgele 1 adet sayı üretelim.
        System.out.println("Desired Number:" + desiredNumber);

        boolean found = false;                                  //istenen sayının listede olup olmadığını kontrol edelim
        for (int i = 0; i < randomNumbers.size(); i++) {           // eğer listede var ise silelim
            if (randomNumbers.get(i) == desiredNumber) {
                randomNumbers.remove(Integer.valueOf(desiredNumber));
                found = true;
            }
        }

           System.out.println("new list:");
            for (int number : randomNumbers) {
                System.out.println(number);
            }
        }
    }


