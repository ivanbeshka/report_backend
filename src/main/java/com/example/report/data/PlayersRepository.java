package com.example.report.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PlayersRepository extends JpaRepository<Player, Long> {

    @Query(value = "SELECT * FROM players ORDER BY \"to_year\" - \"from_year\" DESC LIMIT 20", nativeQuery = true)
    List<Player> selectPlayersWithLongestCareer();

    List<Player> findByTeamNameNotNull();
}