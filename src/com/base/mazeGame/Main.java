package com.base.mazeGame;

import com.base.engine.core.CoreEngine;

public class Main {

    public static void main(String[] args){
	CoreEngine engine = new CoreEngine(800, 600, 60, new Maze());
	engine.createWindow("MAZE GAME");
	engine.start();
    }
}
