package springframework.sfgpetclinic.bootstrap;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.sfgpetclinic.model.Owner;
import springframework.sfgpetclinic.model.Vet;
import springframework.sfgpetclinic.services.map.OwnerServiceMap;
import springframework.sfgpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerServiceMap ownerServiceMap;
    private final VetServiceMap vetServiceMap;

    public DataLoader(OwnerServiceMap ownerServiceMap, VetServiceMap vetServiceMap) {
        this.ownerServiceMap = ownerServiceMap;
        this.vetServiceMap = vetServiceMap;
    }

    @Override
    public void run(String... args) throws Exception {


        Owner o1 = new Owner();
        o1.setId(1L);
        o1.setFirstName("Raj");
        o1.setLastName("Pastagiya");

        ownerServiceMap.save(o1);

        Owner o2 = new Owner();
        o2.setId(2L);
        o2.setFirstName("Sheraram");
        o2.setLastName("Prajapat");

        ownerServiceMap.save(o2);

        System.out.println("Owners loaded...!!!");

        Vet v1 = new Vet();
        v1.setId(1L);
        v1.setFirstName("Raj");
        v1.setLastName("Pastagiya");

        vetServiceMap.save(v1);

        Vet v2 = new Vet();
        v2.setId(2L);
        v2.setFirstName("Hardik");
        v2.setLastName("Soni");

        vetServiceMap.save(v2);

        System.out.println("Vets loaded...!!!");
    }
}
