package project.tvshows.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import project.tvshows.model.Show;
import java.util.Optional;
import java.util.List;

public interface ShowsRepository extends JpaRepository<Show, Long> {
     Show findByName(String name);

    @Query(value = "select s.name from Show s where s.name LIKE '%:keyword%'", nativeQuery = true)
    Optional<Show> findByKeyword(@Param("keyword") String keyword);

    @Transactional
    List<Show> findAllByNameContaining(String keyword);

}
