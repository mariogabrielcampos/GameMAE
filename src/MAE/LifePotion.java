package MAE;

public class LifePotion extends Item{
	private int heal;
	private Hero hero;
	private boolean hasReceivedHero;
	
	public LifePotion(int price, String name, String image,int heal) {
		super(price, name, image);
		this.heal=heal;
	}
	
	public void execute(Game game) {
		game.getHuman().removeItem(this);
		this.hasReceivedHero = false;
		Thread t43 = new Thread(new GI_PickList(game.getHuman().getTeam(), this));
		t43.start();
		while (!this.hasReceivedHero) {
	        try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		hero.heal(this.heal);
		game.getInterface().updateStats();
	}
	
	public void receiveHero(Hero hero) {
		this.hero = hero;
		this.hasReceivedHero = true;
	}
}
