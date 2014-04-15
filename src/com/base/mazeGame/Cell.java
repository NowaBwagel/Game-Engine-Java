package com.base.mazeGame;

import java.util.ArrayList;

public class Cell {
	private ArrayList<Boolean> walls;
	private Integer row;
	private Integer colomn;

	public Cell(Integer row, Integer colomn) {
		this.row = row;
		this.colomn = colomn;
	}

	public ArrayList<Boolean> getWalls() {
		return walls;
	}

	public void knockWall(Integer index) {
		walls.set(index, false);
	}

	public void setWalls(ArrayList<Boolean> walls) {
		this.walls = walls;
	}

	public Integer getColomn() {
		return colomn;
	}

	public void setColomn(Integer colomn) {
		this.colomn = colomn;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}
}
