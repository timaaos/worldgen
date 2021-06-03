package whybrawl.WorldGenerator.Populators;

import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

public class TreePopulator extends BlockPopulator {
    @Override
    public void populate(World world, Random random, Chunk chunk) {
        if (random.nextBoolean()) {
            int amount = random.nextInt(4) + 1;  // Amount of trees
            /*for (int i = 1; i < amount; i++) {
                int X = random.nextInt(15);
                int Z = random.nextInt(15);
                int Y;
                for (Y = world.getMaxHeight()-1; chunk.getBlock(X, Y, Z).getType() == Material.AIR; Y--); // Find the highest block of the (X,Z) coordinate chosen.
                world.generateTree(chunk.getBlock(X, Y, Z).getLocation(), TreeType.TREE); // The tree type can be changed if you want.
            }*/
            for (int i = 1; i < amount; i++) {
                int X = random.nextInt(15);
                int Z = random.nextInt(15);
                int Y;
                for (Y = world.getMaxHeight() - 1; chunk.getBlock(X, Y, Z).getType() == Material.AIR; Y--)
                    ; // Find the highest block of the (X,Z) coordinate chosen.
                int treeheight = random.nextInt(7);
                int cY = Y;
                for (int j = 0; j < treeheight; j++) {
                    cY = cY + 1;
                    chunk.getBlock(X, cY, Z).setType(Material.LOG);
                }
                Y=cY-1;
                if(chunk.getBlock(X,Y,Z).getBiome().equals(Biome.DESERT) || chunk.getBlock(X,Y,Z).getBiome().equals(Biome.DESERT_HILLS))
                {
                    chunk.getBlock(X+1, Y, Z).setType(Material.LOG);
                    chunk.getBlock(X-1, Y, Z).setType(Material.LOG);
                    chunk.getBlock(X, Y, Z-1).setType(Material.LOG);
                    chunk.getBlock(X, Y, Z+1).setType(Material.LOG);
                }else if(chunk.getBlock(X,Y,Z).getBiome().equals(Biome.JUNGLE) || chunk.getBlock(X,Y,Z).getBiome().equals(Biome.JUNGLE_EDGE) || chunk.getBlock(X,Y,Z).getBiome().equals(Biome.JUNGLE_HILLS) || chunk.getBlock(X,Y,Z).getBiome().equals(Biome.MUTATED_JUNGLE_EDGE) || chunk.getBlock(X,Y,Z).getBiome().equals(Biome.MUTATED_JUNGLE))
                {
                    int cX = X;
                    int cZ = Z-1;
                    cY = Y-treeheight;
                    for (int j = 0; j < treeheight; j++) {
                        cY = cY + 1;
                        chunk.getBlock(cX, cY, cZ).setType(Material.LOG);
                    }
                    cX = X-1;
                    cZ = Z;
                    cY = Y-treeheight;
                    for (int j = 0; j < treeheight; j++) {
                        cY = cY + 1;
                        chunk.getBlock(cX, cY, cZ).setType(Material.LOG);
                    }
                    cX = X-1;
                    cZ = Z-1;
                    cY = Y-treeheight;
                    for (int j = 0; j < treeheight; j++) {
                        cY = cY + 1;
                        chunk.getBlock(cX, Y, cZ).setType(Material.LOG);
                    }
                    int ccx = X-4;
                    int ccz = Z-4;
                    int size = 7;
                    for (int j = 0; j < 4; j++) {
                        Y = Y + 1;

                        for (int s = 0; s < size; s++) {
                            ccx = ccx + 1;
                            for (int a = 0; a < size; a++) {
                                ccz = ccz + 1;
                                if(world.getBlockAt(new Location(world, chunk.getX() * 16 + ccx, Y, chunk.getZ() * 16 + ccz)).getType() != Material.LOG)
                                {
                                    world.getBlockAt(new Location(world, chunk.getX() * 16 + ccx, Y, chunk.getZ() * 16 + ccz)).setType(Material.LEAVES);
                                    world.getBlockAt(new Location(world, chunk.getX() * 16 + ccx, Y, chunk.getZ() * 16 + ccz)).setData((byte) 3);
                                }

                            }
                            ccz = (int) (Z-(Math.floor(size/2)+1));
                        }
                        size=size-1;
                        ccx = (int) (X-(Math.floor(size/2)+1));

                    }
                }else {
                    if(random.nextInt(100)<30)
                    {
                        int cx = X-3;
                        int cz = Z-3;
                        int size = 5;
                        for (int j = 0; j < 5; j++) {
                            Y = Y + 1;

                            for (int s = 0; s < size; s++) {
                                cx = cx + 1;
                                for (int a = 0; a < size; a++) {
                                    cz = cz + 1;
                                    if(world.getBlockAt(new Location(world, chunk.getX() * 16 + cx, Y, chunk.getZ() * 16 + cz)).getType() != Material.LOG)
                                    {
                                        world.getBlockAt(new Location(world, chunk.getX() * 16 + cx, Y, chunk.getZ() * 16 + cz)).setType(Material.LEAVES);
                                    }

                                }
                                cz = (int) (Z-(Math.floor(size/2)+1));
                            }
                            size=size-1;
                            cx = (int) (X-(Math.floor(size/2)+1));

                        }
                    }else{
                        int cx = X-2;
                        int cz = Z-2;
                        for (int j = 0; j < 3; j++) {
                            Y = Y + 1;
                            int size = 3;
                            for (int s = 0; s < size; s++) {
                                cx = cx + 1;
                                for (int a = 0; a < size; a++) {
                                    cz = cz + 1;
                                    if(world.getBlockAt(new Location(world, chunk.getX() * 16 + cx, Y, chunk.getZ() * 16 + cz)).getType() != Material.LOG)
                                    {
                                        world.getBlockAt(new Location(world, chunk.getX() * 16 + cx, Y, chunk.getZ() * 16 + cz)).setType(Material.LEAVES);
                                    }
                                }
                                cz = Z-2;
                            }
                            cx = X-2;

                        }
                    }
                }




                // The tree type can be changed if you want.
            }
        }
    }

}