package assignment4.djava.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import assignment4.djava.Gun;

public class GunTest {

	@Test
	public void ShootGunDecreasesAmmo() {
		Gun gun = new Gun(12);
		gun.shoot();
		assertEquals(gun.getAmmoCount(), 11);
	}
	
	@Test
	public void EmptyClip()
	{
		Gun gun = new Gun(10);
		gun.shoot(10);
		assertEquals(gun.getAmmoCount(), 0);
	}
	
	@Test 
	public void EmptyConstructorEmptyGun(){
		Gun gun = new Gun();
		assertEquals(gun.getAmmoCount(), 0);
	}

}
