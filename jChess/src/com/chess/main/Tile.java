package com.chess.main;

public abstract class Tile {
	
	private int tileCoord;
	
	public Tile(int tileCoord){
		this.tileCoord = tileCoord;
	}
	
	public abstract boolean isTileOccupied();
	
	public abstract Piece getPiece();
	
	
	public static final class EmptyTile extends Tile{
		EmptyTile(int coord){
			super(coord);
		}
		@Override
		public boolean isTileOccupied() {
			return false;
		}
		
		@Override
		public Piece getPiece() {
			return null;
		}
		
	}

}
