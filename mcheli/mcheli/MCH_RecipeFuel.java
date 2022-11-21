package mcheli.mcheli;

import mcheli.MCH_MOD;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class MCH_RecipeFuel implements IRecipe {
    public boolean func_77569_a(InventoryCrafting inv, World var2) {
        int jcnt = 0;
        int ccnt = 0;
        for (int i = 0; i < inv.func_70302_i_(); i++) {
            
            ItemStack itemStack = inv.func_70301_a(i);

            if (itemStack != null) {
                if (itemStack.func_77973_b() instanceof mcheli.aircraft.MCH_ItemFuel) {
                    if (itemStack.func_77960_j() == 0)
                        return false;
                    
                    jcnt++; 
                    
                    if (jcnt > 1)
                        return false;
                }
                else {
                    if (itemStack.func_77973_b() instanceof net.minecraft.item.ItemCoal && itemStack.field_77994_a > 0) 
                        ccnt++;
                    else
                        return false;
                }
            }
        }
        return (jcnt == 1 && ccnt > 0);
    }
    
    public ItemStack func_77572_b(InventoryCrafting inv) {
        ItemStack output = new ItemStack((Item)MCH_MOD.itemFuel);
        int i;
        for (i = 0; i < inv.func_70302_i_(); i++) {
        
                ItemStack itemStack = inv.func_70301_a(i);
                if (itemStack != null && itemStack.func_77973_b() instanceof mcheli.aircraft.MCH_ItemFuel) {
                
                output.func_77964_b(itemStack.func_77960_j());
                break;
                }
        }
        for (i = 0; i < inv.func_70302_i_(); i++) {
                
            ItemStack itemStack = inv.func_70301_a(i);
            if (itemStack != null && itemStack.func_77973_b() instanceof net.minecraft.item.ItemCoal) {
                
                int sp = 100;
                if (itemStack.func_77960_j() == 1)
                    sp = 75;
                if (output.func_77960_j() > sp)
                    output.func_77964_b(output.func_77960_j() - sp);
                else
                    output.func_77964_b(0);
            }
        }
        return output;
    }
    
    public int func_77570_a() {
        return 9;
    }
    
    public ItemStack func_77571_b() {
        return null;
    }
}


/* Location:              C:\Users\danie\Desktop\Mod Porting Tools\MC1.7.10_mcheli_1.0.3.jar!\mcheli\mcheli\MCH_RecipeFuel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */