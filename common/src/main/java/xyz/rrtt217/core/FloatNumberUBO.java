package xyz.rrtt217.core;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.buffers.Std140SizeCalculator;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import org.lwjgl.system.MemoryStack;

import java.nio.ByteBuffer;

public class FloatNumberUBO implements AutoCloseable {
    private final GpuBuffer buffer;
    private final long memSize;
    public FloatNumberUBO(String string, int blockSize) {
        GpuDevice gpudevice = RenderSystem.getDevice();
        Std140SizeCalculator calcualtor = new Std140SizeCalculator();
        for(int i = 0; i < blockSize; i++) {
            calcualtor = calcualtor.putFloat();
        }
        memSize = calcualtor.get();
        this.buffer = gpudevice.createBuffer(() -> "Float UBO " + string, 136, memSize);
    }
    public FloatNumberUBO(String string) {
       this(string, 1);
    }
    public GpuBuffer update(Float[] f) {
        try (MemoryStack memorystack = MemoryStack.stackPush()) {
            Std140Builder builder = Std140Builder.onStack(memorystack, (int) memSize);

            for(Float f1 : f) {builder = builder.putFloat(f1);}

            ByteBuffer bytebuffer = builder.get();
            RenderSystem.getDevice().createCommandEncoder().writeToBuffer(this.buffer.slice(), bytebuffer);
        }
        return buffer;
    }
    public void close() {
        this.buffer.close();
    }
}
