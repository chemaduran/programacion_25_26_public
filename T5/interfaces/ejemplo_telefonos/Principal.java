package U5_herencia_interfaces.teoria.interfaces.ejemplo_telefonos;

import U5_herencia_interfaces.teoria.interfaces.ejemplo_telefonos.telefonos.IPhone8;

public class Principal {

  public static void main(String[] args) {

    Persona p = new Persona();
    p.setNombre("juan");
    p.setHuella("huella1");

    IPhone8 telefono = new IPhone8("apple", p);

    telefono.setHuella("huella1");
    System.out.println(telefono.validar(p));

    Persona p1 = new Persona();
    p1.setNombre("gema");
    p1.setHuella("huella2");
    System.out.println(telefono.validar(p1));
  }
}
