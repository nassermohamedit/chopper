package mohamednasser.projects.inventoryservice.controller;


import lombok.RequiredArgsConstructor;
import mohamednasser.projects.inventoryservice.dto.InventoryDto;
import mohamednasser.projects.inventoryservice.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<List<InventoryDto>> inventory(@RequestParam List<String> skuCode) {
        List<InventoryDto> body =  this.inventoryService.getInventoryFor(skuCode);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(body);
    }

    @GetMapping("/all")
    public ResponseEntity<List<InventoryDto>> getAllInventories() {
        List<InventoryDto> inventories = this.inventoryService.getAllInventories();
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(inventories);
    }

}
