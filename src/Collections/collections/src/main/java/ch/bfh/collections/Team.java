package ch.bfh.collections;

import java.util.*;

public class Team {

    private List<Player> players;

    public Team() {
        players = new ArrayList<Player>();
        players.add(new Player("John"));
        players.add(new Player("Marie"));
        players.add(new Player("Bill"));
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public List<Player> getPlayers2() {
        return new ArrayList<Player>(this.players);
    }

    public Iterator<Player> getPlayers3() {
        return this.players.iterator();
    }

    public List<Player> getPlayers4() {
        return Collections.unmodifiableList(players);
    }
}