package com.gustavorickli.fps_arena.utils.rapid_instance_tools;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class ArmourUtils {

    private static ArmourUtils armourUtils;

    private static HashMap<Armour, ItemStack> armourHash = new HashMap<>();
    private static HashMap<Sword, ItemStack> swordHash = new HashMap<>();

    private ArmourUtils() {

        // armours
        armourHash.put(Armour.DIAMOND_HELMET, new ItemStack(Material.DIAMOND_HELMET));
        armourHash.put(Armour.DIAMOND_CHEST, new ItemStack(Material.DIAMOND_CHESTPLATE));
        armourHash.put(Armour.DIAMOND_LEGS, new ItemStack(Material.DIAMOND_LEGGINGS));
        armourHash.put(Armour.DIAMOND_BOOTS, new ItemStack(Material.DIAMOND_BOOTS));

        armourHash.put(Armour.IRON_HELMET, new ItemStack(Material.IRON_HELMET));
        armourHash.put(Armour.IRON_CHEST, new ItemStack(Material.IRON_CHESTPLATE));
        armourHash.put(Armour.IRON_LEGS, new ItemStack(Material.IRON_LEGGINGS));
        armourHash.put(Armour.IRON_BOOTS, new ItemStack(Material.IRON_BOOTS));


        armourHash.put(Armour.GOLD_HELMET, new ItemStack(Material.GOLD_HELMET));
        armourHash.put(Armour.GOLD_CHEST, new ItemStack(Material.GOLD_CHESTPLATE));
        armourHash.put(Armour.GOLD_LEGS, new ItemStack(Material.GOLD_LEGGINGS));
        armourHash.put(Armour.GOLD_BOOTS, new ItemStack(Material.GOLD_BOOTS));

        armourHash.put(Armour.NO_HELMET, new ItemStack(Material.AIR));
        armourHash.put(Armour.NO_CHEST, new ItemStack(Material.AIR));
        armourHash.put(Armour.NO_LEGS, new ItemStack(Material.AIR));
        armourHash.put(Armour.NO_BOOTS, new ItemStack(Material.AIR));


        // swords
        //      diamonds
        swordHash.put(Sword.DIAMOND, new ItemStack(Material.DIAMOND_SWORD));

        ItemStack diamondSwordSharp1 = new ItemStack(Material.DIAMOND_SWORD);
        diamondSwordSharp1.addEnchantment(Enchantment.DAMAGE_ALL, 1);
        swordHash.put(Sword.DIAMOND_SHARP1, diamondSwordSharp1);

        // Sharp 1 with Fire
        ItemStack diamondSwordSharp1wFire = new ItemStack(Material.DIAMOND_SWORD);
        diamondSwordSharp1wFire.addEnchantment(Enchantment.DAMAGE_ALL, 1);
        diamondSwordSharp1wFire.addEnchantment(Enchantment.FIRE_ASPECT, 1);
        swordHash.put(Sword.DIAMOND_SHARP1_FIRE, diamondSwordSharp1wFire);


        ItemStack diamondSwordSharp2 = new ItemStack(Material.DIAMOND_SWORD);
        diamondSwordSharp2.addEnchantment(Enchantment.DAMAGE_ALL, 2);
        swordHash.put(Sword.DIAMOND_SHARP2, diamondSwordSharp2);

        // DIAMOND_SHARP5
        ItemStack diamondSwordSharp5 = new ItemStack(Material.DIAMOND_SWORD);
        diamondSwordSharp5.addEnchantment(Enchantment.DAMAGE_ALL, 5);
        swordHash.put(Sword.DIAMOND_SHARP5, diamondSwordSharp5);

        // DIAMOND_SHARP5_FIRE
        ItemStack diamondSwordSharp5andFire = new ItemStack(Material.DIAMOND_SWORD);
        diamondSwordSharp5andFire.addEnchantment(Enchantment.DAMAGE_ALL, 5);
        diamondSwordSharp5andFire.addEnchantment(Enchantment.FIRE_ASPECT, 1);
        swordHash.put(Sword.DIAMOND_SHARP5_FIRE, diamondSwordSharp5andFire);


        //      stones
        swordHash.put(Sword.STONE, new ItemStack(Material.STONE_SWORD));

        ItemStack stoneSwordSharp1 = new ItemStack(Material.STONE_SWORD);
        stoneSwordSharp1.addEnchantment(Enchantment.DAMAGE_ALL, 1);
        swordHash.put(Sword.STONE_SHARP1, stoneSwordSharp1);

    }

    public static ArmourUtils getInstance() {
        return armourUtils;
    }

    public static ArmourUtils getArmourUtils() {
        if (armourUtils == null) {
            armourUtils = new ArmourUtils();
        }

        return armourUtils;
    }

    public static ItemStack getSword(Sword sword) {
        return getArmourUtils().swordHash.get(sword);
    }

    public HashMap<Sword, ItemStack> getSwordHash() {
        return swordHash;
    }

    public static ItemStack getArmour(Armour armour) {
        return getArmourUtils().armourHash.get(armour);
    }



}
