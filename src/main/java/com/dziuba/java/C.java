package com.dziuba.java;

class C {

    public static void main(String[] args) {

        PetContainer dogContainer = new PetContainer<Dog> (new Dog());
        PetContainer catContainer = new PetContainer<Cat> (new Cat());
    }

}

abstract class Animal {
    abstract public String name();
}

abstract class Pet extends Animal {}

class Cat extends Pet {
  public String name() {
      return "Cat";
  }
}

class Dog extends Pet {
    public String name() {
        return "Dog";
    }
}

class Lion extends Animal {
    public String name() {
        return "Lion";
    }
}

class PetContainer<Pet> {
    private Pet pet;

    public PetContainer(Pet pet) {
        this.pet = pet;
    }
}
