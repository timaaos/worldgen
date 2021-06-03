package whybrawl.WorldGenerator;
import org.bukkit.event.Listener;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.*;

public final class Main extends JavaPlugin implements Listener{
    public static final List<String> villagernames = new ArrayList<>();
    @Override
    public void onEnable() {
        villagernames.add("Max");
        villagernames.add("Bob");
        villagernames.add("Nick");
        villagernames.add("Grandfather");
        villagernames.add("Kid");
        villagernames.add("George");
        villagernames.add("Fat");
        villagernames.add("Big Brain");
    }
    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return new CustomChunkGenerator();
    }
    @Override
    public void onDisable() {
    }
}
