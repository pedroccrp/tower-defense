package domain.general;

public abstract class DefaultInstances {

	public static final int INT_MAP[][] = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {1, 2, 2, 2, 3, 0, 0, 0, 0},
									       {0, 0, 0, 0, 2, 0, 0, 0, 0},
									       {0, 0, 0, 0, 2, 0, 0, 0, 0},
									       {0, 0, 0, 0, 3, 2, 2, 2, 4},
									       {0, 0, 0, 0, 0, 0, 0, 0, 0},
									       {0, 0, 0, 0, 0, 0, 0, 0, 0}};
	
	public abstract int checkMapTile(int i, int j);
}