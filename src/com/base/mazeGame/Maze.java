package com.base.mazeGame;

import com.base.engine.components.Camera;
import com.base.engine.components.DirectionalLight;
import com.base.engine.components.FreeLook;
import com.base.engine.components.FreeMove;
import com.base.engine.components.MeshRenderer;
import com.base.engine.core.Game;
import com.base.engine.core.GameObject;
import com.base.engine.core.Quaternion;
import com.base.engine.core.Vector2f;
import com.base.engine.core.Vector3f;
import com.base.engine.rendering.Material;
import com.base.engine.rendering.Mesh;
import com.base.engine.rendering.Texture;
import com.base.engine.rendering.Vertex;
import com.base.engine.rendering.Window;

public class Maze extends Game {
	public void init() {

		//Cell Information
		Vertex[] cellPlain = new Vertex[] { new Vertex(new Vector3f(-10.0f, 0.0f, -10.0f), new Vector2f(0.0f, 0.0f)), new Vertex(new Vector3f(-10.0f, 0.0f, 10.0f * 3), new Vector2f(0.0f, 1.0f)), new Vertex(new Vector3f(10.0f * 3, 0.0f, -10.0f), new Vector2f(1.0f, 0.0f)), new Vertex(new Vector3f(10.0f * 3, 0.0f, 10.0f * 3), new Vector2f(1.0f, 1.0f)) };
		int cellIndices[] = { 0, 1, 2, 2, 1, 3 };
		
		Mesh cellWall = new Mesh(cellPlain, cellIndices, true);
		
		Material cellMaterial = new Material();
		cellMaterial.addTexture("diffuse", new Texture("bricks.jpg"));
		cellMaterial.addFloat("specularIntensity", 1);
		cellMaterial.addFloat("specularPower", 8);
		
		MeshRenderer cellRender = new MeshRenderer(cellWall, cellMaterial);
		
		GameObject cell = new GameObject().addComponent(cellRender);
		
		GameObject directionalLightObject = new GameObject();
		DirectionalLight directionalLight = new DirectionalLight(new Vector3f(0.82f, 0.91f, 0.51f), 0.4f);

		directionalLightObject.addComponent(directionalLight);
		
		GameObject mainCamera = new GameObject().addComponent(new Camera((float) Math.toRadians(70.0f), (float) Window.getWidth() / (float) Window.getHeight(), 0.01f, 1000.0f)).addComponent(new FreeLook(0.5f)).addComponent(new FreeMove(10.0f));
		
		// Adding Objects to world
		cell.getTransform().getPos().set(0, -1, 5);
		
		addObject(directionalLightObject);
		addObject(cell);
		addObject(mainCamera);
		
		directionalLight.getTransform().setRot(new Quaternion(new Vector3f(1, 0, 0), (float) Math.toRadians(-45)));
	}

}
