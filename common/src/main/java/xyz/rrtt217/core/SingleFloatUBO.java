package xyz.rrtt217.core;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.buffers.Std140SizeCalculator;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import org.lwjgl.system.MemoryStack;

import java.nio.ByteBuffer;

public class SingleFloatUBO implements AutoCloseable {
    private final GpuBuffer buffer;
    private static final long size = (new Std140SizeCalculator()).putFloat().get();
    public SingleFloatUBO(String string) {
        GpuDevice gpudevice = RenderSystem.getDevice();
        this.buffer = gpudevice.createBuffer(() -> "Float UBO " + string, 136, size);
    }
    public GpuBuffer update(Float f) {
        try (MemoryStack memorystack = MemoryStack.stackPush()) {
            ByteBuffer bytebuffer = Std140Builder.onStack(memorystack, (int) size).putFloat(f).get();
            RenderSystem.getDevice().createCommandEncoder().writeToBuffer(this.buffer.slice(), bytebuffer);
        }
        return buffer;
    }
    public void close() {
        this.buffer.close();
    }
}
