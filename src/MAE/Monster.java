package MAE;

public class Monster extends Character {

	public Monster(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName) {
		super(name, category, healthMax, attackMin, attackMax, imgName, true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(GI_Battle playerInterface) {
		playerInterface.setComputerPlaying(this);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
