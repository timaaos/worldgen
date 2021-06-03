package whybrawl.WorldGenerator;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;
import whybrawl.WorldGenerator.Populators.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomChunkGenerator extends ChunkGenerator {
    // Remember this
    int currentHeight = 50;

    @Override
    public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) {
        SimplexOctaveGenerator generator = new SimplexOctaveGenerator(new Random(world.getSeed()), 8);
        ChunkData chunk = createChunkData(world);
        generator.setScale(0.005D);
        Material stoneblock = Material.STONE;
        Material grassblock = Material.GRASS;
        Material dirtblock = Material.DIRT;
        for (int X = 0; X < 16; X++)
            for (int Z = 0; Z < 16; Z++) {
                currentHeight = (int) (generator.noise(chunkX*16+X, chunkZ*16+Z, 0.5D, 0.5D)*15D+50D);
                if(biome.getBiome(X,Z).equals(Biome.DESERT) || biome.getBiome(X,Z).equals(Biome.DESERT_HILLS))
                {
                    stoneblock = Material.SANDSTONE;
                    grassblock = Material.SAND;
                    dirtblock = Material.SAND;
                }
                chunk.setBlock(X, currentHeight, Z, grassblock);
                chunk.setBlock(X, currentHeight-1, Z, dirtblock);
                for (int i = currentHeight-2; i > 0; i--)
                    chunk.setBlock(X, i, Z, stoneblock);
                chunk.setBlock(X, 0, Z, Material.BEDROCK);
            }
        int X, Y, Z;
        boolean isStone;
        for (int i = 1; i < 25; i++) {  // Number of tries
            if (random.nextInt(100) < 80) {  // The chance of spawning
                X = random.nextInt(15);
                Z = random.nextInt(15);
                Y = random.nextInt(180)+10;  // Get randomized coordinates
                if (chunk.getType(X,Y,Z) == Material.STONE) {
                    isStone = true;
                    while (isStone) {
                        chunk.setBlock(X,Y,Z,Material.COAL_ORE);
                        if (random.nextInt(100) < 80)  {   // The chance of continuing the vein
                            switch (random.nextInt(6)) {  // The direction chooser
                                case 0: X++; break;
                                case 1: Y++; break;
                                case 2: Z++; break;
                                case 3: X--; break;
                                case 4: Y--; break;
                                case 5: Z--; break;
                            }
                            isStone = (chunk.getType(X,Y,Z) == Material.STONE) && (chunk.getType(X,Y,Z) != Material.COAL_ORE);
                        } else isStone = false;
                    }
                }
            }
        }
        //GOLD
        for (int i = 1; i < 15; i++) {  // Number of tries
            if (random.nextInt(100) < 40) {  // The chance of spawning
                X = random.nextInt(15);
                Z = random.nextInt(15);
                Y = random.nextInt(25)+10;  // Get randomized coordinates
                if (chunk.getType(X,Y,Z) == Material.STONE) {
                    isStone = true;
                    while (isStone) {
                        chunk.setBlock(X,Y,Z,Material.GOLD_ORE);
                        if (random.nextInt(100) < 40)  {   // The chance of continuing the vein
                            switch (random.nextInt(6)) {  // The direction chooser
                                case 0: X++; break;
                                case 1: Y++; break;
                                case 2: Z++; break;
                                case 3: X--; break;
                                case 4: Y--; break;
                                case 5: Z--; break;
                            }
                            isStone = (chunk.getType(X,Y,Z) == Material.STONE) && (chunk.getType(X,Y,Z) != Material.GOLD_ORE);
                        } else isStone = false;
                    }
                }
            }
        }
        //EMERALD
        for (int i = 1; i < 2; i++) {  // Number of tries
            if (random.nextInt(100) < 5) {  // The chance of spawning
                X = random.nextInt(15);
                Z = random.nextInt(15);
                Y = random.nextInt(25)+10;  // Get randomized coordinates
                if (chunk.getType(X,Y,Z) == Material.STONE) {
                    chunk.setBlock(X,Y,Z,Material.EMERALD_ORE);
                }
            }
        }
        //DIAMOND
        for (int i = 1; i < 5; i++) {  // Number of tries
            if (random.nextInt(100) < 30) {  // The chance of spawning
                X = random.nextInt(15);
                Z = random.nextInt(15);
                Y = random.nextInt(12)+2;  // Get randomized coordinates
                if (chunk.getType(X,Y,Z) == Material.STONE) {
                    isStone = true;
                    while (isStone) {
                        chunk.setBlock(X,Y,Z,Material.DIAMOND_ORE);
                        if (random.nextInt(100) < 20)  {   // The chance of continuing the vein
                            switch (random.nextInt(6)) {  // The direction chooser
                                case 0: X++; break;
                                case 1: Y++; break;
                                case 2: Z++; break;
                                case 3: X--; break;
                                case 4: Y--; break;
                                case 5: Z--; break;
                            }
                            isStone = (chunk.getType(X,Y,Z) == Material.STONE) && (chunk.getType(X,Y,Z) != Material.DIAMOND_ORE);
                        } else isStone = false;
                    }
                }
            }
        }
        //IRON
        for (int i = 1; i < 20; i++) {  // Number of tries
            if (random.nextInt(100) < 70) {  // The chance of spawning
                X = random.nextInt(15);
                Z = random.nextInt(15);
                Y = random.nextInt(35)+10;  // Get randomized coordinates
                if (chunk.getType(X,Y,Z) == Material.STONE) {
                    isStone = true;
                    while (isStone) {
                        chunk.setBlock(X,Y,Z,Material.IRON_ORE);
                        if (random.nextInt(100) < 70)  {   // The chance of continuing the vein
                            switch (random.nextInt(6)) {  // The direction chooser
                                case 0: X++; break;
                                case 1: Y++; break;
                                case 2: Z++; break;
                                case 3: X--; break;
                                case 4: Y--; break;
                                case 5: Z--; break;
                            }
                            isStone = (chunk.getType(X,Y,Z) == Material.STONE) && (chunk.getType(X,Y,Z) != Material.IRON_ORE);
                        } else isStone = false;
                    }
                }
            }
        }
        //REDSTONE
        for (int i = 1; i < 15; i++) {  // Number of tries
            if (random.nextInt(100) < 30) {  // The chance of spawning
                X = random.nextInt(15);
                Z = random.nextInt(15);
                Y = random.nextInt(25)+4;  // Get randomized coordinates
                if (chunk.getType(X,Y,Z) == Material.STONE) {
                    isStone = true;
                    while (isStone) {
                        chunk.setBlock(X,Y,Z,Material.REDSTONE_ORE);
                        if (random.nextInt(100) < 60)  {   // The chance of continuing the vein
                            switch (random.nextInt(6)) {  // The direction chooser
                                case 0: X++; break;
                                case 1: Y++; break;
                                case 2: Z++; break;
                                case 3: X--; break;
                                case 4: Y--; break;
                                case 5: Z--; break;
                            }
                            isStone = (chunk.getType(X,Y,Z) == Material.STONE) && (chunk.getType(X,Y,Z) != Material.REDSTONE_ORE);
                        } else isStone = false;
                    }
                }
            }
        }
        //LAPIS
        for (int i = 1; i < 15; i++) {  // Number of tries
            if (random.nextInt(100) < 20) {  // The chance of spawning
                X = random.nextInt(15);
                Z = random.nextInt(15);
                Y = random.nextInt(25)+10;  // Get randomized coordinates
                if (chunk.getType(X,Y,Z) == Material.STONE) {
                    isStone = true;
                    while (isStone) {
                        chunk.setBlock(X,Y,Z,Material.LAPIS_ORE);
                        if (random.nextInt(100) < 20)  {   // The chance of continuing the vein
                            switch (random.nextInt(6)) {  // The direction chooser
                                case 0: X++; break;
                                case 1: Y++; break;
                                case 2: Z++; break;
                                case 3: X--; break;
                                case 4: Y--; break;
                                case 5: Z--; break;
                            }
                            isStone = (chunk.getType(X,Y,Z) == Material.STONE) && (chunk.getType(X,Y,Z) != Material.LAPIS_ORE);
                        } else isStone = false;
                    }
                }
            }
        }
        return chunk;
    }
    @Override
    public List<BlockPopulator> getDefaultPopulators(World world) {
        List<BlockPopulator> list = new ArrayList<>();
        list.add(new LakePopulator());
        list.add(new BushPopulator());
        list.add(new TreePopulator());
        list.add(new GrassPopulator());
        return list;
    }
}