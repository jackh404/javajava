//Interface Segregation Principle
interface BasicGame {
	void getGameName();
}

interface OnlineGame {
	void getServerList();
}

class MultiplayerGame implements BasicGame, OnlineGame {

	public void getServerList() {
		System.out.println("US-East, US-West, Europe");
	}

	public void getGameName() {
		System.out.println("Multiplayer Game");
	}
}

interface PausableGame {
	void pauseGame();
}

class SingleplayerGame implements BasicGame, PausableGame {

	public void getGameName() {
		System.out.println("Singleplayer Game");		
	}

	public void pauseGame() {
		System.out.println("Pausing game...");
	}

}

public class InterfaceSegregationPrincipleGood {
    public static void main(String[] args){
        SingleplayerGame singleplayerGame = new SingleplayerGame();
        MultiplayerGame multiplayerGame = new MultiplayerGame();

        singleplayerGame.getGameName();
        singleplayerGame.pauseGame();

        multiplayerGame.getGameName();
        multiplayerGame.getServerList();
    }
}


