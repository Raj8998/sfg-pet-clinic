package springframework.sfgpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springframework.sfgpetclinic.model.Owner;
import springframework.sfgpetclinic.model.Pet;
import springframework.sfgpetclinic.services.OwnerService;
import springframework.sfgpetclinic.services.PetService;
import springframework.sfgpetclinic.services.PetTypeService;

import java.util.Set;

@Service
@Profile({"map","default"})
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll().
                stream().
                filter(owner -> owner.getLastName().equalsIgnoreCase(lastName)).
                findFirst().
                orElse(null);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if(object != null)
        {
            if(object.getPets() != null)
            {
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null)
                    {
                        if(pet.getPetType().getId() == null)
                        {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }
                    else
                    {
                        throw new RuntimeException("Pet type in required...!!!");
                    }
                    if(pet.getId() == null)
                    {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        }
        else
        {
            throw new RuntimeException("Objects cannot be null");
        }

    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
