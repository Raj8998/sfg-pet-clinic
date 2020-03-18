package springframework.sfgpetclinic.bootstrap;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.sfgpetclinic.model.*;
import springframework.sfgpetclinic.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
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


        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setFirstName("Sheraram");
        o2.setLastName("Prajapat");

        Pet sherasPet = new Pet();
        sherasPet.setPetType(savedPetTypeCat);
        sherasPet.setDate(LocalDate.now());
        sherasPet.setOwner(o2);
        sherasPet.setName("Sheru");
        o2.getPets().add(sherasPet);
        ownerService.save(o2);

        Visits catVisit = new Visits();
        catVisit.setPet(sherasPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sheraram got no chill");

        visitService.save(catVisit);




        System.out.println("Owners loaded...!!!");

        Vet v1 = new Vet();
        v1.setFirstName("Raj");
        v1.setLastName("Pastagiya");
        v1.getSpecialties().add(savedRadiology);
        v1.getSpecialties().add(savedDentistry);

        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("Hardik");
        v2.setLastName("Soni");
        v2.getSpecialties().add(savedSurgery);

        vetService.save(v2);

        System.out.println("Vets loaded...!!!");



        System.out.println("Visits loaded...!!!");
    }
}
