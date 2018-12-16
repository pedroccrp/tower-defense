package domain.general;

public class MapInstance extends DefaultInstances {

	@Override
	public int checkMapTile(int i, int j) {
		int tileType = DefaultInstances.INT_MAP[i][j];
		
		return tileType;
	}

}
