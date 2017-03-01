package com.morph.game.flappybird;

import com.morph.engine.graphics.GLRenderingEngine;
import com.morph.engine.graphics.Uniforms;
import com.morph.engine.graphics.components.RenderData;
import com.morph.engine.math.Matrix4f;
import com.morph.engine.physics.components.Transform;

public class BasicShaderUniforms extends Uniforms {
	private Matrix4f mvp;

	@Override
	public void defineUniforms(int shader) {
		addUniform("mvp", shader);
	}

	@Override
	public void setUniforms(Transform t, RenderData data) {
		mvp = t.getTransformationMatrix();
		
		setUniformMatrix4fv("mvp", mvp.mul(GLRenderingEngine.projectionMatrix).getTranspose());
	}

	@Override
	public void unbind(Transform t, RenderData data) {
		// TODO Auto-generated method stub
		
	}
}
