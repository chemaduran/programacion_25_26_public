package U1_intro_bucles_condicionales.teoria;

public class bucles {
  public static void main(String[] args) {
    //
    int x = 1;
    while (x <= 5) {
      System.out.println(x);
      x++;
    }

    System.out.println();

    int y = 1;
    do {
      System.out.println(y);
      y++;
    } while (y <= 5);

    System.out.println();
    for (int z = 1; z <= 5; z++) {
      System.out.println(z);
    }
  }
}
