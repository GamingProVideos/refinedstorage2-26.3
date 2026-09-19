package com.refinedmods.refinedstorage.neoforge.support.render;

import com.mojang.renderpearl.api.pipeline.ColorTargetState;
import com.mojang.renderpearl.api.pipeline.DepthStencilState;
import com.mojang.renderpearl.api.pipeline.PrimitiveTopology;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import net.minecraft.client.renderer.BindGroupLayouts;
import net.minecraft.client.renderer.rendertype.RenderSetup;
import net.minecraft.client.renderer.rendertype.RenderType;

import static com.refinedmods.refinedstorage.common.util.IdentifierUtil.MOD_ID;
import static com.refinedmods.refinedstorage.common.util.IdentifierUtil.createIdentifier;

public final class RenderTypes {
    private static final RenderPipeline DISK_LEDS_PIPELINE = RenderPipeline
        .builder()
        .withBindGroupLayout(BindGroupLayouts.GLOBALS)
        .withBindGroupLayout(BindGroupLayouts.PROJECTION)
        .withBindGroupLayout(BindGroupLayouts.DYNAMIC_TRANSFORMS)
        .withColorTargetState(ColorTargetState.DEFAULT)
        .withDepthStencilState(DepthStencilState.DEFAULT)
        .withLocation(createIdentifier("pipeline/disk_leds"))
        .withVertexShader("core/position_color")
        .withFragmentShader("core/position_color")
        .withVertexBinding(0, DefaultVertexFormat.POSITION_COLOR)
        .withPrimitiveTopology(PrimitiveTopology.QUADS)
        .build();

    public static final RenderType DISK_LEDS = RenderType.create(
        MOD_ID + "_disk_leds",
        RenderSetup.builder(DISK_LEDS_PIPELINE).createRenderSetup()
    );

    private RenderTypes() {
    }
}
