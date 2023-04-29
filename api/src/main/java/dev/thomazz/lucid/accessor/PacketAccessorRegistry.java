package dev.thomazz.lucid.accessor;

import dev.thomazz.lucid.packet.PacketType;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * Accessor registry generated by script.
 */
@UtilityClass
@SuppressWarnings("deprecation")
public class PacketAccessorRegistry {
    private final Map<PacketType, Constructor<? extends PacketAccessor>> CONSTRUCTOR_MAP = new HashMap<>();

    // Static registry generated by script below
    static {
        register(PacketType.Handshake.Client.SET_PROTOCOL, dev.thomazz.lucid.accessor.client.handshake.SetProtocol.class);
        register(PacketType.Status.Client.START, dev.thomazz.lucid.accessor.client.status.Start.class);
        register(PacketType.Status.Client.PING, dev.thomazz.lucid.accessor.client.status.Ping.class);
        register(PacketType.Status.Server.SERVER_INFO, dev.thomazz.lucid.accessor.server.status.ServerInfo.class);
        register(PacketType.Status.Server.PONG, dev.thomazz.lucid.accessor.server.status.Pong.class);
        register(PacketType.Login.Client.START, dev.thomazz.lucid.accessor.client.login.Start.class);
        register(PacketType.Login.Client.ENCRYPTION_BEGIN, dev.thomazz.lucid.accessor.client.login.EncryptionBegin.class);
        register(PacketType.Login.Client.CUSTOM_PAYLOAD, dev.thomazz.lucid.accessor.client.login.CustomPayload.class);
        register(PacketType.Login.Server.DISCONNECT, dev.thomazz.lucid.accessor.server.login.Disconnect.class);
        register(PacketType.Login.Server.ENCRYPTION_BEGIN, dev.thomazz.lucid.accessor.server.login.EncryptionBegin.class);
        register(PacketType.Login.Server.SUCCESS, dev.thomazz.lucid.accessor.server.login.Success.class);
        register(PacketType.Login.Server.SET_COMPRESSION, dev.thomazz.lucid.accessor.server.login.SetCompression.class);
        register(PacketType.Login.Server.CUSTOM_PAYLOAD, dev.thomazz.lucid.accessor.server.login.CustomPayload.class);
        register(PacketType.Play.Client.ABILITIES, dev.thomazz.lucid.accessor.client.play.Abilities.class);
        register(PacketType.Play.Client.ADVANCEMENTS, dev.thomazz.lucid.accessor.client.play.Advancements.class);
        register(PacketType.Play.Client.ARM_ANIMATION, dev.thomazz.lucid.accessor.client.play.ArmAnimation.class);
        register(PacketType.Play.Client.AUTO_RECIPE, dev.thomazz.lucid.accessor.client.play.AutoRecipe.class);
        register(PacketType.Play.Client.B_EDIT, dev.thomazz.lucid.accessor.client.play.BEdit.class);
        register(PacketType.Play.Client.BEACON, dev.thomazz.lucid.accessor.client.play.Beacon.class);
        register(PacketType.Play.Client.BLOCK_DIG, dev.thomazz.lucid.accessor.client.play.BlockDig.class);
        register(PacketType.Play.Client.BLOCK_PLACE, dev.thomazz.lucid.accessor.client.play.BlockPlace.class);
        register(PacketType.Play.Client.BOAT_MOVE, dev.thomazz.lucid.accessor.client.play.BoatMove.class);
        register(PacketType.Play.Client.CHAT, dev.thomazz.lucid.accessor.client.play.Chat.class);
        register(PacketType.Play.Client.CLIENT_COMMAND, dev.thomazz.lucid.accessor.client.play.ClientCommand.class);
        register(PacketType.Play.Client.CLOSE_WINDOW, dev.thomazz.lucid.accessor.client.play.CloseWindow.class);
        register(PacketType.Play.Client.CUSTOM_PAYLOAD, dev.thomazz.lucid.accessor.client.play.CustomPayload.class);
        register(PacketType.Play.Client.DIFFICULTY_CHANGE, dev.thomazz.lucid.accessor.client.play.DifficultyChange.class);
        register(PacketType.Play.Client.DIFFICULTY_LOCK, dev.thomazz.lucid.accessor.client.play.DifficultyLock.class);
        register(PacketType.Play.Client.ENCHANT_ITEM, dev.thomazz.lucid.accessor.client.play.EnchantItem.class);
        register(PacketType.Play.Client.ENTITY_ACTION, dev.thomazz.lucid.accessor.client.play.EntityAction.class);
        register(PacketType.Play.Client.ENTITY_NBT_QUERY, dev.thomazz.lucid.accessor.client.play.EntityNBTQuery.class);
        register(PacketType.Play.Client.FLYING, dev.thomazz.lucid.accessor.client.play.Flying.class);
        register(PacketType.Play.Client.LOOK, dev.thomazz.lucid.accessor.client.play.Look.class);
        register(PacketType.Play.Client.POSITION, dev.thomazz.lucid.accessor.client.play.Position.class);
        register(PacketType.Play.Client.POSITION_LOOK, dev.thomazz.lucid.accessor.client.play.PositionLook.class);
        register(PacketType.Play.Client.HELD_ITEM_SLOT, dev.thomazz.lucid.accessor.client.play.HeldItemSlot.class);
        register(PacketType.Play.Client.ITEM_NAME, dev.thomazz.lucid.accessor.client.play.ItemName.class);
        register(PacketType.Play.Client.JIGSAW_GENERATE, dev.thomazz.lucid.accessor.client.play.JigsawGenerate.class);
        register(PacketType.Play.Client.KEEP_ALIVE, dev.thomazz.lucid.accessor.client.play.KeepAlive.class);
        register(PacketType.Play.Client.PICK_ITEM, dev.thomazz.lucid.accessor.client.play.PickItem.class);
        register(PacketType.Play.Client.RECIPE_DISPLAYED, dev.thomazz.lucid.accessor.client.play.RecipeDisplayed.class);
        register(PacketType.Play.Client.RECIPE_SETTINGS, dev.thomazz.lucid.accessor.client.play.RecipeSettings.class);
        register(PacketType.Play.Client.RESOURCE_PACK_STATUS, dev.thomazz.lucid.accessor.client.play.ResourcePackStatus.class);
        register(PacketType.Play.Client.SET_COMMAND_BLOCK, dev.thomazz.lucid.accessor.client.play.SetCommandBlock.class);
        register(PacketType.Play.Client.SET_COMMAND_MINECART, dev.thomazz.lucid.accessor.client.play.SetCommandMinecart.class);
        register(PacketType.Play.Client.SET_CREATIVE_SLOT, dev.thomazz.lucid.accessor.client.play.SetCreativeSlot.class);
        register(PacketType.Play.Client.SET_JIGSAW, dev.thomazz.lucid.accessor.client.play.SetJigsaw.class);
        register(PacketType.Play.Client.SETTINGS, dev.thomazz.lucid.accessor.client.play.Settings.class);
        register(PacketType.Play.Client.SPECTATE, dev.thomazz.lucid.accessor.client.play.Spectate.class);
        register(PacketType.Play.Client.STEER_VEHICLE, dev.thomazz.lucid.accessor.client.play.SteerVehicle.class);
        register(PacketType.Play.Client.STRUCT, dev.thomazz.lucid.accessor.client.play.Struct.class);
        register(PacketType.Play.Client.TAB_COMPLETE, dev.thomazz.lucid.accessor.client.play.TabComplete.class);
        register(PacketType.Play.Client.TELEPORT_ACCEPT, dev.thomazz.lucid.accessor.client.play.TeleportAccept.class);
        register(PacketType.Play.Client.TILE_NBT_QUERY, dev.thomazz.lucid.accessor.client.play.TileNBTQuery.class);
        register(PacketType.Play.Client.TR_SEL, dev.thomazz.lucid.accessor.client.play.TrSel.class);
        register(PacketType.Play.Client.UPDATE_SIGN, dev.thomazz.lucid.accessor.client.play.UpdateSign.class);
        register(PacketType.Play.Client.USE_ENTITY, dev.thomazz.lucid.accessor.client.play.UseEntity.class);
        register(PacketType.Play.Client.USE_ITEM, dev.thomazz.lucid.accessor.client.play.UseItem.class);
        register(PacketType.Play.Client.VEHICLE_MOVE, dev.thomazz.lucid.accessor.client.play.VehicleMove.class);
        register(PacketType.Play.Client.WINDOW_CLICK, dev.thomazz.lucid.accessor.client.play.WindowClick.class);
        register(PacketType.Play.Client.CHAT_ACK, dev.thomazz.lucid.accessor.client.play.ChatAck.class);
        register(PacketType.Play.Client.CHAT_COMMAND, dev.thomazz.lucid.accessor.client.play.ChatCommand.class);
        register(PacketType.Play.Client.CHAT_SESSION_UPDATE, dev.thomazz.lucid.accessor.client.play.ChatSessionUpdate.class);
        register(PacketType.Play.Client.PONG, dev.thomazz.lucid.accessor.client.play.Pong.class);
        register(PacketType.Play.Server.ABILITIES, dev.thomazz.lucid.accessor.server.play.Abilities.class);
        register(PacketType.Play.Server.ADVANCEMENTS, dev.thomazz.lucid.accessor.server.play.Advancements.class);
        register(PacketType.Play.Server.ANIMATION, dev.thomazz.lucid.accessor.server.play.Animation.class);
        register(PacketType.Play.Server.ATTACH_ENTITY, dev.thomazz.lucid.accessor.server.play.AttachEntity.class);
        register(PacketType.Play.Server.AUTO_RECIPE, dev.thomazz.lucid.accessor.server.play.AutoRecipe.class);
        register(PacketType.Play.Server.BLOCK_ACTION, dev.thomazz.lucid.accessor.server.play.BlockAction.class);
        register(PacketType.Play.Server.BLOCK_BREAK_ANIMATION, dev.thomazz.lucid.accessor.server.play.BlockBreakAnimation.class);
        register(PacketType.Play.Server.BLOCK_CHANGE, dev.thomazz.lucid.accessor.server.play.BlockChange.class);
        register(PacketType.Play.Server.BOSS, dev.thomazz.lucid.accessor.server.play.Boss.class);
        register(PacketType.Play.Server.BUNDLE, dev.thomazz.lucid.accessor.server.play.Bundle.class);
        register(PacketType.Play.Server.CAMERA, dev.thomazz.lucid.accessor.server.play.Camera.class);
        register(PacketType.Play.Server.CLOSE_WINDOW, dev.thomazz.lucid.accessor.server.play.CloseWindow.class);
        register(PacketType.Play.Server.COLLECT, dev.thomazz.lucid.accessor.server.play.Collect.class);
        register(PacketType.Play.Server.COMMANDS, dev.thomazz.lucid.accessor.server.play.Commands.class);
        register(PacketType.Play.Server.CUSTOM_PAYLOAD, dev.thomazz.lucid.accessor.server.play.CustomPayload.class);
        register(PacketType.Play.Server.ENTITY, dev.thomazz.lucid.accessor.server.play.Entity.class);
        register(PacketType.Play.Server.ENTITY_LOOK, dev.thomazz.lucid.accessor.server.play.EntityLook.class);
        register(PacketType.Play.Server.REL_ENTITY_MOVE, dev.thomazz.lucid.accessor.server.play.RelEntityMove.class);
        register(PacketType.Play.Server.REL_ENTITY_MOVE_LOOK, dev.thomazz.lucid.accessor.server.play.RelEntityMoveLook.class);
        register(PacketType.Play.Server.ENTITY_DESTROY, dev.thomazz.lucid.accessor.server.play.EntityDestroy.class);
        register(PacketType.Play.Server.ENTITY_EFFECT, dev.thomazz.lucid.accessor.server.play.EntityEffect.class);
        register(PacketType.Play.Server.ENTITY_EQUIPMENT, dev.thomazz.lucid.accessor.server.play.EntityEquipment.class);
        register(PacketType.Play.Server.ENTITY_HEAD_ROTATION, dev.thomazz.lucid.accessor.server.play.EntityHeadRotation.class);
        register(PacketType.Play.Server.ENTITY_METADATA, dev.thomazz.lucid.accessor.server.play.EntityMetadata.class);
        register(PacketType.Play.Server.ENTITY_SOUND, dev.thomazz.lucid.accessor.server.play.EntitySound.class);
        register(PacketType.Play.Server.ENTITY_STATUS, dev.thomazz.lucid.accessor.server.play.EntityStatus.class);
        register(PacketType.Play.Server.ENTITY_TELEPORT, dev.thomazz.lucid.accessor.server.play.EntityTeleport.class);
        register(PacketType.Play.Server.ENTITY_VELOCITY, dev.thomazz.lucid.accessor.server.play.EntityVelocity.class);
        register(PacketType.Play.Server.EXPERIENCE, dev.thomazz.lucid.accessor.server.play.Experience.class);
        register(PacketType.Play.Server.EXPLOSION, dev.thomazz.lucid.accessor.server.play.Explosion.class);
        register(PacketType.Play.Server.GAME_STATE_CHANGE, dev.thomazz.lucid.accessor.server.play.GameStateChange.class);
        register(PacketType.Play.Server.HELD_ITEM_SLOT, dev.thomazz.lucid.accessor.server.play.HeldItemSlot.class);
        register(PacketType.Play.Server.KEEP_ALIVE, dev.thomazz.lucid.accessor.server.play.KeepAlive.class);
        register(PacketType.Play.Server.KICK_DISCONNECT, dev.thomazz.lucid.accessor.server.play.KickDisconnect.class);
        register(PacketType.Play.Server.LIGHT_UPDATE, dev.thomazz.lucid.accessor.server.play.LightUpdate.class);
        register(PacketType.Play.Server.LOGIN, dev.thomazz.lucid.accessor.server.play.Login.class);
        register(PacketType.Play.Server.LOOK_AT, dev.thomazz.lucid.accessor.server.play.LookAt.class);
        register(PacketType.Play.Server.MAP, dev.thomazz.lucid.accessor.server.play.Map.class);
        register(PacketType.Play.Server.MAP_CHUNK, dev.thomazz.lucid.accessor.server.play.MapChunk.class);
        register(PacketType.Play.Server.MOUNT, dev.thomazz.lucid.accessor.server.play.Mount.class);
        register(PacketType.Play.Server.MULTI_BLOCK_CHANGE, dev.thomazz.lucid.accessor.server.play.MultiBlockChange.class);
        register(PacketType.Play.Server.NBT_QUERY, dev.thomazz.lucid.accessor.server.play.NBTQuery.class);
        register(PacketType.Play.Server.NAMED_ENTITY_SPAWN, dev.thomazz.lucid.accessor.server.play.NamedEntitySpawn.class);
        register(PacketType.Play.Server.NAMED_SOUND_EFFECT, dev.thomazz.lucid.accessor.server.play.NamedSoundEffect.class);
        register(PacketType.Play.Server.OPEN_BOOK, dev.thomazz.lucid.accessor.server.play.OpenBook.class);
        register(PacketType.Play.Server.OPEN_SIGN_EDITOR, dev.thomazz.lucid.accessor.server.play.OpenSignEditor.class);
        register(PacketType.Play.Server.OPEN_WINDOW, dev.thomazz.lucid.accessor.server.play.OpenWindow.class);
        register(PacketType.Play.Server.OPEN_WINDOW_HORSE, dev.thomazz.lucid.accessor.server.play.OpenWindowHorse.class);
        register(PacketType.Play.Server.OPEN_WINDOW_MERCHANT, dev.thomazz.lucid.accessor.server.play.OpenWindowMerchant.class);
        register(PacketType.Play.Server.PLAYER_LIST_HEADER_FOOTER, dev.thomazz.lucid.accessor.server.play.PlayerListHeaderFooter.class);
        register(PacketType.Play.Server.POSITION, dev.thomazz.lucid.accessor.server.play.Position.class);
        register(PacketType.Play.Server.RECIPE_UPDATE, dev.thomazz.lucid.accessor.server.play.RecipeUpdate.class);
        register(PacketType.Play.Server.RECIPES, dev.thomazz.lucid.accessor.server.play.Recipes.class);
        register(PacketType.Play.Server.REMOVE_ENTITY_EFFECT, dev.thomazz.lucid.accessor.server.play.RemoveEntityEffect.class);
        register(PacketType.Play.Server.RESOURCE_PACK_SEND, dev.thomazz.lucid.accessor.server.play.ResourcePackSend.class);
        register(PacketType.Play.Server.RESPAWN, dev.thomazz.lucid.accessor.server.play.Respawn.class);
        register(PacketType.Play.Server.SCOREBOARD_DISPLAY_OBJECTIVE, dev.thomazz.lucid.accessor.server.play.ScoreboardDisplayObjective.class);
        register(PacketType.Play.Server.SCOREBOARD_SCORE, dev.thomazz.lucid.accessor.server.play.ScoreboardScore.class);
        register(PacketType.Play.Server.SCOREBOARD_TEAM, dev.thomazz.lucid.accessor.server.play.ScoreboardTeam.class);
        register(PacketType.Play.Server.SELECT_ADVANCEMENT_TAB, dev.thomazz.lucid.accessor.server.play.SelectAdvancementTab.class);
        register(PacketType.Play.Server.SERVER_DIFFICULTY, dev.thomazz.lucid.accessor.server.play.ServerDifficulty.class);
        register(PacketType.Play.Server.SET_COOLDOWN, dev.thomazz.lucid.accessor.server.play.SetCooldown.class);
        register(PacketType.Play.Server.SET_SLOT, dev.thomazz.lucid.accessor.server.play.SetSlot.class);
        register(PacketType.Play.Server.SPAWN_ENTITY, dev.thomazz.lucid.accessor.server.play.SpawnEntity.class);
        register(PacketType.Play.Server.SPAWN_ENTITY_EXPERIENCE_ORB, dev.thomazz.lucid.accessor.server.play.SpawnEntityExperienceOrb.class);
        register(PacketType.Play.Server.SPAWN_POSITION, dev.thomazz.lucid.accessor.server.play.SpawnPosition.class);
        register(PacketType.Play.Server.STATISTIC, dev.thomazz.lucid.accessor.server.play.Statistic.class);
        register(PacketType.Play.Server.STOP_SOUND, dev.thomazz.lucid.accessor.server.play.StopSound.class);
        register(PacketType.Play.Server.TAB_COMPLETE, dev.thomazz.lucid.accessor.server.play.TabComplete.class);
        register(PacketType.Play.Server.TAGS, dev.thomazz.lucid.accessor.server.play.Tags.class);
        register(PacketType.Play.Server.TILE_ENTITY_DATA, dev.thomazz.lucid.accessor.server.play.TileEntityData.class);
        register(PacketType.Play.Server.UNLOAD_CHUNK, dev.thomazz.lucid.accessor.server.play.UnloadChunk.class);
        register(PacketType.Play.Server.UPDATE_ATTRIBUTES, dev.thomazz.lucid.accessor.server.play.UpdateAttributes.class);
        register(PacketType.Play.Server.UPDATE_HEALTH, dev.thomazz.lucid.accessor.server.play.UpdateHealth.class);
        register(PacketType.Play.Server.UPDATE_TIME, dev.thomazz.lucid.accessor.server.play.UpdateTime.class);
        register(PacketType.Play.Server.VEHICLE_MOVE, dev.thomazz.lucid.accessor.server.play.VehicleMove.class);
        register(PacketType.Play.Server.VIEW_CENTRE, dev.thomazz.lucid.accessor.server.play.ViewCentre.class);
        register(PacketType.Play.Server.VIEW_DISTANCE, dev.thomazz.lucid.accessor.server.play.ViewDistance.class);
        register(PacketType.Play.Server.WINDOW_DATA, dev.thomazz.lucid.accessor.server.play.WindowData.class);
        register(PacketType.Play.Server.WINDOW_ITEMS, dev.thomazz.lucid.accessor.server.play.WindowItems.class);
        register(PacketType.Play.Server.WORLD_EVENT, dev.thomazz.lucid.accessor.server.play.WorldEvent.class);
        register(PacketType.Play.Server.WORLD_PARTICLES, dev.thomazz.lucid.accessor.server.play.WorldParticles.class);
        register(PacketType.Play.Server.BLOCK_CHANGED_ACK, dev.thomazz.lucid.accessor.server.play.BlockChangedAck.class);
        register(PacketType.Play.Server.CLEAR_TITLES, dev.thomazz.lucid.accessor.server.play.ClearTitles.class);
        register(PacketType.Play.Server.CUSTOM_CHAT_COMPLETIONS, dev.thomazz.lucid.accessor.server.play.CustomChatCompletions.class);
        register(PacketType.Play.Server.DELETE_CHAT, dev.thomazz.lucid.accessor.server.play.DeleteChat.class);
        register(PacketType.Play.Server.DISGUISED_CHAT, dev.thomazz.lucid.accessor.server.play.DisguisedChat.class);
        register(PacketType.Play.Server.INITIALIZE_BORDER, dev.thomazz.lucid.accessor.server.play.InitializeBorder.class);
        register(PacketType.Play.Server.LEVEL_CHUNK_WITH_LIGHT, dev.thomazz.lucid.accessor.server.play.LevelChunkWithLight.class);
        register(PacketType.Play.Server.PING, dev.thomazz.lucid.accessor.server.play.Ping.class);
        register(PacketType.Play.Server.PLAYER_CHAT, dev.thomazz.lucid.accessor.server.play.PlayerChat.class);
        register(PacketType.Play.Server.PLAYER_COMBAT_END, dev.thomazz.lucid.accessor.server.play.PlayerCombatEnd.class);
        register(PacketType.Play.Server.PLAYER_COMBAT_ENTER, dev.thomazz.lucid.accessor.server.play.PlayerCombatEnter.class);
        register(PacketType.Play.Server.PLAYER_COMBAT_KILL, dev.thomazz.lucid.accessor.server.play.PlayerCombatKill.class);
        register(PacketType.Play.Server.PLAYER_INFO_REMOVE, dev.thomazz.lucid.accessor.server.play.PlayerInfoRemove.class);
        register(PacketType.Play.Server.PLAYER_INFO_UPDATE, dev.thomazz.lucid.accessor.server.play.PlayerInfoUpdate.class);
        register(PacketType.Play.Server.SERVER_DATA, dev.thomazz.lucid.accessor.server.play.ServerData.class);
        register(PacketType.Play.Server.SET_ACTION_BAR_TEXT, dev.thomazz.lucid.accessor.server.play.SetActionBarText.class);
        register(PacketType.Play.Server.SET_BORDER_CENTER, dev.thomazz.lucid.accessor.server.play.SetBorderCenter.class);
        register(PacketType.Play.Server.SET_BORDER_LERP_SIZE, dev.thomazz.lucid.accessor.server.play.SetBorderLerpSize.class);
        register(PacketType.Play.Server.SET_BORDER_SIZE, dev.thomazz.lucid.accessor.server.play.SetBorderSize.class);
        register(PacketType.Play.Server.SET_BORDER_WARNING_DELAY, dev.thomazz.lucid.accessor.server.play.SetBorderWarningDelay.class);
        register(PacketType.Play.Server.SET_BORDER_WARNING_DISTANCE, dev.thomazz.lucid.accessor.server.play.SetBorderWarningDistance.class);
        register(PacketType.Play.Server.SET_SIMULATION_DISTANCE, dev.thomazz.lucid.accessor.server.play.SetSimulationDistance.class);
        register(PacketType.Play.Server.SET_SUBTITLE_TEXT, dev.thomazz.lucid.accessor.server.play.SetSubtitleText.class);
        register(PacketType.Play.Server.SET_TITLE_TEXT, dev.thomazz.lucid.accessor.server.play.SetTitleText.class);
        register(PacketType.Play.Server.SET_TITLES_ANIMATION, dev.thomazz.lucid.accessor.server.play.SetTitlesAnimation.class);
        register(PacketType.Play.Server.SYSTEM_CHAT, dev.thomazz.lucid.accessor.server.play.SystemChat.class);
        register(PacketType.Play.Server.UPDATE_ENABLED_FEATURES, dev.thomazz.lucid.accessor.server.play.UpdateEnabledFeatures.class);
    }

    private void register(PacketType type, Class<? extends PacketAccessor> accessorType) {
        try {
            Constructor<? extends PacketAccessor> constructor = accessorType.getConstructor(Object.class);
            PacketAccessorRegistry.CONSTRUCTOR_MAP.put(type, constructor);
        } catch (Exception ex) {
            throw new RuntimeException("Could not register packet accessor!");
        }
    }

    public PacketAccessor createAccessor(PacketType type, Object handle) {
        Constructor<? extends PacketAccessor> constructor = PacketAccessorRegistry.CONSTRUCTOR_MAP.get(type);

        // If there is no accessor found for this type (should not happen)
        if (constructor == null) {
            return new PacketAccessor(type, handle);
        }

        try {
            return constructor.newInstance(handle);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
}
