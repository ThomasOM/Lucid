package dev.thomazz.lucid.packet;

import com.google.common.collect.ImmutableList;
import dev.thomazz.lucid.util.PacketMethodCache;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import org.bukkit.Bukkit;

/**
 * Defines different types of packets available to the API
 */
@Getter
public final class PacketType {
    public static final PacketType UNKNOWN = new PacketType(PacketState.UNKNOWN, PacketSource.UNKNOWN);

    private static final Map<Class<?>, PacketType> CLASS_TO_TYPE = new IdentityHashMap<>();
    private static final List<PacketIterable> PACKET_ITERABLES = ImmutableList.of(
            Handshake.Client.get(), Handshake.Server.get(),
            Status.Client.get(), Status.Server.get(),
            Login.Client.get(), Login.Server.get(),
            Play.Client.get(), Play.Server.get()
    );

    private final String[] names;
    private final PacketState state;
    private final PacketSource source;
    private final Class<?> packetClass;

    public PacketType(PacketState state, PacketSource source, String... names) {
        this.names = names;
        this.state = state;
        this.source = source;
        this.packetClass = PacketType.getPacketClass(this.getClass().getClassLoader(), state, source, names);

        if (this.packetClass != null) {
            PacketType.CLASS_TO_TYPE.put(this.packetClass, this);
        }
    }

    public String getName() {
        return this.names.length == 0 ? "UNKNOWN" : this.names[0];
    }

    public boolean isLoaded() {
        return this.packetClass != null;
    }

    public Object createPacket() {
        if (!isLoaded()) {
            throw new IllegalStateException("Packet is not available in current runtime!");
        }

        try {
            return PacketMethodCache.create(this.packetClass);
        } catch (Exception ex) {
            throw new RuntimeException("Could not create new packet: " + this.packetClass);
        }
    }

    public static class Handshake {
        public static final PacketState STATE = PacketState.HANDSHAKE;

        public static class Client extends PacketIterable {
            private static final PacketSource SOURCE = PacketSource.CLIENT;

            public static final PacketType SET_PROTOCOL = new PacketType(STATE, SOURCE, "SetProtocol");

            private static Client INSTANCE;

            public static Client get() {
                if (INSTANCE == null) {
                    INSTANCE = new Client();
                }

                return INSTANCE;
            }
        }

        public static class Server extends PacketIterable {
            private static Server INSTANCE;

            public static Server get() {
                if (INSTANCE == null) {
                    INSTANCE = new Server();
                }

                return INSTANCE;
            }
        }
    }

    public static class Status {
        public static final PacketState STATE = PacketState.STATUS;

        public static class Client extends PacketIterable {
            private static final PacketSource SOURCE = PacketSource.CLIENT;

            public static final PacketType START = new PacketType(STATE, SOURCE, "Start");
            public static final PacketType PING = new PacketType(STATE, SOURCE, "Ping");

            private static Client INSTANCE;

            public static Client get() {
                if (INSTANCE == null) {
                    INSTANCE = new Client();
                }

                return INSTANCE;
            }
        }

        public static class Server extends PacketIterable {
            private static final PacketSource SOURCE = PacketSource.SERVER;

            public static final PacketType SERVER_INFO = new PacketType(STATE, SOURCE, "ServerInfo");
            public static final PacketType PONG = new PacketType(STATE, SOURCE, "Pong");

            private static Server INSTANCE;

            public static Server get() {
                if (INSTANCE == null) {
                    INSTANCE = new Server();
                }

                return INSTANCE;
            }
        }
    }

    public static class Login {
        public static final PacketState STATE = PacketState.LOGIN;

        public static class Client extends PacketIterable {
            private static final PacketSource SOURCE = PacketSource.CLIENT;

            public static final PacketType START = new PacketType(STATE, SOURCE, "Start");
            public static final PacketType ENCRYPTION_BEGIN = new PacketType(STATE, SOURCE, "EncryptionBegin");
            public static final PacketType CUSTOM_PAYLOAD = new PacketType(STATE, SOURCE, "CustomPayload");

            private static Client INSTANCE;

            public static Client get() {
                if (INSTANCE == null) {
                    INSTANCE = new Client();
                }

                return INSTANCE;
            }
        }

        public static class Server extends PacketIterable {
            private static final PacketSource SOURCE = PacketSource.SERVER;

