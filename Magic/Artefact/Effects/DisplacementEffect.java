package Reika.ChromatiCraft.Magic.Artefact.Effects;

import net.minecraft.entity.Entity;
import Reika.ChromatiCraft.Magic.Artefact.UABombingEffect;
import Reika.DragonAPI.Libraries.Java.ReikaRandomHelper;


public class DisplacementEffect extends UABombingEffect.EntityEffect {

	@Override
	public void trigger(Entity e) {
		e.motionX += ReikaRandomHelper.getRandomPlusMinus(0, 0.5);
		e.motionY += ReikaRandomHelper.getRandomPlusMinus(0.5, 0.25);
		e.motionZ += ReikaRandomHelper.getRandomPlusMinus(0, 0.5);
		e.velocityChanged = true;
	}

}
