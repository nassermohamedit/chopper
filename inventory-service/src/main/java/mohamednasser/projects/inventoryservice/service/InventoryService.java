package mohamednasser.projects.inventoryservice.service;

import lombok.RequiredArgsConstructor;
import mohamednasser.projects.inventoryservice.dto.InventoryDto;
import mohamednasser.projects.inventoryservice.model.Inventory;
import mohamednasser.projects.inventoryservice.repository.InventoryRepository;
import mohamednasser.projects.inventoryservice.util.EntityDtoConverters;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    public List<InventoryDto> getInventoryFor(List<String> skuCode) {
        List<Inventory> inventories = this.inventoryRepository.findBySkuCodeIn(skuCode);
        return inventories.stream().map(EntityDtoConverters::InventoryEntityToDto).toList();
    }

    public List<InventoryDto> getAllInventories() {
        List<InventoryDto> inventories = new ArrayList<>();
        this.inventoryRepository.findAll().forEach(
                inventory -> inventories.add(EntityDtoConverters.InventoryEntityToDto(inventory))
        );
        return inventories;
    }
}
