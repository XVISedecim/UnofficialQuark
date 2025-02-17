package vazkii.quark.base.handler;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.block.SoundType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.GameData;
import vazkii.arl.util.RegistryHelper;

/**
 * @author WireSegal
 * Created at 12:40 PM on 9/9/19.
 */
public class QuarkSounds {
    private static final List<SoundEvent> REGISTRY_DEFERENCE = Lists.newArrayList();

    public static final SoundEvent ENTITY_STONELING_MEEP = register("entity.stoneling.meep");
    public static final SoundEvent ENTITY_STONELING_PURR = register("entity.stoneling.purr");
    public static final SoundEvent ENTITY_STONELING_GIVE = register("entity.stoneling.give");
    public static final SoundEvent ENTITY_STONELING_TAKE = register("entity.stoneling.take");
    public static final SoundEvent ENTITY_STONELING_EAT = register("entity.stoneling.eat");
    public static final SoundEvent ENTITY_STONELING_DIE = register("entity.stoneling.die");
    public static final SoundEvent ENTITY_STONELING_CRY = register("entity.stoneling.cry");
    public static final SoundEvent ENTITY_STONELING_MICHAEL = register("entity.stoneling.michael");
    
    public static final SoundEvent ENTITY_PICKARANG_THROW = register("entity.pickarang.throw");
    public static final SoundEvent ENTITY_PICKARANG_CLANK = register("entity.pickarang.clank");
    public static final SoundEvent ENTITY_PICKARANG_SPARK = register("entity.pickarang.spark");
    public static final SoundEvent ENTITY_PICKARANG_PICKUP = register("entity.pickarang.pickup");
    
    public static final SoundEvent ENTITY_FOXHOUND_IDLE = register("entity.foxhound.ambient");
    public static final SoundEvent ENTITY_FOXHOUND_DIE = register("entity.foxhound.death");
    public static final SoundEvent ENTITY_FOXHOUND_GROWL = register("entity.foxhound.growl");
    public static final SoundEvent ENTITY_FOXHOUND_HURT = register("entity.foxhound.hurt");
    public static final SoundEvent ENTITY_FOXHOUND_PANT = register("entity.foxhound.pant");
    public static final SoundEvent ENTITY_FOXHOUND_SHAKE = register("entity.foxhound.shake");
    public static final SoundEvent ENTITY_FOXHOUND_WHINE = register("entity.foxhound.whine");
    public static final SoundEvent ENTITY_FROG_WEDNESDAY = register("entity.frog.wednesday");
    public static final SoundEvent ENTITY_FROG_JUMP = register("entity.frog.jump");
    public static final SoundEvent ENTITY_FROG_DIE = register("entity.frog.die");
    public static final SoundEvent ENTITY_FROG_HURT = register("entity.frog.hurt");
    public static final SoundEvent ENTITY_FROG_IDLE = register("entity.frog.idle");
    
    public static final SoundEvent ENTITY_FROG_SHEAR = register("entity.frog.shear");
    public static final SoundEvent ENTITY_CRAB_DIE = register("entity.crab.die");
    public static final SoundEvent ENTITY_CRAB_HURT = register("entity.crab.hurt");
    public static final SoundEvent ENTITY_CRAB_IDLE = register("entity.crab.idle");
    
    public static final SoundEvent ENTITY_TORETOISE_DIE = register("entity.toretoise.die");
    public static final SoundEvent ENTITY_TORETOISE_HURT = register("entity.toretoise.hurt");
    public static final SoundEvent ENTITY_TORETOISE_IDLE = register("entity.toretoise.idle");
    public static final SoundEvent ENTITY_TORETOISE_ANGRY = register("entity.toretoise.angry");
    public static final SoundEvent ENTITY_TORETOISE_HARVEST = register("entity.toretoise.harvest");
    public static final SoundEvent ENTITY_TORETOISE_EAT = register("entity.toretoise.eat");
    public static final SoundEvent ENTITY_TORETOISE_REGROW = register("entity.toretoise.regrow");
    public static final SoundEvent ENTITY_SOUL_BEAD_IDLE = register("entity.soul_bead.idle");
    public static final SoundEvent BLOCK_MONSTER_BOX_GROWL = register("block.monster_box.growl");
    
    public static final SoundEvent BLOCK_PIPE_SHOOT = register("block.pipe.shoot");
    public static final SoundEvent BLOCK_PIPE_PICKUP = register("block.pipe.pickup");
    public static final SoundEvent BLOCK_PIPE_SHOOT_LENNY = register("block.pipe.shoot.lenny");
    public static final SoundEvent BLOCK_PIPE_PICKUP_LENNY = register("block.pipe.pickup.lenny");

    public static final SoundEvent ITEM_CAMERA_SHUTTER = register("item.camera.shutter");
    public static final SoundEvent ITEM_SOUL_POWDER_SPAWN = register("item.soul_powder.spawn");

    public static final SoundEvent AMBIENT_DRIPS = register("ambient.drips");
    public static final SoundEvent AMBIENT_OCEAN = register("ambient.ocean");
    public static final SoundEvent AMBIENT_RAIN = register("ambient.rain");
    public static final SoundEvent AMBIENT_WIND = register("ambient.wind");
    public static final SoundEvent AMBIENT_FIRE = register("ambient.fire");
    public static final SoundEvent AMBIENT_CLOCK = register("ambient.clock");
    public static final SoundEvent AMBIENT_CRICKETS = register("ambient.crickets");
    public static final SoundEvent AMBIENT_CHATTER = register("ambient.chatter");
    
    public static final SoundEvent MUSIC_ENDERMOSH = register("music.endermosh");
    public static void start() {
        for (SoundEvent event : REGISTRY_DEFERENCE)
            RegistryHelper.register(event);
        REGISTRY_DEFERENCE.clear();
    }

    public static SoundEvent register(String name) {
        ResourceLocation loc = GameData.checkPrefix(name, false);
        SoundEvent event = new SoundEvent(loc);
        event.setRegistryName(loc);
        REGISTRY_DEFERENCE.add(event);
        return event;
    }
}
