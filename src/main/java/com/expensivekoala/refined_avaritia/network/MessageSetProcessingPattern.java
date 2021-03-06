package com.expensivekoala.refined_avaritia.network;

import com.expensivekoala.refined_avaritia.tile.TileExtremePatternEncoder;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MessageSetProcessingPattern extends Message<MessageSetProcessingPattern> implements IMessage {

    private int x, y, z;
    private boolean value;

    public MessageSetProcessingPattern() {

    }

    public MessageSetProcessingPattern(int x, int y, int z, boolean value) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.value = value;
    }

    @Override
    public void handle(MessageSetProcessingPattern message, EntityPlayerMP player) {
        BlockPos pos = new BlockPos(message.x, message.y, message.z);
        if(player.getEntityWorld().isBlockLoaded(pos)) {
            TileEntity tile = player.getEntityWorld().getTileEntity(pos);

            if (tile instanceof TileExtremePatternEncoder) {
                ((TileExtremePatternEncoder) tile).setProcessing(message.value);
            }
        }
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        x = buf.readInt();
        y = buf.readInt();
        z = buf.readInt();
        value = buf.readBoolean();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeBoolean(value);
    }
}
