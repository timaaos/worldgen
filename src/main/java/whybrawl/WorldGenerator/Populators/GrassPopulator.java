package whybrawl.WorldGenerator.Populators;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

public class GrassPopulator extends BlockPopulator {
    @Override
    public void populate(World world, Random random, Chunk chunk) {
        for (int i = 0; i < random.nextInt(16)+6; i++) {
            int X = random.nextInt(16);
            int Z = random.nextInt(16);
            int Y;
            for (Y = world.getMaxHeight() - 1; chunk.getBlock(X, Y, Z).getType() == Material.AIR; Y--);
            Material grassBlock = Material.LONG_GRASS;
            if(chunk.getBlock(X,Y,Z).getBiome().equals(Biome.DESERT) || chunk.getBlock(X,Y,Z).getBiome().equals(Biome.DESERT_HILLS)){
                grassBlock = Material.DEAD_BUSH;
            }
            if(!chunk.getBlock(X,Y,Z).getType().equals(Material.GRASS))
            {
                continue;
            }
            if(grassBlock.equals(Material.LONG_GRASS))
            {
                chunk.getBlock(X, Y+1, Z).setType(Material.LONG_GRASS);
                chunk.getBlock(X, Y+1, Z).setData((byte)1);
            }else if(grassBlock.equals(Material.DEAD_BUSH))
            {
                chunk.getBlock(X, Y+1, Z).setType(Material.DEAD_BUSH);
            }

        }

    }
}
