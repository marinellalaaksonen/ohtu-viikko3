package statistics;

import statistics.Player;
import statistics.matcher.*;

public class QueryBuilder {
    private Matcher query;

    public QueryBuilder() {
        this.query = new All();
    }

    public QueryBuilder playsIn(String team) {
        this.query = new And(this.query, new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.query = new And(this.query, new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        this.query = new And(this.query, new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder not(Matcher matcher) {
        this.query = new And(this.query, new Not(matcher));
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.query = new And(this.query, new Or(matchers));
        return this;
    }

    public Matcher build() {
        return this.query;
    }
}