            public static final PacketType DISCONNECT = new PacketType(STATE, SOURCE, "Disconnect");
            public static final PacketType ENCRYPTION_BEGIN = new PacketType(STATE, SOURCE, "EncryptionBegin");
            public static final PacketType SUCCESS = new PacketType(STATE, SOURCE, "Success");
            public static final PacketType SET_COMPRESSION = new PacketType(STATE, SOURCE, "SetCompression");
            public static final PacketType CUSTOM_PAYLOAD = new PacketType(STATE, SOURCE, "CustomPayload");

            private static Server INSTANCE;

            public static Server get() {
                if (INSTANCE == null) {
                    INSTANCE = new Server();
                }

                return INSTANCE;
            }
        }
    }

    public static class Play {
        public static final PacketState STATE = PacketState.PLAY;

        public static class Client extends PacketIterable {
            private static final PacketSource SOURCE = PacketSource.CLIENT;

            public static final PacketType ABILITIES = new PacketType(STATE, SOURCE, "Abilities");
            public static final PacketType ADVANCEMENTS = new PacketType(STATE, SOURCE, "Advancements");
            public static final PacketType ARM_ANIMATION = new PacketType(STATE, SOURCE, "ArmAnimation");
            public static final PacketType AUTO_RECIPE = new PacketType(STATE, SOURCE, "AutoRecipe");
            public static final PacketType B_EDIT = new PacketType(STATE, SOURCE, "BEdit");
            public static final PacketType BEACON = new PacketType(STATE, SOURCE, "Beacon");
            public static final PacketType BLOCK_DIG = new PacketType(STATE, SOURCE, "BlockDig");
            public static final PacketType BLOCK_PLACE = new PacketType(STATE, SOURCE, "BlockPlace");
            public static final PacketType BOAT_MOVE = new PacketType(STATE, SOURCE, "BoatMove");
            public static final PacketType CHAT = new PacketType(STATE, SOURCE, "Chat");
            public static final PacketType CLIENT_COMMAND = new PacketType(STATE, SOURCE, "ClientCommand");
            public static final PacketType CLOSE_WINDOW = new PacketType(STATE, SOURCE, "CloseWindow");
            public static final PacketType CUSTOM_PAYLOAD = new PacketType(STATE, SOURCE, "CustomPayload");
            public static final PacketType DIFFICULTY_CHANGE = new PacketType(STATE, SOURCE, "DifficultyChange");
            public static final PacketType DIFFICULTY_LOCK = new PacketType(STATE, SOURCE, "DifficultyLock");
            public static final PacketType ENCHANT_ITEM = new PacketType(STATE, SOURCE, "EnchantItem");
            public static final PacketType ENTITY_ACTION = new PacketType(STATE, SOURCE, "EntityAction");
            public static final PacketType ENTITY_NBT_QUERY = new PacketType(STATE, SOURCE, "EntityNBTQuery");
            public static final PacketType FLYING = new PacketType(STATE, SOURCE, "Flying");
            public static final PacketType LOOK = new PacketType(STATE, SOURCE, "Flying$Look");
            public static final PacketType POSITION = new PacketType(STATE, SOURCE, "Flying$Position");
            public static final PacketType POSITION_LOOK = new PacketType(STATE, SOURCE, "Flying$PositionLook");
            public static final PacketType HELD_ITEM_SLOT = new PacketType(STATE, SOURCE, "HeldItemSlot");
            public static final PacketType ITEM_NAME = new PacketType(STATE, SOURCE, "ItemName");
            public static final PacketType JIGSAW_GENERATE = new PacketType(STATE, SOURCE, "JigsawGenerate");
            public static final PacketType KEEP_ALIVE = new PacketType(STATE, SOURCE, "KeepAlive");
            public static final PacketType PICK_ITEM = new PacketType(STATE, SOURCE, "PickItem");
            public static final PacketType RECIPE_DISPLAYED = new PacketType(STATE, SOURCE, "RecipeDisplayed");
            public static final PacketType RECIPE_SETTINGS = new PacketType(STATE, SOURCE, "RecipeSettings");
            public static final PacketType RESOURCE_PACK_STATUS = new PacketType(STATE, SOURCE, "ResourcePackStatus");
            public static final PacketType SET_COMMAND_BLOCK = new PacketType(STATE, SOURCE, "SetCommandBlock");
            public static final PacketType SET_COMMAND_MINECART = new PacketType(STATE, SOURCE, "SetCommandMinecart");
            public static final PacketType SET_CREATIVE_SLOT = new PacketType(STATE, SOURCE, "SetCreativeSlot");
            public static final PacketType SET_JIGSAW = new PacketType(STATE, SOURCE, "SetJigsaw");
            public static final PacketType SETTINGS = new PacketType(STATE, SOURCE, "Settings");
            public static final PacketType SPECTATE = new PacketType(STATE, SOURCE, "Spectate");
            public static final PacketType STEER_VEHICLE = new PacketType(STATE, SOURCE, "SteerVehicle");
            public static final PacketType STRUCT = new PacketType(STATE, SOURCE, "Struct");
            public static final PacketType TAB_COMPLETE = new PacketType(STATE, SOURCE, "TabComplete");
            public static final PacketType TELEPORT_ACCEPT = new PacketType(STATE, SOURCE, "TeleportAccept");
            public static final PacketType TILE_NBT_QUERY = new PacketType(STATE, SOURCE, "TileNBTQuery");
            public static final PacketType TR_SEL = new PacketType(STATE, SOURCE, "TrSel");
            public static final PacketType UPDATE_SIGN = new PacketType(STATE, SOURCE, "UpdateSign");
            public static final PacketType USE_ENTITY = new PacketType(STATE, SOURCE, "UseEntity");
            public static final PacketType USE_ITEM = new PacketType(STATE, SOURCE, "UseItem");
            public static final PacketType VEHICLE_MOVE = new PacketType(STATE, SOURCE, "VehicleMove");
            public static final PacketType WINDOW_CLICK = new PacketType(STATE, SOURCE, "WindowClick");
            public static final PacketType CHAT_ACK = new PacketType(STATE, SOURCE, "ChatAck");
            public static final PacketType CHAT_COMMAND = new PacketType(STATE, SOURCE, "ChatCommand");
            public static final PacketType CHAT_SESSION_UPDATE = new PacketType(STATE, SOURCE, "ChatSessionUpdate");
            public static final PacketType PONG = new PacketType(STATE, SOURCE, "Pong");

