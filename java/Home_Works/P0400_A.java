package Home_Work;
import java.util.*;

class P0400_A {
    String name;
    int favoriteNumber;
    int count = 0;

    P0400_A(String name) {
        this.name = name;
    }

    void chooseNumber(int number) {
        this.favoriteNumber = number;
    }

    void resetCount() {
        this.count = 0;
    }
}
