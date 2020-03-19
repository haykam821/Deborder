package io.github.haykam821.deborder.mixin;

import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.WindowEventHandler;
import net.minecraft.client.WindowSettings;
import net.minecraft.client.util.MonitorTracker;
import net.minecraft.client.util.Window;

@Mixin(Window.class)
public class WindowMixin {
	@Shadow
	long handle;

	@Inject(method = "<init>", at = @At("TAIL"))
	public void setUndecorated(WindowEventHandler eventHandler, MonitorTracker tracker, WindowSettings settings, String videoMode, String title, CallbackInfo ci) {
		GLFW.glfwSetWindowAttrib(handle, GLFW.GLFW_DECORATED, GLFW.GLFW_FALSE);
	}
}