            @Deprecated public static final PacketType TRANSACTION = new PacketType(STATE, SOURCE, "Transaction");


            private static Client INSTANCE;

            public static Client get() {
                if (INSTANCE == null) {
                    INSTANCE = new Client();
                }

                return INSTANCE;
            }
        }

        public static class Server extends PacketIterable {
            private static final PacketSource SOURCE = PacketSource.SERVER;

            public static final PacketType ABILITIES = new PacketType(STATE, SOURCE, "Abilities");
            public static final PacketType ADVANCEMENTS = new PacketType(STATE, SOURCE, "Advancements");
            public static final PacketType ANIMATION = new PacketType(STATE, SOURCE, "Animation");
            public static final PacketType ATTACH_ENTITY = new PacketType(STATE, SOURCE, "AttachEntity");
            public static final PacketType AUTO_RECIPE = new PacketType(STATE, SOURCE, "AutoRecipe");
            public static final PacketType BLOCK_ACTION = new PacketType(STATE, SOURCE, "BlockAction");
            public static final PacketType BLOCK_BREAK_ANIMATION = new PacketType(STATE, SOURCE, "BlockBreakAnimation");
            public static final PacketType BLOCK_CHANGE = new PacketType(STATE, SOURCE, "BlockChange");
            public static final PacketType BOSS = new PacketType(STATE, SOURCE, "Boss");
            public static final PacketType BUNDLE = new PacketType(STATE, SOURCE, "Bundle");
            public static final PacketType CAMERA = new PacketType(STATE, SOURCE, "Camera");
            public static final PacketType CLOSE_WINDOW = new PacketType(STATE, SOURCE, "CloseWindow");
            public static final PacketType COLLECT = new PacketType(STATE, SOURCE, "Collect");
            public static final PacketType COMMANDS = new PacketType(STATE, SOURCE, "Commands");
            public static final PacketType CUSTOM_PAYLOAD = new PacketType(STATE, SOURCE, "CustomPayload");
            public static final PacketType ENTITY = new PacketType(STATE, SOURCE, "Entity");
            public static final PacketType ENTITY_LOOK = new PacketType(STATE, SOURCE, "Entity$EntityLook");
            public static final PacketType REL_ENTITY_MOVE = new PacketType(STATE, SOURCE, "Entity$RelEntityMove");
            public static final PacketType REL_ENTITY_MOVE_LOOK = new PacketType(STATE, SOURCE, "Entity$RelEntityMoveLook");
            public static final PacketType ENTITY_DESTROY = new PacketType(STATE, SOURCE, "EntityDestroy");
            public static final PacketType ENTITY_EFFECT = new PacketType(STATE, SOURCE, "EntityEffect");
            public static final PacketType ENTITY_EQUIPMENT = new PacketType(STATE, SOURCE, "EntityEquipment");
            public static final PacketType ENTITY_HEAD_ROTATION = new PacketType(STATE, SOURCE, "EntityHeadRotation");
            public static final PacketType ENTITY_METADATA = new PacketType(STATE, SOURCE, "EntityMetadata");
            public static final PacketType ENTITY_SOUND = new PacketType(STATE, SOURCE, "EntitySound");
            public static final PacketType ENTITY_STATUS = new PacketType(STATE, SOURCE, "EntityStatus");
            public static final PacketType ENTITY_TELEPORT = new PacketType(STATE, SOURCE, "EntityTeleport");
            public static final PacketType ENTITY_VELOCITY = new PacketType(STATE, SOURCE, "EntityVelocity");
            public static final PacketType EXPERIENCE = new PacketType(STATE, SOURCE, "Experience");
            public static final PacketType EXPLOSION = new PacketType(STATE, SOURCE, "Explosion");
            public static final PacketType GAME_STATE_CHANGE = new PacketType(STATE, SOURCE, "GameStateChange");
            public static final PacketType HELD_ITEM_SLOT = new PacketType(STATE, SOURCE, "HeldItemSlot");
            public static final PacketType KEEP_ALIVE = new PacketType(STATE, SOURCE, "KeepAlive");
            public static final PacketType KICK_DISCONNECT = new PacketType(STATE, SOURCE, "KickDisconnect");
            public static final PacketType LIGHT_UPDATE = new PacketType(STATE, SOURCE, "LightUpdate");
            public static final PacketType LOGIN = new PacketType(STATE, SOURCE, "Login");
            public static final PacketType LOOK_AT = new PacketType(STATE, SOURCE, "LookAt");
            public static final PacketType MAP = new PacketType(STATE, SOURCE, "Map");
            public static final PacketType MOUNT = new PacketType(STATE, SOURCE, "Mount");
            public static final PacketType MULTI_BLOCK_CHANGE = new PacketType(STATE, SOURCE, "MultiBlockChange");
            public static final PacketType NBT_QUERY = new PacketType(STATE, SOURCE, "NBTQuery");
            public static final PacketType NAMED_ENTITY_SPAWN = new PacketType(STATE, SOURCE, "NamedEntitySpawn");
            public static final PacketType NAMED_SOUND_EFFECT = new PacketType(STATE, SOURCE, "NamedSoundEffect");
            public static final PacketType OPEN_BOOK = new PacketType(STATE, SOURCE, "OpenBook");
            public static final PacketType OPEN_SIGN_EDITOR = new PacketType(STATE, SOURCE, "OpenSignEditor");
            public static final PacketType OPEN_WINDOW = new PacketType(STATE, SOURCE, "OpenWindow");
            public static final PacketType OPEN_WINDOW_HORSE = new PacketType(STATE, SOURCE, "OpenWindowHorse");
            public static final PacketType OPEN_WINDOW_MERCHANT = new PacketType(STATE, SOURCE, "OpenWindowMerchant");
            public static final PacketType PLAYER_LIST_HEADER_FOOTER = new PacketType(STATE, SOURCE, "PlayerListHeaderFooter");
            public static final PacketType POSITION = new PacketType(STATE, SOURCE, "Position");
            public static final PacketType RECIPE_UPDATE = new PacketType(STATE, SOURCE, "RecipeUpdate");
            public static final PacketType RECIPES = new PacketType(STATE, SOURCE, "Recipes");
            public static final PacketType REMOVE_ENTITY_EFFECT = new PacketType(STATE, SOURCE, "RemoveEntityEffect");
            public static final PacketType RESOURCE_PACK_SEND = new PacketType(STATE, SOURCE, "ResourcePackSend");
            public static final PacketType RESPAWN = new PacketType(STATE, SOURCE, "Respawn");
            public static final PacketType SCOREBOARD_DISPLAY_OBJECTIVE = new PacketType(STATE, SOURCE, "ScoreboardDisplayObjective");
            public static final PacketType SCOREBOARD_SCORE = new PacketType(STATE, SOURCE, "ScoreboardScore");
            public static final PacketType SCOREBOARD_TEAM = new PacketType(STATE, SOURCE, "ScoreboardTeam");
            public static final PacketType SELECT_ADVANCEMENT_TAB = new PacketType(STATE, SOURCE, "SelectAdvancementTab");
            public static final PacketType SERVER_DIFFICULTY = new PacketType(STATE, SOURCE, "ServerDifficulty");
            public static final PacketType SET_COOLDOWN = new PacketType(STATE, SOURCE, "SetCooldown");
            public static final PacketType SET_SLOT = new PacketType(STATE, SOURCE, "SetSlot");
            public static final PacketType SPAWN_ENTITY = new PacketType(STATE, SOURCE, "SpawnEntity");
            public static final PacketType SPAWN_ENTITY_EXPERIENCE_ORB = new PacketType(STATE, SOURCE, "SpawnEntityExperienceOrb");
            public static final PacketType SPAWN_POSITION = new PacketType(STATE, SOURCE, "SpawnPosition");
            public static final PacketType STATISTIC = new PacketType(STATE, SOURCE, "Statistic");
            public static final PacketType STOP_SOUND = new PacketType(STATE, SOURCE, "StopSound");
            public static final PacketType TAB_COMPLETE = new PacketType(STATE, SOURCE, "TabComplete");
            public static final PacketType TAGS = new PacketType(STATE, SOURCE, "Tags");
            public static final PacketType TILE_ENTITY_DATA = new PacketType(STATE, SOURCE, "TileEntityData");
            public static final PacketType UNLOAD_CHUNK = new PacketType(STATE, SOURCE, "UnloadChunk");
            public static final PacketType UPDATE_ATTRIBUTES = new PacketType(STATE, SOURCE, "UpdateAttributes");
            public static final PacketType UPDATE_HEALTH = new PacketType(STATE, SOURCE, "UpdateHealth");
            public static final PacketType UPDATE_TIME = new PacketType(STATE, SOURCE, "UpdateTime");
            public static final PacketType VEHICLE_MOVE = new PacketType(STATE, SOURCE, "VehicleMove");
            public static final PacketType VIEW_CENTRE = new PacketType(STATE, SOURCE, "ViewCentre");
            public static final PacketType VIEW_DISTANCE = new PacketType(STATE, SOURCE, "ViewDistance");
            public static final PacketType WINDOW_DATA = new PacketType(STATE, SOURCE, "WindowData");
            public static final PacketType WINDOW_ITEMS = new PacketType(STATE, SOURCE, "WindowItems");
            public static final PacketType WORLD_EVENT = new PacketType(STATE, SOURCE, "WorldEvent");
            public static final PacketType WORLD_PARTICLES = new PacketType(STATE, SOURCE, "WorldParticles");
            public static final PacketType BLOCK_CHANGED_ACK = new PacketType(STATE, SOURCE, "BlockChangedAck");
            public static final PacketType CLEAR_TITLES = new PacketType(STATE, SOURCE, "ClearTitles");
            public static final PacketType CUSTOM_CHAT_COMPLETIONS = new PacketType(STATE, SOURCE, "CustomChatCompletions");
            public static final PacketType DELETE_CHAT = new PacketType(STATE, SOURCE, "DeleteChat");
            public static final PacketType DISGUISED_CHAT = new PacketType(STATE, SOURCE, "DisguisedChat");
            public static final PacketType INITIALIZE_BORDER = new PacketType(STATE, SOURCE, "InitializeBorder");
            public static final PacketType LEVEL_CHUNK_WITH_LIGHT = new PacketType(STATE, SOURCE, "LevelChunkWithLight");
            public static final PacketType PING = new PacketType(STATE, SOURCE, "Ping");
            public static final PacketType PLAYER_CHAT = new PacketType(STATE, SOURCE, "PlayerChat");
            public static final PacketType PLAYER_COMBAT_END = new PacketType(STATE, SOURCE, "PlayerCombatEnd");
            public static final PacketType PLAYER_COMBAT_ENTER = new PacketType(STATE, SOURCE, "PlayerCombatEnter");
            public static final PacketType PLAYER_COMBAT_KILL = new PacketType(STATE, SOURCE, "PlayerCombatKill");
            public static final PacketType PLAYER_INFO_REMOVE = new PacketType(STATE, SOURCE, "PlayerInfoRemove");
            public static final PacketType PLAYER_INFO_UPDATE = new PacketType(STATE, SOURCE, "PlayerInfoUpdate");
            public static final PacketType SERVER_DATA = new PacketType(STATE, SOURCE, "ServerData");
            public static final PacketType SET_ACTION_BAR_TEXT = new PacketType(STATE, SOURCE, "SetActionBarText");
            public static final PacketType SET_BORDER_CENTER = new PacketType(STATE, SOURCE, "SetBorderCenter");
            public static final PacketType SET_BORDER_LERP_SIZE = new PacketType(STATE, SOURCE, "SetBorderLerpSize");
            public static final PacketType SET_BORDER_SIZE = new PacketType(STATE, SOURCE, "SetBorderSize");
            public static final PacketType SET_BORDER_WARNING_DELAY = new PacketType(STATE, SOURCE, "SetBorderWarningDelay");
            public static final PacketType SET_BORDER_WARNING_DISTANCE = new PacketType(STATE, SOURCE, "SetBorderWarningDistance");
            public static final PacketType SET_SIMULATION_DISTANCE = new PacketType(STATE, SOURCE, "SetSimulationDistance");
            public static final PacketType SET_SUBTITLE_TEXT = new PacketType(STATE, SOURCE, "SetSubtitleText");
            public static final PacketType SET_TITLE_TEXT = new PacketType(STATE, SOURCE, "SetTitleText");
            public static final PacketType SET_TITLES_ANIMATION = new PacketType(STATE, SOURCE, "SetTitlesAnimation");
            public static final PacketType SYSTEM_CHAT = new PacketType(STATE, SOURCE, "SystemChat");
            public static final PacketType UPDATE_ENABLED_FEATURES = new PacketType(STATE, SOURCE, "UpdateEnabledFeatures");

