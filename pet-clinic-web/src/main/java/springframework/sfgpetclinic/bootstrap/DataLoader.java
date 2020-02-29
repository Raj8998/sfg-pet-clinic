package springframework.sfgpetclinic.bootstrap;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.sfgpetclinic.model.Owner;
import springframework.sfgpetclinic.model.PetType;
import springframework.sfgpetclinic.model.Vet;
import springframework.sfgpetclinic.services.map.OwnerServiceMap;
import springframework.sfgpetclinic.services.map.PetTypeServiceMap;
import springframework.sfgpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerServiceMap ownerServiceMap;
    private final VetServiceMap vetServiceMap;
    private final PetTypeServiceMap petTypeServiceMap;

    public DataLoader(OwnerServiceMap ownerServiceMap, VetServiceMap vetServiceMap, PetTypeServiceMap petTypeServiceMap) {
        this.ownerServiceMap = ownerServiceMap;
        this.vetServiceMap = vetServiceMap;
        this.petTypeServiceMap = petTypeServiceMap;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedPetTypeDog = petTypeServiceMap.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedPetTypeCat = petTypeServiceMap.save(cat);

        Owner o1 = new Owner();
        o1.setFirstName("Raj");
        o1.setLastName("Pastagiya");

        ownerServiceMap.save(o1);

        Owner o2 = new Owner();
        o2.setFirstName("Sheraram");
        o2.setLastName("Prajapat");

        ownerServiceMap.save(o2);

        System.out.println("Owners loaded...!!!");

        Vet v1 = new Vet();
        v1.setFirstName("Raj");
        v1.setLastName("Pastagiya");

        vetServiceMap.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("Hardik");
        v2.setLastName("Soni");

        vetServiceMap.save(v2);

        System.out.println("Vets loaded...!!!");
    }
}
