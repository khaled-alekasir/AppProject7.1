package Model;

import java.util.List;

public abstract class Filter extends Object {
    abstract public List<Music> filter(List<Music> musics);

    @Override
    public boolean equals(Object obj) {
        return this.getClass().getName().equals(obj.getClass().getName());
    }

    @Override
    public int hashCode() {
        return this.getClass().getName().hashCode();
    }
}
