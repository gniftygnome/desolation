package raltsmc.desolation.init.server;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import raltsmc.desolation.Desolation;

public record CinderSoulC2SPacket(TYPE type) implements CustomPayload {
    public enum TYPE {
        DASH,
        READY,
        TICK
    }

    public static final CustomPayload.Id<CinderSoulC2SPacket> ID = new Id<>(Identifier.of(Desolation.MOD_ID, "cinder_soul"));
    public static final PacketCodec<RegistryByteBuf, CinderSoulC2SPacket> CODEC = CustomPayload.codecOf(CinderSoulC2SPacket::write, CinderSoulC2SPacket::new);

    public CinderSoulC2SPacket(RegistryByteBuf buf) {
        this(TYPE.valueOf(buf.readString()));
    }

    public void write(PacketByteBuf buf) {
        buf.writeString(this.type.toString());
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
