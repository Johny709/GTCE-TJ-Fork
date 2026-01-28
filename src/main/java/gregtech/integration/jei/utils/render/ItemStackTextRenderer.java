package gregtech.integration.jei.utils.render;

import mezz.jei.plugins.vanilla.ingredients.item.ItemStackRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class ItemStackTextRenderer extends ItemStackRenderer {

    @Override
    public void render(@Nonnull Minecraft minecraft, int xPosition, int yPosition, @Nullable ItemStack ingredient) {
        int amount = -1;
        if (ingredient != null) {
            amount = ingredient.getCount();
            if (amount == Integer.MAX_VALUE)
                ingredient.setCount(1);
        }
        super.render(minecraft, xPosition + 1, yPosition + 1, ingredient);
        if (amount == 0)
            minecraft.fontRenderer.drawStringWithShadow("NC", (xPosition + 6) * 2 - minecraft.fontRenderer.getStringWidth("NC") + 21, (yPosition + 12) * 2, 0xFFEC00);
    }
}
