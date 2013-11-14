package assignment4.djava;

public class Gun {

	private int ammo;
	
	public Gun(int ammo) {
		this.ammo = ammo;
	}
	
	public Gun() {
		this.ammo = 0;
	}

	public void shoot() {
		ammo--;
	}
	
	public void shoot(int n)
	{
		while (n > 0) {
			shoot();
			n--;
		}
	}

	public int getAmmoCount() {
		return ammo;
	}

}
