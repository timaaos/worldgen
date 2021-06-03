package whybrawl.WorldGenerator.Populators;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

public class LakePopulator extends BlockPopulator {
    @Override
    public void populate(World world, Random random, Chunk source) {
        int chunkX = source.getX();
        int chunkZ = source.getZ();
        int ystart = 60;
        int y = ystart;
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                while(world.getChunkAt(chunkX,chunkZ).getBlock(x,y,z).getType().equals(Material.AIR)){
                    world.getChunkAt(chunkX,chunkZ).getBlock(x,y,z).setType(Material.WATER);
                    y--;
                }
                world.getChunkAt(chunkX,chunkZ).getBlock(x,y,z).setType(Material.SAND);
                y = ystart;
            }
        }
    }
}
