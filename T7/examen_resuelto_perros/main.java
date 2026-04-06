package U7_collections.en_clase.concurso_canino;

public class main {
	public static void main(String[] args) {
		Concurso concurso = new Concurso();

		Perro p1 = new Perro("Sánchez", "Pitbull");
		Perro p2 = new Perro("Trump", "Terrier");
		Perro p3 = new Perro("Chucho", "Pitbull");
		Perro p4 = new Perro("Animal", "Pitbull");

//		concurso.addDog("Presa canario", p4);
		concurso.addDog("Pitbull", p1);
		concurso.addDog("Terrier", p2);
		concurso.addDog("Pitbull", p3);

		System.out.println(concurso);

		concurso.disqualifyDog(p4);
		concurso.disqualifyDog(p2);

		System.out.println(concurso);


	}
}
