package springframework.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import springframework.sfgpetclinic.model.Visits;
import springframework.sfgpetclinic.services.VisitService;

import java.util.Set;


@Service
public class VisitServiceMap extends AbstractMapService<Visits, Long> implements VisitService {
    @Override
    public Set<Visits> findAll() {
        return super.findAll();
    }

    @Override
    public Visits findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visits save(Visits object) {
        if(object.getPet() == null || object.getPet().getId() == null ||
                object.getPet().getOwner() == null || object.getPet().getOwner().getId() == null)
        {
            throw new RuntimeException("Invalid Visit Entity Exception");
        }
        return super.save(object);
    }

    @Override
    public void delete(Visits object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
