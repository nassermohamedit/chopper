package mohamednasser.projects.inventoryservice.util;

import mohamednasser.projects.inventoryservice.dto.InventoryDto;
import mohamednasser.projects.inventoryservice.model.Inventory;

public class EntityDtoConverters {

    public static InventoryDto InventoryEntityToDto(Inventory inventory) {
        return new InventoryDto(inventory.getSkuCode(), inventory.getQuantity());
    }
}
