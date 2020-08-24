package ga.brunnofdc.fdchomes.objects;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Profile {

    private UUID uuid;
    private String name;
    private List<Home> homeList;

    public Profile(UUID uuid, String name, List<Home> homeList) {
        this.uuid = uuid;
        this.name = name;
        this.homeList = homeList;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public List<Home> getHomes() {
        return homeList;
    }

    public void setHomes(List<Home> homeList) {
        this.homeList = homeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return uuid.equals(profile.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
