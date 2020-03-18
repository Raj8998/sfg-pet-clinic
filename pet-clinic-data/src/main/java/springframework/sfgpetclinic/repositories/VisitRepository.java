package springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.sfgpetclinic.model.Visits;

public interface VisitRepository extends CrudRepository<Visits, Long> {
}
