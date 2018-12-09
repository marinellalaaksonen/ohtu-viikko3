package statistics.matcher;

import statistics.Player;

public class HasFewerThan implements Matcher {
    
    private Matcher NotHasAtLeast;

    public HasFewerThan(int value, String category) {
        this.NotHasAtLeast = new Not(new HasAtLeast(value, category));
    }

    @Override
    public boolean matches(Player p) {
        return NotHasAtLeast.matches(p);
    }       
}