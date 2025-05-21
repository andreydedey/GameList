package com.codewithandrey.game.repositories;

import com.codewithandrey.game.dto.GameMinDTO;
import com.codewithandrey.game.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameListRepository extends JpaRepository<GameList, Long> {
    @Query("""
        SELECT new com.codewithandrey.game.dto.GameMinDTO(
            g.id, g.title, g.year, g.imgUrl, g.shortDescription, b.position)
        FROM GameBelongList b
        JOIN b.game g
        WHERE b.gameList.id = :listId
        ORDER BY b.position
""")
    List<GameMinDTO> searchByList(@Param("listId") Long listId);

}
