package MAE;

public class Hero extends Character {
	private Character monsterToAttack;
	
	public Hero(String name, Categories category, int healthMax, int attackMin, int attackMax, String imgName) {
		super(name, category, healthMax, attackMin, attackMax, imgName, false);
	}

	@Override
	public void play(GI_Battle playerInterface) {
		playerInterface.setHumanPlaying(this);
		if (this.canPlay && this.isAlive()) {
			this.monsterToAttack = null;
			playerInterface.getMonsterToAttack(this);
			while(this.monsterToAttack == null) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			String result = this.attack(this.monsterToAttack, playerInterface);
			playerInterface.setHumanStatus(result);
		} else if (!this.canPlay && this.isAlive()) {
			this.unBlock();
			playerInterface.setHumanStatus(this.name + " is now unblocked and free to play");
		}
	}
	
	public void setMonsterToAttack(Character monsterToAttack) {
		this.monsterToAttack = monsterToAttack;
	}

	@Override
	public void revive() {
		super.revive();
		this.attackMax = Heroes.valueOf(this.name).getMaxAttack();
		this.attackMin = Heroes.valueOf(this.name).getMinAttack();
	}
}