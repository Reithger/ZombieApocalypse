package testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import zombie.Zombie;
import horde.symbol.*;
import hunter.TaeKwonDoHunter;
import hunterguild.HunterGuildKickPower;
import hunterguild.career.KickPowerCareer;
import town.Sackville;
import weapon.KickPower;
import weapon.Machete;
import horde.ZombieberHorde;
import pronoun.*;

class ZombieTest {

	@Test
	void test() {
		Sackville sack = new Sackville();
		assertEquals(sack.getTownName(), "Sackville");
		
		//Zombie Testing
		ZombieberHorde hordeBieb = new ZombieberHorde("A");
		FactionSymbol facSymb = hordeBieb.getFactionSymbol();
		Feminine femPronoun = new Feminine();
		Zombie zomGa = new Zombie(0, "Silal", 3, facSymb, femPronoun);
		hordeBieb.employZombie(zomGa);
		assertEquals(zomGa.getFactionSymbol().compatible(new ZombieberSymbol()), true);
		assertEquals(zomGa.getHorde(), hordeBieb);
		assertEquals(zomGa.getLimbCount(), 3);
		assertEquals(zomGa.getZombieID(), 0);
		assertEquals(zomGa.getZombieName(), "Silal");
		assertEquals(zomGa.getPronouns(), femPronoun);
		assertEquals(hordeBieb.getZombieRegistry().get(0), zomGa);
		assertEquals(zomGa.accessWeakness(), facSymb.getCulturalWeakness());
		assertEquals(facSymb.compatible(new ZombieberSymbol()), true);
		ZombieTubbiesSymbol zomT = new ZombieTubbiesSymbol();
		zomGa.setFactionSymbol(zomT);
		assertEquals(zomGa.getFactionSymbol().compatible(new ZombieTubbiesSymbol()), true);
		assertNotEquals(zomGa.accessWeakness(), facSymb.getCulturalWeakness());
		hordeBieb.updateZombiesOnTrend();
		assertEquals(zomGa.accessWeakness(), facSymb.getCulturalWeakness());
		zomGa.leaveHorde();
		assertNotEquals(zomGa.getHorde(), hordeBieb);
		zomGa.setFactionSymbol(zomT);
		hordeBieb.updateZombiesOnTrend();
		assertEquals(zomGa.getFactionSymbol().compatible(new ZombieTubbiesSymbol()), true);
		hordeBieb.employZombie(zomGa);
		hordeBieb.updateZombiesOnTrend();
		
		//Hunter Testing
		HunterGuildKickPower kicks = new HunterGuildKickPower("Kickery");
		Masculine masc = new Masculine();
		TaeKwonDoHunter tkD = new TaeKwonDoHunter("Mac", masc, kicks);
		assertEquals(tkD.getName(), "Mac");
		assertEquals(tkD.getPronouns(), masc);
		tkD.applyNameChange("Maya");
		tkD.applyPronouns(femPronoun);
		assertEquals(tkD.getName(), "Maya");
		assertEquals(tkD.getPronouns(), femPronoun);
		assertNotEquals(tkD.getPronouns(), masc);
		assertEquals(tkD.getHunterType().compatible(new KickPowerCareer()), true);
		assertEquals(tkD.getHuntingPower().compatible(new KickPower()), true);
		assertEquals(tkD.getGuildAssociation(), kicks);
		tkD.quitGuild();
		assertNotEquals(tkD.getGuildAssociation(), kicks);
		tkD.joinGuild(kicks);
		assertEquals(tkD, kicks.getHunterRegistry().get(0));
		assertEquals(kicks.getHunterRegistry(new KickPower()).size(), 1);
		assertEquals(kicks.getHunterRegistry(new Machete()).size(), 0);
		assertEquals(kicks.getGuildTitle(), "Kickery");
		
		//Town Testing
		sack.amalgamateNewHorde(hordeBieb);
		sack.ratifyNewGuild(kicks);
		assertEquals(sack.seeZombieHordes().get(0), hordeBieb);
		assertEquals(sack.seeZombieHunterGuilds().get(0), kicks);
		sack.renameTown("SackedVille");
		assertEquals(sack.getTownName(), "SackedVille");
		assertNotEquals(sack.getTownName(), "Sackville");
		TaeKwonDoHunter jill = new TaeKwonDoHunter("Si", femPronoun, null);
		assertEquals(sack.employZombieHunter(jill), true);
		assertEquals(sack.seeZombieHunterGuilds(new KickPowerCareer()).get(0), kicks);
		assertEquals(sack.seeZombieHunterGuilds(new KickPowerCareer()).get(0).getHunterRegistry().get(1), jill);
		Zombie zzT = new Zombie(1, "Minsky", 4, new ZombieberSymbol(), masc);
		assertEquals(sack.attractZombie(zzT), true);
		zzT.setFactionSymbol(new ZombieTubbiesSymbol());
		assertEquals(sack.orderSlaying(tkD, zomGa), true);
		assertEquals(sack.orderSlaying(jill, zzT), false);
		hordeBieb.updateZombiesOnTrend();
		assertEquals(sack.orderSlaying(tkD, zzT), true);
		assertEquals(sack.seeZombieHordes().get(0).getZombieRegistry().size(), 0);
		assertEquals(tkD.getName(), "Maya");
	}

}
