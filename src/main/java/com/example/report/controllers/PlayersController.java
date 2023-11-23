package com.example.report.controllers;

import com.example.report.controllers.models.Career;
import com.example.report.controllers.models.Command;
import com.example.report.data.Player;
import com.example.report.data.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class PlayersController {
    private PlayersRepository playersRepository;

    @Autowired
    public PlayersController(PlayersRepository playersRepository) {
        this.playersRepository = playersRepository;
    }

    @GetMapping("/longest-career")
    public List<Career> getLongestCareerList() {
        return playersRepository.selectPlayersWithLongestCareer()
                .stream()
                .map(player -> new Career(
                        player.getFirstLastName(),
                        player.getToYear() - player.getFromYear()
                        )
                )
                .toList();
    }

    @GetMapping("/players-in-commands")
    public List<Command> getCommandsWithPlayersNumber() {
        return playersRepository.findByTeamNameNotNull()
                .stream()
                .filter(player -> !Objects.equals(player.getTeamName(), ""))
                .collect(Collectors.groupingBy(Player::getTeamName))
                .entrySet()
                .stream()
                .map(entry -> new Command(entry.getKey(), entry.getValue().size()))
                .toList();
    }
}
