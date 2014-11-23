package Reika.ChromatiCraft.GUI;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;

import Reika.ChromatiCraft.Base.GuiChromaBase;
import Reika.ChromatiCraft.Container.ContainerMiner;
import Reika.ChromatiCraft.TileEntity.TileEntityMiner;

public class GuiMiner extends GuiChromaBase {

	private final TileEntityMiner tile;

	public GuiMiner(EntityPlayer ep, TileEntityMiner te) {
		super(new ContainerMiner(ep, te), ep, te);
		tile = te;
		ySize = 206;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		super.drawGuiContainerForegroundLayer(par1, par2);
		List<ItemStack> c = tile.getFound();
		int j = (width - xSize) / 2;
		int k = (height - ySize) / 2;
		int i = 0;
		int n = 10;
		for (ItemStack is : c) {
			double s = 0.75;
			int dx = (int)((1/s)*(j*s+10+(i%n)*10))-3;
			int dy = (int)((1/s)*(k*s+17+(i/n)*10))-6;
			if (api.isMouseInBox(dx, dx+12, dy, dy+12)) {
				api.drawTooltipAt(fontRendererObj, is.getDisplayName()+": "+tile.getNumberFound(is), dx-12, dy-12);
			}
			i++;
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int a, int b) {
		super.drawGuiContainerBackgroundLayer(f, a, b);
		int j = (width - xSize) / 2;
		int k = (height - ySize) / 2;
		List<ItemStack> c = tile.getFound();
		GL11.glPushMatrix();
		double s = 0.75;
		GL11.glScaled(s, s, s);
		int i = 0;
		int n = 10;
		for (ItemStack is : c) {
			int dx = (int)((1/s)*(j+10+(i%n)*18*s));
			int dy = (int)((1/s)*(k+17+(i/n)*18*s));
			api.drawItemStack(itemRender, is, dx, dy);
			i++;
		}
		GL11.glPopMatrix();
	}

	@Override
	public String getGuiTexture() {
		return "miner";
	}

}