            @Deprecated public static final PacketType BED = new PacketType(STATE, SOURCE, "Bed");
            @Deprecated public static final PacketType CHAT = new PacketType(STATE, SOURCE, "Chat");
            @Deprecated public static final PacketType MAP_CHUNK = new PacketType(STATE, SOURCE, "MapChunk");
            @Deprecated public static final PacketType MAP_CHUNK_BULK = new PacketType(STATE, SOURCE, "MapChunkBulk");
            @Deprecated public static final PacketType PLAYER_INFO = new PacketType(STATE, SOURCE, "PlayerInfo");
            @Deprecated public static final PacketType TRANSACTION = new PacketType(STATE, SOURCE, "Transaction");
            @Deprecated public static final PacketType WORLD_BORDER = new PacketType(STATE, SOURCE, "WorldBorder");

            private static Server INSTANCE;

            public static Server get() {
                if (INSTANCE == null) {
                    INSTANCE = new Server();
                }

                return INSTANCE;
            }
        }
    }

    // Tries a few methods to get the packet class dynamically from the server resources
    public static Class<?> getPacketClass(ClassLoader loader, PacketState state, PacketSource source, String... names) {
        for (String nameStub : names) {
            try {
                String packageName = Bukkit.getServer().getClass().getPackage().getName().replace("org.bukkit.craftbukkit", "net.minecraft.server");

                String className;
                if (nameStub.contains("$")) {
                    String[] entries = nameStub.split("\\$");
                    className = packageName + ".Packet" + state.getNameLegacy() + source.getNameLegacy() + entries[0];
                    className = className + "$Packet" + state.getNameLegacy() + source.getNameLegacy() + entries[1];
                } else {
                    className = packageName + ".Packet" + state.getNameLegacy() + source.getNameLegacy() + nameStub;
                }

                return Class.forName(className, true, loader);
            } catch (Throwable ignored) {
            }

            try {
                String packageName = "net.minecraft.network.protocol";

                String className;
                if (nameStub.contains("$")) {
                    String[] entries = nameStub.split("\\$");
                    className = packageName + "." + state.getName() + ".Packet" + state.getNameLegacy() + source.getNameLegacy() + entries[0];
                    className = className + "$Packet" + state.getNameLegacy() + source.getNameLegacy() + entries[1];
                } else {
                    className = packageName + "." + state.getName() + ".Packet" + state.getNameLegacy() + source.getNameLegacy() + nameStub;
                }

                return Class.forName(className, true, loader);
            } catch (Throwable ignored) {
            }

            try {
                String packageName = "net.minecraft.network.protocol";
                String className = packageName + "." + state.getName() + "." + source.getName() + nameStub + "Packet";
                return Class.forName(className, true, loader);
            } catch (Throwable ignored) {
            }
        }

        return null;
    }

    public static PacketType fromClass(Class<?> clazz) {
        return PacketType.CLASS_TO_TYPE.getOrDefault(clazz, PacketType.UNKNOWN);
    }

    public static Collection<PacketIterable> iterables() {
        return PacketType.PACKET_ITERABLES;
    }
}
