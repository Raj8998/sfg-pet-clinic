package springframework.sfgpetclinic.bootstrap;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.sfgpetclinic.model.*;
import springframework.sfgpetclinic.services.PetTypeService;
import springframework.sfgpetclinic.services.SpecialtyService;
import springframework.sfgpetclinic.services.map.OwnerServiceMap;
import springframework.sfgpetclinic.services.map.VetServiceMap;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerServiceMap ownerServiceMap;
    private final VetServiceMap vetServiceMap;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerServiceMap ownerServiceMap, VetServiceMap vetServiceMap, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerServiceMap = ownerServiceMap;
        this.vetServiceMap = vetServiceMap;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0 ){
            getData();
        }
    }

    private void getData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedPetTypeDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedPetTypeCat = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);


        Owner o1 = new Owner();
        o1.setFirstName("Raj");
        o1.setLastName("Pastagiya");

        Pet rajsPet = new Pet();
        rajsPet.setPetType(savedPetTypeDog);
        rajsPet.setDate(LocalDate.now());
        rajsPet.setOwner(o1);
        rajsPet.setName("Rosso");
        o1.getPets().add(rajsPet);


        ownerServiceMap.save(o1);

        Owner o2 = new Owner();
        o2.setFirstName("Sheraram");
        o2.setLastName("Prajapat");

        Pet sherasPet = new Pet();
        sherasPet.setPetType(savedPetTypeDog);
        sherasPet.setDate(LocalDate.now());
        sherasPet.setOwner(o2);
        sherasPet.setName("Sheru");
        o2.getPets().add(sherasPet);
        ownerServiceMap.save(o2);

        System.out.println("Owners loaded...!!!");

        Vet v1 = new Vet();
        v1.setFirstName("Raj");
        v1.setLastName("Pastagiya");
        v1.getSpecialties().add(savedRadiology);
        v1.getSpecialties().add(savedDentistry);

        vetServiceMap.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("Hardik");
        v2.setLastName("Soni");
        v2.getSpecialties().add(savedSurgery);

        vetServiceMap.save(v2);

        System.out.println("Vets loaded...!!!");
    }
}
