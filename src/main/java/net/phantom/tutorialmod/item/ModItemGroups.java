package net.phantom.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.phantom.tutorialmod.TutorialMod;
import net.phantom.tutorialmod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TutorialMod.MOD_ID,"ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
                .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {
                    entries.add(ModItems.RUBY);
                    entries.add(ModItems.RAW_RUBY);
                    entries.add(ModItems.RUBY_PLATE);
                    entries.add(ModItems.RUBY_DETECTOR);
                    entries.add(ModItems.TOMATO);
                    entries.add(ModItems.COAL_PILE);

                    entries.add(ModBlocks.SOUND_BLOCK);

                    entries.add(ModBlocks.RUBY_BLOCK);
                    entries.add(ModBlocks.RAW_RUBY_BLOCK);

                    entries.add(ModBlocks.RUBY_ORE);
                    entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                    entries.add(ModBlocks.NETHER_RUBY_ORE);
                    entries.add(ModBlocks.END_RUBY_ORE);
                }).build());

    public static void registerItemGroups(){
        TutorialMod.LOGGER.info("Registering Item Groups for "+TutorialMod.MOD_ID);
    }
}