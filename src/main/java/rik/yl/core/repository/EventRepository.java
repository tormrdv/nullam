package rik.yl.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rik.yl.core.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
