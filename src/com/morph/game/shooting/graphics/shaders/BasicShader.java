package com.morph.game.shooting.graphics.shaders;

import com.morph.engine.graphics.Shader;

public class BasicShader extends Shader<BasicShaderUniforms> {
	public BasicShader() {
		super("shaders/basic");
	}

	@Override
	protected void initUniforms(Shader<BasicShaderUniforms> shader) {
		uniforms = new BasicShaderUniforms();
		uniforms.init(shader);
	}
}
