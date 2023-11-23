package com.example.report.data;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "players")
@Data @AllArgsConstructor @NoArgsConstructor
public class Player implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "person_id")
    private Long personId;

    @Column(name = "first_last_name", nullable = false)
    private String firstLastName;

    @Column(name = "last_comma_first_name", nullable = false)
    private String lastCommaFirstName;

    @Column(name = "from_year", nullable = false)
    private Integer fromYear;

    @Column(name = "to_year", nullable = false)
    private Integer toYear;

    @Column(name = "games_played_flag")
    private Character gamesPlayedFlag;

    @Column(name = "other_league_experience_ch")
    private String otherLeagueExperienceCh; //00 01 11

    @Column(name = "player_code")
    private String playerCode;

    @Column(name = "roster_status")
    private Boolean rosterStatus;

    @Column(name = "team_abbreviation")
    private String teamAbbreviation;

    @Column(name = "team_city")
    private String teamCity;

    @Column(name = "team_code")
    private String teamCode;

    @Column(name = "team_id")
    private Integer teamId;

    @Column(name = "team_name")
    private String teamName;
}
