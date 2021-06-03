package whybrawl.WorldGenerator.Populators;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

public class BushPopulator extends BlockPopulator {
    @Override
    public void populate(World world, Random random, Chunk chunk) {
        if (random.nextBoolean()) {
            if(random.nextInt(100)<80)
            {
                int X = random.nextInt(15);
                int Z = random.nextInt(15);
                int Y;
                for (Y = world.getMaxHeight() - 1; chunk.getBlock(X, Y, Z).getType() == Material.AIR; Y--);
                chunk.getBlock(X,Y,Z).setType(Material.LOG);
                Y=Y+1;
                        if (chunk.getBlock(X,Y,Z).getType() == Material.AIR) {
                            Boolean isStone = true;
                            while (isStone) {
                                chunk.getBlock(X,Y,Z).setType(Material.LEAVES);
                                if (random.nextInt(100) < 99)  {   // The chance of continuing the vein
                                    switch (random.nextInt(6)) {  // The direction chooser
                                        case 0: X++; break;
                                        case 1: Y--; break;
                                        case 2: Z++; break;
                                        case 3: X--; break;
                                        case 4: Y--; break;
                                        case 5: Z--; break;
                                    }
                                    isStone = (chunk.getBlock(X,Y,Z).getType() == Material.AIR) && (chunk.getBlock(X,Y,Z).getType() != Material.LEAVES) && (chunk.getBlock(X,Y,Z).getType() != Material.LOG);
                                } else isStone = false;
                            }
                        }
                    }
                }
            }
        }